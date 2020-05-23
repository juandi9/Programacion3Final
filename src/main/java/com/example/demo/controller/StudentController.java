package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.response.Response;
import com.example.demo.service.StudentService;
import com.example.demo.util.Constants;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;


    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id){
        try {
            return new ResponseEntity<Student>(studentService.getStudent(id),HttpStatus.ACCEPTED);
        }catch (Exception ex){
            return new ResponseEntity(new Response("Student not found",""),HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

  @PostMapping("/student")
    public ResponseEntity<Student> addStudent (@RequestBody Student student){
        if (studentService.findStudent(student)==false && studentService.addStudent(student)==true){
            return new ResponseEntity(new Response(Constants.SUCCESS_MESSAGE,""),HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(new Response(Constants.ERROR_MESSAGE,Constants.STUDENT_ID_IS_ALREADY),HttpStatus.NOT_FOUND);
        }
  }

  @DeleteMapping("/student/{id}")
    public ResponseEntity<Response> deleteStudent (@PathVariable int id){
        return studentService.deleteStudent(id) == false ?
                new ResponseEntity(new Response(Constants.ERROR_MESSAGE,Constants.STUDENT_NOT_FOUND_MESSAGE), HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(new Response(Constants.SUCCESS_MESSAGE , ""));
  }

  @PutMapping("/student")
    public ResponseEntity<Response> modifyStudent (@RequestBody Student student){
        if (studentService.findStudent(student)&&studentService.addStudent(student)==true){
            return new ResponseEntity(new Response(Constants.SUCCESS_MESSAGE,""),HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity(new Response(Constants.ERROR_MESSAGE,Constants.STUDENT_NOT_FOUND_MESSAGE),HttpStatus.NOT_FOUND);
        }
  }

  @GetMapping("/students/best")
    public List<Student> bestStudents (){
        return studentService.bestStudents();
  }



}
