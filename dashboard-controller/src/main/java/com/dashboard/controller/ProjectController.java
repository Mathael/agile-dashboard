package com.dashboard.controller;

import com.dashboard.api.bean.Response;
import com.dashboard.api.services.ProjectService;
import com.dashboard.core.model.project.Project;
import com.dashboard.request.ProjectCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Leboc Philippe.
 */
@RestController
@RequestMapping(value = "/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = GET)
    public Response findAll() {
        return new Response(projectService.findAll());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Response findById(@PathVariable("id") int id) {
        return new Response(projectService.find(id));
    }

    @RequestMapping(method = POST)
    public Response create(@RequestBody ProjectCreationRequest request){
        return new Response(projectService.save(new Project(request.getLabel(), request.getDescription())));
    }
}
