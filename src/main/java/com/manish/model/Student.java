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
    private LocalDate admissionDate;
    private double fee;
    private String status;



    //Default Constructor
    public Student(){}

    //Parameterized Constructor
    public Student(int id,String name,int age,String gender,String course,String email,String phone,String address
   , LocalDate dateOfBirth,LocalDate admissionDate,double fee,String status){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.admissionDate = admissionDate;
        this.fee = fee;
        this.status = status;
    }

    //      Using getter and Setter

    public void setId(int id){
        if(id >= 0) {
            this.id = id;
        }
        else{
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        else{
            throw new IllegalArgumentException("Invalid name");
        }
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

    public void setGender(String gender) {
        if (gender != null &&
                (gender.equalsIgnoreCase("Male") ||
                gender.equalsIgnoreCase("Female") ||
                gender.equalsIgnoreCase("Other"))) {
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid gender");
        }
    }

    public String getGender(){
        return gender;
    }

    public void setCourse(String course){
        if(course != null && !course.trim().isEmpty()) {
            this.course = course;
        }
        else{
            throw new IllegalArgumentException("Invalid course");
        }
    }

    public String getCourse(){
        return course;
    }

    public void setEmail(String email){
       if(email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
           throw new IllegalArgumentException("Invalid email");
       }
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhone(String phone){
       if((phone == null || !phone.matches("\\d{10}"))){
           throw new IllegalArgumentException("Phone number must be contain 10 digits");
       }
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setAddress(String address){
        if(address != null && !address.trim().isEmpty()) {
            this.address = address;
        }
         else{
             throw new IllegalArgumentException("Invalid address");
        }
    }

    public String getAddress(){
        return address;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
       if(dateOfBirth == null || dateOfBirth.isAfter(LocalDate.now())){
           throw new IllegalArgumentException("Invalid  date of Birth");
       }
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }

    public void setAdmissionDate(LocalDate admissionDate){
        if(admissionDate == null || admissionDate.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Invalid AdmissionDate");
        }
        this.admissionDate = admissionDate;
    }

    public LocalDate getAdmissionDate(){
        return admissionDate;
    }

    public void setFee(double fee){
       if(fee < 0){
           throw new IllegalArgumentException("Fee cannot be negative");
       }
        this.fee = fee;
    }


    public double getFee(){
        return fee;
    }

    public void setStatus(String status){
        if(status != null &&
                (status.equalsIgnoreCase("Active") ||
            status.equalsIgnoreCase("InActive"))) {


            this.status = status;
            return;
        }
         throw new IllegalArgumentException("Invalid status");
    }


    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return "Student{" +
                "Id:- " +id+ "\n"+
                "Name:- " +name+ "\n"+
                "Age:- " +age+ "\n"+
                "Gender:- " +gender+ "\n"+
                "Course:- " +course+ "\n"+
                "Email:- " +email+ "\n"+
                "Phone:- " +phone+ "\n"+
                "Address:- " +address+ "\n"+
                "DateOfBirth:- " +dateOfBirth+ "\n"+
                "Admission Date:- " +admissionDate+ "\n"+
                "Fee:- " +fee+ "\n"+
                "Status:- " +status+ "\n";


    }

}


