package com.gmail.ddzhunenko.organizationdirectory.dao;

import com.gmail.ddzhunenko.organizationdirectory.entity.Position;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {

    private Connection connection;
    private String user = "postgres";
    private String password = "postgres";
    private String url = "jdbc:postgresql://localhost:5432/organization";

    public PositionDAO() throws Exception {

        // connect to database
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("DB connection successful to: " + url);
    }

    public List<Position> getAllPositions() throws Exception {
        List<Position> list = new ArrayList<>();

        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from positions");

            while (resultSet.next()) {
                Position position = new Position(resultSet.getString("code"),resultSet.getString("name")) ;
                list.add(position);
            }

            return list;
        }
        finally {
            connection.close();
        }
    }

    public void populateTable() throws Exception{
        Statement statement;
        ResultSet resultSet;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from positions");

            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                DefaultTableModel tableModel = new DefaultTableModel();
                Object[] obj = {code,name};
                tableModel.addRow(obj);
            }

        }
        finally {
            connection.close();
        }
    }




    public static void main(String[] args) throws Exception {

    }
}

