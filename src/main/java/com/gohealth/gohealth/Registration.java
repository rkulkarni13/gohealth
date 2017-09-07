package com.gohealth.gohealth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rameshkulkarni on 9/4/17.
 */
@Entity
public class Registration
{
    public Registration()
    {

    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", patientLastName='" + patientLastName + '\'' +
                ", patientFirstName='" + patientFirstName + '\'' +
                ", patientMiddleInitial='" + patientMiddleInitial + '\'' +
                ", patientDOB='" + patientDOB + '\'' +
                ", insuranceYN='" + insuranceYN + '\'' +
                ", insuranceId='" + insuranceId + '\'' +
                ", carrierName='" + carrierName + '\'' +
                '}';
    }

    public Registration(String patientLastName, String patientFirstName, String patientMiddleInitial, String patientDOB, String insuranceYN,
                        String insuranceId, String carrierName)
    {

        this.patientLastName = patientLastName;
        this.patientFirstName = patientFirstName;
        this.patientMiddleInitial = patientMiddleInitial;
        this.patientDOB = patientDOB;
        this.insuranceYN = insuranceYN;
        this.insuranceId = insuranceId;
        this.carrierName = carrierName;
    }

    @Id @GeneratedValue
    private Long id;
    private String patientLastName;
    private String patientFirstName;
    private String patientMiddleInitial;
    private String patientDOB;
    private String insuranceYN;
    private String insuranceId;
    private String carrierName;

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientMiddleInitial() {
        return patientMiddleInitial;
    }

    public void setPatientMiddleInitial(String patientMiddleInitial) {
        this.patientMiddleInitial = patientMiddleInitial;
    }

    public String getInsuranceYN() {
        return insuranceYN;
    }

    public void setInsuranceYN(String insuranceYN) {
        this.insuranceYN = insuranceYN;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(String patientDOB) {
        this.patientDOB = patientDOB;
    }
}
