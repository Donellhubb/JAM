import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';

class Review extends Component{
	constructor(){
		super();
		this.state={
		}
		this.getProducts = this.getProducts.bind(this);
 	}


 	getProducts(){
 		 // console.log(this.props.cabinet.data)
 		 let cabinets
 		 let doors
 		 let windows
 		if(this.props.cabinet.data != undefined){
 			// console.log("Yoo")
 			cabinets = this.props.cabinet.data.CabinetCreatedSuccessfully.map((data, index)=>{
 			// console.log(data.id);
 				return(
 					<h2> Type: {data.type}</h2>
 				)
 			})
 		}

 		if(this.props.door.data != undefined){
 			// console.log("YO")
 			doors = this.props.door.data.DoorCreatedSuccessfully.map((data, index)=>{
 			return(
 				<h2>Type: {data.id}</h2>
 			)
 		})

 		}

 		if(this.props.window.data != undefined){
 			windows = this.props.window.data.WindowCreatedSuccessfully.map((data, index)=>{
 				return(
 					<h2>Type: {data.type}</h2>
 					)
 			})
 		}
 		


 		// console.log(cabinets)
 		return(
 			<div>
 				<span> {cabinets}</span>
	 			<span> {doors} </span>
	 			<span> {windows} </span>
 			</div>
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