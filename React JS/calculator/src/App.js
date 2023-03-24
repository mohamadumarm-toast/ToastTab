
import './App.css';
import Calc from './Calc'
import SciCalc from './SciCalc'
import { useState } from 'react';

function App() {
  const[show, setShow] = useState(true);

  const toggle = () =>{
    setShow(!show)
  }
  return (
    <div>
        <div>
          <button onClick={toggle}>Change</button>
          {show? <Calc /> : <SciCalc />}
        </div>
    </div>
  );
}

export default App;
