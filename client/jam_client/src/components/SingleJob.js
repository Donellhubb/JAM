import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import Door from './Door';
import Window from './Window';
import Cabinet from './Cabinet';
import Review from './Review';
import { Tabs, Tab } from 'react-bootstrap';

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
			// console.log(data);
			this.setState({
				job: data.data,
				customer: data.data.customer
			})
			// console.log(this.state.job);
			// console.log(this.state.customer)
		})
	}

	render(){

		// console.log(this.state.job.id)
		const loggedIn= localStorage.token;
		// console.log(loggedIn)
		return(
			<div className='container'>
					{loggedIn == undefined
						?
						
						<h1>Must be logged in</h1>
						:
						<div>	
							<div className="modal-body row">
								<div className="col-md-6" id="customer_info">
									<h2>Job#: {this.state.job.id}</h2>
									<hr />
									<h4>Name: {this.state.customer.first_name} {this.state.customer.last_name}</h4>
									<h4>Address: {this.state.customer.address}</h4>
									<h4>Phone: {this.state.customer.phone}</h4>
									<h4>Email: {this.state.customer.email}</h4>
								</div>
							</div>

							<Tabs defaultActiveKey={1} id="tab_form">
								<Tab eventKey={1} title="Door">
									<Door job_id={this.state.job}/>
								</Tab>
								<Tab eventKey={2} title="Window">
									<Window />
								</Tab>
								<Tab eventKey={3} title="Cabinet">
									<Cabinet />
								</Tab>
								<Tab eventKey={4} title="Review/Edit">
									<Review />
								</Tab>
							</Tabs>
						</div>
					}
				</div>
		)
	}
}

export default SingleJob;