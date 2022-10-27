package com.projectspring.course.resources;

import com.projectspring.course.entities.Order;
import com.projectspring.course.entities.User;
import com.projectspring.course.services.OrderService;
import com.projectspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {       // ResponseEntity é para retornar respostas de requisições web
        List<Order> list = service.findAll();
        return ResponseEntity.ok().body(list);     // retornar um ok e o body de u
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){    //pega o id do value
        Order obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
