import React, { Component } from 'react';
import { Glyphicon, NavItem } from 'react-bootstrap';
import {Link} from "react-router-dom";

class Logout extends Component{
	constructor(){
		super();
		this.logout = this.logout.bind(this);
	}

	logout(){
		// event.preventDefault();
		// console.log("YO");
		localStorage.clear();
	}

	render(){
		return(
			<Link to="/" id="logout" onClick={this.logout} className="navbar-brand">
				<Glyphicon glyph="log-out"/> Logout
			</Link>
		)
	}
}

export default Logout;