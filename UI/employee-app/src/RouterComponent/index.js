import { BrowserRouter as Router,Redirect, Route, Switch } from 'react-router-dom'
import Home from '../Home';
import React from "react";
import Login from '../Login';
import EmployeeForm from '../EmployeeForm';

const AppRouter = () => {
    return (
        <Router>
            <Switch>
                <Route path="/" exact component={Login} />
                <Route path="/Home" component={Home} />
                <Route path="/EmployeeForm" component={EmployeeForm} />
            </Switch>
        </Router>
    )
}

export default AppRouter;