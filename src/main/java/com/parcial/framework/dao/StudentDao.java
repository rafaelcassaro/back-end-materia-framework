package com.parcial.framework.dao;

import com.parcial.framework.db.ConnectionDb;
import com.parcial.framework.entities.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao{

    Connection conn = ConnectionDb.getInstance().getConnection();

    public StudentDao() {

    }

    public List<Student> findAll(){
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Student> ls = new ArrayList<>();

            // Processa os resultados da consulta
            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                ls.add(student);


                //int id = resultSet.getInt("id");
                //String nome = resultSet.getString("first_name");
                // Faça algo com os dados recuperados do banco de dados
            }
            resultSet.close();
            preparedStatement.close();
            return ls;
            // Feche os recursos do banco de dados

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
            // Lide com exceções de consulta aqui
        }

    }

    public Student findById(int id)
    {
        try {
            String query
                    = "select * from student where id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ps.setInt(1, id);
            Student emp = new Student();

            boolean check = false;

            while (rs.next()) {
                check = true;
                emp.setId(rs.getInt("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
            }

            if (check == true) {
                return emp;
            }
            else
                return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student add(Student emp)
    {
        try {
            String query
                    = "insert into student(first_name, last_name) VALUES (?, ?)";
            PreparedStatement ps
                    = conn.prepareStatement(query);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());

            ps.executeUpdate();
            return emp;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(int id)
    {
        try {
            String query
                    = "delete from student where id =?";
            PreparedStatement ps
                    = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

        }
        catch(SQLException e){
            e.printStackTrace();

        }
    }

    public void update(Student emp)
    {
        try {
            String query
                    = "update student set first_name=?, "
                    + " last_name= ? where id = ?";
            PreparedStatement ps
                    = conn.prepareStatement(query);
            ps.setString(1, emp.getFirstName());
            ps.setString(2, emp.getLastName());
            ps.setInt(3, emp.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }





}
