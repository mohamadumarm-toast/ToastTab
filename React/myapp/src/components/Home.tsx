import React, { Component } from 'react'
import Navigation from './Navigation'

export class Home extends Component {
  render() {
    return (
      <div>
        <Navigation/>
        <h2 className='display-4 my-5'>
            We Don't Pray For Love,<br/>
            We Just Pray For Cars.
        </h2>
        <img className='img-fluid rounded' src='https://wallpaperaccess.com/full/271399.jpg' />
      </div>
    )
  }
}

export default Home
