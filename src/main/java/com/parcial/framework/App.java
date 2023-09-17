package com.parcial.framework;

import com.parcial.framework.dao.ConnectionDb;
import com.parcial.framework.dao.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void main(String[] args){

        StudentDao dao = new StudentDao();

        dao.findAll();


    }
}
