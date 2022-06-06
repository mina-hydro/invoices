package controller;

import Model.Model;
import view.View;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InvoiceLine {
    View main;
    public InvoiceLine() {
        main = new View();

        Model model = new Model();
    }

    void cancel() {
        main.i = 0;
        main.t4.setText(main.i+"");

        main.t2.setText("");
        main.t3.setText("");
        for (int l = 0; l < main.tableRight.getRowCount(); l++) {

            for (int j = 0; j < main.tableRight.getColumnCount(); j++) {
                main.tableRight.setValueAt("", l, j);
            }
        }
    }
    void saveI() throws IOException {
        for (int m = 0; m < main.tableRight.getRowCount(); m++) {
            if (main.tableRight.getValueAt(m, 4) != null) {
                try {
                    main.total = main.total + Integer.parseInt(main.tableRight.getValueAt(m, 4).toString());

                    main.t4.setText(main.total + "");
                } catch (NumberFormatException n) {

                }
            }
        }
        if (main.i < 4) {
            main.model.setValueAt(main.t1.getText(), main.i - 1, 0);
            main.model.setValueAt(main.t2.getText(), main.i - 1, 1);
            main.model.setValueAt(main.t3.getText(), main.i - 1, 2);
            main.model.setValueAt("" + main.total, main.i - 1, 3);
        } else {
            main.model.addRow(new String[]{main.t1.getText(), main.t2.getText(), main.t3.getText(), main.t4.getText()});
        }

        FileWriter fw2 = new FileWriter(main.file2, true);
        BufferedWriter bw2 = new BufferedWriter(fw2);
//        for (int i = 0; i < tableRight.getColumnCount(); i++) {
//            bw2.newLine();
//            bw2.write(tableRight.getColumnName(i));
//            bw2.write(",");
//        }
        for (int l = 0; l < main.tableRight.getRowCount(); l++) {
            bw2.newLine();
            bw2.write((String) "InVoice" + main.i);
            bw2.write(",");
            for (int j = 0; j < main.tableRight.getColumnCount(); j++) {
                if (!main.tableRight.getValueAt(l, j).toString().isEmpty()) {
                    bw2.write((String) (main.tableRight.getValueAt(l, j)));
                    bw2.write(",");
                }else{
                    bw2.close();
                    fw2.close();
                    return;
                }
            }
        }
        bw2.close();
        fw2.close();
    }
}
