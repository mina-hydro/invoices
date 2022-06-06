package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Invoice {
    private DefaultTableModel model = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private JTable tableRight = new JTable(model2);
    private JTable tableLeft = new JTable(model);
    int i = 0;
    int total = 0;


    public int getRowCount1() {
        return tableLeft.getRowCount();
    }

    public int getRowCount2() {
        return tableRight.getRowCount();
    }


    public int getColumnCount1() {
        return tableLeft.getColumnCount();
    }


    public int getColumnCount2() {
        return tableRight.getColumnCount();
    }

    public void setRowCount1() {
        tableLeft.getRowCount();
    }


    public void setRows1(Object[] array) {
        model.addRow(array);
    }


    public void setRows2(Object[] array) {
        model2.addRow(array);
    }
}
