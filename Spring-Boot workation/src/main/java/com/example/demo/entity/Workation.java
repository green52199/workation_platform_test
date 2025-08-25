package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "workation")
public class Workation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workation_seq")
    @SequenceGenerator(name = "workation_seq", sequenceName = "workation_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)  // Explicitly map 'id' to the 'id' column in the database
    private Long id;

    @Column(name = "workationid", nullable = false)  // Map 'workationId' column in the database
    private String workationid;

    @Column(name = "employee", nullable = false, length = 200)
    private String employee;

    @Column(name = "origin", nullable = false, length = 100)
    private String origin;

    @Column(name = "start", nullable = false, length = 200)
    private String start;

    @Column(name = "\"end\"", nullable = false, length = 200)
    private String end;

    @Column(name = "destination", length = 200)
    private String destination;

    @Column(name = "workingdays")
    private Integer workingdays;

    @Column(name = "risk", length = 100)
    private String risk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getWorkationid() {
        return workationid;
    }

    public void setWorkationid(String workationid) {
        this.workationid = workationid;
    }

    public Integer getWorkingdays() {
        return workingdays;
    }

    public void setWorkingdays(Integer workingdays) {
        this.workingdays = workingdays;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    //TODO [Reverse Engineering] generate columns from DB
}