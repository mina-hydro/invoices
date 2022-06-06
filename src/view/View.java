package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;

public class View extends JFrame implements ActionListener {
    //some variables needed to be global
    public File file = new File("InvoiceHeader.csv");
    public File file2 = new File("InvoiceLine.csv");
    public int i = 1;
    String tea;
    File selectedFilee;
    String savepath;
    int taxi = 0;
    public int savecounter = 1;

    int ver;

    int carrot;
    File selectedFile;

    JLabel l1;
    public JLabel t1;
    public JTextField t2;
    int haha = 0;
    public JTextField t3;
    DefaultTableModel model2;
    public DefaultTableModel model;
    public JLabel t4;
    public int total = 0;
    JPanel panelLeft;
    public   JTable tableLeft;
    JScrollPane scroll1;
    JButton b1;
    JButton b2;
    int reload;

    String[] heads = {"No.", "Date", "Customer", "Total"};
    // String[] data = {"", "", "", ""};
    public String[] data = {null,null,null,null};
    String[] data2 = {"", "", "", "",""};
    int finol;

    JPanel panelRight;
    public JTable tableRight;
    JScrollPane scroll2;
    JButton b3;
    JButton b4;

    public View() {
        // setting the Frame
        super("Sales invoice generator");

        setSize(950, 700);

        setLocation(250, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));

        // MENU BAR
        JMenuBar menuBar;
        JMenu menu;
        JMenuItem loadFile;
        JMenuItem saveFile;
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menu = new JMenu("File");
        menuBar.add(menu);
        loadFile = new JMenuItem("Load File");
        loadFile.addActionListener(this);
        loadFile.setActionCommand("loadFile");

        menu.add(loadFile);

        saveFile = new JMenuItem("Save File");
        saveFile.addActionListener(this);
        saveFile.setActionCommand("saveFile");
        menu.add(saveFile);
        // initiating the left table
        model = new DefaultTableModel();
        tableLeft = new JTable(model);
        model.addColumn("No.");
        model.addColumn("Date");
        model.addColumn("Customer");
        model.addColumn("Total");
//        model.addRow(data);
//        model.addRow(data);
//        model.addRow(data);

        // LEFT panel Elements
        scroll1 = new JScrollPane(tableLeft);
        b1 = new JButton("Create New Invoice");
        b1.setActionCommand("create");
        b1.addActionListener(this);
        b2 = new JButton("Delete Invoice");
        b2.setActionCommand("delete");
        b2.addActionListener(this);
        b1.setBackground(Color.LIGHT_GRAY);
        b2.setBackground(Color.LIGHT_GRAY);
        panelLeft = new JPanel();
        panelLeft.setPreferredSize(new Dimension(465, 700));
        scroll1.setPreferredSize(new Dimension(465, 480));
        // adding left panel and its elements
        add(panelLeft, BorderLayout.WEST);
        JLabel lol = new JLabel("Invoices Table");
        panelLeft.add(lol);
        panelLeft.add(scroll1);
        panelLeft.add(b1);
        panelLeft.add(b2);

        // THE UPPER panel(Labels and textFields part) OF THE RIGHT SIDE
        //it consist of TWo columns (L)eft And (R)ight
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(250, 100));
        JPanel l = new JPanel();
        JPanel r = new JPanel();
        topPanel.setLayout(new GridLayout(1, 2));
        l.setPreferredSize(new Dimension(50, 100));
        r.setPreferredSize(new Dimension(200, 100));
        l.setLayout(new GridLayout(4, 1));
        r.setLayout(new GridLayout(4, 1));
        topPanel.add(l);
        topPanel.add(r);
        l1 = new JLabel("Invoice No.");
        JLabel l3 = new JLabel("Customer Name: ");
        JLabel l4 = new JLabel("Invoice Total");
        JLabel l2 = new JLabel("Invoice Date: ");
        l.add(l1);

        l.add(l2);
        l.add(l3);
        l.add(l4);

        t1 = new JLabel("" + i);
        t2 = new JTextField(30);
        t3 = new JTextField(30);
        t4 = new JLabel(""+total);

        r.add(t1);
        r.add(t2);
        r.add(t3);
        r.add(t4);

        // the RIGHT table
        model2 = new DefaultTableModel();
        tableRight = new JTable(model2);
        model2.addColumn("No.");
        model2.addColumn("Item Name");
        model2.addColumn("Item Price");
        model2.addColumn("Count");
        model2.addColumn("Total Price");
        model2.addRow(data2);
        model2.addRow(data2);
        model2.addRow(data2);


        tableRight.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model2.addRow(data);
try {


    for (int j = 0; j < tableRight.getRowCount(); j++) {
        String qw11 = tableRight.getValueAt(j, 2).toString();
        String qw22 = tableRight.getValueAt(j, 3).toString();
        int uuuu = Integer.parseInt(qw11);
        int uuu = Integer.parseInt(qw22);
//                        String finaly = String.valueOf(uuuu);
///
        int finol = uuu * uuuu;
        tableRight.setValueAt(finol, j, 4);

    }
            }catch (NullPointerException v){

            }catch (NumberFormatException n){

            }
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        tableLeft.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    //
                    tea = "";
                    cancel();
                    carrot = 0;
                    //
                    if (taxi == 0) {
                        i--;
                        taxi++;
                    }
                    t1.setText(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),0)));
                    t2.setText(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),1)));
                    t3.setText(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),2)));
                    String strange = String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),3)).replace(" ","");
                    try {


                        total = Integer.parseInt(strange);
                    }catch (NumberFormatException n){

                    }
//                    System.out.println(total);
//                    t4.setText(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),3)));
                    t4.setText(""+total);
                    //
                    if (selectedFile != null) {
                    String lier;
                        String lier22;
                    FileReader read = null;
                    FileReader read22 = null;
                    try {
                        read = new FileReader(new File(selectedFile.getAbsolutePath()));

                    BufferedReader bufread = new BufferedReader(read);
                        read22 = new FileReader(new File(selectedFile.getAbsolutePath()));

                        BufferedReader bufread22 = new BufferedReader(read22);
                    int ooof =0;
                        while ((lier22 = bufread22.readLine()) != null) {
                            if(lier22.split(",")[0].equals(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),0)))){
                                ooof++;
                            }
                        }
                        if (tableRight.getRowCount() < ooof) {
                            for (int j = 0; j < (ooof - tableRight.getRowCount()); j++) {
                                model2.addRow(data);
                            }
                        }
                    int geer = 0;
                    while ((lier = bufread.readLine()) != null) {
//                        System.out.println(lier.split(",")[1]);

//                        System.out.println(geer);
                        if(lier.split(",")[0].equals(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),0)))){
//                            System.out.println(lier.split(",")[0]);
                            tableRight.setValueAt(lier.split(",")[0],geer,0);
                            tableRight.setValueAt(lier.split(",")[1],geer,1);
                            tableRight.setValueAt(lier.split(",")[2],geer,2);
                            tableRight.setValueAt(lier.split(",")[3],geer,3);
                            tableRight.setValueAt(lier.split(",")[4],geer,4);
                            geer++;
                        }


                    }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }catch (NullPointerException n) {

                    }catch (ArrayIndexOutOfBoundsException n) {

                    }
                }else if (selectedFile == null) {
//                    System.out.println("gggggggg");
                    String lier;
                    String lier22;
                    FileReader read = null;
                    FileReader read22 = null;
                    try {
                        read = new FileReader(file2);

                        BufferedReader bufread = new BufferedReader(read);
                        read22 = new FileReader(file2);

                        BufferedReader bufread22 = new BufferedReader(read22);
                        int ooof =0;
                        while ((lier22 = bufread22.readLine()) != null) {
                            if(lier22.split(",")[0].equals(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),0)))){
                                ooof++;
                            }
                        }
                        if (tableRight.getRowCount() < ooof) {
                            for (int j = 0; j < (ooof - tableRight.getRowCount()); j++) {
                                model2.addRow(data);
                            }
                        }
                        int geer = 0;
                        while ((lier = bufread.readLine()) != null) {
//                        System.out.println(lier.split(",")[1]);

//                            System.out.println(geer);
                            if(lier.split(",")[0].equals(String.valueOf(tableLeft.getValueAt(tableLeft.getSelectedRow(),0)))){
                                System.out.println(lier.split(",")[0]);
                                tableRight.setValueAt(lier.split(",")[0],geer,0);
                                tableRight.setValueAt(lier.split(",")[1],geer,1);
                                tableRight.setValueAt(lier.split(",")[2],geer,2);
                                tableRight.setValueAt(lier.split(",")[3],geer,3);
                                tableRight.setValueAt(lier.split(",")[4],geer,4);
                                geer++;
                            }


                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }catch (NullPointerException n) {

                    }catch (ArrayIndexOutOfBoundsException n) {

                    }
                }}
                for (int j = 0; j <tableRight.getRowCount(); j++) {
                    if (!tableRight.getValueAt(j,1).toString().isEmpty()){
                        carrot++;
                    }else {
                        return;
                    }
                }
            }



            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //the LOWER panel of the RIGHT side
        // adding the setField , the RIGHT table and Buttons
        scroll2 = new JScrollPane(tableRight);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(465, 420));
        bottomPanel.add(scroll2);
        JLabel addd = new JLabel("press 'Enter' to add a row");
        addd.setBackground(Color.lightGray);
        bottomPanel.add(addd);
        bottomPanel.setBorder(BorderFactory.createTitledBorder("Invoice Items"));
        scroll2.setPreferredSize(new Dimension(450, 370));
        // scroll2.setPreferredSize(new Dimension(460, 300));
        // scroll2.setBorder(BorderFactory.createTitledBorder("bar"));
        b3 = new JButton("Save");
        b3.setActionCommand("save");
        b3.addActionListener(this);
        b3.setBackground(Color.LIGHT_GRAY);
        b4 = new JButton("Cancel");
        b4.setActionCommand("cancel");
        b4.addActionListener(this);
        b4.setBackground(Color.LIGHT_GRAY);
        panelRight = new JPanel();
        panelRight.setPreferredSize(new Dimension(465, 600));
        // adding the RIGHT PANEL AND ITS ELEMENTS
        add(panelRight, BorderLayout.EAST);
        panelRight.add(topPanel);
        panelRight.add(bottomPanel);
        panelRight.add(b3);
        panelRight.add(b4);
        loadFile2();


    }

    // METHODS to be called when ACTION Listner function is called
    private void createI() {
        tea = "";
        carrot = 0;
        cancel();
        if (tableLeft.getValueAt(tableLeft.getRowCount()-1,1) == null && tableLeft.getValueAt(tableLeft.getRowCount()-1,3) == null ){
            return;
        }
        i++;

        t2.setText("");
        t3.setText("");
        t4.setText("" + total);
        int previous = Integer.parseInt(String.valueOf(tableLeft.getValueAt(tableLeft.getRowCount()-1,0))) + 1;
        System.out.println(previous);
        t1.setText("" + previous);
        model.addRow(new String[] {String.valueOf(previous),null,null,null});

//        for (int l = 0; l < tableRight.getRowCount(); l++) {
//
//            for (int j = 0; j < tableRight.getColumnCount(); j++) {
//                tableRight.setValueAt("", l, j);
//            }
//        }

    }
    private void cancel() {
        total = 0;
        t4.setText(total+"");

        t2.setText("");
        t3.setText("");
        for (int l = 0; l < tableRight.getRowCount(); l++) {

            for (int j = 0; j < tableRight.getColumnCount(); j++) {
                tableRight.setValueAt("", l, j);
            }
        }
    }
    public void deleteI() {
//        try {
//            saveFile();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        cancel();
        if (tableLeft.getSelectedRow() != -1) {
            model.removeRow(tableLeft.getSelectedRow());
        }
    }


    private void saveI() throws IOException {



        for (int m = 0; m < tableRight.getRowCount(); m++) {
            if (tableRight.getValueAt(m, 4) != null) {
                try {
                    String qw11 = tableRight.getValueAt(m, 2).toString();
                    String qw22 = tableRight.getValueAt(m, 3).toString();
                    int uuuu = Integer.parseInt(qw11);
                    int uuu = Integer.parseInt(qw22);

                     finol = uuu * uuuu;
                     reload = reload + (uuu * uuuu);
//
                } catch (NumberFormatException n) {

                }catch (NullPointerException w){

                }catch (ClassCastException k){

                }
            }
        }

//                    total = total + Integer.parseInt(tableRight.getValueAt(m, 4).toString());

        t4.setText(""+reload);
//        if (i < 4) {
//            model.setValueAt(t1.getText(), i - 1, 0);
//            model.setValueAt(t2.getText(), i - 1, 1);
//            model.setValueAt(t3.getText(), i - 1, 2);
//            model.setValueAt("" + total, i - 1, 3);
//        } else {
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        for (int aa = 0; aa < tableLeft.getRowCount(); aa++) {
//            System.out.println(String.valueOf(tableLeft.getValueAt(aa,0)));
//        }
        for (int aa = 0; aa < tableLeft.getRowCount(); aa++) {
            if (String.valueOf(tableLeft.getValueAt(aa,0)).equals(t1.getText())){
                tableLeft.setValueAt(t1.getText(),aa,0);
                tableLeft.setValueAt(t2.getText(),aa,1);
                tableLeft.setValueAt(t3.getText(),aa,2);
                tableLeft.setValueAt(t4.getText(),aa,3);
//                haha++;

            }
        }
//        if (haha == 0) {
//            model.addRow(new String[]{t1.getText(), t2.getText(), t3.getText(), t4.getText()});
//        }
//
//         if (tea.isEmpty()){
//            tea = "jjjjjadsdsdjjj";
//            }
        if (savecounter == 1 ){
//            System.out.println(t4.getText());

            if (tea.equals(t4.getText())){
                return;
            }else {
                savecounter++;
//                JFileChooser fileChooser = new JFileChooser();
//                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//                int result = fileChooser.showOpenDialog(this);
//                if (result == JFileChooser.APPROVE_OPTION) {
//                    selectedFile = fileChooser.getSelectedFile();
//
//                    savepath = selectedFile.getAbsolutePath();
                    FileWriter fw2 = new FileWriter(file2, true);
                    BufferedWriter bw2 = new BufferedWriter(fw2);
                    FileReader roler = new FileReader(file2);
                    BufferedReader ruler = new BufferedReader(roler);
                    String pregnant;

                    for (int l = carrot; l < tableRight.getRowCount(); l++) {
                        bw2.newLine();

                        for (int j = 0; j < tableRight.getColumnCount(); j++) {

                            if (!tableRight.getValueAt(l, j).toString().isEmpty()) {
//                    while ((pregnant = ruler.readLine()) != null) {
//                        if (pregnant.split(",")[0].equals(tableRight.getValueAt(l, 0).toString()) ){
//                            if (pregnant.split(",")[1].equals(tableRight.getValueAt(l, 1).toString()) ) {
//                                if (pregnant.split(",")[2].equals(tableRight.getValueAt(l, 2).toString()) ) {
//                                on_off++;
//                            }
//                            }
//                    }
//                    }

                                bw2.write(String.valueOf(tableRight.getValueAt(l, j)));

                                bw2.write(",");


                            } else {
                                bw2.close();
                                fw2.close();
                                return;
                            }


                        }
                    }
                    bw2.close();
                    fw2.close();

            }






        } else if (savecounter > 1) {
//            System.out.println(savecounter);
//            System.out.println(tea);
//            System.out.println(t4.getText());
            if (tea.equals(t4.getText())){
                return;
            }else {
//            System.out.println(savecounter);
            FileWriter fw2 = new FileWriter(file2.getPath(), true);
            BufferedWriter bw2 = new BufferedWriter(fw2);

            for (int l = carrot; l < tableRight.getRowCount(); l++) {
                bw2.newLine();

                for (int j = 0; j < tableRight.getColumnCount(); j++) {
                    if (!tableRight.getValueAt(l, j).toString().isEmpty()) {
                        bw2.write(String.valueOf(tableRight.getValueAt(l, j)));

                        bw2.write(",");

                    } else {
                        bw2.close();
                        fw2.close();
                        return;
                    }


                }}
            bw2.close();
            fw2.close();}}

        }
        public void tea(){
            tea = t4.getText();
//            System.out.println(tea);
        }
public void reload() {
        reload = 0;
}


    private void lol() {
        total = 0;
        t4.setText("");
        try {
//

    for (int j = 0; j < tableRight.getRowCount(); j++) {
        String qw11 = tableRight.getValueAt(j, 2).toString();
        String qw22 = tableRight.getValueAt(j, 3).toString();
        int uuuu = Integer.parseInt(qw11);
        int uuu = Integer.parseInt(qw22);

        int finol = uuu * uuuu;
        tableRight.setValueAt(finol, j, 4);

    }
            }catch (NullPointerException v){

            }catch (NumberFormatException b) {

        }
    }
    public void log() {


            for (int j = 0; j < tableRight.getRowCount(); j++) {
                if (!tableRight.getValueAt(j, 1).toString().isEmpty()) {
                    tableRight.setValueAt(t1.getText(), j, 0);
                }else{
                    return;
                }

            }

    }


    private void saveFile() throws IOException {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
//        int result = fileChooser.showOpenDialog(this);
//        if (result == JFileChooser.APPROVE_OPTION) {
//            File selectedFile = fileChooser.getSelectedFile();
        if (selectedFilee == null){
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);


            for (int l = 0; l < tableLeft.getRowCount(); l++) {
                bw.newLine();


                for (int j = 0; j < tableLeft.getColumnCount(); j++) {
                    if (tableLeft.getValueAt(l, j) != null) {
                        bw.write(String.valueOf(tableLeft.getValueAt(l, j)));
//                        System.out.println(String.valueOf(tableLeft.getValueAt(l, j)));
                        bw.write(",");
//                        System.out.println(",");
                    } else {
                        bw.close();
                        fw.close();
                        return;
                    }

                }
            }
            bw.close();
            fw.close();
        } else if (selectedFilee != null) {
            FileWriter fw = new FileWriter(selectedFilee);
            BufferedWriter bw = new BufferedWriter(fw);


            for (int l = 0; l < tableLeft.getRowCount(); l++) {
                bw.newLine();


                for (int j = 0; j < tableLeft.getColumnCount(); j++) {
                    if (tableLeft.getValueAt(l, j) != null) {
                        bw.write(String.valueOf(tableLeft.getValueAt(l, j)));
//                        System.out.println(String.valueOf(tableLeft.getValueAt(l, j)));
                        bw.write(",");
//                        System.out.println(",");
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
    public void loadFile() {
        String li = ",";
        String li2 = ",";
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            BufferedReader br2 = null;
            if (result == JFileChooser.APPROVE_OPTION) {
                selectedFilee = fileChooser.getSelectedFile();
                br2 = new BufferedReader(new FileReader(selectedFilee));
                BufferedReader br9 = new BufferedReader(new FileReader(selectedFilee));
 }

            String line2;
            String line9;

            for (int i = 0; i < tableLeft.getRowCount(); i++) {
                model.removeRow(i);
            }


            while ((line2 = br2.readLine()) != null) {
                String[] values2 = line2.split(li);


                if (Arrays.asList(values2).toArray().length > 1) {
                    String q = Arrays.asList(values2).toString();
                    String z = q.replace("[", "");
                    String p = z.replace("]", "");
                    String[] l = p.split(",");
                    if (l.length < 4) {
                        model.addRow(new String[]{l[0],l[1], l[2], " "});
                    }
                    if (l.length == 4) {
                        model.addRow(new String[]{l[0], l[1], l[2], l[3]});
                        System.out.println(l[0] + " " + l[1] + " " + l[2] + " " + l[3]);
                    }

                }

            }
        } catch (IOException e) {

        }catch (ArrayIndexOutOfBoundsException j){

        }
        model.removeRow(0);
        i = tableLeft.getRowCount() + 1;
        t1.setText(i+"");
//        if (tableLeft.getRowCount() < 3) {
//            for (int j = 0; j < 3-tableLeft.getRowCount(); j++) {
//                model.addRow(data);
//            }
//        }
        createI();
    }
    public void loadFile2() {
        String li = ",";
        String li2 = ",";

        try {


            BufferedReader br2 = new BufferedReader(new FileReader(file));
                BufferedReader br9 = new BufferedReader(new FileReader(file));


            String line2;
            String line9;

//            for (int i = 0; i < tableLeft.getRowCount(); i++) {
//                model.removeRow(i);
//            }


            while ((line2 = br2.readLine()) != null) {
                String[] values2 = line2.split(li);


                if (Arrays.asList(values2).toArray().length > 1) {
                    String q = Arrays.asList(values2).toString();
                    String z = q.replace("[", "");
                    String p = z.replace("]", "");
                    String[] l = p.split(",");

                    if (l.length == 4) {
                        model.addRow(new String[]{l[0], l[1], l[2], l[3]});

                    }

                }

            }
        } catch (IOException e) {

        }catch (ArrayIndexOutOfBoundsException j){

        }

//        model.removeRow(0);
        i = tableLeft.getRowCount();
        t1.setText(i+"");
//        if (tableLeft.getRowCount() < 3) {
//            for (int j = 0; j < 3-tableLeft.getRowCount(); j++) {
//                model.addRow(data);
//            }
//        }
        createI();
    }


    @Override
    public void actionPerformed(ActionEvent c) {
        switch (c.getActionCommand()) {
            case "create":
                createI();
                break;
            case "delete":
                deleteI();
                try {
                    saveFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "save":
                reload();
                lol();
                log();
                try {
                    saveI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }catch (ClassCastException m){

                }catch (ArrayIndexOutOfBoundsException v){

                }
                tea();
                break;
            case "cancel":
                cancel();
                break;
            case "loadFile":
                loadFile();
                break;
            case "saveFile":
                try {
                    saveFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;

        }

    }

}
//
//
//