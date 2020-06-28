package com.gmail.ddzhunenko.organizationdirectory.admin;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import java.util.List;

import com.gmail.ddzhunenko.organizationdirectory.dao.PositionDAO;
import com.gmail.ddzhunenko.organizationdirectory.entity.Position;


public class AdminApp extends JFrame {

    private JPanel contentPane;
    private JTextField lastNameTextField;
    private JButton btnSearch;
    private JScrollPane scrollPane;
    private JTable table;

    private PositionDAO positionDAO;
    private JTable table1;
    private JPanel panel1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                AdminApp frame = new AdminApp();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public AdminApp() {

        // create the DAO
        try {
            positionDAO = new PositionDAO();
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
        }

        setTitle("Admin Search App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 750);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblEnterLastName = new JLabel("Enter last name");
        panel.add(lblEnterLastName);

        lastNameTextField = new JTextField();
        panel.add(lastNameTextField);
        lastNameTextField.setColumns(10);

        btnSearch = new JButton("Search");

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Get last name from the text field
                // Call DAO and get employees for the last name
                // If last name is empty, then get all employees
                // Print out employees

                try {
                    String lastName = lastNameTextField.getText();
                    List<Position> positions = positionDAO.getAllPositions();

                    // create the model and update the "table"
                    AdminPositionsTableMode model = new AdminPositionsTableMode(positions);

                    table.setModel(model);

					/*
					for (Employee temp : employees) {
						System.out.println(temp);
					}
					*/
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(AdminApp.this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        panel.add(btnSearch);

        scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setViewportView(table);
    }

}
