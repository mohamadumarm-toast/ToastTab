import logo from './logo.svg';
import './App.css';
import Func from './components/FunctionalComponent'
import Class1 from './components/ClassComponent'; 
import Greet from './components/Prop';
import State from './components/State';
function App() {
  return (
    <div className="App">
      {/* <Func />
      <Class1 />
      <Greet name="Manoj" age="21">
          React Dev
      </Greet>
      <Greet name="Md" age="20">
          Full Stack
      </Greet>
      <Greet name="Kaus" age="23">
          Game Dev
      </Greet> */}
      <State></State>
    </div>
  );
}

export default App;
