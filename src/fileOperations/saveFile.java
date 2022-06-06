package fileOperations;

import view.View;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class saveFile {
    View view = new View();
    public void saveF() throws IOException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            FileWriter fw = new FileWriter(selectedFile);
            BufferedWriter bw = new BufferedWriter(fw);


            for (int l = 0; l < view.tableLeft.getRowCount(); l++) {
                bw.newLine();


                for (int j = 0; j < view.tableLeft.getColumnCount(); j++) {
                    if (view.tableLeft.getValueAt(l, j) != null) {
                        bw.write(String.valueOf(view.tableLeft.getValueAt(l, j)));
                        System.out.println(String.valueOf(view.tableLeft.getValueAt(l, j)));
                        bw.write(",");
                        System.out.println(",");
                    } else {
                        bw.close();
                        fw.close();
                        return;
                    }

                }
            }
            bw.close();
            fw.close();

        }
    }
}
