package com.example.demo.model;

public class Project {
    private int projectId;
    private String assignments;
    private String name;

    //To Do gør så man kan sætte en deadline. Skal måske ændres til int
    private boolean deadline;

    public Project (int projectId, String assignments, String name){
        this.projectId = projectId;
        this.assignments = assignments;
        this.name = name;
    }
    public int getProjectId(){
        return projectId;
    }
    public String getAssignments(){
        return assignments;
    }
    public String getName(){
        return name;
    }
    public void setProjectId(int projectId){
        this.projectId = projectId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAssignments(String assignments){
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", assignments='" + assignments + '\'' +
                ", title='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
