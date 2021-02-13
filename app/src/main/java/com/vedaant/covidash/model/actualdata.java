package com.vedaant.covidash.model;

public class actualdata {
    private String totalCases;
    private String activeCases;
    private String recoveredCases;
    private String deceasedCases;

    public String getTotalCases() {
        return totalCases;
    }

    public String getActiveCases() {
        return activeCases;
    }

    public String getRecoveredCases() {
        return recoveredCases;
    }

    public String getDeceasedCases() {
        return deceasedCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public void setActiveCases(String activeCases) {
        this.activeCases = activeCases;
    }

    public void setRecoveredCases(String recoveredCases) {
        this.recoveredCases = recoveredCases;
    }

    public void setDeceasedCases(String deceasedCases) {
        this.deceasedCases = deceasedCases;
    }

    public actualdata(String totalCases, String activeCases, String recoveredCases, String deceasedCases) {
        this.totalCases = totalCases;
        this.activeCases = activeCases;
        this.recoveredCases = recoveredCases;
        this.deceasedCases = deceasedCases;

    }



}
