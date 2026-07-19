package com.manish.menu;

import com.manish.service.StudentService;
import com.manish.service.StudentServiceImpl;

import java.util.Scanner;
public class StudentMenu {

    private final Scanner scan = new Scanner(System.in);

    //Service Object to perform business operations
    private final StudentService service = new StudentServiceImpl();

    //Start menu method;
    public void start(){

        //Infinite loop to display;
        while(true){
            System.out.println(":-----------------:STUDENT MANAGEMENT SYSTEM:----------------");
            System.out.println("1.Add Student");
            System.out.println("2.View all Student");
            System.out.println("3.Search Student by Id");
            System.out.println("4.Search Student by name");
            System.out.println("5.Search Student by email");
            System.out.println("6.Update Student");
            System.out.println("7.Delete Student");
            System.out.println("8.Exist");


            //Take user choice
            System.out.print("Enter Choice:- ");
        }
    }
}
