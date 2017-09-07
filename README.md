# Requirements
Create a web application that will capture and store a patient’s demographic and insurance information
to expedite the registration process when they arrive at a GoHealth Urgent Care facility. The application
should check (and display) whether the patient’s insurance is valid and display their insurance copay
amount specific to an urgent care visit so the patient knows what they will be expected to pay when
they arrive.

## Details
The application should prompt the user to enter their basic demographic information including:
- Full name
- DOB
- Phone number

The application should ask the patient whether they have health insurance and if they do, it should ask
them for these details:
- Insurance Carrier
- Insurance ID

If the patient says they do not have insurance, only their demographic information needs to be saved.
The insurance information should be checked using the Insurance Eligibility API noted in the appendix.
The application should show the patient an indicator about whether their insurance is valid or not and
should show them their expected copay that they will need to pay when they arrive at the urgent care
center.
Once the patient has successfully completed their registration – they should be taken to
https://www.gohealthuc.com/about/

# Technical Details
This application was built with ReactUI and Spring Boot for the backend API.
In-memory database H2 was used to store the data. JWT was used for generating
authentication tokens used to call the eligibility API. 

- React UI
- Spring Boot
- Spring Data
- Spring Security
- JWT

## How to run the application
Following are the prerequisites to run the application:

- NodeJs
- Maven
- NPM

To run the react UI, run the following command:

```
cd gohealth
npm start
```

This command will start the application at `http://localhost:3000`

To run the Spring backend API, run the following command:

```
cd gohealth
mvn spring-boot:run
```
The application will start at `http://localhost:8080/`

### Rest API
The backend API exposes the following REST endpoints:

`http://localhost:8080/api/registrations/all` - 

This endpoint will show the list of all registrations saved in the database


`http://localhost:8080/api/registrations/save` - 

This endpoint will save a new Registration. Below is an example payload:

```
{
	"patientLastName":"Kulkarni",
	"patientFirstName":"Shlok",
	"patientMiddleInitial":"C",
	"patientDOB":"1980-10-01",
	"insuranceYN":"Y",
	"insuranceId":"3456789",
	"carrierName":"Kaiser"
}
```

# Known Issues
As the React UI and the Spring Boot application are separate applications which are deployed on different domains,
when the UI calls the backend API, it is failing with a 401 or 403 status code. We are getting "Invalid CORS Request" 
response. The reason for this is because the two applications are on different domains, the request is being rejected 
for cross-domain
 
## Workaround
A solution is being worked upon but until then we have a workaround. We need to download a chrome plugin Allow-Control-Allow-Origin [https://chrome.google.com/webstore/detail/allow-control-allow-origi/nlfbmbojpeacfghkpbjhddihlkkiljbi]
After downloading the extension, add the below header:

Origin: http://localhost:3000

