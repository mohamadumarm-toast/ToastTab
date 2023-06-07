import React from 'react';
import logo from './logo.svg';
import './App.css';
import Navigation from './components/Navigation';
import Login from './components/Login';
import Signup from './components/Signup';
import { Routes, Route } from 'react-router-dom'
import Home from './components/Home';
import 'bootstrap/dist/css/bootstrap.css';
import Dashboard from './components/Dashboard';
function App() {
  return (
    <div className="App">
      
      <Routes>
        <Route path='/' element={<Home/>}></Route>
        <Route path='/Login' element={<Login/>}></Route>
        <Route path='/Signup' element={<Signup/>}></Route>
        <Route path='/Dashboard' element={<Dashboard/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
