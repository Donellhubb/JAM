import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {Link} from 'react-router-dom';

class Jobs extends Component{
	constructor(){
		super();
		this.state={
			jobs: [""],
			token: localStorage.getItem('token')
		}
	}

	componentDidMount(){
		const getToken = axios({
			method: "POST",
			url: url.url + "jobs",
			data:{
				token: this.state.token
			}
		});

		getToken.then((jobData)=>{
			// console.log("are there jobss",jobData.data);
			this.setState({
				jobs: jobData.data
			})
		})
	}



	render(){
		const jobs = this.state.jobs.map((data, index)=>{
			return(
				<li>
					<div className="jumbotron">
						<Link to={`/job/${data.id}`} >
							<h2> Job# {data.id} </h2>
							<hr />
							<h4> Time: {data.time} </h4>
							<h4> Description: {data.description} </h4>
						</Link>
					</div>
				</li>
			)
		})
		
		return(
			<div className="container">
				<ul className="jobs-list">
					{jobs}
				</ul>
			</div>
		)
	}


} 

export default Jobs;