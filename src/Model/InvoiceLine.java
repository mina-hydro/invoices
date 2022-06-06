package Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InvoiceLine {
    private DefaultTableModel model = new DefaultTableModel();
    private   DefaultTableModel model2 = new DefaultTableModel();
    private JTable tableRight = new JTable(model2);
    private JTable tableLeft = new JTable(model);
    int i = 0;
    int total = 0;
    private JLabel t1 = new JLabel("   " + i);
    private JTextField t2 = new JTextField(30);
    private JTextField t3 = new JTextField(30);
    private JLabel t4 = new JLabel(""+total);

    public String getT1() {
            return t1.getText();
        }

        public String getT2() {
            return t2.getText();
        }

        public String getT3() {
            return t3.getText();
        }

        public String getT4() {
            return t4.getText();
        }

        public void setT1(String label) {
            t1.setText(label);
        }
        public void setT2(String label) {
            t2.setText(label);
        }
        public void setT3(String label) {
            t3.setText(label);
        }
        public void setT4(String label) {
            t4.setText(label);
        }

    }


