package com.parcial.framework;

import com.parcial.framework.dao.StudentDao;

public class App {

    public static void main(String[] args){

        StudentDao dao = new StudentDao();

        dao.findAll();


    }
}
