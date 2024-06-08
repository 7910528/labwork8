package com.labworks.projectmanager.controller;

import com.labworks.projectmanager.entity.Project;
import com.labworks.projectmanager.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public String listProjects(Model model, Principal principal) {
        model.addAttribute("projects", projectService.findAll());
        return "projects";
    }

    @GetMapping("/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-form";
    }

    @PostMapping("/create")
    public String createProject(Project project) {
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/edit/{id}")
    public String editProjectForm(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        return "project-form";
    }

    @PostMapping("/edit/{id}")
    public String editProject(@PathVariable Long id, Project project) {
        project.setId(id);
        projectService.save(project);
        return "redirect:/projects";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return "redirect:/projects";
    }

    @GetMapping("/{id}")
    public String projectDetails(@PathVariable Long id, Model model) {
        model.addAttribute("project", projectService.findById(id));
        return "project-details";
    }
}
