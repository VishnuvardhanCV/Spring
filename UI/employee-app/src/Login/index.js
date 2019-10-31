import React from 'react';
import { authenticate } from '../Utils/authenticate';
import { Redirect } from 'react-router-dom';
export default class Login extends React.Component {

    constructor() {
        super();
        let loginStatus = localStorage.getItem('isLoggedIn');
        this.state = {
            username: '',
            password: '',
            isLoggedIn: loginStatus,
            message: ''
        };
    }

    handleSubmit = (event) => {
        event.preventDefault();
        authenticate(this.state, this.onSuccess,this.onFailure);
    }

    onSuccess = () => {
        localStorage.setItem('isLoggedIn','true');
        this.setState({ isLoggedIn: true }); 
    }

    onFailure = () => {
        this.setState({ isLoggedIn: false, message: 'Login Failed' });
    }

    handleChange = (event) => {
        let formAttribute = event.target.id;
        let value = event.target.value;
        let newState = this.state;
        newState[formAttribute] = value;
        this.setState(newState);
    }


    render() {
        if (this.state.isLoggedIn)
            return <Redirect to='/Home' />
        return (
            <div className='container shadow p-3 mb-5 bg-white rounded'>
                <form onSubmit={this.handleSubmit}>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" className="form-control" id="username" value={this.state.username} onChange={this.handleChange} placeholder="Enter Username" />
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input type="password" className="form-control" id="password" value={this.state.password} onChange={this.handleChange} placeholder="Enter Password" />
                    </div>
                    <button type="submit" className="btn btn-primary m-auto">Submit</button>
                </form>
                <br />
                { (this.state.message) &&
                    <div className="alert alert-danger" role="alert">
                       {this.state.message} !!! Try again.
                    </div>
                }
            </div>
        );
    }
}