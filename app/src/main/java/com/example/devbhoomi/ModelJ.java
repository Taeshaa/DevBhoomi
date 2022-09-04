package com.example.devbhoomi;

public class ModelJ {
    String id,name,category,bailable,city,date, desc,age;

    public ModelJ(){}

    public ModelJ(String age,String name,String category,String bailable,String city,String date, String desc,String id){
        this.id=id;
        this.name=name;
        this.category=category;
        this.bailable=bailable;
        this.city=city;
        this.date=date;
        this.desc=desc;
        this.age=age;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBailable() {
        return bailable;
    }
    public void  setBailable(String bailable){
        this.bailable=bailable;
    }

    public String getAge() {
        return age;
    }
    public void  setAge(String age){
        this.age=age;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}