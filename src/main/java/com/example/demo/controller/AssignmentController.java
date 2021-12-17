package com.example.demo.controller;

import com.example.demo.model.Assignment;
import com.example.demo.model.Project;
import com.example.demo.repository.AssignmentRepo;
import com.example.demo.services.AssignmentService;
import com.example.demo.services.ProjectService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

public class AssignmentController {
    AssignmentService assignmentService = new AssignmentService();
    ProjectService projectService = new ProjectService();

    @GetMapping("/createAssignment/{projektId}")
    public String createAssignment(@PathVariable int projektId, WebRequest web, Model m){
        Assignment a = assignmentService.getAssignmentFromDB(projektId);
        return "createNewAssignment";
    }

}
