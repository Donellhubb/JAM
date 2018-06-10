import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {FormGroup, ControlLabel, FormControl, NumericInput} from 'react-bootstrap';

class Cabinet extends Component{
  constructor(){
    super();
    this.state={
      cabinet: []
    }
  }

  componentDidMount(){
    document.getElementById('cabinet_quantity').setAttribute("value", "1");
    document.getElementById('cabinet_hinges').setAttribute("value", "2");
    document.getElementById('cabinet_screws').setAttribute("value", "8");
  }

  handleQuantity(){
    let quantity = document.getElementById('cabinet_quantity');
    let hinges = document.getElementById('cabinet_hinges');
    let screws = document.getElementById('cabinet_screws');
    const numHinges = (quantity.value * 2);
    hinges.setAttribute("value", numHinges);
    const numScrews = (numHinges * 4);
    screws.setAttribute("value", numScrews)
  }



  render(){
    return(
      <div className="container">
        <div className="modal-body row">
              <form>
                <div className="col-md-6">
              <FormGroup controlId="formControlsSelect">
                  <ControlLabel>Cabinet Type</ControlLabel>
                    <FormControl componentClass="select" placeholder="Cabinet Type" id="cabinet_type" bsSize="large">
                      <option value="Wood">Wood</option>
                      <option value="Steel">Steel</option>
                    </FormControl>
                </FormGroup>


                <div className="modal-body row">
                  <div className="col-md-4">
                      <FormGroup bsSize="large">
                        <ControlLabel>Color</ControlLabel>
                      <FormControl componentClass="select" placeholder="Color" id="cabinet_color">
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
                      <FormControl type="number" placeholder="0" id="cabinet_height" min="0" />
                    </FormGroup>
                  </div>
                  <div className="col-md-4">
                    <FormGroup bsSize="large">
                        <ControlLabel>Width (in.)</ControlLabel>
                      <FormControl type="number" placeholder="0" id="cabinet_width" min="0" />
                    </FormGroup>
                  </div>
                </div>
                
                <div className="modal-body row">
                  <div className="col-md-4">
                      <FormGroup bsSize="large">
                        <ControlLabel>Quantity</ControlLabel>
                      <FormControl type="number" placeholder="1" id="cabinet_quantity" min="1" onClick={this.handleQuantity} />
                    </FormGroup>
                  </div>
                  <div className="col-md-4">
                    <FormGroup bsSize="large">
                        <ControlLabel>Hinges</ControlLabel>
                      <FormControl type="number" placeholder="2" id="cabinet_hinges" min="2" />
                    </FormGroup>
                  </div>
                  <div className="col-md-4">
                    <FormGroup bsSize="large">
                        <ControlLabel>Screws</ControlLabel>
                      <FormControl type="number" placeholder="8" id="cabinet_screws" min="8" />
                    </FormGroup>
                  </div>
                </div>
            </div>
            </form>
        </div>
      </div>
    )
  }
}
export default Cabinet;