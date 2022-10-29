package com.projectspring.course.services;

import com.projectspring.course.entities.Product;
import com.projectspring.course.entities.User;
import com.projectspring.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //public ProductService(ProductRepository repository) {
        //this.repository = repository;
    //}

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
