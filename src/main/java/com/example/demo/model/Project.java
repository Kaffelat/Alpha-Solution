package com.example.demo.model;

public class Project {
    private int projectId;
    private String projectName;
    private String projectAssignments;
    private String status;
    private String startDate;
    private String endDate;
    private String deadline;

    public Project (int projectId, String projectAssignments, String projectName, String status , String endDate , String startDate , String deadline){
        this.projectId = projectId;
        this.projectAssignments = projectAssignments;
        this.projectName = projectName;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deadline = deadline;
    }
    public Project(){

    }
    public int getProjectId(){
        return projectId;
    }
    public String getProjectName(){
        return projectName;
    }
    public String getProjectAssignments(){
        return projectAssignments;
    }
    public String getStatus() {
        return status;
    }
    public String getStartDate() {
        return startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getDeadline() {
        return deadline;
    }

    public void setProjectId(int projectId){
        this.projectId = projectId;
    }
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
    public void setProjectAssignments(String projectAssignments){
        this.projectAssignments = projectAssignments;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }


    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectAssignments='" + projectAssignments + '\'' +
                ", projectName='" + projectName + '\'' +
                ", status='" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
