import React, { useState } from 'react'
import Board from './Board'

function Game() {
    const [takeTurns, setTakeTurns] = useState(true)
    const [history, setHistory] = useState([Array(9).fill(null)])
    const [currMove, setCurrMove] = useState(0);
    const currentBoard = history[currMove]

    function handlePlay(nextSquare:any){
        const nextHistory = ([...history.slice(0,currMove+1), nextSquare])
        setHistory(nextHistory);
        setTakeTurns(!takeTurns);
        setCurrMove(nextHistory.length - 1)
    }

    function jumpTo(nextMove:number){
        setCurrMove(nextMove);
        setTakeTurns(nextMove % 2 === 0)
    }
    const moves = history.map((squares, move)=>{
        let desc;
        if(move>0){
            desc = 'GO TO MOVE #'+move;
        }
        else{
            desc = 'GO TO START..'
        }
        return(
            <li key={move}>
                <button onClick={()=>jumpTo(move)}>{desc}</button>
            </li>
        );
    })
  return (
    <div className='game'>
        <div className="game-board">
            <Board takeTurns = {takeTurns} onPlay = {handlePlay} squares = {currentBoard}/>
        </div>
        <div className="game-info">
            {moves}
        </div>
      
    </div>
  )
}

export default Game
