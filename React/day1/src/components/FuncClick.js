import React from 'react'

function FuncClick() {
    function wish(){
        console.log("Working!");
    }
  return (
    <div>
      <button onClick={wish}>Click!</button>
    </div>
  )
}

export default FuncClick
