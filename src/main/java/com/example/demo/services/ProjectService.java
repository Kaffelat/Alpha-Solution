package com.example.demo.services;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;

import java.util.List;
//Simon Bøg Jørgensen
public class ProjectService {
    ProjectRepo pr;

    public ProjectService(){
        pr = new ProjectRepo();
    }

    public Project createNewProject(int projectId, String projectName, String projectAssignments, String status, String startDate, String endDate, String deadline){
        Project projectFromUser = new Project(projectId, projectName, projectAssignments,status, endDate,startDate,deadline);
        return projectFromUser;
    }

    public List<Project> getAllProjects(){
        return pr.getAllProjects();
    }

    public void deleteProjectFromDB(int id){
        deleteProjectFromDB(id);
    }

    public Project getProjectFromDB(int projectId){
        return pr.getProject(projectId);
    }
    public void updateProject(Project p){
        pr.updateProject(p);
    }
}
