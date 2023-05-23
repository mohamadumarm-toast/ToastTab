import React, { Component } from 'react'

class State extends Component {
    constructor(props) {
      super(props)
    
      this.state = {
         like:0
      }
    }
    like5(){
        this.like();
        this.like();
        this.like();
        this.like();
        this.like();
    }
    like(){
        this.setState((prev)=>(
            {
                like: prev.like+1
            }
        )
        )
    }
    disLike(){
        this.setState((prev)=>(
            {
                like: prev.like - 1
            }
        )
        )
    }
  render() {
    return (
      <div>
        <p>Likes: {this.state.like}</p>
        <button onClick={()=>this.like5()}>Like5</button>
        <button onClick={()=>this.disLike()}>disLike</button>
      </div>
    )
  }
}

export default State
