package com.gmail.ddzhunenko.organizationdirectory.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class GUI extends JFrame {

    private String user = "postgres";
    private String password = "postgres";
    private String url = "jdbc:postgresql://localhost:5432/organization";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    private final JButton loadBtn;
    private final JButton newWindowBtn;
    private final JTable table;


    private final DefaultTableModel tableModel = new DefaultTableModel();

    public GUI() throws HeadlessException {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadBtn = new JButton("Load Data");
        newWindowBtn = new JButton("Open new window");

        loadBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        loadData();
                        return null;
                    }
                }.execute();
            }
        });
        add(loadBtn, BorderLayout.PAGE_START);

        setLocation(new Point().x = 200, new Point().y = 200);
        setSize(640, 480);

        newWindowBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setSize(100,100);
                frame.setVisible(true);
            }
        });

        add(newWindowBtn, BorderLayout.PAGE_END);

    }

    void loadData() {
        //LOG.info("START loadData method");

        loadBtn.setEnabled(false);

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            ResultSet rs = stmt.executeQuery("select * from positions");
            ResultSetMetaData metaData = rs.getMetaData();

            // Names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            // Data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int i = 1; i <= columnCount; i++) {
                    vector.add(rs.getObject(i));
                }
                data.add(vector);
            }

            tableModel.setDataVector(data, columnNames);
        } catch (Exception e) {
            //LOG.log(Level.SEVERE, "Exception in Load Data", e);
        }
        loadBtn.setEnabled(true);

        //LOG.info("END loadData method");
    }

}