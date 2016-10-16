/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import static com.dk.FXMLmainController.currentUser;
import com.dk.orm.Klant;
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
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author Nick
 */
public class FXMLDashboard2Controller implements Initializable {

    private static final String FILL_THIS_FIELD = "dit veld invullen";
    private static final String graylabelStyle = "-fx-background-color: gray;";

    public static FXMLDashboard2Controller instance;
    @FXML
    private MenuItem menuFile;
    @FXML
    MenuItem usersMenu;
    @FXML
    MenuItem setupMenu;
    @FXML
    private ToggleButton klantBtn;
    @FXML
    private ToggleButton oogmetingBtn;
    @FXML
    private ToggleButton montuurBtn;
    @FXML
    private ToggleButton glazenBtn;
    @FXML
    private ToggleButton mailingBtn;
    @FXML
    private ToggleButton artikelbeheerBtn;
    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane klantPane;
    @FXML
    private AnchorPane oogmetingPane;
    @FXML
    private AnchorPane montuurPane;
    @FXML
    private AnchorPane glazenPane;
    @FXML
    private AnchorPane mailingPane;
    @FXML
    private AnchorPane artikelbeheerPane;

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
    private TitledPane zoekenPane;
    @FXML
    private AnchorPane innerAnchorPane;

    @FXML
    private VBox searchClientBox;
    private Node editClientNode;
    private Node delClientNode;

    private TextField[] searchFields = null;
    private TableGridPanel klantGrid = null;
    private int selectedKlantID = 0;

    static void expandeFirst() {
        if (instance != null && instance.zoekenPane != null) {
            instance.zoekenPane.setExpanded(true);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        instance = this;
        Image menuIcon = new Image(getClass().getResourceAsStream("menu_icon.png"));
        ImageView sysMenuView = new ImageView(menuIcon);
        sysMenuView.setFitWidth(32);
        sysMenuView.setFitHeight(32);
        menuFile.setGraphic(sysMenuView);
//        if (currentUser != null && currentUser.getIsAdmin().intValue() != 1) {
//            usersMenu.setDisable(true);
//            setupMenu.setDisable(true);
//        }
        Node searchClientNode = FXutils.createButton(getClass(), "search.png", new Runnable() {
            @Override
            public void run() {
                //TODO: search clients
                String newSelect = addWhereCondition();
                try {
                    klantGrid.reload(newSelect);
                } catch (RemoteException ex) {
                    OpticStore.logAndShowErrorMessage(ex);
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
                                OpticStore.logAndShowErrorMessage(ex);
                            }
                        }
                    }
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex);
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
                        OpticStore.logAndShowErrorMessage(ex);
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
            OpticStore.logAndShowErrorMessage(ex);
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

    private int saveChangedKlant() throws RemoteException, SQLException, ForeignKeyViolationException, ParseException {
        int klid = Integer.parseInt(klantIDfield.getText().trim());
        Klant klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, klid);
        fillKlantFromEdits(klant);
        klant = (Klant) OpticStore.getExchanger().saveDbObject(klant);
        return klid;
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
            OpticStore.logAndShowErrorMessage(ex);
        }
        return 0;
    }

    private void enableLoadKlantOperations(boolean enable) {
        editClientNode.setDisable(!enable);
        delClientNode.setDisable(!enable);
    }

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

//        for (Label lbl : new Label[]{klntIdLabel, klntNameLabel, klntAdresLabel,
//            klntPostCodePlaatsLabel, klntteleFoonLabel, klntMobielLabel,
//            klntEmailLabel, klntVerkoolDatumLabel,
//            odSphLabel, odCylLabel, odAsLabel, odAddLabel, odNabijLabel,
//            odPrLabel, odBasisLabel, odPr1Label, odBasis1Label,
//            odVisLabel, odPdDnLabel, odLhLabel, odHaLabel, odIodLabel,
//            osSphLabel, osCylLabel, osAsLabel, osAddLabel, osNabijLabel,
//            osPrLabel, osBasisLabel, osPr1Label, osBasis1Label,
//            osVisLabel, osPdDnLabel, osLhLabel, osHaLabel, osIodLabel,
//            r_leverancierLabel, l_leverancierLabel, r_typeglasLabel, l_typeglasLabel,
//            r_coatingLabel, l_coatingLabel, r_kleurglazenLabel, l_kleurglazenLabel,
//            r_diameterLabel, l_diameterLabel, r_prijsglasLabel, l_prijsglasLabel,
//            r_btwLabel, l_btwLabel, merkLabel, modelLabel,
//            kleurLabel, maatLabel, prijsmontuurLabel, btwLabel,
//            soortglasLabel, montuurtypeLabel, materiaalLabel, kortingLabel,
//            totaalBtwLabel, totaalLabel,
//            breedteLabel, hoogteLabel, neusmaatLabel, diversenLabel, vidLabel
//
//        }) {
//            lbl.setText("");
//        }
//        voorlettersInput.setText("");
//        emailInput.setText("");
//        achternaamInput.setText("");
//        emailsInput.setText("");
//        emailssInput.setText("");
//
//        oogmetingTab.setDisable(true);
//        montuurTab.setDisable(true);
//        glazenTab.setDisable(true);
//        mailingTab.setDisable(true);
//        anamneseButton.setDisable(true);
        klantIDfield.setDisable(false);
        if (withDeselect) {
            klantGrid.unselect();
        }
//        clearTab2();
//        clearTab3();
//        clearTab4();
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
                sb.append("to_char(geboortedatum,'" + OpticStore.dateFormat.toPattern().toUpperCase() + "') like '" + gebortedatumField.getText() + "%'");
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

//                voorlettersInput.setText(klant.getVoorletters() == null ? "" : klant.getVoorletters());
//                achternaamInput.setText(klant.getAchternaam() == null ? "" : klant.getAchternaam());
                voorlettersField.setText(klant.getVoorletters() == null ? "" : klant.getVoorletters());
                tussenvoegselField.setText(klant.getTussenvoegsel() == null ? "" : klant.getTussenvoegsel());
                achternaamField.setText(klant.getAchternaam() == null ? "" : klant.getAchternaam());
                adresField.setText(klant.getAdres() == null ? "" : klant.getAdres());
                huisnummerField.setText(klant.getHuisnummer() == null ? "" : klant.getHuisnummer());
                postcodeField.setText(klant.getPostcode() == null ? "" : klant.getPostcode());
                plaatsField.setText(klant.getPlaats() == null ? "" : klant.getPlaats());
                landField.setText(klant.getLand() == null ? "" : klant.getLand());
                if (klant.getGeboortedatum() != null) {
                    gebortedatumField.setText(OpticStore.dateFormat.format(klant.getGeboortedatum()));//klant.getGeboortedatum().toString());
                }
                String tlfn;
                telefonField.setText(tlfn = klant.getTelefoon() == null ? "" : klant.getTelefoon());
                String mbl;
                mobileField.setText(mbl = klant.getMobiel() == null ? "" : klant.getMobiel());
                String eml;
                emailField.setText(eml = klant.getEmail() == null ? "" : klant.getEmail());
//                emailInput.setText(eml);
                String postPlaats = (klant.getPostcode() == null ? "" : (klant.getPostcode() + " "))
                        + (klant.getPlaats() == null ? "" : klant.getPlaats());
//                klntIdLabel.setText(klid);
//                klntNameLabel.setText(klant.getAanhef() + " " + klant.getVoorletters()
//                        + " " + klant.getTussenvoegsel() + " " + klant.getAchternaam());
//                klntAdresLabel.setText(klant.getAdres() + " " + klant.getHuisnummer());
//                klntteleFoonLabel.setText("telefoon:" + tlfn);
//                klntMobielLabel.setText("mobiel:" + mbl);
//                klntEmailLabel.setText("e-mail:" + eml);
//                klntPostCodePlaatsLabel.setText(postPlaats);
//                klntVerkoolDatumLabel.setText(getLastSellDate(klant.getKlantId()));
//                loadLastBrilvoorschriftList(klant);
//                loadLastVerkoopList(klant);
//                oogmetingTab.setDisable(false);
//                montuurTab.setDisable(false);
//                glazenTab.setDisable(false);
//                mailingTab.setDisable(false);
//                anamneseButton.setDisable(false);
            }
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex);
        }
    }

    @FXML
    private void handleExit() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void handleLogout() {
        FXMLmainController.staticPwdField.setText(null);
        OpticStore.mainApp.hideDashboardAndShowLogin();
    }

    @FXML
    private void handleUsersMenu() {
        if (currentUser.getIsAdmin().intValue() != 1) {
            OpticStore.logAndShowErrorMessage("You have no admin permissions, sorry!");
        } else {
            try {
                FXMLLoader compLoader = new FXMLLoader(getClass().getResource("FXMLusersForm.fxml"));
                Parent usersPane = (Parent) compLoader.load();
                Callback<Void, Void> myCallback = new Callback<Void, Void>() {
                    @Override
                    public Void call(Void param) {
                        return null;
                    }
                };
                Dialogs.DialogResponse resp
                        = Dialogs.showCustomDialog(OpticStore.mainStage,
                                (Pane) usersPane, "", "Users", Dialogs.DialogOptions.OK, myCallback);
//                    if (resp.equals(Dialogs.DialogResponse.OK)) {
//                        //TODO: save text
//                    }
            } catch (Exception ex) {
                OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
            }
        }
    }

    @FXML
    private void handleAnamnesButton() {
        //OpticStore.logAndShowErrorMessage("Deze knop niet werkt, ga dan naar [oogmeting]");
        try {
            FXMLLoader compLoader = new FXMLLoader(getClass().getResource("AnamnesPane.fxml"));
            Parent anamnesPane = (Parent) compLoader.load();
            Callback<Void, Void> myCallback = new Callback<Void, Void>() {
                @Override
                public Void call(Void param) {
                    return null;
                }
            };
            Dialogs.DialogResponse resp
                    = Dialogs.showCustomDialog(OpticStore.mainStage,
                            (Pane) anamnesPane, "", "Anamnese", Dialogs.DialogOptions.OK, myCallback);
        } catch (Exception ex) {
            OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
        }
    }

    private void setOnTop(Node node) {
        //ObservableList<Node> childs = stackPane.getChildren();
        node.toFront();
    }

    @FXML
    private void klantPress() {
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        //TODO: klant selected
        setOnTop(klantPane);
    }

    @FXML
    private void oogmetingPress() {
        klantBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        //TODO: oogmeting selected
        setOnTop(oogmetingPane);
    }

    @FXML
    private void montuurPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        //TODO: montuur selected
        setOnTop(montuurPane);
    }

    @FXML
    private void glazenPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        //TODO: glazen selected
        setOnTop(glazenPane);
    }

    @FXML
    private void mailingPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        //TODO: mailing selected
        setOnTop(mailingPane);
    }

    @FXML
    private void artikelbeheerPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        //TODO: artikelbeheer selected
        setOnTop(artikelbeheerPane);
    }
}
