import React, { Component } from 'react'
import Navigation from './Navigation'
export class Dashboard extends Component {
  render() {
    return (
      <div>
        <Navigation/>
         Hello! {localStorage.getItem('currentUser')}
      </div>
    )
  }
}

export default Dashboard
