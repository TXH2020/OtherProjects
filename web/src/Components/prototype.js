function activate(){
function prototypeExample(){
prototypeExample.prototype.add=(a,b)=>{return a+b}
prototypeExample.prototype.sub=(a,b)=>{return a-b}
prototypeExample.prototype.mul=(a,b)=>{return a*b}
prototypeExample.prototype.div=(a,b)=>{return a/b}
}
var g=new prototypeExample();
var op=document.getElementById('op').value
var i1=parseInt(document.getElementById('i1').value)
var i2=parseInt(document.getElementById('i2').value)
if(op==='+')
alert(g.add(i1,i2))
else if(op==='-')
alert(g.sub(i1,i2))
else if(op==='*')
alert(g.mul(i1,i2))
else if(op==='/')
alert(g.div(i1,i2))
}

function PrototypeExample(){
return (
    <div style={{position:"absolute",top:"60%"}}>
        <h4>Prototype Implementation.</h4><br/>
        No1<input id="i1" type="text"></input><br />
        No2<input id="i2" type="text"></input><br />
        Op<input id="op" type="text"></input><br />
        <button onClick={()=>activate()}>Click</button>
    </div>
)    
}

export default PrototypeExample