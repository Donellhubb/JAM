import React, {Component} from 'react';
import axios from 'axios';
import url from '../url';
import {FormGroup, ControlLabel, FormControl, NumericInput} from 'react-bootstrap';

class Window extends Component{
  constructor(props){
    super(props);
    this.state={
      window: []
    }
  }

  componentDidMount(){
    document.getElementById('window_quantity').setAttribute("value", "1");
  }

  render(){
    return(
      <div className="container">
        <div className="modal-body row">
              <form>
                <div className="col-md-6">
              <FormGroup controlId="formControlsSelect">
                  <ControlLabel>Window Type</ControlLabel>
                    <FormControl componentClass="select" placeholder="Window Type" id="window_type" bsSize="large">
                      <option value="Single Hung Windows">Single Hung Windows</option>
                      <option value="Double Hung Windows">Double Hung Windows</option>
                      <option value="Casement Windows">Casement Windows</option>
                      <option value="Awning Windows">Awning Windows</option>
                      <option value="Sliding Windows">Sliding Windows</option>
                      <option value="Basement Windows">Basement Windows</option>
                      <option value="Skylights">Skylights</option>
                      <option value="Glass Block Windows">Glass Block Windows</option>
                    </FormControl>
                </FormGroup>


                <div className="modal-body row">
                  <div className="col-md-4">
                      <FormGroup bsSize="large">
                        <ControlLabel>Color</ControlLabel>
                      <FormControl componentClass="select" placeholder="Color" id="window_color">
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
                      <FormControl type="number" placeholder="0" id="window_height" min="0" />
                    </FormGroup>
                  </div>
                  <div className="col-md-4">
                    <FormGroup bsSize="large">
                        <ControlLabel>Width (in.)</ControlLabel>
                      <FormControl type="number" placeholder="0" id="window_width" min="0" />
                    </FormGroup>
                  </div>
                </div>
                
                <div className="modal-body row">
                  <div className="col-md-4">
                      <FormGroup bsSize="large">
                        <ControlLabel>Quantity</ControlLabel>
                      <FormControl type="number" placeholder="1" id="window_quantity" min="1" />
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
export default Window;