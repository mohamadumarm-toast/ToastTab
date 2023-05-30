import React, { Component } from 'react'

class List extends Component {
  render() {
    const names = ['Manoj','Umar', 'Devi']
    const nameList = names.map(name => <h1>{name}</h1>)
    return (
      <div>
        {
            nameList
        }
      </div>
    )
  }
}

export default List
