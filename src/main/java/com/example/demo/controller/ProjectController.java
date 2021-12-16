package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProjectController {
    ProjectRepo projectRepo = new ProjectRepo();
    ProjectService projectService = new ProjectService();
    Project selectedProject = new Project();


    @GetMapping("/project/{projectId}")
    public String project(@PathVariable int projectId, Model model) {
        List<Project> projectList = new ArrayList<>();

        projectList.add(projectService.getProjectFromDB(projectId));

        model.addAttribute("projectList", projectList);
        return "showProject";
    }

    @GetMapping("/createProject")
    public String createProject() {
        return "createProject";
    }

    @PostMapping(value = "/createProject")
    public String createNewProject(@RequestParam("projectName") String projectName, @RequestParam("projectId") int projectId, @RequestParam("projectAssignments") String projectAssignments, @RequestParam("status") String status, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("deadline") String deadline, RedirectAttributes attributes) {

        Project projectFromUser = projectService.createNewProject(projectId, projectName, projectAssignments, status, startDate, endDate, deadline);
        attributes.addAttribute("projectName", projectName);
        attributes.addAttribute("projectId", projectId);
        attributes.addAttribute("projectAssignments", projectAssignments);
        attributes.addAttribute("status", status);
        attributes.addAttribute("startDate", startDate);
        attributes.addAttribute("endDate", endDate);
        attributes.addAttribute("deadline", deadline);

        projectRepo.insertProjectIntoDB(projectFromUser);
        return "seeProjects";
    }


    @GetMapping("/seeProjects")
    public String seeProjects(Model model) {

        List<Project> projects = projectService.getAllProjects();

        model.addAttribute("Projects", projects);

        return "seeProjects";
    }


    @GetMapping("/editProject{projectId}")
    public String editProject(@PathVariable("projectId") int selectedProject, Model model) {
        Project projectThatWillBeEdited = projectService.getProjectFromDB(selectedProject);
        model.addAttribute("Project", projectService.getProjectFromDB(selectedProject));
        return "editProject";
    }

    @RequestMapping("/editProject")
    public String changesMadeToProject(WebRequest webr) {

        String projectName = webr.getParameter("projectName");
        String projectAssignments = webr.getParameter("projectAssignments");
        String status = webr.getParameter("status");
        String startDate = webr.getParameter("startDate");
        String endDate = webr.getParameter("endDate");
        String deadline = webr.getParameter("deadline");

        selectedProject.setProjectName(projectName);
        selectedProject.setProjectAssignments(projectAssignments);
        selectedProject.setStatus(status);
        selectedProject.setStartDate(startDate);
        selectedProject.setEndDate(endDate);
        selectedProject.setDeadline(deadline);

        projectService.updateProject(selectedProject);
        return "/seeProjects";
    }
}





