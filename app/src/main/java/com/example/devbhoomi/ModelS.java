package com.example.devbhoomi;

public class ModelS {
    String id,name,category,bailable,city,rdate, cdesc,age;

    public ModelS(){}

    public ModelS(String age,String name,String category ,String bailable,String city,String rdate, String cdesc,String id){
        this.id=id;
        this.name=name;
        this.category=category;
        this.bailable=bailable;
        this.city=city;
        this.rdate=rdate;
        this.cdesc=cdesc;
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


    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getCdesc() {
        return cdesc;
    }

    public void setCdesc(String cdesc) {
        this.cdesc = cdesc;
    }
}