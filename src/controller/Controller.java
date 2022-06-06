package controller;

import Model.Model;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class Controller implements ActionListener {
    View main;
    Invoice invoice;
    InvoiceLine invoiceLine;
    public Controller() {
      main = new View();

        Model model = new Model();
        invoice = new Invoice();
        invoiceLine = new InvoiceLine();

    }


    @Override
    public void actionPerformed(ActionEvent c) {
        switch (c.getActionCommand()) {
            case "create":
                invoice.createI();
                break;
            case "delete":
                invoice.deleteI();
                break;
            case "save":
                try {
                    invoiceLine.saveI();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "cancel":
                invoiceLine.cancel();
                break;
            case "loadFile":
                invoice.loadFile();
                break;
            case "saveFile":
                try {
                    invoice.saveF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
 }
 }
}
