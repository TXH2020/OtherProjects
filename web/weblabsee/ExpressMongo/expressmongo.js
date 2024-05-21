var express=require('express')
var MongoClient = require('mongodb').MongoClient;
var app = express();
MongoClient.connect("mongodb://192.168.0.204/somedatabase1", function(err, db) {
    if(!err) {
    app.get('/', function (req, res) {  
       res.sendFile(__dirname+"/index.html");  
    })

    app.get('/insert.html', function (req, res) {  
      res.sendFile(__dirname+"/insert.html");  
   })

    app.get('/update.html', function (req, res) {  
    res.sendFile(__dirname+"/update.html");  
   })

   app.get('/delete.html', function (req, res) {  
    res.sendFile(__dirname+"/delete.html");  
   })

   app.get('/search.html', function (req, res) {  
    res.sendFile(__dirname+"/search.html");  
   })

    app.get('/insert_record', function (req, res) { 
            var insertobject = req.query;
            db.collection('somecollection1').insert(insertobject, function(err, doc) {
            if (err) {
              res.send("insert error:"+err)
            } else {
                 res.send(doc);
            }
          });
        });
    
        app.get("/update_record", function(req, res) {
            var uo=JSON.parse(req.query.hif);
            console.log(uo)
            var suo={}
            keys=Object.keys(req.query);
            for(var i=0;i<keys.length;i++)
            if(req.query[keys[i]]!='')
            suo[keys[i]]=req.query[keys[i]];
            db.collection('somecollection1').update(uo,{$set:suo},{multi:true}, function (err, data) {
                        if (err) 
                            res.send("update error"+err);
                        else 
                            res.send(data);
                
            });
        })

        app.get("/search_record", function(req, res) {
          var suo={}
          keys=Object.keys(req.query);
          for(var i=0;i<keys.length;i++)
          if(req.query[keys[i]]!='')
          suo[keys[i]]=req.query[keys[i]];
            db.collection('somecollection1').find(suo).toArray(function(err, docs) {
            if (err) {
              res.send("find error");
            } else {
              
              res.render('disp.ejs',{data:docs})
            }
          });
          });

          app.get("/delete_record", function(req, res) {
            var uo=req.query.hif;
            var suo={}
            keys=Object.keys(req.query);
            for(var i=0;i<keys.length;i++)
            if(req.query[keys[i]]!='')
            suo[keys[i]]=req.query[keys[i]];
            db.collection('somecollection1').deleteOne(suo,function(err, docs) {
            if (err) {
              res.send("find error");
            } else {
              res.send(docs)
            }
          });
          });
     app.listen(5000);     
}
else{
console.log("Unable to connect to database") 
}
})