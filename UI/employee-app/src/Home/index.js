import React from 'react';
import { Loading } from 'carbon-components-react';
import EmployeeCard from './EmployeeCard';
import { get, post } from '../api';
import ErrorCard from './ErrorCard';
import NavBar from '../NavBar';

export default class Home extends React.Component {

    constructor() {
        super();
        this.state = {}
    }

    componentDidMount() {
        get('getEmployees').then((response) => {
            if (typeof response.data === 'object') {
                this.setState({ 'employees': response.data });
            }
            else
                this.setState({ 'error': response.data });
        }).catch((response) => {
            this.setState({ 'error': response.toString() });
        })
    }


    onRemove = (event) => {
        const employeeId = event.target.id;
        post('removeEmployee', null, { "id": Number.parseInt(employeeId) }).then((response) => {
            if (response.data == true) {
                let newEmployeelist = this.state.employees.filter((employee) => employee.id != employeeId);
                this.setState({ employees: newEmployeelist });
            }
        })
    }

    renderCards = () => {
        let cards = [];
        for (let i = 0; i < this.state.employees.length;) {
            let card = <div className='row m-2'>
                {(i < this.state.employees.length) &&
                    <div className='col-sm'>
                        <EmployeeCard  {...this.state.employees[i++]} onRemove={this.onRemove} />
                    </div>
                }
                {(i < this.state.employees.length) &&
                    <div className='col-sm'>
                        <EmployeeCard {...this.state.employees[i++]} onRemove={this.onRemove} />
                    </div>
                }
                {(i < this.state.employees.length) &&
                    <div className='col-sm'>
                        <EmployeeCard {...this.state.employees[i++]} onRemove={this.onRemove} />
                    </div>
                }
            </div>
            cards.push(card);
        }
        return cards;
    }

    render() {
        if (!this.state.error && !this.state.employees)
            return <Loading />;
        return (
            <div className='container shadow p-3 mb-5 bg-white rounded'>
                <NavBar />
                {!this.state.error && this.renderCards()}
                <br />
                {this.state.error && <ErrorCard message={this.state.error} />}
            </div>
        );
    }
}