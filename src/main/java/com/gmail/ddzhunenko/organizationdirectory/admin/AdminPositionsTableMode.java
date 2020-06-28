package com.gmail.ddzhunenko.organizationdirectory.admin;

import com.gmail.ddzhunenko.organizationdirectory.entity.Position;

import javax.swing.table.AbstractTableModel;
import java.util.List;


class AdminPositionsTableMode extends AbstractTableModel {

    private static final int CODE_COL = 0;
    private static final int NAME_COL = 1;


    private String[] columnNames = { "Last Name", "First Name", "Email",
            "Salary" };
    private List<Position> positions;

    public AdminPositionsTableMode(List<Position> positions) {
        positions = positions;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {

        Position position = positions.get(row);

        switch (col) {
            case CODE_COL:
                return position.getCode();
            default:
                return position.getName();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
}