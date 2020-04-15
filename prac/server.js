const express = require('express');
const bodyParser = require("body-parser");
const app = express();
const path = require('path');
const { fork } = require('child_process');
const fs = require('fs');

const { FolderModel, FileModel } = require('./database/db');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static('views'));

app.get("/", (req, res) => {
    res.sendFile(path.join(__dirname, "/views/abhi.html"));
})


async function saveFile(name) {
    return new Promise((resolve, reject) => {
        let db = new FileModel;
        const data = fs.readFileSync(name, 'utf8');
        db.name = name;
        db.data = data;
        db.save().then(res => {
            resolve({res,isFile:1});
        }).catch(err => { console.error(err); reject(err) });
    })
}
async function saveToBase(name) {
    return new Promise(async (resolve, reject) => {
        let db = new FolderModel;
        db.name = name;
        db.isFile = false;
        try {
            const res = await db.save();
            resolve({res,isFile:0});
        } catch (err) {
            resolve({res:{name:db.name},isFile:false})
        }
    })
}

async function update(id, contentIDs) {
    console.log(id);
    contentIDs.map(i=>console.log(i));
    return new Promise((resolve, reject) => {
        FolderModel.findByIdAndUpdate({ _id: id }, {contents:contentIDs}, { new: true }).then(user => {
            resolve(user);
        }).catch(err => { console.error(err); reject(err) });
    }
    )
}

async function pushToDB(data) {
    return new Promise((resolve, reject) => {
        var promises = [];
        let hashmap = {};
        data.map(async block => {
            // console.log("55");
            try {
                console.log("57");
                if(block.location in hashmap)
                    hashmap[block.location]=hashmap[block.location];
                else{
                    const id=await saveToBase(block.location,hashmap);
                    hashmap[block.location]=id.res._id;
                }
                // console.log(hashmap[block.location]+" "+block.location);
                var contentIDs = [];
                var promises=[];
                block.files.map(async subBlock => {
                    if (subBlock.name in hashmap) {
                        //pass
                    }
                    else {
                        if (subBlock.isFile) {
                            // hashmap[subBlock.name] = await saveFile(subBlock.name);
                            promises.push(saveFile(subBlock.name));
                            // contentIDs.push({ fId: hashmap[subBlock.name], isFile: 1 });
                        }
                        else {
                            // hashmap[subBlock.name] = await saveToBase(subBlock.name);
                            promises.push(saveToBase(subBlock.name));
                            // contentIDs.push({ fId: hashmap[subBlock.name], isFile: 0 })
                        }
                    }
                    // console.log(contentIDs);
                })
                Promise.all(promises).then(async res=>{
                    console.log(res);
                    var contentIDs=[];
                    res.map(i=>{
                        console.log(i.res.name);
                        if(i.res.name in hashmap){
                            contentIDs.push({fId:hashmap[i.res.name],isFile:i.isFile});
                        }
                        else{
                            hashmap[i.res.name]=i.res._id;
                            contentIDs.push({fId:i.res._id,isFile:i.isFile})
                        }
                    });
                    // console.log(block.location+" "+contentIDs);
                    try{
                        await update(hashmap[block.location],contentIDs);
                    }catch(err){
                        console.log(err);
                        reject(err);
                    }
                })
                // promises.push(update(hashmap[block.location], contentIDs));
            } catch (err) {
                reject(err);
            }
        })
        console.log("79");
        Promise.all(promises).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err);
        })
    })
}

app.get("/upload", (req, res) => {
    const child = fork("heavy.js");
    child.send({ path: "./" });
    child.on("message", async data => {
        data[0].location = "prac";
        pushToDB(data).then(user => {
            res.send("successful");
        }).catch(err => {
            console.log(err);
            res.send(err);
        })
        // res.send(data);
    })
});

app.get("/test", (req, res) => {
    // console.log("yes");
    // let db = new FolderModel;
    // db.name = "abhi";
    // db.isFile = false;
    // // db.contents=[1,2,3];
    // db.save().then(user => { res.send(user) }).catch(err => res.send(err));
    // console.log(2);
    // let hashmap = {};
    // hashmap['cat'] = 1;
    // hashmap['dog'] = 2;
    // const r = ('cat' in hashmap) ? "yes" : "no";
    // res.send(r);
    var a=[1];
    a.map(i=>{
        setTimeout(()=>{console.log("yes")},1000);
    })
    console.log("no");
    res.send("yes");
})

app.get("/test2", async (req, res) => {
    // FolderModel.findByIdAndUpdate({_id:'5e9740157135836231471683'},{contents:[1,2,4,5]},{new:true}).then(user=>{
    //     res.send(user);
    // }).catch(err=>{res.send(err)});
    let db = new FileModel;
    const data = fs.readFileSync("./views/abhi.html", "utf8");
    db.name = "abhi.html";
    db.data = data;
    db.save().then(user => {
        res.send(user);
    }).catch(err => { res.send(err) });
})


app.listen(process.env.PORT || 3000);