package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") //setting an address
public class StudentController {

    private final StudentService studentService;

    //dependency injection: automatically instantiates StudentService and injects it into controller constructor
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //getting something out of the server
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    //POST
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    //DELETE
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
