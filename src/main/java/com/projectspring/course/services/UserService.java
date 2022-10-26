package com.projectspring.course.services;

import com.projectspring.course.entities.User;
import com.projectspring.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service     //para poder ser injetado no UserResource através do Autowired
public class UserService  {

    @Autowired//injeção de dependência
    private UserRepository repository;

    public List<User> findAll(){        //retorna todos os usuários
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
