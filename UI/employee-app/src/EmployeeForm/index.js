import React from 'react';
import { post } from '../api';
import NavBar from '../NavBar';

export default class EmployeeForm extends React.Component {

    constructor() {
        super();
        this.state = {
            name : '',
            address : '',
            department : '',
            salary : ''
        };
    }

    onSubmit = (event) => {
        event.preventDefault();
        post('addEmployee',this.state).then((response)=>{
            alert('Successfully saved');
        }).catch(() => {
            alert('Connection Errorr');
        })
       this.setState({
        name : '',
        address : '',
        department : '',
        salary : '' 
    });
    }

    handleChange= (event) => {
        let formAttribute = event.target.id;
        let value = event.target.value;
        if(formAttribute == 'salary'){
            if(/^[0-9]*$/.test(value)){
                let newState = this.state;
                newState[formAttribute] = value;
                this.setState(newState);
            }
            else{
                alert("Only Numbers allowed");
            }
        }
        else {
            if(/^[A-Za-z]*$/.test(value)){
                let newState = this.state;
                newState[formAttribute] = value;
                this.setState(newState);
            }
            else{
                alert("Numbers not allowed");
            }
        }
    }

    render() {
        return (
            <div className='container shadow-lg'>
                <NavBar />
                <form onSubmit={this.onSubmit} className='container p-2' id='employeeForm'>
                    <div className="form-group">
                        <input type="text" className="form-control" id="name" onChange={this.handleChange} placeholder="Enter Full Name" value={this.state.name} required/>
                    </div>
                    <div class="form-group">
                        <input type="text" className="form-control" id="address" onChange={this.handleChange} placeholder="Enter Address" value={this.state.address} required/>
                    </div>
                    <div class="form-group">
                        <input type="text" className="form-control" id="department"  onChange={this.handleChange} placeholder="Department" value={this.state.department} required/>
                    </div>
                    <div class="form-group">
                        <input type="text" className="form-control" id="salary" onChange={this.handleChange} placeholder="Enter Salary" value={this.state.salary} required/>
                    </div>
                    <button type="submit" className="btn btn-primary align-middle">Submit</button>
                </form>
            </div>
        );
    }

}