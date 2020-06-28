package com.gmail.ddzhunenko.organizationdirectory.admin;

import com.gmail.ddzhunenko.organizationdirectory.admin.actions.TestAction;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class MenuWindow extends JFrame {

    private final JTable table = new JTable();
    private final DefaultTableModel tableModel = new DefaultTableModel();
    private JInternalFrame jInternalFrame = new JInternalFrame();

    private JPanel panel1;
    private JList list1;

    public MenuWindow() {

//        Container container = this.getContentPane();
//        container.setLayout(new GridLayout());

        JMenuBar jMenuBar = new JMenuBar();

        JMenu viewMenu = new JMenu("Перегляд");
        JMenu addMenu = new JMenu("Додати");
        JMenu editMenu = new JMenu("Редагування");
        JMenu searchMenu = new JMenu("Пошук");

        JMenuItem viewPositionDirectory = new JMenuItem("Довідник посад");
        JMenuItem viewDepartamentDirectory = new JMenuItem("Довідник департаменту");

        JMenuItem addPostion = new JMenuItem("Додати посаду");
        JMenuItem addBranch = new JMenuItem("Додати відділ");
        JMenuItem addDepartament = new JMenuItem("Додати департамент");

        JMenuItem editPostion = new JMenuItem("Редагувати посаду");
        JMenuItem editBranch = new JMenuItem("Редагувати відділ");
        JMenuItem editDepartament = new JMenuItem("Редагувати департамент");

        JMenuItem searchPostion = new JMenuItem("Пошук по посаді");
        JMenuItem searchBranch = new JMenuItem("Пошук за  відділом");
        JMenuItem searchDepartament = new JMenuItem("Пошук за департаментом");

        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setVisible(true);

        setJMenuBar(jMenuBar);

        jMenuBar.add(viewMenu);
        jMenuBar.add(addMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(searchMenu);

        viewMenu.add(viewPositionDirectory);
        viewMenu.add(viewDepartamentDirectory);

        addMenu.add(addPostion);
        addMenu.add(addBranch);
        addMenu.add(addDepartament);

        editMenu.add(editPostion);
        editMenu.add(editBranch);
        editMenu.add(editDepartament);

        searchMenu.add(searchPostion);
        searchMenu.add(searchBranch);
        searchMenu.add(searchDepartament);

        viewPositionDirectory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JDesktopPane jDesktopPane = new JDesktopPane();
                JInternalFrame jInternalFrame = new JInternalFrame("test");

                jInternalFrame.setSize(5000,5000);
                jInternalFrame.setResizable(true);
                jInternalFrame.setVisible(true);

                add(jDesktopPane.add(jInternalFrame));

            }
        });

    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MenuWindow().setVisible(true));
    }
}


// viewPositionDirectory.addActionListener(new ActionListener() {
//@Override
//public void actionPerformed(ActionEvent e) {
//        new SwingWorker<Void, Void>() {
//@Override
//protected Void doInBackground() throws Exception {
//        new TableInfo().loadData();
//        System.out.println("actionPerformed");
//        return null;
//        }
//        }.execute();
//        }
//        });