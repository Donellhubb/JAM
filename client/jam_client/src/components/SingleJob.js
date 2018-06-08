import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';

class SingleJob extends Component{
	constructor(){
		super();
		this.state={
			token: localStorage.getItem('token'),
			job:{},
			customer:{}
		}
	}



	componentDidMount(){
		const getCustomerJob = axios({
			method: "POST",
			url: url.url + "customer",
			data:{
				id: this.props.match.params.job_id
			}
		});

		getCustomerJob.then((data)=>{
			console.log(data);
			this.setState({
				job: data.data,
				customer: data.data.customer
			})
		})
	}


	render(){

		// console.log(this.state.job.description)
		const loggedIn= localStorage.token;
		// console.log(this.props)
		// console.log(loggedIn)

		return(
			<div className='container'>
				{loggedIn == undefined
					?
					<h1>Amos is a b*****</h1>
					:
					<h1>WE In HERE</h1>
				}
			</div>
		)
	}
}

export default SingleJob;