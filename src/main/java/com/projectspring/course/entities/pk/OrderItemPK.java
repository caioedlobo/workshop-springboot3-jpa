package com.projectspring.course.entities.pk;

import com.projectspring.course.entities.Order;
import com.projectspring.course.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;
@Embeddable
public class OrderItemPK {      //sempre que precisar criar uma classe auxiliar para ser uma chave primária composta, cria um package pk

    private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    //não cria construtor


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override                               //coloca tanto order como product
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK that)) return false;
        return getOrder().equals(that.getOrder()) && getProduct().equals(that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrder(), getProduct());
    }
}
