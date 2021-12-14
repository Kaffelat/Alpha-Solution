package com.example.demo.repository;

import com.example.demo.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepo {
    List<Project> projects;
    PreparedStatement state;

    public void insertProjectIntoDB(Project p) {
        try {
            state = DBManager.getConnection().prepareStatement("INSERT INTO baef4d5806b13b.projects" + "(projectId, projectName, projectAssignments, status, startDate, endDate, deadline) VALUES " + "(?,?,?,?,?,?,?);");
            state.setInt(1, p.getProjectId());
            state.setString(2, p.getProjectName());
            state.setString(3, p.getProjectAssignments());
            state.setString(4, p.getStatus());
            state.setString(5, p.getStartDate());
            state.setString(6, p.getEndDate());
            state.setString(7, p.getDeadline());
        } catch (Exception e) {
            System.out.println("not working");
            System.out.println(e.getMessage());
        }
    }

    public List<Project> getAllProjects() {
        projects = new ArrayList<>();
        try {
            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.project");
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                Project project = new Project(
                        rs.getInt("ProjectId"),
                        rs.getString("projectName"),
                        rs.getString("projectAssignments"),
                        rs.getString("status"),
                        rs.getString("startDate"),
                        rs.getString("endDate"),
                        rs.getString("deadline")
                );
                projects.add(project);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }
        return projects;
    }
}
