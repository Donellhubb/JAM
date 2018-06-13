import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {Link} from 'react-router-dom';
import SingleJob from './SingleJob';

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
			 // console.log(jobData.data[0].customer.id)
			this.setState({
				jobs: jobData.data
			})
		})
	}



	render(){
		// col-lg-2 col-md-2 col-xl-12 col-sm-4 
		// console.log(this.state.jobs)
		const jobs = this.state.jobs.map((data, index)=>{
			return(
				<li>
					<div className="container">
						<div className="row justify-content-md-center">
							<div className="jumbotron col-md-6 col-md-offset-3 col-sm-4 col-sm-offset-4 col-xs-6 col-xs-offset-3">
								<Link to={`/job/${data.id}`} >
									<h2> Job# {data.id} </h2>
									<hr />
									<h4> Time: {data.time} </h4>
									<h4> Description: {data.description} </h4>
								</Link>
							</div>
						</div>
					</div>
				</li>
			)
		})
		
		return(
			<div className="container2">
				<div className="jobs-list">
					{jobs}
				</div>
			</div>
		)
	}
} 

export default Jobs;