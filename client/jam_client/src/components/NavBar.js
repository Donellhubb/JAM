import React, {Component} from 'react';
import {Link} from "react-router-dom";

class NavBar extends Component{
	render(){
		return(
			<div>
				<nav className="navbar navbar-inverse myNavBar">
					<div className="container-fluid">
						<div className="navbar-header">
							<Link to="/" className="navbar-brand">JAM</Link>
						</div>
					</div>
				</nav>			
			</div>
			)
	}
}

export default NavBar;