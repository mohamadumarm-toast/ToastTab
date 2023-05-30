import React, { useState, ChangeEvent, FormEvent } from 'react';
import {Link, useNavigate} from 'react-router-dom'
import Navigation from './Navigation';

const Login: React.FC = () => {
  let nav = useNavigate();
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleEmailChange = (e: ChangeEvent<HTMLInputElement>) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e: ChangeEvent<HTMLInputElement>) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();
    const keyUser = {
      email: email,
      password: password
    }
    const existingUsers = JSON.parse(localStorage.getItem('users')|| '[]');
    
    const isvalid = existingUsers.some((e: { email: string; password: string; }) => {
      if(e.email == keyUser.email && e.password == keyUser.password){
        return true;
      }
      return false;
    })

    if(isvalid){
      localStorage.setItem('currentUser', email);
      nav('/Dashboard');
      window.location.reload();
    }
    else{
      alert("Invalid Username or Password!")
    }

  };

  return (
    <div>
      <Navigation/>
        <div className="container p-5">
        <form onSubmit={handleSubmit} className='container form-group border p-2' style={{width:'30%'}}>
        <h3>Login</h3>
      <div className="mb-3">
        <label htmlFor="email" className="form-label">Email</label>
        <input
          type="email"
          className="form-control"
          id="email"
          value={email}
          onChange={handleEmailChange}
          placeholder='Enter your email'
          required
        />
      </div>
      <div className="mb-3">
        <label htmlFor="password" className="form-label">Password</label>
        <input
          type="password"
          className="form-control"
          id="password"
          value={password}
          onChange={handlePasswordChange}
          placeholder='Enter your password'
          required
        />
      </div>
      <Link to="/Signup">
        <a>Create an account</a>
      </Link>
      <br />
      <button type="submit" className="btn btn-primary">Login</button>
    </form>
        </div>
    </div>
    
  );
};

export default Login;
