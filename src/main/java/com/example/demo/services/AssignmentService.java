package com.example.demo.services;

import com.example.demo.model.Assignment;
import com.example.demo.repository.AssignmentRepo;

import java.util.ArrayList;

public class AssignmentService {
    AssignmentRepo ar;

    public AssignmentService(){
        ar = new AssignmentRepo();
    }

    public Assignment createNewAssignment(int assignmentId,int assignmentProjecId,int estimatedTime ,int spentTime, String assignmentName ,String assignmentDescription, String assignmentDeadline, String assignmentStatus){
        Assignment assignment = new Assignment();
        assignment.setAssignmentId(assignmentId);
        assignment.setAssignmentProjecId(assignmentProjecId);
        assignment.setEstimatedTime(estimatedTime);
        assignment.setSpentTime(spentTime);
        assignment.setAssignmentName(assignmentName);
        assignment.setAssignmentDescription(assignmentDescription);
        assignment.setAssignmentDeadline(assignmentDeadline);
        assignment.setAssignmentStatus(assignmentStatus);

        return assignment;
    }

    public Assignment getAssignmentFromDB(int assignmentId){
        return ar.getOneAssignmentFromDB(assignmentId);
    }

    public void updateAssignment(Assignment a){
        ar.updateAssignment(a);
    }
    public void deleteAssignmentFromDB(int Id){
        ar.deletedAssignment(Id);
    }
    public void insertAssignmentIntoDB(Assignment a){
        ar.insertAssignmentIntoDB(a);
    }

    public ArrayList<Assignment> getAllAssignmentAsAArray(){
        return ar.getAssignmentsInAnArray();
    }
}
