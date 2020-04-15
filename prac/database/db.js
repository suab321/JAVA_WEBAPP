const mongoose=require('mongoose');
const multer=require('multer');
const GridFsStorage=require('multer-gridfs-storage');
const Grid=require('gridfs-stream');
const mongoURL="mongodb://127.0.0.1/folderUpload"
mongoose.connect(mongoURL,{useNewUrlParser:true,useUnifiedTopology:true});
let connection=mongoose.connection;
let gfs;
connection.once("open",()=>{
    gfs=Grid(connection.db,mongoose.mongo);
})

const storage=new GridFsStorage({
    url:mongoURL,
    file:(file)=>{
        const fileInfo={
            filename:file.originalname
        }
    }
});

const FolderSchema=new mongoose.Schema({
    name:{type:String,unique:true},
    isFile:{type:Boolean},
    contents:[{}]
});
const FileSchema=new mongoose.Schema({
    name:{type:String},
    data:{type:Buffer}
})


const FolderModel=mongoose.model("FolderModel",FolderSchema);
const FileModel=mongoose.model("FileModel",FileSchema);

module.exports={
    FolderModel,
    FileModel,
}


