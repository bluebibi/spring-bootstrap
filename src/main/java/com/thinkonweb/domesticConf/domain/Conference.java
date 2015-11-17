package com.thinkonweb.domesticConf.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Conference {
    private int id;
    private String nameId;
    private String name;
    private String hostingInstitution;
    private String location;
    private Date submissionDueDate;
    private Date conferenceStartDate;
    private Date conferenceEndDate;
    private Timestamp creationTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostingInstitution() {
        return hostingInstitution;
    }

    public void setHostingInstitution(String hostingInstitution) {
        this.hostingInstitution = hostingInstitution;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getSubmissionDueDate() {
        return submissionDueDate;
    }

    public void setSubmissionDueDate(Date submissionDueDate) {
        this.submissionDueDate = submissionDueDate;
    }

    public Date getConferenceStartDate() {
        return conferenceStartDate;
    }

    public void setConferenceStartDate(Date conferenceStartDate) {
        this.conferenceStartDate = conferenceStartDate;
    }

    public Date getConferenceEndDate() {
        return conferenceEndDate;
    }

    public void setConferenceEndDate(Date conferenceEndDate) {
        this.conferenceEndDate = conferenceEndDate;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", nameId='" + nameId + '\'' +
                ", name='" + name + '\'' +
                ", hostingInstitution='" + hostingInstitution + '\'' +
                ", location='" + location + '\'' +
                ", submissionDueDate=" + submissionDueDate +
                ", conferenceStartDate=" + conferenceStartDate +
                ", conferenceEndDate=" + conferenceEndDate +
                ", creationTime=" + creationTime +
                '}';
    }
}
