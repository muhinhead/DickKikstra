/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.util.FXutils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author nick
 */
public class AnamnesPaneController implements Initializable {

    @FXML 
    private VBox rightButtonsPane;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Node okNode = FXutils.createButton(getClass(), "ok.png", new Runnable() {
//            @Override
//            public void run() {
//                //TODO
//            }
//        });
//        rightButtonsPane.getChildren().add(okNode);
        Node prevNode = FXutils.createButton(getClass(), "prev.png", new Runnable() {
            @Override
            public void run() {
                //TODO
            }
        });
        rightButtonsPane.getChildren().add(prevNode);
        Node nextNode = FXutils.createButton(getClass(), "next.png", new Runnable() {
            @Override
            public void run() {
                //TODO
            }
        });
        rightButtonsPane.getChildren().add(nextNode);
    }    
    
}
