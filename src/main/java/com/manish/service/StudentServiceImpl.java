package com.manish.service;

import com.manish.dao.StudentDAO;
import com.manish.dao.StudentDAOImpl;
import com.manish.model.Student;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO;

    public StudentServiceImpl(){
        studentDAO = new StudentDAOImpl();
    }

//-------------------------------:Add student:----------------------------------------------------------
    @Override
    public boolean addStudent(Student student){
        return studentDAO.addStudent(student);
    }
}
