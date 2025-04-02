package models;

import constants.Status;

public class Issue {
    String issueId;
    String orderId;
    String description;

    public String getIssueType() {
        return issueType;
    }

    String resolution;
    Status status;

    public String getIssueId() {
        return issueId;
    }

    String issueType;

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    public Issue(String issueId, String orderId, String issueType, String description) {
        this.issueId = issueId;
        this.orderId = orderId;
        this.issueType = issueType;
        this.description = description;
    }


}
