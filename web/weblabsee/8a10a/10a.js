var express=require('express')
const cookieParser = require('cookie-parser');
var app=express()
app.use(cookieParser());
app.get('/',function(req,res,next){
    next();},
    (req,res,next)=>{
        if(req.cookies.visitorCount!=undefined){
            res.cookie('visitorCount',parseInt(req.cookies.visitorCount)+1,{
                maxAge: 86400 * 1000, // 24 hours
                httpOnly: true, // http only, prevents JavaScript cookie access
                secure: true // cookie must be sent over https / ssl
            }).send((req.cookies.visitorCount).toString())}
        else
        res.cookie('visitorCount', 2, {
            maxAge: 86400 * 1000, // 24 hours
            httpOnly: true, // http only, prevents JavaScript cookie access
            secure: true // cookie must be sent over https / ssl
        }).send('set cookie');
    next();
    
},
(req,res,next)=>{
    console.log(req.rawHeaders);
    next();
})
app.listen(5000);