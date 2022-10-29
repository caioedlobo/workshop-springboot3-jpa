package com.projectspring.course.services;

import com.projectspring.course.entities.Order;
import com.projectspring.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service     //para poder ser injetado no OrderResource através do Autowired
public class OrderService {

    @Autowired//injeção de dependência
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
