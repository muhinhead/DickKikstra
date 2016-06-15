/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.util.FXutils;
import com.dk.util.TableGridPanel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Vector;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author nick
 */
public class FXMLDashboardController implements Initializable {
    
    @FXML
    private HBox logoutBox;
    
    @FXML
    private VBox searchClientBox;
    
    @FXML
    private BorderPane rightTablePane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Node logoutNode = FXutils.createButton(getClass(), "exit.png", new Runnable() {
            @Override
            public void run() {
            OpticStore.mainApp.resize2(OpticStore.mainApp.getLoginWidth(), OpticStore.mainApp.getLoginHeight());
                FXMLmainController.staticPwdField.setText(null);
                OpticStore.mainApp.hideDashboardAndShowLogin();
            }
        });
        logoutBox.getChildren().add(logoutNode);
        
        Node searchClientNode = FXutils.createButton(getClass(), "search.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
            }
        });
        //searchClientNode.setDisable(true);
        searchClientBox.getChildren().add(searchClientNode);
        
        Node newClientNode = FXutils.createButton(getClass(), "newuser.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
            }
        });
        newClientNode.setDisable(true);
        searchClientBox.getChildren().add(newClientNode);
        Node editClientNode = FXutils.createButton(getClass(), "edituser.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
            }
        });
        editClientNode.setDisable(true);
        searchClientBox.getChildren().add(editClientNode);
        Node delClientNode = FXutils.createButton(getClass(), "deluser.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
            }
        });
        delClientNode.setDisable(true);
        searchClientBox.getChildren().add(delClientNode);
        
        rightTablePane.setCenter(new TableGridPanel(new Vector[]{
            new Vector(getHdrs()),new Vector(getBdy())}));
    }    

    private ArrayList<String> getHdrs() {
        ArrayList<String> lst = new ArrayList<String>();
        lst.add("id klant");
        lst.add("voorletters");
        lst.add("achternaam");
        return lst;
    }
    
    private Collection getBdy() {
        Vector rows = new Vector();
        for (int r=0; r<10; r++) {
            Vector line = new Vector();
            for (int c=0; c<3; c++) {
                line.add("ceil "+r+"/"+c);
            }
            rows.add(line);
        }
        return rows;
    }
    
}
