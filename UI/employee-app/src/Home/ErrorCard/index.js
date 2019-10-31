import React from 'react';

export default class ErrorCard extends React.Component {
     render(){
         return(
            <div className='card'>
                <div className="alert alert-danger">
                    <strong>Error !</strong>
                    <br/>
                    {this.props.message}
                </div>
            </div>
         );
     }
}