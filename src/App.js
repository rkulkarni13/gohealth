import React, { Component } from 'react';
import './App.css';

class App extends Component {

  constructor(){
    super();
    this.state={
      showing: false
    }
  }

  render() {
    const {showing} = this.state;
    return (
      <div className="container">
        <img src="gohealth_logo.png" alt="Go Health Logo" />
        <h1>Registration</h1>
        <p> Please enter your information below to complete registration </p>
        <form>
          <div className="register">
            <div className="demographics">
              <div className="form-group">
                <label><strong>Patient Last Name: </strong> </label> <input type="text" ref="pLastName" />
              </div>
              <div className="form-group">
                <label><strong> Patient First Name: </strong> </label> <input type="text" ref="pFirstName"  /> 
              </div>
              <div className="form-group">
                <label><strong> Patient Middle Initial: </strong> </label> <input type="text" ref="pMiddleInitial"  />
              </div>
            </div>
            <div className="insuranceQuestion">
              <label><strong>Do you have Insurance?: </strong> </label><input type="radio" value="yes" ref="insuranceYN" name="insuranceYN"
                                                          onClick={() => this.setState ({showing : !showing})}/> Yes 
              <span><label><input type="radio" value="no" ref="insuranceYN" name="insuranceYN" 
                                                          onClick={() => this.setState ({showing : !showing})}/> No </label></span>
                                      
            </div>
            <br/><br/>
            <div className="insuranceDetails" style={{ display: (showing ? 'block' : 'none') }}>
                <div className="form-group">
                  <label> <strong>Insurance Id: </strong> </label> <input type="text" ref="insuranceId"  />
                </div>
                <div className="form-group"> 
                  <label> <strong>Carrier Name: </strong> </label> <input type="text" ref="carrier"  />
                </div>
            </div>
            <input type="submit" name="Continue" value = "Continue" />  
          </div>
        </form>
      </div>
    );
  }
}

export default App;
