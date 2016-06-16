/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.Klant;
import com.dk.util.FXutils;
import com.dk.util.TableGridPanel;
import com.sun.javafx.collections.ObservableListWrapper;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane innerAnchorPane;
    //private BorderPane rightTablePane;

    @FXML
    private TextField klantIDfield;
    @FXML
    private TextField aanhefField;
    @FXML
    private TextField voorlettersField;
    @FXML
    private TextField tussenvoegselField;
    @FXML
    private TextField achternaamField;
    @FXML
    private TextField adresField;
    @FXML
    private TextField huisnummerField;
    @FXML
    private TextField postcodeField;
    @FXML
    private TextField plaatsField;
    @FXML
    private TextField landField;
    @FXML
    private TextField gebortedatumField;
    @FXML
    private TextField telefonField;
    @FXML
    private TextField mobileField;
    @FXML
    private TextField emailField;

    private TextField[] searchFields = null;
    private TableGridPanel klantGrid = null;
    private int selectedKlantID = 0;
    private Node editClientNode;
    private Node delClientNode;

    private void clearKlantForm(boolean withDeselect) {
        if (searchFields == null) {
            searchFields = new TextField[]{
                klantIDfield, aanhefField, voorlettersField,
                tussenvoegselField, achternaamField, adresField,
                huisnummerField, postcodeField, plaatsField, landField,
                gebortedatumField, telefonField, mobileField, emailField
            };
        }
        for (TextField tf : searchFields) {
            if (tf != null) {
                tf.setText(null);
            }
        }
        klantIDfield.setDisable(false);
        if (withDeselect) {
            klantGrid.unselect();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Node logoutNode = FXutils.createButton(getClass(), "exit.png", new Runnable() {
            @Override
            public void run() {
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
        Node clearClientNode = FXutils.createButton(getClass(), "clear.png", new Runnable() {
            @Override
            public void run() {
                clearKlantForm(true);
            }
        });
        searchClientBox.getChildren().add(clearClientNode);

        Node newClientNode = FXutils.createButton(getClass(), "newuser.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
            }
        });
        newClientNode.setDisable(true);
        searchClientBox.getChildren().add(newClientNode);
        editClientNode = FXutils.createButton(getClass(), "edituser.png", new Runnable() {
            @Override
            public void run() {
                try {
                    //TODO:
                    loadKlantFrom(selectedKlantID);
                } catch (RemoteException ex) {
                    OpticStore.logAndShowErrorMessage(ex.getMessage());
                }
            }
        });
        editClientNode.setDisable(true);
        searchClientBox.getChildren().add(editClientNode);
        delClientNode = FXutils.createButton(getClass(), "deluser.png", new Runnable() {
            @Override
            public void run() {
                //TODO: 
                if (selectedKlantID != 0 && OpticStore.yesOrNoDialog(
                        "Bent u zeker dat u wilt verwijderen van dit record? (klant id="+selectedKlantID+")")) {
                    Klant klant = null;
                    try {
                        klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, selectedKlantID);
                        if (klant != null) {
                            OpticStore.getExchanger().deleteObject(klant);
                            klantGrid.reload();
                            clearKlantForm(true);
                        }
                    } catch (RemoteException ex) {
                        OpticStore.logAndShowErrorMessage(ex.getMessage());
                    }
                }
            }
        });
        delClientNode.setDisable(true);
        searchClientBox.getChildren().add(delClientNode);

        try {
            klantGrid = new TableGridPanel(OpticStore.getExchanger(), OpticStore.KLANTLIST);
            innerAnchorPane.setTopAnchor(klantGrid, 10.0);
            innerAnchorPane.setLeftAnchor(klantGrid, 400.0);
            innerAnchorPane.setRightAnchor(klantGrid, 0.0);
            innerAnchorPane.setBottomAnchor(klantGrid, 10.0);
            innerAnchorPane.getChildren().add(klantGrid);
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex.getMessage());
        }
        klantGrid.getTableView().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue ov, Object oldSelection, Object newSelection) {
                if (newSelection == null) {
                    selectedKlantID = 0;
                    enableLoadKlantOperations(false);
                } else {
                    ObservableListWrapper itm = (ObservableListWrapper) newSelection;
                    selectedKlantID = Integer.parseInt(itm.get(0).toString().trim());
                    enableLoadKlantOperations(true);
                }
            }
        });

    }

    private void loadKlantFrom(int selectedKlantID) throws RemoteException {
        clearKlantForm(false);
        Klant klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, selectedKlantID);
        if (klant != null) {
            klantIDfield.setDisable(true);
            klantIDfield.setText(klant.getKlantId().toString());
            aanhefField.setText(klant.getAanhef());
            voorlettersField.setText(klant.getVoorletters());
            tussenvoegselField.setText(klant.getTussenvoegsel());
            achternaamField.setText(klant.getAchternaam());
            adresField.setText(klant.getAdres());
            huisnummerField.setText(klant.getHuisnummer());
            postcodeField.setText(klant.getPostcode());
            plaatsField.setText(klant.getPlaats());
            landField.setText(klant.getLand());
            if (klant.getGeboortedatum() != null) {
                gebortedatumField.setText(klant.getGeboortedatum().toString());
            }
            telefonField.setText(klant.getTelefoon());
            mobileField.setText(klant.getMobiel());
            emailField.setText(klant.getEmail());
        }
    }

    private void enableLoadKlantOperations(boolean enable) {
        editClientNode.setDisable(!enable);
        delClientNode.setDisable(!enable);
    }
}
