package com.parcial.framework.services;

import com.parcial.framework.dao.StudentDao;
import com.parcial.framework.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao dao;

    public List<Student> findAll(){
        return dao.findAll();
    }

    public Student save(Student student){
        return dao.add(student);
    }

    public void deleteById(int id){
        dao.deleteById(id);
    }

    public Student findById(int id){
        return dao.getEmployeeById(id);
    }

    public void update (Student student)  {
        dao.update(student);
    }




}
