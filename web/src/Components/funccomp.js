import {useState} from 'react'
function FuncExample({hello}){
    const [count,setCount]=useState(0)
  function increment_count({hello}){
    setCount(count+1)
  }
  function decrement_count(){
    setCount(count-1)
  }
    return (
      <div style={{position:"absolute",right:"0px",top:"0px",width:"50%"}}>
        <h4>This is a Functionl Component. Props={hello}</h4><br/>
          <button onClick={increment_count}>Increment</button>
          <button onClick={decrement_count}>Decrement</button><br/>
          <div style={{backgroundColor:"purple",color:"yellow"}}>{count}</div>
      </div>
    )
  }
  export default FuncExample