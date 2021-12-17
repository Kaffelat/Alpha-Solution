package com.example.demo.repository;

import com.example.demo.model.Assignment;
import com.example.demo.model.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//Simon Bøg Jørgensen
public class AssignmentRepo {
    PreparedStatement state;

    public void insertAssignmentIntoDB(Assignment a) {
        try {
            state = DBManager.getConnection().prepareStatement("INSERT INTO `heroku_3b09630b0e3ee46`.`assignment` "+" (`assignmentId`, `projectId`, `estimatedTime`, `spentTime`, `name`, `description`, `deadline`, status) VALUES " + "(?,?,?,?,?,?,?,?);");
            state.setInt(1, a.getAssignmentId());
            state.setInt(2, a.getAssignmentProjecId());
            state.setInt(3, a.getEstimatedTime());
            state.setInt(4, a.getSpentTime());
            state.setString(5, a.getAssignmentName());
            state.setString(6, a.getAssignmentDescription());
            state.setString(7, a.getAssignmentDeadline());
            state.setString(8, a.getAssignmentStatus());
            state.executeUpdate();
        } catch (Exception e) {
            System.out.println("couldn't insert assignment into db");
            System.out.println(e.getMessage());
        }
    }
    public Assignment getOneAssignmentFromDB(int Id){
        Assignment a = new Assignment();
        try {
            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.assignment WHERE assignment_id =?;");
            state.setInt(1,Id);
            ResultSet rs = state.executeQuery();

            while (rs.next()){
                Id = rs.getInt("Id");
                int assignmentId = rs.getInt("assignmentId");
                int projectId = rs.getInt("projectId");
                int estimatedTime = rs.getInt("estimatedTime");
                int spentTime = rs.getInt("spentTime");
                String AssignmentName = rs.getString("name");
                String AssignmentDescription = rs.getString("description");
                String AssignmentDeadline = rs.getString("deadline");
                String AssignmentStatus = rs.getString("status");
                System.out.printf("%s, %s, %s, %s, %s, %s, %s, %s\n", assignmentId, projectId, estimatedTime, spentTime, AssignmentName, AssignmentDescription,AssignmentDeadline,AssignmentStatus);

                a = new Assignment(Id, projectId, estimatedTime, spentTime, AssignmentName, AssignmentDescription, AssignmentDeadline,AssignmentStatus);
                a.setAssignmentId(Id);
                a.setAssignmentProjecId(projectId);
                a.setEstimatedTime(estimatedTime);
                a.setSpentTime(spentTime);
                a.setAssignmentName(AssignmentName);
                a.setAssignmentDescription(AssignmentDescription);
                a.setAssignmentDeadline(AssignmentDeadline);
                a.setAssignmentStatus(AssignmentStatus);
            }
            state.close();
        } catch (SQLException e){
            System.out.println("Wasn't able to get the project with Id " + Id + " From the database");
            System.out.println(e.getMessage());
        }
        return a;
    }
    public void updateAssignment(Assignment a){
        try{
            state = DBManager.getConnection().prepareStatement("UPDATE heroku_3b09630b0e3ee46.assignment SET projectId = ?, estimatedTime = ?, spentTime = ?, name =?, description = ?, deadline = ?, status = ? WHERE (assignmentId = ?);");
            state.setInt(1, a.getAssignmentProjecId());
            state.setInt(2, a.getEstimatedTime());
            state.setInt(3, a.getSpentTime());
            state.setString(4, a.getAssignmentName());
            state.setString(5, a.getAssignmentDescription());
            state.setString(6, a.getAssignmentDeadline());
            state.setString(7, a.getAssignmentStatus());
            state.setInt(8, a.getAssignmentId());
            state.executeUpdate();

        }catch (Exception e){
            System.out.println("Wasn't able to update assignment");
            System.out.printf(e.getMessage());
        }
    }
    public ArrayList<Assignment> getAllAssignmentsInAProject(int aId){
        ArrayList<Assignment> allAssignments = new ArrayList<>();
        Assignment a;
        try {

            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.assignment where projectid=?");
            state.setInt(1, aId);

            ResultSet rs = state.executeQuery();

            while(rs.next()){
                int assignmentId = rs.getInt("assignmentId");
                int assignmentProjectId = rs.getInt("assignmentProjectId");
                int estimatedTime = rs.getInt("estimatedTime");
                int spentTime = rs.getInt("spentTime");
                String assignmentName = rs.getString("assignmentName");
                String assignmentDescription = rs.getString("assignmentDescription");
                String assignmentDeadline = rs.getString("assignmentDeadline");
                String assignmentStatus = rs.getString("assignmentStatus");

                a = new Assignment(assignmentId,assignmentProjectId,estimatedTime,spentTime,assignmentName,assignmentDescription,assignmentDeadline,assignmentStatus);
                a.setAssignmentId(assignmentId);
                a.setAssignmentProjecId(assignmentProjectId);
                a.setEstimatedTime(estimatedTime);
                a.setSpentTime(spentTime);
                a.setAssignmentName(assignmentName);
                a.setAssignmentDescription(assignmentDescription);
                a.setAssignmentDeadline(assignmentDeadline);
                a.setAssignmentStatus(assignmentStatus);

                allAssignments.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Couldn't get the Assignment from database");
            System.out.println(e.getMessage());
        }
        return allAssignments;
    }
    public void deletedAssignment(int assignmentId){

        try {
            state = DBManager.getConnection().prepareStatement("DELETE FROM heroku_3b09630b0e3ee46.assignment WHERE assignmentId= ?;");
            state.setInt(1, assignmentId);
            state.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Couldn't delete assignment with that id " + assignmentId + " from the database");
            System.out.println(e.getMessage());
        }

    }
    public ArrayList<Assignment> getAssignmentsInAnArray(){
        ArrayList<Assignment> assignmentArray = new ArrayList<>();
        try{
            state = DBManager.getConnection().prepareStatement("SELECT * FROM heroku_3b09630b0e3ee46.assignment;");
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int Id = rs.getInt("projectId");
                int assignmentId = rs.getInt("assignmentId");
                int assignmentProjecId = rs.getInt("assignmentProjecId");
                int estimatedTime = rs.getInt("estimatedTime");
                int spentTime = rs.getInt("spentTime");
                String assignmentName = rs.getString("assignmentName");
                String assignmentDescription = rs.getString("assignmentDescription");
                String assignmentDeadline = rs.getString("assignmentDeadline");
                String assignmentStatus = rs.getString("assignmentStatus");

                Assignment a = new Assignment(Id,assignmentProjecId , estimatedTime, spentTime, assignmentName, assignmentDescription,assignmentDeadline, assignmentStatus);
                a.setAssignmentProjecId(Id);
                a.setAssignmentProjecId(assignmentProjecId);
                a.setEstimatedTime(estimatedTime);
                a.setSpentTime(spentTime);
                a.setAssignmentName(assignmentName);
                a.setAssignmentDescription(assignmentDescription);
                a.setAssignmentDeadline(assignmentDeadline);
                a.setAssignmentStatus(assignmentStatus);

                assignmentArray.add(a);

            }
        } catch (SQLException e) {
            System.out.println("Couldn't get projects from database");
            System.out.println(e.getMessage());
        }
            return assignmentArray;
    }

}
