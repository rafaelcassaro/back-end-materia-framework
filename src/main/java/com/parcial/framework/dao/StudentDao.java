package com.parcial.framework.dao;

import com.parcial.framework.db.ConnectionDb;
import com.parcial.framework.entities.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao extends Daos<Student>{

    public StudentDao() {
        super();

    }

    @Override
    String sqlCommandFindAll() {
        return "SELECT * FROM student";
    }

    @Override
    String sqlCommandFindByID() {
        return "select * from student where id= ?";
    }

    @Override
    String sqlCommandDeleteByID() {
        return "delete from student where id =?";
    }

    @Override
    String sqlCommandAdd() {
        return "insert into student(first_name, last_name) VALUES (?, ?)";
    }

    @Override
    String sqlCommandUpdate() {
        return "update student set first_name=?, last_name= ? where id = ?";
    }

    @Override
    void ProcessingResultFindAll() {
        try {
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                ls.add(student);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    void ProcessingResultFindByID() {
        try {
            object = new Student();


            while (resultSet.next()) {

                object.setId(resultSet.getInt("id"));
                object.setFirstName(resultSet.getString("first_name"));
                object.setLastName(resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void ProcessingResultAdd(Student object) {
        try {

            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    void ProcessingResultUpdate(Student object) {
        try {
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setInt(3, object.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
