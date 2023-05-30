import React, { Component } from 'react'

class BindEvent extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         message: "Hello Mohamad Umar!"
      }
    // 3 this.boss = this.boss.bind(this) 
    }
    // 1,2,3 boss(){
    //     this.setState({
    //         message:"Hi Boss!"
    //     })
    // }

    // 4 boss = ()=>{
    //     this.setState({
    //         message:"Hi Boss!"
    //     })
    // }
    
  render() {
    return (
      <div>
        <h1>{this.state.message}</h1>
        {/*1 <button onClick = {this.boss.bind(this)}>
            Call me BOSS!
        </button> */}
        {/*2 <button onClick = {()=>this.boss()}>
            Call me BOSS!
        </button> */}
        {/*3 <button onClick = {this.boss}>
            Call me BOSS!
        </button> */}
        {/*4 <button onClick = {this.boss}>
            Call me BOSS!
        </button> */}
      </div>
    )
  }
}

export default BindEvent
