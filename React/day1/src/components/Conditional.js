import React, { Component } from 'react'

export class Conditional extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         flag : false
      }
    }
    
  render() {
    // let message
    // if(this.state.flag){
    //     message = <h1>Hello!</h1>
    // }
    // else{
    //     message = <h1>hii!</h1>
    // }
    // return(
    //     <div>{message}</div>
    // )
    return(
        this.state.flag?
        <div>Helloo!</div>:
        <div>Hii</div>
    )
  }
}

export default Conditional
