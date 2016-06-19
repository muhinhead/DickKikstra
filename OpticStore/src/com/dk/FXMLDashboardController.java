/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.Brilvoorschrift;
import com.dk.orm.Klant;
import com.dk.orm.Verkoop;
import com.dk.orm.dbobject.DbObject;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.util.FXutils;
import com.dk.util.TableGridPanel;
import com.sun.javafx.collections.ObservableListWrapper;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
//import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author nick
 */
public class FXMLDashboardController implements Initializable {

    private static final String FILL_THIS_FIELD = "dit veld invullen";
    private static final String graylabelStyle = "-fx-background-color: gray;";
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

    @FXML
    private VBox detailsVbox;

    @FXML
    private Label klntIdLabel;
    @FXML
    private Label klntNameLabel;
    @FXML
    private Label klntAdresLabel;
    @FXML
    private Label klntPostCodePlaatsLabel;

    @FXML
    private Label klntteleFoonLabel;
    @FXML
    private Label klntMobielLabel;
    @FXML
    private Label klntEmailLabel;
    @FXML
    private Label klntVerkoolDatumLabel;

    @FXML
    private Label odSphLabel;
    @FXML
    private Label odCylLabel;
    @FXML
    private Label odAsLabel;
    @FXML
    private Label odAddLabel;
    @FXML
    private Label odNabijLabel;
    @FXML
    private Label odPrLabel;
    @FXML
    private Label odBasisLabel;
    @FXML
    private Label odVisLabel;
    @FXML
    private Label odPdDnLabel;
    @FXML
    private Label odLhLabel;
    @FXML
    private Label odHaLabel;
    @FXML
    private Label odIodLabel;

    @FXML
    private Label osSphLabel;
    @FXML
    private Label osCylLabel;
    @FXML
    private Label osAsLabel;
    @FXML
    private Label osAddLabel;
    @FXML
    private Label osNabijLabel;
    @FXML
    private Label osPrLabel;
    @FXML
    private Label osBasisLabel;
    @FXML
    private Label osVisLabel;
    @FXML
    private Label osPdDnLabel;
    @FXML
    private Label osLhLabel;
    @FXML
    private Label osHaLabel;
    @FXML
    private Label osIodLabel;
    @FXML
    private Label typeGlasLabel;
    @FXML
    private Label coatingLabel;
    @FXML
    private Label kleurglazenLabel;

    @FXML
    private Label brilvoorschriftLabel;

    @FXML
    private GridPane glazenGridPane;
    @FXML
    private Label leverancierLabel;
    @FXML
    private Label glazenLabel;
    @FXML
    private Label diameterLabel;
    @FXML
    private Label prijsGlasLabel;
    @FXML
    private Label btwLabel;
    @FXML
    private Label empty1Label;
    @FXML
    private Label empty2Label;
    @FXML
    private Label breedteLabel;
    @FXML
    private Label hoogteLabel;
    @FXML
    private Label neusmaatLabel;
    @FXML
    private Label merkLabel;
    @FXML
    private Label empty3Label;
    @FXML
    private Label modelLabel;
    @FXML
    private Label empty4Label;
    @FXML
    private Label kleurLabel;
    @FXML
    private Label empty5Label;
    @FXML
    private Label maatLabel;
    @FXML
    private Label empty6Label;
    @FXML
    private Label prijsMontuurLabel;
    @FXML
    private Label btw2Label;
    @FXML
    private Tab oogmetingTab;
    @FXML
    private Tab montuurTab;
    @FXML
    private Tab glazenTab;
    @FXML
    private Tab mailingTab;

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
                gebortedatumField,
                telefonField, mobileField, emailField
            };
        }
        for (TextField tf : searchFields) {
            if (tf != null) {
                tf.setText("");
            }
        }

        for (Label lbl : new Label[]{klntIdLabel, klntNameLabel, klntAdresLabel,
            klntPostCodePlaatsLabel, klntteleFoonLabel, klntMobielLabel,
            klntEmailLabel, klntVerkoolDatumLabel,
            odSphLabel, odCylLabel, odAsLabel, odAddLabel, odNabijLabel, odPrLabel, odBasisLabel,
            odVisLabel, odPdDnLabel, odLhLabel, odHaLabel, odIodLabel,
            osSphLabel, osCylLabel, osAsLabel, osAddLabel, osNabijLabel, osPrLabel, osBasisLabel,
            osVisLabel, osPdDnLabel, osLhLabel, osHaLabel, osIodLabel
        }) {
            lbl.setText("");
        }

        oogmetingTab.setDisable(true);
        montuurTab.setDisable(true);
        glazenTab.setDisable(true);
        mailingTab.setDisable(true);

        klantIDfield.setDisable(false);
        if (withDeselect) {
            klantGrid.unselect();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        brilvoorschriftLabel.setStyle(graylabelStyle);
//        leverancierLabel.setStyle(graylabelStyle);
//        glazenLabel.setStyle(graylabelStyle);
//        typeGlasLabel.setStyle(graylabelStyle);
//        coatingLabel.setStyle(graylabelStyle);
//        kleurglazenLabel.setStyle(graylabelStyle);
//        diameterLabel.setStyle(graylabelStyle);
//        prijsGlasLabel.setStyle(graylabelStyle);
//        btwLabel.setStyle(graylabelStyle);
//        empty1Label.setStyle(graylabelStyle);
//        empty2Label.setStyle(graylabelStyle);
//        breedteLabel.setStyle(graylabelStyle);
//        hoogteLabel.setStyle(graylabelStyle);
//        neusmaatLabel.setStyle(graylabelStyle);
//        merkLabel.setStyle(graylabelStyle);
//        empty3Label.setStyle(graylabelStyle);
//        modelLabel.setStyle(graylabelStyle);
//        empty4Label.setStyle(graylabelStyle);
//        kleurLabel.setStyle(graylabelStyle);
//        empty5Label.setStyle(graylabelStyle);
//        maatLabel.setStyle(graylabelStyle);
//        empty6Label.setStyle(graylabelStyle);
//        prijsMontuurLabel.setStyle(graylabelStyle);
//        btw2Label.setStyle(graylabelStyle);
        //glazenGridPane.getChildren().get(0).setStyle("-fx-background-color: gray;");
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
                String newSelect = addWhereCondition();
                try {
                    klantGrid.reload(newSelect);
                } catch (RemoteException ex) {
                    OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
                }
            }
        });
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
                int newKlant_id = 0;
                try {
                    if (validateFields()) {
                        if (klantIDfield.getText().isEmpty()) {
                            newKlant_id = addNewKlant();
                        } else {
                            newKlant_id = saveChangedKlant();
                        }
                        if (newKlant_id != 0) {
                            try {
                                klantGrid.reload(OpticStore.KLANTLIST);
                                klantGrid.scrollToID(newKlant_id);
                                loadKlantFrom(selectedKlantID);
                            } catch (RemoteException ex) {
                                OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
                            }
                        }
                    }
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
                }
            }
        });

        searchClientBox.getChildren().add(newClientNode);
        editClientNode = FXutils.createButton(getClass(), "edituser.png", new Runnable() {
            @Override
            public void run() {
                loadKlantFrom(selectedKlantID);
            }
        });
        editClientNode.setDisable(true);
        searchClientBox.getChildren().add(editClientNode);
        delClientNode = FXutils.createButton(getClass(), "deluser.png", new Runnable() {
            @Override
            public void run() {
                if (selectedKlantID != 0 && OpticStore.yesOrNoDialog(
                        "Bent u zeker dat u wilt verwijderen van dit record?\n(klant_id=" + selectedKlantID + ")")) {
                    Klant klant = null;
                    try {
                        klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, selectedKlantID);
                        if (klant != null) {
                            OpticStore.getExchanger().deleteObject(klant);
                            klantGrid.reload();
                            clearKlantForm(true);
                        }
                    } catch (RemoteException ex) {
                        OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
                    }
                }
            }
        });
        delClientNode.setDisable(true);
        searchClientBox.getChildren().add(delClientNode);

        try {
            klantGrid = new TableGridPanel(OpticStore.getExchanger(), OpticStore.KLANTLIST);
            klantGrid.getTableView().setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                        loadKlantFrom(selectedKlantID);
                    }
                }
            });
            innerAnchorPane.setTopAnchor(klantGrid, 10.0);
            innerAnchorPane.setLeftAnchor(klantGrid, 400.0);
            innerAnchorPane.setRightAnchor(klantGrid, 0.0);
            innerAnchorPane.setBottomAnchor(klantGrid, 10.0);
            innerAnchorPane.getChildren().add(klantGrid);
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
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

    private void fillKlantFromEdits(Klant klant) throws SQLException, ForeignKeyViolationException, ParseException {
        klant.setAanhef(aanhefField.getText());
        klant.setAchternaam(achternaamField.getText());
        klant.setAdres(adresField.getText());
        klant.setEmail(emailField.getText());
        if (!gebortedatumField.getText().isEmpty()) {
            java.util.Date dt = OpticStore.dateFormat.parse(gebortedatumField.getText());
            klant.setGeboortedatum(new Date(dt.getTime()));
        }
        klant.setHuisnummer(huisnummerField.getText());
        klant.setLand(landField.getText());
        klant.setMobiel(mobileField.getText());
        klant.setPlaats(plaatsField.getText());
        klant.setPostcode(postcodeField.getText());
        klant.setTelefoon(telefonField.getText());
        klant.setTussenvoegsel(tussenvoegselField.getText());
        klant.setVoorletters(voorlettersField.getText());
    }

    private boolean validateFields() {
        if (aanhefField.getText().isEmpty()) {
            aanhefField.setPromptText(FILL_THIS_FIELD);
            aanhefField.requestFocus();
            return false;
        }
        if (voorlettersField.getText().isEmpty()) {
            voorlettersField.setPromptText(FILL_THIS_FIELD);
            voorlettersField.requestFocus();
            return false;
        }
        if (achternaamField.getText().isEmpty()) {
            achternaamField.setPromptText(FILL_THIS_FIELD);
            achternaamField.requestFocus();
            return false;
        }
        if (emailField.getText().isEmpty()) {
            emailField.setPromptText(FILL_THIS_FIELD);
            emailField.requestFocus();
            return false;
        }
        return true;
    }

    private int addNewKlant() {
        try {
            Klant klant = new Klant(null);
            klant.setKlantId(0);
            klant.setNew(true);
            fillKlantFromEdits(klant);
            klant = (Klant) OpticStore.getExchanger().saveDbObject(klant);
            klantIDfield.setText(klant.getKlantId().toString());
            return klant.getKlantId().intValue();
        } catch (Exception ex) {
            OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
        }
        return 0;
    }

    private int saveChangedKlant() throws RemoteException, SQLException, ForeignKeyViolationException, ParseException {
        int klid = Integer.parseInt(klantIDfield.getText().trim());
        Klant klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, klid);
        fillKlantFromEdits(klant);
        klant = (Klant) OpticStore.getExchanger().saveDbObject(klant);
        return klid;
    }

    private String addWhereCondition() {
        if (!klantIDfield.getText().isEmpty()
                || !aanhefField.getText().isEmpty()
                || !voorlettersField.getText().isEmpty()
                || !tussenvoegselField.getText().isEmpty()
                || !achternaamField.getText().isEmpty()
                || !adresField.getText().isEmpty()
                || !huisnummerField.getText().isEmpty()
                || !postcodeField.getText().isEmpty()
                || !plaatsField.getText().isEmpty()
                || !landField.getText().isEmpty()
                || !gebortedatumField.getText().isEmpty()
                || !telefonField.getText().isEmpty()
                || !mobileField.getText().isEmpty()
                || !emailField.getText().isEmpty()) {

            StringBuilder sb = new StringBuilder(OpticStore.KLANTLIST.substring(0, OpticStore.KLANTLIST.indexOf(" order by")) + " where ");
            boolean isThere = false;
            if (!klantIDfield.getText().isEmpty()) {
                sb.append("klant_id = " + klantIDfield.getText());
                isThere = true;
            }
            if (!aanhefField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(aanhef) like '" + aanhefField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!voorlettersField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(voorletters) like '" + voorlettersField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!tussenvoegselField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(tussenvoegsel) like '" + tussenvoegselField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!achternaamField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(achternaam) like '" + achternaamField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!adresField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(adres) like '" + adresField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!huisnummerField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(huisnummer) like '" + huisnummerField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!postcodeField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(postcode) like '" + postcodeField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!plaatsField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(plaats) like '" + plaatsField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!landField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(land) like '" + landField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!gebortedatumField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("geboortedatum like '" + gebortedatumField.getText() + "%'");
                isThere = true;
            }
            if (!telefonField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(telefoon) like '" + telefonField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!mobileField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(mobiel) like '" + mobileField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            if (!emailField.getText().isEmpty()) {
                if (isThere) {
                    sb.append(" and ");
                }
                sb.append("UPPER(email) like '" + emailField.getText().toUpperCase() + "%'");
                isThere = true;
            }
            sb.append(OpticStore.KLANTLIST.substring(OpticStore.KLANTLIST.indexOf(" order by")));
            return sb.toString();
        } else {
            return OpticStore.KLANTLIST;
        }
    }

    private void loadKlantFrom(int selectedKlantID) {
        try {
            clearKlantForm(false);
            Klant klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, selectedKlantID);
            if (klant != null) {
                klantIDfield.setDisable(true);
                String klid;
                klantIDfield.setText(klid = klant.getKlantId().toString());
                aanhefField.setText(klant.getAanhef() == null ? "" : klant.getAanhef());
                voorlettersField.setText(klant.getVoorletters() == null ? "" : klant.getVoorletters());
                tussenvoegselField.setText(klant.getTussenvoegsel() == null ? "" : klant.getTussenvoegsel());
                achternaamField.setText(klant.getAchternaam() == null ? "" : klant.getAchternaam());
                adresField.setText(klant.getAdres() == null ? "" : klant.getAdres());
                huisnummerField.setText(klant.getHuisnummer() == null ? "" : klant.getHuisnummer());
                postcodeField.setText(klant.getPostcode() == null ? "" : klant.getPostcode());
                plaatsField.setText(klant.getPlaats() == null ? "" : klant.getPlaats());
                landField.setText(klant.getLand() == null ? "" : klant.getLand());
                if (klant.getGeboortedatum() != null) {
                    gebortedatumField.setText(klant.getGeboortedatum().toString());
                }
                String tlfn;
                telefonField.setText(tlfn = klant.getTelefoon() == null ? "" : klant.getTelefoon());
                String mbl;
                mobileField.setText(mbl = klant.getMobiel() == null ? "" : klant.getMobiel());
                String eml;
                emailField.setText(eml = klant.getEmail() == null ? "" : klant.getEmail());
                String postPlaats = (klant.getPostcode() == null ? "" : (klant.getPostcode() + " "))
                        + (klant.getPlaats() == null ? "" : klant.getPlaats());
                klntIdLabel.setText(klid);
                klntNameLabel.setText(klant.getAanhef() + " " + klant.getVoorletters()
                        + " " + klant.getTussenvoegsel() + " " + klant.getAchternaam());
                klntAdresLabel.setText(klant.getAdres() + " " + klant.getHuisnummer());
                klntteleFoonLabel.setText("telefoon:" + tlfn);
                klntMobielLabel.setText("mobiel:" + mbl);
                klntEmailLabel.setText("e-mail:" + eml);
                klntPostCodePlaatsLabel.setText(postPlaats);
                klntVerkoolDatumLabel.setText(getLastSellDate(klant.getKlantId()));
                loadLastBrilvoorschrift(klant.getKlantId());
                oogmetingTab.setDisable(false);
                montuurTab.setDisable(false);
                glazenTab.setDisable(false);
                mailingTab.setDisable(false);

            }
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
        }
    }

    private void enableLoadKlantOperations(boolean enable) {
        editClientNode.setDisable(!enable);
        delClientNode.setDisable(!enable);
    }

    private String getLastSellDate(Integer klantId) throws RemoteException {
        DbObject[] recs = OpticStore.getExchanger().getDbObjects(Verkoop.class, "klant_id=" + klantId, "verkoopdatum desc");
        if (recs.length > 0) {
            Verkoop vk = (Verkoop) recs[0];
            Date dt = vk.getVerkoopdatum();
            return dt == null ? "" : OpticStore.dateFormat.format(dt);
        }
        return "geen verkoop";
    }

    private void loadLastBrilvoorschrift(Integer klantId) throws RemoteException {
        DbObject[] recs = OpticStore.getExchanger().getDbObjects(Brilvoorschrift.class, "klant_id=" + klantId, "datum_refractie desc");
        if (recs.length > 0) {
            Brilvoorschrift bs = (Brilvoorschrift) recs[0];
            Date dt = bs.getDatumRefractie();
            odSphLabel.setText(bs.getOdSph().toString());
            odCylLabel.setText(bs.getOdCyl().toString());
            odAsLabel.setText(bs.getOdAs().toString());
            odAddLabel.setText(bs.getOdAdd().toString());
            odNabijLabel.setText(bs.getOdNabil().toString());
            odPrLabel.setText(bs.getOdPr().toString());
            odBasisLabel.setText(bs.getOdBasis().toString());
            odVisLabel.setText(bs.getOdVis().toString());
            odPdDnLabel.setText(bs.getOdPddn());
            odLhLabel.setText(bs.getOdLh().toString());
            odHaLabel.setText(bs.getOdHa().toString());
            odIodLabel.setText(bs.getOdIod().toString());

            osSphLabel.setText(bs.getOsSph().toString());
            osCylLabel.setText(bs.getOsCyl().toString());
            osAsLabel.setText(bs.getOsAs().toString());
            osAddLabel.setText(bs.getOsAdd().toString());
            osNabijLabel.setText(bs.getOsNabil().toString());
            osPrLabel.setText(bs.getOsPr().toString());
            osBasisLabel.setText(bs.getOsBasis().toString());
            osVisLabel.setText(bs.getOsVis().toString());
            osPdDnLabel.setText(bs.getOsPddn());
            osLhLabel.setText(bs.getOsLh().toString());
            osHaLabel.setText(bs.getOsHa().toString());
            osIodLabel.setText(bs.getOsIod().toString());
        }
    }
}
