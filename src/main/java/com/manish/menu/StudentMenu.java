package com.manish.menu;

import com.manish.service.StudentService;
import com.manish.service.StudentServiceImpl;
import com.manish.model.Student;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
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
            int choice = scan.nextInt();

            //Consume newLine
            scan.nextLine();

            switch(choice){

                case 1:
                    addStudent();  //Add Student;
                    break;

                case 2:
                    viewAllStudents();  // View all student;
                    break;

                case 3:
                    searchById();  // student search by id;
                    break;

                case 4:
                    searchByName();   // student search by name;
                    break;

                case 5:
                    searchByEmail();    // student search  by email;
                    break;

                case 6:
                    updateStudent();     // update student;
                    break;

                case 7:
                    deleteStudent();   // student delete;
                    break;

                case 8:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // -----------------------------------------------:add student:-----------------------------------------------

          private void addStudent(){
        Student student = new Student();

        System.out.print("ID:- ");
        student.setId(scan.nextInt());
        scan.nextLine();

        System.out.print("Name:- ");
        student.setName(scan.nextLine());

        System.out.print("Age:- ");
        student.setAge(scan.nextInt());
        scan.nextLine();

        System.out.print("Gender:- ");
        student.setGender(scan.nextLine());

        System.out.print("Course:- ");
        student.setCourse(scan.nextLine());

        System.out.print("Email:- ");
        student.setEmail(scan.nextLine());

        System.out.print("Phone:- ");
        student.setPhone(scan.nextLine());

        System.out.print("Address:- ");
        student.setAddress(scan.nextLine());

        System.out.print("Date Of Birth(yyyy-mm-dd):- ");
        student.setDateOfBirth(LocalDate.parse(scan.nextLine()));

        System.out.print("Admission(yyyy-mm-dd):- ");
        student.setAdmissionDate(LocalDate.parse(scan.nextLine()));

        System.out.print("Fee:- ");
        student.setFee(scan.nextDouble());
        scan.nextLine();

        System.out.print("Status:- ");
        student.setStatus(scan.nextLine());

        if(service.addStudent(student)){
            System.out.println("Student Added Successfully");
        }
         else{
             System.out.println("Filed added student");
        }
    }
  //-----------------------------------------:View Student:-----------------------------------------------------
         private void viewAllStudents(){
        List<Student> list = new ArrayList<>();

        // Check if list is empty
            if(list.isEmpty()){
                System.out.println("No record found");
                return;
            }

            //Print every student;
            list.forEach(System.out::println);
         }


  //------------------------------------------:Search student by id:-------------------------------------------------
      private void searchById(){   // method Search by id;

        System.out.print("Enter ID:- ");
        int id = scan.nextInt();

        //Search student;
          Student student = service.getStudentById(id);


          if(student != null){
              System.out.println(student);
          }
           else{
               System.out.println("Student not found");
          }
      }

//-------------------------------------------------:Search by name:-------------------------------------------------
    private void searchByName(){

        System.out.print("Enter Name:- ");
        String name = scan.nextLine();

        //Search by name;
       List<Student> list = service.getStudentByName(name);

       if(list == null){
           System.out.println("No record found");
           return;
       }

       list.forEach(System.out::println);
    }
//-----------------------------------------:Search by email:-------------------------------------------------------
    private void searchByEmail(){

        System.out.print("Enter Email:- ");
        String email = scan.nextLine();

        //Search student by email;
        Student student = service.getStudentByEmail(email);

        if(email != null){
            System.out.println(student);
        }
         else{
             System.out.println("No Record found");
        }
    }

    //--------------------------------------------:Update Student:-------------------------------------------------
    private void updateStudent(){

        System.out.print("Enter Student ID:- ");
        int id = scan.nextInt();
        scan.nextLine();

        Student student = service.getStudentById(id);
        if(student == null){
            System.out.println("Student not found");
            return;
        }

        student.setId(id);

        System.out.print("Name:- ");
        student.setName(scan.nextLine());

        System.out.print("Age:- ");
        student.setAge(scan.nextInt());

        System.out.print("Gender:- ");
        student.setGender(scan.nextLine());

        System.out.print("Course:- ");
        student.setCourse(scan.nextLine());

        System.out.print("Email:- ");
        student.setEmail(scan.nextLine());

        System.out.print("Phone:- ");
        student.setPhone(scan.nextLine());

        System.out.print("Address:- ");
        student.setAddress(scan.nextLine());

        System.out.print("Date Of Birth(yyyy-mm-dd):- ");
        student.setDateOfBirth(LocalDate.parse(scan.nextLine()));

        System.out.print("Admission Date(yyyy-mm-dd):- ");
        student.setAdmissionDate(LocalDate.parse(scan.nextLine()));

        System.out.print("Fee:- ");
        student.setFee(scan.nextDouble());

        System.out.print("Status:- ");
        student.setStatus(scan.nextLine());

        if(service.updateStudent(student)){
            System.out.println("Student update Successfully");
        }
         else{
             System.out.println("filed to update student");
        }
    }

    //-------------------------------:Delete student:-----------------------------------------------
    private void deleteStudent(){

        System.out.print("Enter ID:- ");
        int id = scan.nextInt();

        if(service.deleteStudent(id)){
            System.out.println("Deleted student Successfully");
        }
         else{
             System.out.println("Failed deleted student");
        }
    }
}
