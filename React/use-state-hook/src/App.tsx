import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  const [count, setCount] = useState(0);
  function decrement(){
    setCount(prev => prev - 1)
  }
  function increment(){
    setCount(prev => prev + 1)
  }
  return (
    <>
    <h1>useState() hooks</h1>
    <button onClick={decrement}>-</button>
    <span>{count}</span>
    <button onClick={increment}>+</button>
    </>
  );
}

export default App;
