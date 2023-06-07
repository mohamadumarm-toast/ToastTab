import React,{useState} from "react";

function Square({value, squareClick}:any) {
  // const [value, setValue] = useState('');
  // function handleClick() {
  //   console.log("Button clicked!");
  //   setValue('X')
  // }
  return (
    <>
      <button className="square" onClick={squareClick} style={{width:60,height:60, verticalAlign:"top", backgroundColor:"white", border: "1px solid"}}>
        {value}
      </button>
    </>
  );
}

export default Square;
