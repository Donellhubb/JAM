import React, {Component} from 'react';
import {BrowserRouter, Route, Link, NavLink, Switch, Redirect } from 'react-router-dom'
import axios from 'axios';
import url from '../url';
import '../style.css';

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
          console.log("LoginSuccessful");
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
    <div className="container bg">
			
				
				<form onSubmit={this.handleLogin} className="loginform">
					<div>
					<h1> Login </h1>
							<div className="form-group email login-space">
								<label htmlFor="email">Email address:</label>
								<input type="email" className="form-control input-width" id="email" placeholder="example@gmail.com"/>
							</div>
							<div className="form-group login-space">
								<label htmlFor="pwd" >Password:</label>
								<input type="password" className="form-control input-width1" id="pwd" placeholder="Password"/>
							</div>
						
							<button type="submit" className="btn btn-primary login-space">Submit</button><br/>
							{/* <p className = "login-space">If you are a new user please register</p> */}
							<NavLink to="/register">New User</NavLink><br/>
					</div>
				</form>	
	 </div>
    ) 
  }
}

export default Login;