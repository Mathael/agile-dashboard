package com.dashboard.controller;

import com.dashboard.api.bean.Response;
import com.dashboard.api.services.UserGroupService;
import com.dashboard.core.model.user.UserGroup;
import com.dashboard.request.UserGroupCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author Leboc Philippe.
 */
@RestController
@RequestMapping(name = "/user/group", produces = APPLICATION_JSON_UTF8_VALUE)
public class UserGroupController {

    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(method = GET)
    public Response findAll() {
        return new Response(userGroupService.findAll());
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Response findById(@PathVariable("id") int id) {
        return new Response(userGroupService.find(id));
    }

    @RequestMapping(method = POST)
    public Response create(@RequestBody UserGroupCreationRequest request) {
        return new Response(userGroupService.save(new UserGroup(request.getLabel(), request.getDescription())));
    }
}
