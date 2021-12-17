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
            state = DBManager.getConnection().prepareStatement("INSERT INTO `heroku_3b09630b0e3ee46`.`project` "+" (`projectId`, `projectName`, `projectAssignments`, `status`, `startDate`, `endDate`, `deadline`) VALUES " + "(?,?,?,?,?,?,?);");
            state.setInt(1, p.getProjectId());
            state.setString(2, p.getProjectName());
            state.setString(3, p.getProjectAssignments());
            state.setString(4, p.getStatus());
            state.setString(5, p.getStartDate());
            state.setString(6, p.getEndDate());
            state.setString(7, p.getDeadline());
            state.executeUpdate();
        } catch (Exception e) {
            System.out.println("Couldn't insert project into db");
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

    public void deleteProjectFromDB(int id){
        try {
            state = DBManager.getConnection().prepareStatement("DELETE FROM heroku_3b09630b0e3ee46.project WHERE projectId = ?;");
            state.setInt(1, id);
            state.executeUpdate();
        } catch (Exception e){
            System.out.println("The program wasn't able to delete the project with id" + id +  " from the database. Please check the id of the project you are trying to delete");
            System.out.println(e.getMessage());
        }
    }

    public Project getProject(int Id){
        Project p = new Project();
        try {
            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.project WHERE projectid=?;");
            state.setInt(1,Id);
            ResultSet rs = state.executeQuery();

            while (rs.next()){
                Id = rs.getInt("projectId");
                String projectName = rs.getString("projectName");
                String projectAssignments = rs.getString("projectAssignments");
                String status = rs.getString("status");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");
                String deadline = rs.getString("deadline");

                p = new Project(Id, projectName, projectAssignments, status, startDate, endDate, deadline);
                p.setProjectId(Id);
                p.setProjectName(projectName);
                p.setProjectAssignments(projectAssignments);
                p.setStatus(status);
                p.setStartDate(startDate);
                p.setEndDate(endDate);
                p.setDeadline(deadline);
            }
        } catch (SQLException e){
            System.out.println("Wasn't able to get the project with id " + Id + " From the database");
            System.out.println(e.getMessage());
        }
        return p;
}

    public void updateProject(Project p){
        try{
            state = DBManager.getConnection().prepareStatement("UPDATE heroku_3b09630b0e3ee46.project SET projectName = ?,projectAssignments = ?, status = ?, startDate = ?, endDate = ?, deadline = ? WHERE (projectId = ?);");
            state.setString(1, p.getProjectName());
            state.setString(2, p.getProjectAssignments());
            state.setString(3, p.getStatus());
            state.setString(4, p.getStartDate());
            state.setString(5, p.getEndDate());
            state.setString(6, p.getDeadline());
            state.setInt(7, p.getProjectId());
            state.executeUpdate();

        }catch (Exception e){
            System.out.println("Wasn't able to update project");
            System.out.printf(e.getMessage());
        }
    }
    }

