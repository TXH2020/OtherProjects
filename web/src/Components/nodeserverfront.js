function NodeFrontend(){
    return (
        <div style={{position:"absolute",top:"35%"}}>
            <form action="http://localhost:5000/getData" method="get">
                GET<br/ >
            Enter name here:<input type="text" name="name" /><br />
            Enter age here:<input type="text" name="age" /><br />
            <input type="submit" />
            </form>
            <form action="http://localhost:5000/getData" method="post">
                POST<br/ >
            Enter name here:<input type="text" name="name" /><br />
            Enter age here:<input type="text" name="age" /><br />
            <input type="submit" />
            </form>
        </div>
    )
}

export default NodeFrontend