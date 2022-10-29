package com.projectspring.course.resources;

import com.projectspring.course.entities.Product;
import com.projectspring.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    //public ProductResource(ProductService service){
        //this.service = service;
    //}

    @GetMapping
    public ResponseEntity <List<Product>> findAll(){    //quando retorna algo, acho que precisa retornar o ResponseEntity
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){    //pega o id do value
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
