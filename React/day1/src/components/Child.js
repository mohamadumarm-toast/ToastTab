import React from 'react'

export default function Child(props) {
  return (
    <div>
      {/* <button onClick={props.do}>Click</button> */}
      <button onClick={()=>props.do("C1")}>Click</button>
    </div>
  )
}
