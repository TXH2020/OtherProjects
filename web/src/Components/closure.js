function activate(a,b){
function outer(a,b){
    var c='hi'
    function inner(d){
        alert('Local variable of inner='+d+"Closure over outer function variables="+a+b+c)
    }
    return inner
}
var g=outer(a,b)
g('the')
}
function ClosureExample(){
return (
    <div style={{position:"absolute",top:"15%"}}>
        <h4>Closure Implementation. Click on the button below</h4><br/>
        <button onClick={()=>activate('a','b')}>Click</button>
    </div>
)    
}

export default ClosureExample