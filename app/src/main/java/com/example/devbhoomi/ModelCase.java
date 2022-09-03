package com.example.devbhoomi;

public class ModelCase {
    String id,name,phone,city,drug,quantity, age;

    public ModelCase(){}

    public ModelCase(String name,String phone,String city,String drug,String quantity,String id, String age){
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.city=city;
        this.drug=drug;
        this.quantity=quantity;
        this.age=age;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.id = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDrug() {
        return drug;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.quantity = phone;
    }
}