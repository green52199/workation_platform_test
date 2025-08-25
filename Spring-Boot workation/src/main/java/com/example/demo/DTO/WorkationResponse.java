package com.example.demo.DTO;

public class WorkationResponse {
    private String workationid;
    private String employee;
    private String origin;
    private String destination;
    private String start;
    private String end;
    private Integer workingdays;
    private String risk;

    // Constructor
    public WorkationResponse(String workationid, String employee, String origin, String destination, String start, String end, Integer workingdays, String risk) {
        this.workationid = workationid;
        this.employee = employee;
        this.origin = origin;
        this.destination = destination;
        this.start = start;
        this.end = end;
        this.workingdays = workingdays;
        this.risk = risk;
    }

    // Getters and Setters
    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getWorkationid() {
        return workationid;
    }

    public void setWorkationid(String workationid) {
        this.workationid = workationid;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Integer getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(Integer workingdays) {
        this.workingdays = workingdays;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }
}
