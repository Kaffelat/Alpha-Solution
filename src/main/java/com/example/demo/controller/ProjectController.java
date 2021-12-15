package com.example.demo.controller;

import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepo;
import com.example.demo.services.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProjectController {
    private ProjectRepo projectRepo = new ProjectRepo();
    private ProjectService projectService = new ProjectService();

    @GetMapping("/createProject")
    public String createProject(){
        return "createProject";
    }

    @PostMapping(value = "/createProject")
    public String createNewProject(@RequestParam("projectName") String projectName, @RequestParam("projectId") int projectId, @RequestParam("projectAssignments") String projectAssignments, @RequestParam("status") String status, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("deadline") String deadline, RedirectAttributes attributes){

        System.out.println(projectName);
        Project projectFromUser = projectService.createNewProject(projectId,projectName,projectAssignments,status,startDate,endDate,deadline);
        attributes.addAttribute("projectName", projectName);
        attributes.addAttribute("projectId", projectId);
        attributes.addAttribute("projectAssignments", projectAssignments);
        attributes.addAttribute("status", status);
        attributes.addAttribute("startDate", startDate);
        attributes.addAttribute("endDate", endDate);
        attributes.addAttribute("deadline", deadline);

        projectRepo.insertProjectIntoDB(projectFromUser);
        return "redirect:/createProjectSuccess";
    }

    @GetMapping("createProjectSuccess")
    @ResponseBody
    public String createProjectPageSuccess(@RequestParam String projectName, @RequestParam int projectId, @RequestParam String projectAssignments, @RequestParam String status, @RequestParam String startDate, @RequestParam String endDate, @RequestParam String deadline){
        return "Project created with name: " + projectName + " and its Id " + projectId + " and the assignments " + projectAssignments +" the status of the project is " + status + " the project started on " + startDate + " the project ended on " + endDate + " the project's deadline is " + deadline;
    }

    @GetMapping("/seeProjects")
    public String seeProjects(Model model){
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("Projects", projects);
        return "seeProjects";
    }

    /*@GetMapping("/deleteProject")
        public String deleteProjectFromDB(int Id){
        projectService.deleteProjectFromDB(Id);
        return "seeProjects";
        }*/

        @GetMapping("/editProject")
        public String editProject(){

        return "editProject";
    }

        @RequestMapping("/editProject")
        public String changesMadeToProject(){

            return "/";
            }
        }



