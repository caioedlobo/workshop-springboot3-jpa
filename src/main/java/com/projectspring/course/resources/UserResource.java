package com.projectspring.course.resources;

import com.projectspring.course.entities.User;
import com.projectspring.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity <List<User>> findAll() {       // ResponseEntity é para retornar respostas de requisições web
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);     // retornar um ok e o body de u
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){    //pega o id do value
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){  // oara dizer que o obj vai chegar como json e vai virar um objeto do tipo User usamos o RequestBody
        obj = service.insert(obj);
        //como o codigo deve ser 201 (created) temos que fazer isso
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);       //precisa do location que é o que colocamos no uri
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();        //retorno vazio é o 204, que é o que vai retornar
    }

}
