package com.parcial.framework.controllers;


import com.parcial.framework.entities.Student;
import com.parcial.framework.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/students")
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping("students/{id}")
    public Student findStudentById(@PathVariable int id){
        Student student = service.findById(id);

        return student;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) throws SQLException {
        student.setId(0);
        Student dbStudent = service.save(student);
        return dbStudent;
    }

    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable int id){
        service.deleteById(id);
    }

    @PutMapping("/students")
    public void upadateStudent(@RequestBody Student student){
        service.update(student);

    }





}
