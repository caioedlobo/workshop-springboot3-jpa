package com.projectspring.course.resources;

import com.projectspring.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity <User> findAll() {       // ResponseEntity é para retornar respostas de requisições web
        User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");

        return ResponseEntity.ok().body(u);     // retornar um ok e o body de u
    }
}
