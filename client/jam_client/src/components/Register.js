import React, {Component} from 'react';
import axios from 'axios';

class Register extends Component{
  constructor(){
    super();
    this.handleRegister = this.handleRegister.bind(this);
  }


  handleRegister(event){
    event.preventDefault();
    // axios is how we make our AJAX requests
    // in other words, how React talks to Express/Spring
    const email = document.getElementById('email').value;
    const password = document.getElementById('pwd').value;
    // console.log(password);
    // console.log(email);
    const registerRequest = axios({
      method: "POST",
      url: "http://localhost:8080/register",
      data: {
        email,
        password
      }
    });

    registerRequest.then((registerData)=>{
      console.log(registerData)
      if(registerData.data.msg === "registerSuccess"){

        localStorage.setItem('token',registerData.data.token)
        this.props.history.push('/')
      }
    })

  }

  render(){
    // JSX DEMANDS all self-closing tags, be closed with a /
    return(
    <div className="container">
    <h1>Register</h1>
      <form onSubmit={this.handleRegister} className="login-form">
        <div className="form-group">
          <label htmlFor="first-name">First Name:</label>
          <input type="text" className="form-control" id="name" placeholder="First Name" />
        </div>
        <div className="form-group">
          <label htmlFor="last-name">Last Name:</label>
          <input type="text" className="form-control" id="name" placeholder="Last Name" />
        </div>
        <div className="form-group">
          <label htmlFor="email">Email address:</label>
          <input type="email" className="form-control" id="email" placeholder="example@gmail.com"/>
        </div>
        <div className="form-group">
          <label htmlFor="pwd">Password:</label>
          <input type="password" className="form-control" id="pwd" placeholder="Password" />
        </div>
        <button type="submit" className="btn btn-default">Register</button>
      </form>
    </div>
    ) 
  }
}

export default Register;