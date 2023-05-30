import React, { Component } from 'react'
class ClassClick extends Component {
    wish(){
        console.log("Happy B'day!")
    }
  render() {
    return (
      <div>
        <button onClick={this.wish}>Click me</button>
      </div>
    )
  }
}

export default ClassClick
