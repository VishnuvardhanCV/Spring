import React from 'react';

export default class EmployeeCard extends React.Component {

    render() {
        return (
            <div className="card " key={this.props.id}>
                <div className="card-body my-auto">
                    <h5 className="card-title">{this.props.name}</h5>
                    <h6 className="card-subtitle mb-2 text-muted">Department : {this.props.department}</h6>
                    <br />
                    <p className="card-text">Address : {this.props.address}<br />Salary : {this.props.salary}</p><br />
                    <button type="button" id={this.props.id} className="btn btn-danger" onClick={this.props.onRemove}>Remove</button>
                </div>
            </div>
        );
    }
}