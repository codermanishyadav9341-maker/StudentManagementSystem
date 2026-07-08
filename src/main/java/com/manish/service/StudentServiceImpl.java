package com.manish.service;

import com.manish.dao.StudentDAO;
import com.manish.dao.StudentDAOImpl;
import com.manish.model.Student;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl() {
        studentDAO = new StudentDAOImpl();
    }

    //-------------------------------:Add student:----------------------------------------------------------
    @Override
    public boolean addStudent(Student student) {
        return studentDAO.addStudent(student);
    }

//-----------------------------------------:View Student:---------------------------------------------------

    @Override
    public List<Student> getAllStudent(){
        return studentDAO.getAllStudents();
    }

//--------------------------------------:Search by id:-------------------------------------------------------
    @Override
    public Student studentById(int id){
        return studentDAO.getStudentById(id);
    }

//----------------------------------:Search by name:---------------------------------------------------------
    @Override
    public List<Student> getStudentByName(String name){
        return studentDAO.getStudentsByName(name);
    }

//-----------------------------------------:Search by email:------------------------------------------------
    @Override
    public Student studentByEmail(String email){
        return studentDAO.getStudentByEmail(email);
    }

//-----------------------------------------:Update Student:-------------------------------------------------

    public boolean updateStudent(Student student){
        return studentDAO.updateStudent(student);
    }

//------------------------------------------:Delete student:-----------------------------------------------

    public boolean deleteStudent(int id){
        return studentDAO.deleteStudent(id);
    }

//-------------------------------------------Exists student:-----------------------------------------------
    @Override
    public boolean existsStudent(int id){
        return studentDAO.existsStudent(id);
    }

}
