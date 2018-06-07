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
				token: this.state.token,
				job_id: this.props.match.params.job_id
			}
		});

		getCustomerJob.then((data)=>{
			this.setState({
				jobs: data.data.job,
				customer: data.data.customer
			})
		})
	}


	render(){
		console.log(this.props.match.params.job_id)
		return(
			<div className='container'>
				Amos is a b*****
			</div>

		)
	}
}

export default SingleJob;