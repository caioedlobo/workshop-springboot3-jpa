package com.projectspring.course.services;

import com.projectspring.course.entities.Category;
import com.projectspring.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;



    public List<Category> findAll(){        //retorna todos os usuários
        return this.repository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> obj = this.repository.findById(id);
        return obj.get();
    }
}
