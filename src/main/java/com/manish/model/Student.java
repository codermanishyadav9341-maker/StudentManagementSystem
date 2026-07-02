package com.manish.model;

import java.time.LocalDate;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private String course;
    private String email;
    private String phone;
    private String address;
    private LocalDate dateOfBirth;


    //Default Constructor
    public Student(){}

    //Parameterized Constructor
    public Student(int id,String name,int age,String gender,String course,String email,String phone,String address){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    //      Using getter and Setter

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setAge(int age){
        if(age < 1 || age >= 100){
            throw new IllegalArgumentException("Invalid age");
        }
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getCourse(){
        return course;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }
}


