package com.manish.dao;

import com.manish.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.manish.util.DBConnection;

public class StudentDAOImpl implements StudentDAO {
    //------------------------------------Add Student:---------------------------------------------------------
    @Override
    public boolean addStudent(Student student) {
        String str = "INSERT INTO students" +
                "(id,name,age,gender,course,email,phone,address,dateOfBirth,admissionDate,fee,status)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement ps = con.prepareStatement(str);

            ps.setInt(1, student.getId());
            ps.setString(2, student.getName());
            ps.setInt(3, student.getAge());
            ps.setString(4, student.getGender());
            ps.setString(5, student.getCourse());
            ps.setString(6, student.getEmail());
            ps.setString(7, student.getPhone());
            ps.setString(8, student.getAddress());
            ps.setDate(9, java.sql.Date.valueOf(student.getDateOfBirth()));
            ps.setDate(10, java.sql.Date.valueOf(student.getAdmissionDate()));
            ps.setDouble(11, student.getFee());
            ps.setString(12, student.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

//--------------------------------View Student--------------------------------------------------------------
    @Override
    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        String str = "SELECT *FROM students";

        try(Connection con = DBConnection.getConnection()){
            PreparedStatement ps = con.prepareStatement(str);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setCourse(rs.getString("course"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setAddress(rs.getString("address"));
                student.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                student.setAdmissionDate(rs.getDate("admissionDate").toLocalDate());
                student.setFee(rs.getDouble("fee"));
                student.setStatus(rs.getString("status"));

                students.add(student);
            }

        }
        catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
        return students;
    }

    //---------------------------------------:Search by id:---------------------------------------------;

    @Override
    public Student getStudentById(int id){
        String sql = "SELECT *FROM students WHERE id = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getString("gender"));
                student.setEmail(rs.getString("email"));
                student.setPhone(rs.getString("phone"));
                student.setCourse(rs.getString("course"));
                student.setAddress(rs.getString("address"));
                student.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                student.setAdmissionDate(rs.getDate("admissionDate").toLocalDate());
                student.setFee(rs.getDouble("fee"));
                student.setStatus(rs.getString("status"));

                return student;
            }
        }
        catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
        return null;
    }

    //----------------------------------------:Search by email:-------------------------------------------
@Override
    public Student getStudentByEmail(String email){
        String sql = "SELECT *FROM students WHERE email = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setPhone(rs.getString("phone"));
                student.setGender(rs.getString("gender" ));
                student.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                student.setAdmissionDate(rs.getDate("admissionDate").toLocalDate());
                student.setFee(rs.getDouble("fee"));
                student.setStatus(rs.getString("status"));

                return student;
            }
        }
        catch (SQLException e){
            throw new IllegalArgumentException(e);
        }
       return null;
    }

    //-------------------------------------:Search student by name:-------------------------------------;

    @Override
    public List<Student> getStudentsByName(String name){
        List<Student> student = new ArrayList<>();

        String str = "SELECT *FROM students WHERE name  = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Student students = new Student();

                students.setId(rs.getInt("id"));
                students.setName(rs.getString("name"));
                students.setAge(rs.getInt("age"));
                students.setGender(rs.getString("gender"));
                students.setCourse(rs.getString("course"));
                students.setAddress(rs.getString("address"));
                students.setPhone(rs.getString("phone"));
                students.setEmail(rs.getString("email"));
                students.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                students.setAdmissionDate(rs.getDate("admissionDate").toLocalDate());
                students.setFee(rs.getDouble("fee"));
                students.setStatus(rs.getString("status"));

                student.add(students);
            }
        }
        catch(SQLException e){
            throw new IllegalArgumentException(e);
        }
        return student;
    }

    //--------------------------------Update Student:------------------------------------------------;
    @Override
    public boolean updateStudent(Student student){
        String sql = "UPDATE students SET "
                + "name = ?,age = ? , gender = ?,course = ? , phone = ? ,email =  ?,address = ? "
                + "dateOfBirth = ?, admissionDate = ? ,fee = ? ,status = ?" +
                " WHERE id = ?";


        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,student.getName());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getGender());
            ps.setString(4,student.getCourse());
            ps.setString(5,student.getPhone());
            ps.setString(6,student.getEmail());
            ps.setString(7,student.getAddress());
            ps.setDate(8,java.sql.Date.valueOf(student.getDateOfBirth()));
            ps.setDate(9,java.sql.Date.valueOf(student.getAdmissionDate()));
            ps.setDouble(10,student.getFee());
            ps.setString(11,student.getStatus());
            ps.setInt(12,student.getId());

            return ps.executeUpdate()  > 0;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
//---------------------------------------:Delete student from id:----------------------------------------;
    @Override
    public boolean deleteStudent(int id){
        String str = "DELETE FROM students WHERE id = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(str);

            ps.setInt(1,id);

            return ps.executeUpdate() > 0;
        }
         catch(SQLException e){
            e.printStackTrace();
         }
return false;
    }

    //---------------------------------------:Exists by id:------------------------------------------;
    @Override
    public boolean existsStudent(int id){
        String str = "SELECT id FROM students WHERE id = ?";

        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(str);

            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
return  false;
    }

}
