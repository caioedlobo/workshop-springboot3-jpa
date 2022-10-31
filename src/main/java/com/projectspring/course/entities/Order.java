package com.projectspring.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projectspring.course.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {  // Serializable para o objeto poder trafegar na rede, ser gravado em arquivos.

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    private Integer orderStatus;

    //@JsonIgnore optou por deixar apenas no User
    @ManyToOne      // para dizer que é uma chave estrangeira muitos para um
    @JoinColumn(name = "client_id")     // nome da chave
    private User client;

    @OneToMany(mappedBy = "id.order")   //id.order porque ele tem que acessar o id e depois o order que está dentro dele
    private Set<OrderItem> items = new HashSet<>();     // faz o pedido conhecer os itens dele
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)       //como é OneToOne colocamos o cascade
    //mapeamos as duas entidades para terem o mesmo ID, se o pedido for codigo 5, o pedido também terá codigo 5
    private Payment payment;

    public Order() {
    }

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);    // como é static pode chamar assim
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if(orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<OrderItem> getItems(){
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal(){
        double sum = 0.0;
        for(OrderItem oi: items ){
            sum += oi.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return getId().equals(order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
