package com.manish.dao;

import com.manish.model.Student;
import java.util.List;
public interface StudentDAO {

    //Add Student
    boolean addStudent(Student student);

    //View All Student
    List<Student> getAllStudents();

    // Student search by id;
    Student getStudentById(int id);

    //Search Student by name;
    Student getStudentByEmail(String email);

    //Update Student;
    boolean updateStudent(Student student);

    //Delete Student;
    boolean deleteStudent(int id);


    // check Student exists;
    boolean existsStudent(int id);
}
