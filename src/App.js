import React, { Component } from 'react';
//import $ from 'jquery';
import './App.css';

class App extends Component {

  constructor(){
    super();
    this.state={
      showing: false,
      newRegistration:[ ]
    }
  }

  handleSubmit(e)
  {
     e.preventDefault();
    console.log('In Handle Submit ');
    let registration = this.state.newRegistration;
    
    let addRegistration = {
      
        patientLastName: this.refs.pLastName.value,
        patientFirstName: this.refs.pFirstName.value,
        patientMiddleInitial: this.refs.pMiddleInitial.value,
        patientDOB:this.refs.patientDOB.value,
        insuranceYN: this.refs.insuranceYN.value,
        insuranceId: this.refs.insuranceId.value,
        carrierName: this.refs.carrierName.value
      
    }

    registration.push(addRegistration);
    this.setState({newRegistration:addRegistration});
    console.log(this.state);
    console.log(addRegistration);
    

    /*$.ajax({
      url:'http://localhost:8080/api/registrations/save',
      contentType:'application/json',
      cache:false,
      type:'POST',
      //beforeSend: function(xhr){xhr.setRequestHeader("Origin","http://localhost:3000");},
      crossDomain:true,
      //headers: {'Origin':'http://localhost:3000'},
      data: addRegistration,
      success: function(data){
        console.log(data);
      },
      error: function(xhr,status,err)
      {
        console.log('Status'+ status);
        console.log('Error Message'+ err);
      }

    });*/
    fetch('http://localhost:8080/api/registrations/save',{
          method: 'POST',
          mode:'cors',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin':'*'
          },
          body: JSON.stringify(addRegistration)

    })
    .then((response) => console.log(response))
   
  }

  componentDidMount()
  {
    this.setState.showing=false;
    
  }

  render() {
    const {showing} = this.state;
    return (
      <div className="container">
        <img src="logo.png" alt="Go Health Logo" />
        <h1>Registration</h1>
        <p> Please enter your information below to complete registration </p>
        <form onSubmit={this.handleSubmit.bind(this)}>
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
              <div className="form-group">
                <label><strong> Patient Date of Birth: </strong> </label> <input type="text" ref="patientDOB"  /> <span> YYYY-MM-DD </span>
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
                  <label> <strong>Carrier Name: </strong> </label> <input type="text" ref="carrierName"  />
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
