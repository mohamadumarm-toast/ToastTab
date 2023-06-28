import React from 'react'
import axios from 'axios'
export default function ApiButton() {
    
    function getCoaAccounts(): void {
        const token = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCIsImN0eSI6IkpXVCJ9.eyJ1c2VySWQiOiIxIiwidXNlclJvbGUiOiIxIiwidGVuYW50SWQiOiIxIiwibG9jYXRpb25JZCI6IjAiLCJ1c2VyR3VpZCI6IiIsInRlbmFudEd1aWQiOiIiLCJ0b2FzdFVzZXJHdWlkIjoiIiwiZXhwIjoxNjg2MzQ4OTYyLCJpc3MiOiJ4dHJhQ0hFRiBJbmMiLCJhdWQiOiJ4dHJhQ0hFRiBJbmMifQ.5h0BQQ8XlFP1GbfZHwj6UuOywqkJwVScCz_lZK98ZmQ'
        axios.get("https://localhost:61700/api/1.0/Books/get-coa-accounts",
        {
            headers: {
                Authorization: `Bearer ${token}`
            }
        })
        .then(response =>{
            console.log(response)
        })
        .catch(error => {
            console.log(error)
        })
    }

    return (
    <div>
      <button type = "button" onClick = {getCoaAccounts}>Click me</button>
    </div>
  )
}

