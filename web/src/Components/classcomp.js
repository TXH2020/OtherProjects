import React from 'react'
class ClassExample extends React.Component{
    constructor(){
        super();
        this.state={count:0}
      }
      increment_count=()=>{this.setState({count:this.state.count+1})}
      decrement_count=()=>{this.setState({count:this.state.count-1})}
    render(){
        return (
            <div style={{position:"absolute",left:"0px",top:"0px",width:"50%"}}>
                <h4>This is a Class Component. Props={this.props.hello}</h4><br/>
                <button onClick={this.increment_count}>Increment</button>
                <button onClick={this.decrement_count}>Decrement</button><br/>
                <div style={{backgroundColor:"blue",color:"yellow"}}>{this.state.count}</div>
            </div>
        )
    }
}
export default ClassExample