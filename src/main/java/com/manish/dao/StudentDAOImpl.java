package com.manish.dao;

import com.manish.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.manish.util.DBConnection;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public boolean addStudent(Student student){
        String str = "INSERT INTO students"
                +"id,name,age,gender,course,email,phone,address"
                +"date_of_birth,admission_date,fee,status"
                +"VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement(str);

                ps.setInt(1,student.getId());
                ps.setString(2,student.getName());
                ps.setInt(3,student.getAge());
                ps.setString(4,student.getGender());
                ps.setString(5,student.getCourse());
                ps.setString(6,student.getEmail());
                ps.setString(7,student.getPhone());
                ps.setString(8,student.getAddress());
                ps.setDate(9,java.sql.Date.valueOf(student.getDateOfBirth()));
                ps.setDate(10,java.sql.Date.valueOf(student.getAdmissionDate()));
                ps.setDouble(11,student.getFee());
                ps.setString(12,student.getStatus());

                return ps.executeUpdate() > 0;

        }
        catch(SQLException e){
            e.printStackTrace();
        }
return false;
    }
}
