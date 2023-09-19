package com.parcial.framework.dao;

import com.parcial.framework.db.ConnectionDb;
import com.parcial.framework.entities.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class Daos <T> {

    ConnectionDb connectionDb = ConnectionDb.getInstance();
    Connection conn = connectionDb.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    List<T> ls = new ArrayList<>();
    T object;
    
    protected Daos() {

    }

    /*public Daos(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet, List<T> ls, T object) {
        this.conn = conn;
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
        this.ls = ls;
        this.object = object;
    }

    public Daos(Connection conn, PreparedStatement preparedStatement, ResultSet resultSet, List<T> ls, T object) {
        this.conn = conn;
        this.preparedStatement = preparedStatement;
        this.resultSet = resultSet;
        this.ls = ls;
        this.object = object;
    }*/

    public List<T> findAll(){
        try {
            String sql = sqlCommandFindAll();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            ProcessingResultFindAll();

            resultSet.close();
            preparedStatement.close();
            return ls;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public T findById(int id){
        try {
            preparedStatement = conn.prepareStatement(sqlCommandFindByID());
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            ProcessingResultFindByID();

            resultSet.close();
            preparedStatement.close();

            return object;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteById(int id){
        try {
            preparedStatement = conn.prepareStatement(sqlCommandDeleteByID());
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public T add(T obj){
        try {

            preparedStatement = conn.prepareStatement(sqlCommandAdd());

            ProcessingResultAdd(obj);

            preparedStatement.executeUpdate();
            return obj;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update (T obj){
        try {

            preparedStatement = conn.prepareStatement(sqlCommandUpdate());
            ProcessingResultUpdate(obj);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }




    abstract String sqlCommandFindAll();
    abstract String sqlCommandFindByID();
    abstract String sqlCommandDeleteByID();
    abstract String sqlCommandAdd();
    abstract String sqlCommandUpdate();


    abstract void ProcessingResultFindAll();
    abstract void ProcessingResultFindByID();
    abstract void ProcessingResultAdd(T obj);

    abstract void ProcessingResultUpdate(T obj);


}
