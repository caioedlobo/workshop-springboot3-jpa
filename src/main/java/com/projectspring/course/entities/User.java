package com.projectspring.course.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// colocar annotations para que o JPA saiba como converter os objetos para o modelo relacional
@Entity
@Table(name = "tb_user")    // especificando o nome da tabela do banco de dados
public class User implements Serializable{     // Serializable para o objeto poder trafegar na rede, ser gravado em arquivos.

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    //coloca so o get da List porque não podemos ficar setando ela (Coleções é somente o get)
    @OneToMany(mappedBy = "client")        //falar com quem ele está mapeado
    private List<Order> orders = new ArrayList<>();     //como é coleção tem que se instanciado (colocar o =  new...)

    //como é framework é obrigado a colocar um construtor vazio
    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
