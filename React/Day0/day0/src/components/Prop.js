import React,{Component} from "react";

// function Greet(props){
//     return(
//         <div>
//             <h1>Hi {props.name}, I am {props.age} years old</h1>
//             {props.children}
//         </div>
//     )
// }
class Greet extends Component{
    render(){
        return(
            <div>
                <h1>Hi {this.props.name}, I am {this.props.age} years old</h1>
                {this.props.children}
            </div>
        )
    }
}
export default Greet