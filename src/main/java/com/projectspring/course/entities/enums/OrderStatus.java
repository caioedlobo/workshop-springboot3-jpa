package com.projectspring.course.entities.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) { //construtor do enum é PRIVATE
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrderStatus valueOf(int code) {//método para converter valor numérico para o tipo enumerado (STATIC pq o método funciona sem precisar instanciar
        for(OrderStatus value: OrderStatus.values()){   //percorre todos os valores enumerados
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }



}
