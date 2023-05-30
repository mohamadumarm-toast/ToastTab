import React, { useState, ChangeEvent, FormEvent } from 'react';
import {Link, useNavigate} from 'react-router-dom'
import Navigation from './Navigation'
const Signup: React.FC = () => {
  const nav = useNavigate();
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
    const existingUsers = JSON.parse(localStorage.getItem('users')|| '[]');
    const newUser = {
      email: email,
      password: password,
    };

    const updatedUser = [...existingUsers, newUser];
    localStorage.setItem('users', JSON.stringify(updatedUser));

    setEmail('');
    setPassword('');

    nav("/Login")
  };

  return (
    <div>
      <Navigation/>
        <div className="container p-5">
        <form onSubmit={handleSubmit} className='container form-group border p-2' style={{width:'30%'}}>
          <h3>Signup</h3>
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
      <Link to="/Login">
        <a>Already having an account? Log in.</a>
      </Link>
      <br />
      <button type="submit" className="btn btn-primary">Signup</button>
    </form>
        </div>
    </div>
    
  );
};

export default Signup;
