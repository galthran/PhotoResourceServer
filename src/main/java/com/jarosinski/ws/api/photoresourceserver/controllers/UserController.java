package com.jarosinski.ws.api.photoresourceserver.controllers;

import com.jarosinski.ws.api.photoresourceserver.response.UserRest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/status")
    public String status() {
        return "Working....";
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGER') or #id == #jwt.subject")
    //@PreAuthorize("hasRole('MANAGER') or #id == #jwt.subject")
    //@Secured({"ROLE_MANAGER", "ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        return "Deleted user with id: " + id;
    }

    @PostAuthorize("returnObject.userId == #jwt.subject")
    @GetMapping("/{id}")
    public UserRest getUser(@PathVariable String id) {
        return new UserRest(id, "John", "Doe");
    }

    /*

     */
}
