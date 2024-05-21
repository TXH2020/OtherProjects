var ex=require('express-validator')
var express=require('express')
var app=express()
app.get('/hello',ex.query('person').isNumeric(),function(req,res){
    var x=ex.validationResult(req)
    if(x.isEmpty())
    res.send(ex.matchedData(req).person)
    else
    res.send({"errors":x.array()})
})
app.listen(3000);