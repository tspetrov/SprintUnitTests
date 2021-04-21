package com.example.testspringmavenproblem.classestotest;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Item {

    private String name;
    private int price;
    private int quantity;
    private Long id;


    private int value;

    public Item(Long id, String name, int price, int quantity) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Item() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Transient
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
