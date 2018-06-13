import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {Table} from 'react-bootstrap';
import WindowEdit from './WindowEdit';
import DoorEdit from './DoorEdit';
import CabinetEdit from './CabinetEdit';


class Review extends Component{
	constructor(){
		super();
		this.state={
		}
		this.getProducts = this.getProducts.bind(this);
		// this.handleWindowEdit = this.handleWindowEdit.bind(this);
 	}


 	getProducts(){
 		 // console.log(this.props.cabinet.data)
 		 let cabinets
 		 let doors
 		 let windows
 		if(this.props.cabinet.data != undefined){
 			// console.log("Yoo")
 			cabinets = this.props.cabinet.data.CabinetCreatedSuccessfully.map((data, index)=>{
			// console.log(this.props.cabinet.data.CabinetCreatedSuccessfully) 		
 			// console.log(index);
 				return(
					<tr>
						<td>{data.type}</td>
						<td>{data.color}</td>
						<td>{data.height}</td>
						<td>{data.width}</td>
						<td>{data.quantity}</td>
						<td>{data.hinges}</td>
						<td>{data.screws}</td>
					</tr>
 				)
 			});
 		}


 		if(this.props.door.data != undefined){
 			// console.log("YO")
 			doors = this.props.door.data.DoorCreatedSuccessfully.map((data, index)=>{
 			return(
 				<tr>
					<td>{data.type}</td>
					<td>{data.color}</td>
					<td>{data.height}</td>
					<td>{data.width}</td>
					<td>{data.quantity}</td>
					<td>{data.hinges}</td>
					<td>{data.screws}</td>
				</tr>
 			)
 		})

 		}

 		if(this.props.window.data != undefined){
 			// this.handleWindowEdit()
 			windows = this.props.window.data.WindowCreatedSuccessfully.map((data, index)=>{

 				console.log(index)
 				return(
	 				<tr key = {index} className='windowList'>
						<td>{data.type}</td>
						<td>{data.color}</td>
						<td>{data.height}</td>
						<td>{data.width}</td>
						<td>{data.quantity}</td>
						<td>
							<WindowEdit index={index} window={data} />
       					</td>		
					</tr>
 				)
 			})
 		}
 		// console.log(cabinets)
 		return(
 			<div>
 				{cabinets != undefined
 					?
 					<div>
	 					<h3> Cabinets </h3>
	 					<Table>
	 						<thead>
	 							{this.cabinetHeaders()}
	 						</thead>
	 						<tbody>
	 							{cabinets}
	 						</tbody>
	 					</Table>
	 				</div>
	 				:
	 				<span></span>
	 			}
	 			{doors != undefined
 					?
 					<div>
	 					<h3> Doors </h3>
	 					<Table>
	 						<thead>
	 							{this.cabinetHeaders()}
	 						</thead>
	 						<tbody>
	 							{doors}
	 						</tbody>
	 					</Table>
	 				</div>
	 				:
	 				<span></span>
	 			}
	 			{windows != undefined
 					?
 					<div>
	 					<h3> Windows </h3>
	 					<Table>
	 						<thead>
	 							{this.windowHeaders()}
	 						</thead>
	 						<tbody>
	 							{windows}
	 						</tbody>
	 					</Table>
	 				</div>
	 				:
	 				<span></span>
	 			}
 			</div>
 		)
  	}

  // 	handleWindowEdit(){
  // 		let edit = document.getElementsByClassName('edit-btn');
  // 		// console.log("YOYOYO")
  // 		for(let i=0; i < edit.length; i++){
		// 	edit[i].addEventListener('click', function(){

		// 	})
		// }
  // 		// event.preventDefault();
  // 		// document.getElementsBy('')

  // 	}
	
	windowHeaders(){
		return(
		<tr>
			<th className='text-center' width='200'>Type</th>
			<th className='text-center' width='200'>Color</th>
			<th className='text-center' width='200'>Height</th>
			<th className='text-center' width='200'>Width</th>
			<th className='text-center' width='200'>Quantity</th>
		</tr>
		)
	}

	cabinetHeaders(){
		return(
		<tr>
			<th className='text-center' width='200'>Type</th>
			<th className='text-center' width='200'>Color</th>
			<th className='text-center' width='200'>Height</th>
			<th className='text-center' width='200'>Width</th>
			<th className='text-center' width='200'>Quantity</th>
			<th className='text-center' width='200'>Hinges</th>
			<th className='text-center' width='200'>Screws</th>
		</tr>
		)
	}

	render(){

		// console.log(this.state.cabinets)
		// let cabinets = ""

		// if(this.props.cabinet.length > 0){
		// 	cabinets = this.props.cabinet.data.CabinetCreatedSuccessfully.map((data, index)=>{
		// 			<h2> Type: {data.type} </h2> 
		// 	})
		// }

		// if (this.props.cabinet.data == undefined){
		// 	console.log(this.props.cabinet.length == 0 && this.props.window.length == 0 && this.props.door.length == 0)
		// }
		// else {
		// 	console.log(this.props.cabinet.data.CabinetCreatedSuccessfully[0].type)
		// }

		return(
			<div className="container">
				{ this.props.cabinet.length == 0 && this.props.window.length == 0 && this.props.door.length == 0
					?
					<h1>Nothing to review</h1>
					:
					<div className="container">
						{this.getProducts()}
					</div>
				}
				
			</div>
		)
	}
}

export default Review;