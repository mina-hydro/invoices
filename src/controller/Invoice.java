package controller;

import Model.Model;
import view.View;

import java.io.*;
import java.util.Arrays;

public class Invoice {
    View main;
    public Invoice() {
        main = new View();

        Model model = new Model();
    }
    public void deleteI() {
        if (main.tableLeft.getSelectedRow() != -1) {
            main.model.removeRow(main.tableLeft.getSelectedRow());
        }
    }
    void createI() {
        main.total = 0;
        main.i++;
        main.t1.setText(" " + main.i);
        main.t2.setText("");
        main.t3.setText("");
        main.t4.setText("" + main.total);
        for (int l = 0; l < main.tableRight.getRowCount(); l++) {

            for (int j = 0; j < main.tableRight.getColumnCount(); j++) {
                main.tableRight.setValueAt("", l, j);
            }
        }

    }



    void saveF() throws IOException {

        FileWriter fw = new FileWriter(main.file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (int l = 0; l < main.tableLeft.getRowCount(); l++) {
            bw.newLine();
            bw.write("InVoice" + (main.tableLeft.getRowCount() - (main.tableLeft.getRowCount() - (l + 1))));
            bw.write(",");

            for (int j = 0; j < main.tableLeft.getColumnCount(); j++) {
                if(main.tableLeft.getValueAt(l, j) != null) {
                    bw.write(String.valueOf(main.tableLeft.getValueAt(l, j)));
                    bw.write(",");
                }else{
                    bw.close();
                    fw.close();
                    return;
                }

            }}
        bw.close();
        fw.close();
    }
    public void loadFile() {
        String li = ",";
        String li2 = ",";
        try {
            BufferedReader br2 = new BufferedReader(new FileReader("Invoice Header.csv"));
            BufferedReader br9 = new BufferedReader(new FileReader("Invoice Header.csv"));
            String line2;
            String line9;
            for (int i = 0; i < main.tableLeft.getRowCount(); i++) {
                main.model.removeRow(i);
            }

            while ((line2 = br2.readLine()) != null) {
                String[] values2 = line2.split(li);

                if (Arrays.asList(values2).toArray().length > 1) {
                    String q = Arrays.asList(values2).toString();
                    String z = q.replace("[","");
                    String p = z.replace("]","");
                    String[] l =  p.split(",");
                    main.model.addRow(new String[]{l[1],l[2],l[3],l[4]});
                }
            }
        } catch (IOException e) {

        }
        main.model.removeRow(0);
        main.i = main.tableLeft.getRowCount() + 1;
        main.t1.setText(main.i+"");
        if (main.tableLeft.getRowCount() < 3) {
            for (int j = 0; j < 3-main.tableLeft.getRowCount(); j++) {
                main.model.addRow(main.data);
            }
        }
    }
}
