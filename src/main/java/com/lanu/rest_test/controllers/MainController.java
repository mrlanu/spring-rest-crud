package com.lanu.rest_test.controllers;

import com.lanu.rest_test.domains.Student;
import com.lanu.rest_test.domains.StudentErrorResponse;
import com.lanu.rest_test.domains.StudentNotFoundException;
import com.lanu.rest_test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id){
        Student result = studentService.findByStudentId(id);
        if(result != null){
            return result;
        }else {
            throw new StudentNotFoundException(String.format("The student with id - %d hasn't been founded", id));
        }
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    /*@GetMapping("/findAllByLastName")
    public List<Student> getAllStudentByLastName(@RequestParam("lastName")String lastName){
        return studentService.findAllByLastName(lastName);
    }*/

    /*@GetMapping("/students/{lastName}")
    public List<Student> getAllStudentByLastName(@PathVariable String lastName){
        return studentService.findAllByLastName(lastName);
    }*/

    @PostMapping("/students")
    public Student newStudent(@RequestBody Student student){
        studentService.save(student);
        return student;
    }

}
