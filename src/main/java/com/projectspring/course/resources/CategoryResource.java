package com.projectspring.course.resources;

import com.projectspring.course.entities.Category;
import com.projectspring.course.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private CategoryService service;
    public CategoryResource(CategoryService service) {      //tive que criar fora da aula, não funciona sem
        this.service = service;
    }



    @GetMapping
    public ResponseEntity<List<Category>> findAll() {       // ResponseEntity é para retornar respostas de requisições web
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);     // retornar um ok e o body de u
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){    //pega o id do value

        Category obj = this.service.findById(id);
        System.out.println(obj);
        return ResponseEntity.ok().body(obj);
    }
}
