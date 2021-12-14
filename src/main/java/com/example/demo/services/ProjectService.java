package com.example.demo.services;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;

import java.util.List;

public class ProjectService {
    ProjectRepo pr = new ProjectRepo();

    public ProjectService(){
        pr = new ProjectRepo();
    }
    public Project createNewProject(int projectId, String projectName, String projectAssignments, String status, String startDate, String endDate, String deadline){
        Project project = new Project(projectId, projectName, projectAssignments,status, endDate,startDate,status);
        return project;
    }
    public List<Project> getAllProjects(){
        return pr.getAllProjects();
    }
}
