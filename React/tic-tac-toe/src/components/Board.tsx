import React from 'react'
import Square from './Square'

function Board({takeTurns, squares, onPlay}:any) {

  // function restart(){
  //   setSquares(Array(9).fill(null))
  //   setTakeTurns(true)
  //   winner = null;
  // }
  function calculateWinner(squares:any) {
    const lines = [
      [0, 1, 2],
      [3, 4, 5],
      [6, 7, 8],
      [0, 3, 6],
      [1, 4, 7],
      [2, 5, 8],
      [0, 4, 8],
      [2, 4, 6]
    ];
    for (let i = 0; i < lines.length; i++) {
      const [a, b, c] = lines[i];
      if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
        return squares[a];
      }
    }
    return null;
  }

  function handleClick(i:number){
    if(squares[i]!=null || calculateWinner(squares))
      return;
    const squareCopy = squares.slice()
    takeTurns?squareCopy[i] = 'X':squareCopy[i] = 'O'
    onPlay(squareCopy)
  }
  let winner = calculateWinner(squares)
  let status;
  if(winner){
    status = 'Winner:' + winner;
  }
  else{
    status = "Next Turn : " + (takeTurns?'X':'O')
  }
  return (
    <div>
      <div>{status}</div>
      <div className='board-row'>
        <Square value={squares[0]} squareClick={() => handleClick(0)}/>
        <Square value={squares[1]} squareClick={() => handleClick(1)}/>
        <Square value={squares[2]} squareClick={() => handleClick(2)}/>
      </div>
      <div className='board-row'>
        <Square value={squares[3]} squareClick={() => handleClick(3)}/>
        <Square value={squares[4]} squareClick={() => handleClick(4)}/>
        <Square value={squares[5]} squareClick={() => handleClick(5)}/>
      </div>
      <div className='board-row'>
        <Square value={squares[6]} squareClick={() => handleClick(6)}/>
        <Square value={squares[7]} squareClick={() => handleClick(7)}/>
        <Square value={squares[8]} squareClick={() => handleClick(8)}/>
      </div>
      {/* <button onClick={restart}>RESTART</button> */}
    </div>
  )
}

export default Board
