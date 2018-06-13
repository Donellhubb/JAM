import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {FormGroup, ControlLabel, FormControl, Button} from 'react-bootstrap';

class CabinetEdit extends Component{

  constructor(){
		super();
		this.state={
			cabinet: {},
			job: {}
		}
		this.handleSubmit = this.handleSubmit.bind(this)
  }
  
  componentDidMount(){
		this.setState({
			cabinet: this.props.cabinet,
			job: this.props.cabinet.job,
    })
  }

  handleSubmit(event){
		event.preventDefault();
		// console.log(this.props.index)
		const job = this.state.job;
		const type = document.getElementById(`type${this.props.index}`).value;
		const color = document.getElementById(`color${this.props.index}`).value;
		const height = document.getElementById(`height${this.props.index}`).value;
		const width = document.getElementById(`width${this.props.index}`).value;
    const quantity = document.getElementById(`quantity${this.props.index}`).value;
    const hinges = document.getElementById(`hinges${this.props.index}`).value;
    const screws = document.getElementById(`screws${this.props.index}`).value;
    
    const updateCabinet = axios({
			method: "POST",
			url: url.url + "edit/cabinet",
			data:{
				job,
        type,
        color,
        height,
        width,
        quantity,
        hinges,
        screws
			}
		});
  }

  render(){
    return(

      <span>
				<span data-toggle="modal" data-target={`#myModal${this.props.index}`}>
					<Glyphicon glyph="edit" /> 
			  </span>

        <div className="modal fade" id={`myModal${this.props.index}`} role="dialog">
				    <div className="modal-dialog modal-md">
				      <div className="modal-content">
				        <div className="modal-header">
				          <button type="button" className="close" data-dismiss="modal">&times;</button>
				         	<h2 className="modal-title">Job#: {this.state.job.id}</h2>
				        </div>
				        <div className="modal-body"> 

                <form onSubmit={this.handleSubmit}>
				                <div className="col-md-12">
				              <FormGroup controlId="formControlsSelect">
				                  <ControlLabel>Cabinet Type</ControlLabel>
				                    <FormControl componentClass="select" id={`type${this.props.index}`} bsSize="large">
				                      <option value="" selected disabled>{this.state.cabinet.type}</option>
				                      <option value="Fiber Glass">Fiber Glass</option>
				                      <option value="Wood">Wood</option>
                              <option value="Steel">Steel</option>
				                    </FormControl>
				                </FormGroup>

                        <div className="modal-body row">
				                  <div className="col-md-4">
				                      <FormGroup bsSize="large">
				                        <ControlLabel>Color</ControlLabel>
				                      <FormControl componentClass="select" placeholder={`${this.state.cabinet.color}`} id={`color${this.props.index}`}>
				                        <option value="Black">Black</option>
				                        <option value="White">White</option>
				                        <option value="Blue">Blue</option>
				                        <option value="Silver">Silver</option>
				                        </FormControl>
				                    </FormGroup>
				                  </div>
				                  <div className="col-md-4">
				                    <FormGroup bsSize="large">
				                        <ControlLabel>Height (in.)</ControlLabel>
				                      <FormControl type="number" placeholder="0" id={`height${this.props.index}`} min="0" />
				                    </FormGroup>
				                  </div>
				                  <div className="col-md-4">
				                    <FormGroup bsSize="large">
				                        <ControlLabel>Width (in.)</ControlLabel>
				                      <FormControl type="number" placeholder="0" id={`width${this.props.index}`} min="0" />
				                    </FormGroup>
				                  </div>
                          <div className="col-md-4">
				                    <FormGroup bsSize="large">
				                        <ControlLabel>Hinges</ControlLabel>
				                      <FormControl type="number" placeholder="0" id={`width${this.props.index}`} min="0" />
				                    </FormGroup>
				                  </div>
                          <div className="col-md-4">
				                    <FormGroup bsSize="large">
				                        <ControlLabel>Screws</ControlLabel>
				                      <FormControl type="number" placeholder="0" id={`width${this.props.index}`} min="0" />
				                    </FormGroup>
				                  </div>
				                </div>
				                
				                <div className="modal-body row">
				                  <div className="col-md-4">
				                      <FormGroup bsSize="large">
				                        <ControlLabel>Quantity</ControlLabel>
				                      <FormControl type="number" placeholder="0" id={`quantity${this.props.index}`} min="1" />
				                    </FormGroup>
				                  </div>
				                  <Button type="submit">Submit</Button>
				                </div>
				              </div>
				            </form>
				        </div>
				        <div className="modal-footer">
				          <button type="button" className="btn btn-default" data-dismiss="modal">Close</button>
				        </div>
				      </div>
				    </div>
				  </div>
			</span>
    )
  }
  
  
}
export default CabinetEdit;