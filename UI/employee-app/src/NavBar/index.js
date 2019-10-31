import React from 'react';
import {
    Link
} from "react-router-dom";
export default class NavBar extends React.Component {

    onLogout = () => {
        localStorage.clear();
    }
    render() {
        return (
            <div className='container'>
                <Link to='/employeeForm' className='btn btn-link'>Add Employee</Link>
                <Link to='/Home' className='btn btn-link'>Employee List</Link>
                <Link to = '/' className='btn btn-link' onClick={this.onLogout}>{(localStorage.getItem('isLoggedIn') == 'true')?'Log out':'Log in'}</Link>
            </div>
        );
    }
}