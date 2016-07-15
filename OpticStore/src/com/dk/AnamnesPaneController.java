/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.Brilvoorschrift;
import com.dk.util.FXutils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author nick
 */
public class AnamnesPaneController implements Initializable {

    @FXML
    private HBox downButtonPane;
    @FXML
    private Label idLabel;
    @FXML
    private TextArea anamneseTextArea;
    private int curBrilvoorschrift = -1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        curBrilvoorschrift = FXMLDashboardController.getBrilvoorschriftArray().size() - 1;
        reLoadAnamneseText();
        Node firstNode = FXutils.createButton(getClass(), "first.png", new Runnable() {
            @Override
            public void run() {
                curBrilvoorschrift = FXMLDashboardController.getBrilvoorschriftArray().size() > 0 ? 0 : -1;
                reLoadAnamneseText();
            }
        });
        downButtonPane.getChildren().add(firstNode);
        Node prevNode = FXutils.createButton(getClass(), "prev.png", new Runnable() {
            @Override
            public void run() {
                if (FXMLDashboardController.getBrilvoorschriftArray().size() > 0 && curBrilvoorschrift > 0) {
                    curBrilvoorschrift--;
                    reLoadAnamneseText();
                }
            }
        });
        downButtonPane.getChildren().add(prevNode);
        Node nextNode = FXutils.createButton(getClass(), "next.png", new Runnable() {
            @Override
            public void run() {
                if (FXMLDashboardController.getBrilvoorschriftArray().size() > 0 
                        && curBrilvoorschrift < FXMLDashboardController.getBrilvoorschriftArray().size() - 1) {
                    curBrilvoorschrift++;
                    reLoadAnamneseText();
                }
            }
        });
        downButtonPane.getChildren().add(nextNode);
        Node lastNode = FXutils.createButton(getClass(), "last.png", new Runnable() {
            @Override
            public void run() {
                curBrilvoorschrift = FXMLDashboardController.getBrilvoorschriftArray().size() - 1;
                reLoadAnamneseText();
            }
        });
        downButtonPane.getChildren().add(lastNode);
//        Node okNode = FXutils.createButton(getClass(), "ok.png", new Runnable() {
//            @Override
//            public void run() {
//                //TODO
//            }
//        });
//        downButtonPane.getChildren().add(okNode);
    }

    private void reLoadAnamneseText() {
        anamneseTextArea.setText("");
        idLabel.setText("");
        if(curBrilvoorschrift>=0 && curBrilvoorschrift<FXMLDashboardController.getBrilvoorschriftArray().size()) {
            Brilvoorschrift anamnese = FXMLDashboardController.getBrilvoorschriftArray().get(curBrilvoorschrift);
            anamneseTextArea.setText(anamnese.getAnamnese());
            idLabel.setText(""+(curBrilvoorschrift+1)+"/"+FXMLDashboardController.getBrilvoorschriftArray().size());
        }
    }
    
}
