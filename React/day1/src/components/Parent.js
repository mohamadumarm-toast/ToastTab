import React, { Component } from 'react'
import Child from './Child'

class Parent extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         parentName: "P1"
      }
      this.greetParent = this.greetParent.bind(this) //do this whenever u have a function that uses this.state.... to prevent this undefined error
    }
    greetParent(childName){
        alert('Hello '+this.state.parentName+" by "+childName)
    }
  render() {
    return (
      <div>
        <Child do={this.greetParent}></Child>
      </div>
    )
  }
}

export default Parent
