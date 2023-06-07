import React, { Component } from 'react'
import {Link, useNavigate} from 'react-router-dom'
import Login from './Login';
class Navigation extends Component {
    
    
    Logout(){
        // let nav = useNavigate();
        localStorage.removeItem("currentUser");
        window.location.href = "http://localhost:3000/"
    }
  render() {
    if(localStorage.getItem('currentUser')=== null)
    return ( 
        <div>
            <div className='container-fluid' style={{backgroundColor: '#ffcc99' }}>
                <>
                    <link rel="preconnect" href="https://fonts.googleapis.com" />
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossOrigin="" />
                    <link
                        href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap"
                        rel="stylesheet"
                    />
                </>

                <nav className="navbar navbar-light navbar-expand">
                    <a className="navbar-brand fw-bold fs-4" style={{fontFamily: "'Poppins', sans-serif"}} href="#">
                    <img className='mx-1' src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/BMW_logo_%28gray%29.svg/2048px-BMW_logo_%28gray%29.svg.png' width={40} height={40} />           
                    BMW
                    </a>
                    <ul className="navbar-nav px-3">
                        <li className="nav-item">
                            <a href="/" className="nav-link fw-bold">Home</a>
                        </li>
                        <li className="nav-item">
                            <a href="#" className="nav-link fw-bold">About</a>
                        </li>
                        <li className="nav-item">
                            <a href="#" className="nav-link fw-bold">Contact</a>
                        </li>
                    </ul>
                    <div className="container-fluid d-flex justify-content-end">
                        <Link to="/Login">
                            <button className="btn  btn-outline-dark mx-2" type="button">Login</button>
                        </Link>
                        <Link to="/Signup">
                            <button className="btn btn-dark" type="button">Signup</button>
                        </Link>
                    </div>
                </nav>
            </div>
        </div>
    )
    else{
        return(
            <div>
                <div className='container-fluid' style={{backgroundColor: '#ffcc99' }}>
                <>
                    <link rel="preconnect" href="https://fonts.googleapis.com" />
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossOrigin="" />
                    <link
                        href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap"
                        rel="stylesheet"
                    />
                </>

                <nav className="navbar navbar-light navbar-expand">
                    <a className="navbar-brand fw-bold fs-4" style={{fontFamily: "'Poppins', sans-serif"}} href="#">
                    <img className='mx-1' src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/BMW_logo_%28gray%29.svg/2048px-BMW_logo_%28gray%29.svg.png' width={40} height={40} />           
                    BMW
                    </a>
                    <ul className="navbar-nav px-3">
                        <li className="nav-item">
                            <a href="/" className="nav-link fw-bold">Home</a>
                        </li>
                        <li className="nav-item">
                            <a href="#" className="nav-link fw-bold">About</a>
                        </li>
                        <li className="nav-item">
                            <a href="#" className="nav-link fw-bold">Contact</a>
                        </li>
                    </ul>
                    <div className="container-fluid d-flex justify-content-end">
                            <button className="btn  btn-outline-dark mx-2" type="button" onClick={this.Logout}>Logout</button>
                    </div>
                </nav>
            </div>
            </div>
        )
    }
  }
}

export default Navigation
