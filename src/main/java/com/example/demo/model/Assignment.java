package com.example.demo.model;

public class Assignment {
    private int assignmentId;
    private  int assignmentProjecId;
    private  int estimatedTime;
    private  int spentTime;
    private  String assignmentName;
    private  String assignmentDescription;
    private  String assignmentDeadline;
    private  String assignmentStatus;

    public Assignment(int assignmentId, int assignmentProjecId, int estimatedTime, int spentTime, String assignmentName, String assignmentDescription, String assignmentDeadline, String assignmentStatus) {
        this.assignmentId = assignmentId;
        this.assignmentProjecId = assignmentProjecId;
        this.estimatedTime = estimatedTime;
        this.spentTime = spentTime;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.assignmentDeadline = assignmentDeadline;
        this.assignmentStatus = assignmentStatus;
    }
    public Assignment(){}

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getAssignmentProjecId() {
        return assignmentProjecId;
    }

    public void setAssignmentProjecId(int assignmentProjecId) {
        this.assignmentProjecId = assignmentProjecId;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public int getSpentTime() {
        return spentTime;
    }

    public void setSpentTime(int spentTime) {
        this.spentTime = spentTime;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public String getAssignmentDeadline() {
        return assignmentDeadline;
    }

    public void setAssignmentDeadline(String assignmentDeadline) {
        this.assignmentDeadline = assignmentDeadline;
    }

    public String getAssignmentStatus() {
        return assignmentStatus;
    }

    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }
}
