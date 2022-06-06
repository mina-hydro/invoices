package fileOperations;

import view.View;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class loadFile {
    View view = new View();
    public void loadFile() {
        String li = ",";
        String li2 = ",";
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(view);
            BufferedReader br2 = null;
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                br2 = new BufferedReader(new FileReader(selectedFile));
                BufferedReader br9 = new BufferedReader(new FileReader(selectedFile));
            }

            String line2;
            String line9;

            for (int i = 0; i < view.tableLeft.getRowCount(); i++) {
                view.model.removeRow(i);
            }


            while ((line2 = br2.readLine()) != null) {
                String[] values2 = line2.split(li);


                if (Arrays.asList(values2).toArray().length > 1) {
                    String q = Arrays.asList(values2).toString();
                    String z = q.replace("[", "");
                    String p = z.replace("]", "");
                    String[] l = p.split(",");
                    if (l.length < 4) {
                        view.model.addRow(new String[]{l[0],l[1], l[2], " "});
                    }
                    if (l.length == 4) {
                        view.model.addRow(new String[]{l[0], l[1], l[2], l[3]});
                        System.out.println(l[0] + " " + l[1] + " " + l[2] + " " + l[3]);
                    }

                }

            }
        } catch (IOException e) {

        }catch (ArrayIndexOutOfBoundsException j){

        }
        view.model.removeRow(0);
        view.i = view.tableLeft.getRowCount() + 1;
        view.t1.setText(view.i+"");
//        if (tableLeft.getRowCount() < 3) {
//            for (int j = 0; j < 3-tableLeft.getRowCount(); j++) {
//                model.addRow(data);
//            }
//        }
    }
}
