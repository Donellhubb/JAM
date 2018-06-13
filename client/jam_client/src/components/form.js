import React, { Component } from 'react';
import axios from 'axios';
import url from '../url';
  
class Forms extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName : "",
            lastName : "",
            email : "",
            phone : "",
            address :"",
            job :"",
            
        }
    }

    fillForm = (item) => (event) => {
        this.setState({ [item]: event.target.value})
    }

    sendForm(){
        axios({
            method:'post',
            url:'http://192.168.88.181:8080/form',
            data: { //use req.body in express backend using body-parser, not req.body.data 
                firstName: this.state.firstName,
                lastName: this.state.lastName,
                email: this.state.email,
                phone : this.state.phone,
                address : this.state.address,
                job : this.state.job,
                }
            })
        .then(responseFromSpring => {
            this.setState({ 
                messageFromSpring : responseFromSpring.data
            }) 
        })
    }

    render() {
        return (
            <div>
                <form>
                    <input placeholder="firstName" type="text" value={this.state.firstName} onChange={this.fillForm("firstName")}/><br/>
                    <input placeholder="lastName" type="text" value={this.state.lastName} onChange={this.fillForm("lastName")}/><br/>
                    <input placeholder="email" type="text" value={this.state.email} onChange={this.fillForm("email")}/><br/>
                    <input placeholder="phone" type="text" value={this.state.phone} onChange={this.fillForm("phone")}/><br/>
                    <input placeholder="address" type="text" value={this.state.address} onChange={this.fillForm("address")}/><br/>
                    <input placeholder="job" type="text" value={this.state.job} onChange={this.fillForm("job")}/><br/>

                </form>


                <button onClick={() => this.sendForm()}>Confirm</button>
            </div>
        );
    }
}

export default Forms;
