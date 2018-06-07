import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import '../index.css';

class Login extends Component{
  constructor(){
    super();
    this.handleLogin = this.handleLogin.bind(this);
    this.state ={
      message: ""
    }
  }


  handleLogin(event){
  	event.preventDefault();

  	const email = document.getElementById('email').value;
  	const password = document.getElementById('pwd').value;

  	const loginRequest = axios({
  		method: "POST",
  		url: url.url + "login",
  		data:{
  			email,
  			password
  		}
  	})

  	loginRequest.then((userData)=>{
  		// console.log("yo");
  		if(userData.data.msg === "LoginSuccessful" ){
  		    localStorage.setItem('token',userData.data.token)
  		    this.props.history.push('/jobs')
          // console.log(localStorage.token)
  		} 
  		// else {

  		// }
  	})
  }


  render(){
    // console.log(url.url)
  	// JSX DEMANDS all self-closing tags, be closed with a /
    return(
    <div className="container">
      <h1> Login </h1>
  		<form onSubmit={this.handleLogin} className="loginform">
  		  <div className="form-group ">
  		    <label htmlFor="email">Email address:</label>
  		    <input type="email" className="form-control" id="email" placeholder="example@gmail.com"/>
  		  </div>
  		  <div className="form-group">
  		    <label htmlFor="pwd" >Password:</label>
  		    <input type="password" className="form-control" id="pwd" placeholder="Password"/>
  		  </div>
  		  
  		  <button type="submit" className="btn btn-default">Submit</button>
  		</form>
	 </div>
    ) 
  }
}

export default Login;