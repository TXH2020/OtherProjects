import ClassExample from "./Components/classcomp";
import FuncExample from "./Components/funccomp";
import ClosureExample from "./Components/closure";
import NodeFrontend from "./Components/nodeserverfront";
import PrototypeExample from "./Components/prototype";
function App() {
  return (
    <div className="App">
      <ClassExample hello='hi'></ClassExample><br />
      <FuncExample hello="hey"></FuncExample>
      <ClosureExample></ClosureExample>
      <NodeFrontend></NodeFrontend>
      <PrototypeExample></PrototypeExample>
    </div>
  );
}

export default App;
