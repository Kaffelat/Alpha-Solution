package com.example.demo.model;

public class Project {
    private int projectId;
    private String assignments;
    private String title;

    //To Do gør så man kan sætte en deadline. Skal måske ændres til int
    private boolean deadline;

    public Project (int projectId, String assignments, String title){
        this.projectId = projectId;
        this.assignments = assignments;
        this.title = title;
    }
    public int getProjectId(){
        return projectId;
    }
    public String getAssignments(){
        return assignments;
    }
    public String getTitle(){
        return title;
    }
    public void setProjectId(int projectId){
        this.projectId = projectId;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAssignments(String assignments){
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", assignments='" + assignments + '\'' +
                ", title='" + title + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
