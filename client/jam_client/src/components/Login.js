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
<<<<<<< Updated upstream
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
=======
		<div>
		<div className="bgbody"></div>
    <div className="container" >
			
				<form onSubmit={this.handleLogin} className="loginform loginRegisterWindow">
					<div>
					<h1 className="loginRegisterH1"> Login </h1>
							<div className="form-group email login-space">
								<label htmlFor="email" className="loginRegisterLabel">Email address:</label>
								<input type="email" className="loginInput" id="email" placeholder="example@gmail.com"/>
							</div>
							<div className="form-group login-space">
								<label htmlFor="pwd" className="loginRegisterLabel">Password:</label>
								<input type="password" className="loginInput" id="pwd" placeholder="Password"/>
							</div>
						
							<button type="submit" className="btn btn-primary login-space">Submit</button><br/>
						
							<div className="newUser">
								<NavLink to="/register">New User</NavLink><br/>
							</div>
					</div>
				</form>	
>>>>>>> Stashed changes
	 </div>
	 </div>
	 
    ) 
  }
}

export default Login;