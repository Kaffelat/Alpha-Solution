package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
//Simon Bøg Jørgensen
@Controller
public class ProjectController {
    ProjectRepo projectRepo = new ProjectRepo();
    ProjectService projectService = new ProjectService();
    Project selectedProject = new Project();


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
        return "/seeAllProjects";
    }


    @GetMapping("/seeProjects")
    public String seeProjects(Model model) {

        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("Projects", projects);

        return "seeAllProjects";
    }
    @GetMapping("/project/{projectId}")
    public String project(@PathVariable int projectId, Model model) {

        List<Project> projectList = new ArrayList<>();

        projectList.add(projectService.getProjectFromDB(projectId));

        model.addAttribute("projectList", projectList);
        return "seeProject";
    }

    @GetMapping("/editProject{projectId}")
    public String editProject(@PathVariable int projectId, Model model) {

        selectedProject = projectService.getProjectFromDB(projectId);

        model.addAttribute("Project", projectService.getProjectFromDB(projectId));

        return "editProject";
    }
    //virker ikke
    @RequestMapping("/editProject")
    public String changesMadeToProject(@RequestParam("projectName") String projectName, @RequestParam("projectId") int projectId, @RequestParam("projectAssignments") String projectAssignments, @RequestParam("status") String status, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("deadline") String deadline,RedirectAttributes attributes) {

        Project selectedProject = projectService.createNewProject(projectId, projectName, projectAssignments, status, startDate, endDate, deadline);
        attributes.addAttribute("projectName", projectName);
        attributes.addAttribute("projectAssignments", projectAssignments);
        attributes.addAttribute("status", status);
        attributes.addAttribute("startDate", startDate);
        attributes.addAttribute("endDate", endDate);
        attributes.addAttribute("deadline", deadline);
        attributes.addAttribute("projectId", projectId);

        projectService.updateProject(selectedProject);

        return "seeAllProjects";
    }

    @GetMapping("/deleteProject/{projectId}")
    public String deleteProject (@PathVariable String projectId){
        int Id = Integer.parseInt(projectId);
        projectService.deleteProjectFromDB(Id);
        return "seeAllProjects";
    }
}







