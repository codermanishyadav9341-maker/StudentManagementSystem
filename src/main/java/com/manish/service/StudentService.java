package com.manish.service;

import com.manish.model.Student;
import java.util.List;
public interface StudentService {

    // Add student;
    boolean addStudent(Student student);

    //View all Student;
    List<Student> getAllStudent();

    //Search by id;
    Student studentById(int id);

    //Search by name;
    List<Student> getStudentByName(Student student);

    //update student;
    boolean updateStudent(Student student);

    //Delete student;
    boolean deleteStudent(int id);

    //Check Student exists
    boolean existsStudent(int id);
}
