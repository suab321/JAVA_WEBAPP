const fs=require('fs');
const path=require('path');

function getContents(location){
    return new Promise((resolve,reject)=>{
        try{
            const files=fs.readdirSync(location);
            for(var i=0;i<files.length;i++)
                files[i]=path.join(location,files[i]);
            resolve(files);
        }catch(err){
            reject(err);
        }
    })
}

// console.log(fs.lstatSync("./heavy.js").isDirectory());

process.on("message",async data=>{
    var arr=[];
    arr.push(data.path);
    var result=[];
    while(arr.length!==0){
        var location=arr[0];
        arr.splice(0,1);
        try {
            var localResult=[];
            const files=await getContents(location);
            files.forEach(i=>{
                if(fs.lstatSync(i).isDirectory()){
                    arr.push(i);
                    localResult.push({name:i,isFile:0})
                }
                else
                    localResult.push({name:i,isFile:1});
            })
            result.push({location:location,files:localResult})
        } catch (error) {
            console.log(error);
        }
    }
    process.send(result);
});



