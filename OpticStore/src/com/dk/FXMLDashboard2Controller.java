/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import static com.dk.FXMLmainController.currentUser;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Vector;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
    private static ArrayList<Brilvoorschrift> brilvoorschriftArray;
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
    TitledPane zoekenPane;
    @FXML
    private AnchorPane innerAnchorPane;

    @FXML
    private VBox searchClientBox;
    private Node editClientNode;
    private Node delClientNode;

    @FXML
    private TextField odSphInput;
    @FXML
    private TextField odCylInput;
    @FXML
    private TextField odAsInput;
    @FXML
    private TextField odAddInput;
    @FXML
    private TextField odNabijInput;
    @FXML
    private TextField odPrInput;
    @FXML
    private TextField odBasisInput;
    @FXML
    private TextField odPr1Input;
    @FXML
    private TextField odBasis1Input;
    @FXML
    private TextField odVisInput;
    @FXML
    private TextField odPdDnInput;
    @FXML
    private TextField odLhInput;
    @FXML
    private TextField odHaInput;
    @FXML
    private TextField odIodInput;

    @FXML
    private TextField osSphInput;
    @FXML
    private TextField osCylInput;
    @FXML
    private TextField osAsInput;
    @FXML
    private TextField osAddInput;
    @FXML
    private TextField osNabijInput;
    @FXML
    private TextField osPrInput;
    @FXML
    private TextField osBasisInput;
    @FXML
    private TextField osPr1Input;
    @FXML
    private TextField osBasis1Input;
    @FXML
    private TextField osVisInput;
    @FXML
    private TextField osPdDnInput;
    @FXML
    private TextField osLhInput;
    @FXML
    private TextField osHaInput;
    @FXML
    private TextField osIodInput;
    @FXML
    private TextField oogmetinggDoorInput;
    @FXML
    private TextField datumRefractieInput;

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
    private Label odPr1Label;
    @FXML
    private Label odBasis1Label;
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
    private Label osPr1Label;
    @FXML
    private Label osBasis1Label;
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
////////
    @FXML
    private Label r_leverancierLabel;
    @FXML
    private Label l_leverancierLabel;
    @FXML
    private Label breedteLabel;
    @FXML
    private Label hoogteLabel;
    @FXML
    private Label neusmaatLabel;
    @FXML
    private Label merkLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label diversenLabel;
    @FXML
    private Label soortglasLabel;
    @FXML
    private Label montuurtypeLabel;
    @FXML
    private Label materiaalLabel;
    @FXML
    private Label kleurLabel;
    @FXML
    private Label maatLabel;
    @FXML
    private Label prijsmontuurLabel;
    @FXML
    private Label btwLabel;
    @FXML
    private Label kortingLabel;
    @FXML
    private Label totaalLabel;
    @FXML
    private Label totaalBtwLabel;
    @FXML
    private Label r_typeglasLabel;
    @FXML
    private Label l_typeglasLabel;
    @FXML
    private Label r_coatingLabel;
    @FXML
    private Label l_coatingLabel;
    @FXML
    private Label r_kleurglazenLabel;
    @FXML
    private Label l_kleurglazenLabel;
    @FXML
    private Label r_diameterLabel;
    @FXML
    private Label l_diameterLabel;
    @FXML
    private Label r_prijsglasLabel;
    @FXML
    private Label l_prijsglasLabel;
    @FXML
    private Label r_btwLabel;
    @FXML
    private Label l_btwLabel;
    @FXML
    private Label diversePrijsLabel;
    @FXML
    private Label diverseBtwLabel;
    @FXML
    private TextField voorlettersInput;
    @FXML
    private TextField emailInput;
    @FXML
    private TextField achternaamInput;
    @FXML
    private TextField emailsInput;
    @FXML
    private TextField emailssInput;

    @FXML
    private Label vidLabel;
    @FXML
    private RadioButton klantRB;
    @FXML
    private RadioButton listRB;
    @FXML
    private RadioButton ageRB;
    @FXML
    private TextField vanDeInput;
    @FXML
    private TextField totDeInput;
    @FXML
    private Button sendEmailButton;
    @FXML
    private TextArea emailBodyField;
    @FXML
    private TextField emailSubjectField;
    @FXML
    private Button anamneseButton;
    @FXML
    private TextArea anamneseField;

    @FXML
    private Label verkoopLabel;
    @FXML
    private Label verkoop1Label;
    @FXML
    private ComboBox merkCombo;
    @FXML
    private ComboBox modelCombo;
    @FXML
    private ComboBox kleurCombo;
    @FXML
    private TextField maatInput;
    @FXML
    private TextField prijsMontuurInput;
    @FXML
    private ComboBox montuurTypeCombo;
    @FXML
    private ComboBox materiallCombo;
    @FXML
    private ComboBox diversenCombo;
    @FXML
    private TextField idMontuurInput;
    @FXML
    private TextField montuurDatumInput;

    @FXML
    private ComboBox rLeverancierCombo;
    @FXML
    private ComboBox lLeverancierCombo;
    @FXML
    private ComboBox rTypeGlasCombo;
    @FXML
    private ComboBox lTypeGlasCombo;
    @FXML
    private ComboBox rCoatingCombo;
    @FXML
    private ComboBox lCoatingCombo;
    @FXML
    private ComboBox rKleurGlasCombo;
    @FXML
    private ComboBox lKleurGlasCombo;
    @FXML
    private ComboBox soortGlasCombo;
    @FXML
    private TextField rDiameterInput;
    @FXML
    private TextField lDiameterInput;
    @FXML
    private TextField rPrijsGlasInput;
    @FXML
    private TextField lPrijsGlasInput;
    @FXML
    private TextField breedteInput;
    @FXML
    private TextField hoogteInput;
    @FXML
    private TextField neusmaatInput;
    @FXML
    private TextField kortingInput;
    @FXML
    private TextField totaalInput;
    @FXML
    private TextField btwInput;
    @FXML
    private TextField diversenPrijsInput;

    private TextField[] searchFields = null;
    private TableGridPanel klantGrid = null;
    private int selectedKlantID = 0;

    static void expandeFirst() {
        if (instance != null && instance.zoekenPane != null) {
            instance.zoekenPane.setExpanded(true);
        }
    }
    private Brilvoorschrift currentBrilvoorschrift;
    private int brilvoorschriftIndex;
    private Verkoop currentVerkoop;
    private static ArrayList<Verkoop> verkoopArray = new ArrayList<Verkoop>();
    private int verkoopIndex;

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
        klantPane.setVisible(true);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(false);
        glazenPane.setVisible(false);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(false);
    }

    private void clearTab2() {
        //vidLabel.setText("");
        for (TextField tf : new TextField[]{
            odSphInput, odCylInput, odAsInput, odAddInput, odNabijInput,
            odPrInput, odBasisInput, odPr1Input, odBasis1Input,
            odVisInput, odPdDnInput, odLhInput, odHaInput, odIodInput,
            osSphInput, osCylInput, osAsInput, osAddInput, osNabijInput,
            osPrInput, osBasisInput, osPr1Input, osBasis1Input,
            osVisInput, osPdDnInput, osLhInput, osHaInput, osIodInput,
            oogmetinggDoorInput
        }) {
            if (tf != null) {
                tf.setText("");
            }
        }
        datumRefractieInput.setText(OpticStore.dateFormat.format(Calendar.getInstance().getTime()));
        //anamneseField.setText("");
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

        for (Label lbl : new Label[]{klntIdLabel, klntNameLabel, klntAdresLabel,
            klntPostCodePlaatsLabel, klntteleFoonLabel, klntMobielLabel,
            klntEmailLabel, klntVerkoolDatumLabel,
            odSphLabel, odCylLabel, odAsLabel, odAddLabel, odNabijLabel,
            odPrLabel, odBasisLabel, odPr1Label, odBasis1Label,
            odVisLabel, odPdDnLabel, odLhLabel, odHaLabel, odIodLabel,
            osSphLabel, osCylLabel, osAsLabel, osAddLabel, osNabijLabel,
            osPrLabel, osBasisLabel, osPr1Label, osBasis1Label,
            osVisLabel, osPdDnLabel, osLhLabel, osHaLabel, osIodLabel,
            r_leverancierLabel, l_leverancierLabel, r_typeglasLabel, l_typeglasLabel,
            r_coatingLabel, l_coatingLabel, r_kleurglazenLabel, l_kleurglazenLabel,
            r_diameterLabel, l_diameterLabel, r_prijsglasLabel, l_prijsglasLabel,
            r_btwLabel, l_btwLabel, merkLabel, modelLabel,
            kleurLabel, maatLabel, prijsmontuurLabel, btwLabel,
            soortglasLabel, montuurtypeLabel, materiaalLabel, kortingLabel,
            totaalBtwLabel, totaalLabel,
            breedteLabel, hoogteLabel, neusmaatLabel, diversenLabel, vidLabel

        }) {
            if (lbl != null) {
                lbl.setText("");
            }
        }
        voorlettersInput.setText("");
        emailInput.setText("");
        achternaamInput.setText("");
        emailsInput.setText("");
        emailssInput.setText("");

//        oogmetingTab.setDisable(true);
//        montuurTab.setDisable(true);
//        glazenTab.setDisable(true);
//        mailingTab.setDisable(true);
//        anamneseButton.setDisable(true);
        klantIDfield.setDisable(false);
        if (withDeselect) {
            klantGrid.unselect();
        }
        clearTab2();
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
                klntIdLabel.setText(klid);
                klntNameLabel.setText(klant.getAanhef() + " " + klant.getVoorletters()
                        + " " + klant.getTussenvoegsel() + " " + klant.getAchternaam());
                klntAdresLabel.setText(klant.getAdres() + " " + klant.getHuisnummer());
                klntteleFoonLabel.setText("telefoon:" + tlfn);
                klntMobielLabel.setText("mobiel:" + mbl);
                klntEmailLabel.setText("e-mail:" + eml);
                klntPostCodePlaatsLabel.setText(postPlaats);
                klntVerkoolDatumLabel.setText(getLastSellDate(klant.getKlantId()));
                loadLastBrilvoorschriftList(klant);
                loadLastVerkoopList(klant);
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

    private String getLastSellDate(Integer klantId) throws RemoteException {
        DbObject[] recs = OpticStore.getExchanger().getDbObjects(Verkoop.class, "klant_id=" + klantId, "verkoopdatum desc");
        if (recs.length > 0) {
            Verkoop vk = (Verkoop) recs[0];
            fillLastVerkoop(vk);
            Date dt = vk.getVerkoopdatum();
            return dt == null ? "" : OpticStore.dateFormat.format(dt);
        }
        return "geen verkoop";
    }

    private void loadLastBrilvoorschriftList(Klant klant) throws RemoteException {
        getBrilvoorschriftArray().clear();
        setCurrentBrilvoorschrift(null);
        if (klant != null) {
            DbObject[] recs = OpticStore.getExchanger().getDbObjects(Brilvoorschrift.class,
                    "klant_id=" + klant.getKlantId(), "brilvoorschrift_id");
            for (DbObject rec : recs) {
                getBrilvoorschriftArray().add((Brilvoorschrift) rec);
            }
            if (getBrilvoorschriftArray().size() > 0) {
                setCurrentBrilvoorschrift(getBrilvoorschriftArray().get(getBrilvoorschriftArray().size() - 1));
            }
        }
        loadLastBrilvoorschrift();
        loadBrilvoorschrift();
    }

    private void loadBrilvoorschrift() {
        if (getCurrentBrilvoorschrift() != null) {
            //vidLabel.setText(getCurrentBrilvoorschrift().getBrilvoorschriftId().toString());
            vidLabel.setText("" + (brilvoorschriftIndex + 1) + "/" + getBrilvoorschriftArray().size());
            fillFieldWithValue(datumRefractieInput, getCurrentBrilvoorschrift().getDatumRefractie());
            fillFieldWithValue(odAddInput, getCurrentBrilvoorschrift().getOdAdd());
            fillFieldWithValue(osAddInput, getCurrentBrilvoorschrift().getOsAdd());
            fillFieldWithValue(odAsInput, getCurrentBrilvoorschrift().getOdAs());
            fillFieldWithValue(osAsInput, getCurrentBrilvoorschrift().getOsAs());
            fillFieldWithValue(odBasisInput, getCurrentBrilvoorschrift().getOdBasis());
            fillFieldWithValue(odBasis1Input, getCurrentBrilvoorschrift().getOdBasis1());
            fillFieldWithValue(osBasisInput, getCurrentBrilvoorschrift().getOsBasis());
            fillFieldWithValue(osBasis1Input, getCurrentBrilvoorschrift().getOsBasis1());
            fillFieldWithValue(odCylInput, getCurrentBrilvoorschrift().getOdCyl());
            fillFieldWithValue(osCylInput, getCurrentBrilvoorschrift().getOsCyl());
            fillFieldWithValue(odHaInput, getCurrentBrilvoorschrift().getOdHa());
            fillFieldWithValue(osHaInput, getCurrentBrilvoorschrift().getOsHa());
            fillFieldWithValue(odIodInput, getCurrentBrilvoorschrift().getOdIod());
            fillFieldWithValue(osIodInput, getCurrentBrilvoorschrift().getOsIod());
            fillFieldWithValue(odLhInput, getCurrentBrilvoorschrift().getOdLh());
            fillFieldWithValue(osLhInput, getCurrentBrilvoorschrift().getOsLh());
            fillFieldWithValue(odNabijInput, getCurrentBrilvoorschrift().getOdNabil());
            fillFieldWithValue(osNabijInput, getCurrentBrilvoorschrift().getOsNabil());
            fillFieldWithValue(odPdDnInput, getCurrentBrilvoorschrift().getOdPddn());
            fillFieldWithValue(osPdDnInput, getCurrentBrilvoorschrift().getOsPddn());
            fillFieldWithValue(odPrInput, getCurrentBrilvoorschrift().getOdPr());
            fillFieldWithValue(osPrInput, getCurrentBrilvoorschrift().getOsPr());
            fillFieldWithValue(odPr1Input, getCurrentBrilvoorschrift().getOdPr1());
            fillFieldWithValue(osPr1Input, getCurrentBrilvoorschrift().getOsPr1());
            fillFieldWithValue(odSphInput, getCurrentBrilvoorschrift().getOdSph());
            fillFieldWithValue(osSphInput, getCurrentBrilvoorschrift().getOsSph());
            fillFieldWithValue(odVisInput, getCurrentBrilvoorschrift().getOdVis());
            fillFieldWithValue(osVisInput, getCurrentBrilvoorschrift().getOsVis());
            fillFieldWithValue(oogmetinggDoorInput, getCurrentBrilvoorschrift().getOogmetingDoor());
            anamneseField.setText(getCurrentBrilvoorschrift().getAnamnese());
        }
    }

    private void loadLastBrilvoorschrift() throws RemoteException {
        if (getBrilvoorschriftArray().size() > 0) {
            Brilvoorschrift bs = getBrilvoorschriftArray().get(getBrilvoorschriftArray().size() - 1);
            Date dt = bs.getDatumRefractie();
            odSphLabel.setText(bs.getOdSph().toString());
            odCylLabel.setText(bs.getOdCyl().toString());
            odAsLabel.setText(bs.getOdAs().toString());
            odAddLabel.setText(bs.getOdAdd().toString());
            odNabijLabel.setText(bs.getOdNabil().toString());
            odPrLabel.setText(bs.getOdPr().toString());
            odBasisLabel.setText(bs.getOdBasis().toString());
            odPr1Label.setText(bs.getOdPr1().toString());
            odBasis1Label.setText(bs.getOdBasis1().toString());
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
            osPr1Label.setText(bs.getOsPr1().toString());
            osBasis1Label.setText(bs.getOsBasis1().toString());
            osVisLabel.setText(bs.getOsVis().toString());
            osPdDnLabel.setText(bs.getOsPddn());
            osLhLabel.setText(bs.getOsLh().toString());
            osHaLabel.setText(bs.getOsHa().toString());
            osIodLabel.setText(bs.getOsIod().toString());
        }
    }

    private void loadLastVerkoopList(Klant klant) throws RemoteException {
        verkoopArray.clear();
        setCurrentVerkoop(null);
        if (klant != null) {
            DbObject[] recs = OpticStore.getExchanger().getDbObjects(Verkoop.class,
                    "klant_id=" + klant.getKlantId(), "verkoop_id");
            for (DbObject rec : recs) {
                //verkoopArray.add(new Verkoop((Verkoop) rec,NDS));
                verkoopArray.add((Verkoop) rec);
            }
            if (verkoopArray.size() > 0) {
                setCurrentVerkoop(verkoopArray.get(verkoopArray.size() - 1));
            }
        }
        loadLastVerkoop();
        loadVerkoop();
    }

    private static void fillFieldWithValue(TextField fld, Object val) {
        if (val == null) {
            fld.setText("");
        } else if (val instanceof java.util.Date) {
            fld.setText(OpticStore.dateFormat.format(val));
        } else {
            fld.setText(val.toString());
        }
    }

    private void loadLastVerkoop() throws RemoteException {
        if (verkoopArray.size() > 0) {
            Verkoop vp = verkoopArray.get(verkoopArray.size() - 1);
            merkLabel.setText(vp.getMontuurMerk());
            modelLabel.setText(vp.getMontuurModel());
            kleurLabel.setText(vp.getMontuurKleur());
            maatLabel.setText(vp.getMontuurMaat());
            prijsmontuurLabel.setText(vp.getMontuurPrijs().toString());
            btwLabel.setText(vp.getMontuurBtw() == null ? "" : vp.getMontuurBtw().toString());
            diversenLabel.setText(vp.getDiverse());
            soortglasLabel.setText(vp.getSoortGlas());
            montuurtypeLabel.setText(vp.getMontuurType());
            materiaalLabel.setText(vp.getMateriaal());
            kortingLabel.setText(vp.getKorting().toString());
            totaalLabel.setText(vp.getTotaal().toString());
            totaalBtwLabel.setText(vp.getTotalBtw() == null ? "" : vp.getTotalBtw().toString());
            r_leverancierLabel.setText(vp.getLReverancier());
            l_leverancierLabel.setText(vp.getRLeverancier());
            r_typeglasLabel.setText(vp.getRTypeGlas());
            l_typeglasLabel.setText(vp.getLTypeGlas());
            r_coatingLabel.setText(vp.getRCoating());
            l_coatingLabel.setText(vp.getLCoating());
            r_kleurglazenLabel.setText(vp.getRKleurGlazen());
            l_kleurglazenLabel.setText(vp.getLKleurGlazen());
            r_diameterLabel.setText(vp.getRDiameter() == null ? "" : vp.getRDiameter().toString());
            l_diameterLabel.setText(vp.getLDiameter() == null ? "" : vp.getLDiameter().toString());
            r_prijsglasLabel.setText(vp.getRPrijsGlas() == null ? "" : vp.getRPrijsGlas().toString());
            l_prijsglasLabel.setText(vp.getLPrijsGlas() == null ? "" : vp.getLPrijsGlas().toString());
            r_btwLabel.setText(vp.getRBtw() == null ? "" : vp.getRBtw().toString());
            l_btwLabel.setText(vp.getLBtw() == null ? "" : vp.getLBtw().toString());
            breedteLabel.setText(vp.getBreedte() == null ? "" : vp.getBreedte().toString());
            hoogteLabel.setText(vp.getHoogte() == null ? "" : vp.getHoogte().toString());
            neusmaatLabel.setText(vp.getNeusmaat() == null ? "" : vp.getNeusmaat().toString());
            merkLabel.setText(vp.getMontuurMerk());
            modelLabel.setText(vp.getMontuurModel());
            kleurLabel.setText(vp.getMontuurKleur());
            maatLabel.setText(vp.getMontuurMaat());
            prijsmontuurLabel.setText(vp.getMontuurPrijs() == null ? "" : vp.getMontuurPrijs().toString());
            diversenLabel.setText(vp.getDiverse());
            diversePrijsLabel.setText(vp.getDiversePrijs() == null ? "" : vp.getDiversePrijs().toString());
            diverseBtwLabel.setText(vp.getDiverseBtw() == null ? "" : vp.getDiverseBtw().toString());
            soortglasLabel.setText(vp.getSoortGlas());
            montuurtypeLabel.setText(vp.getMontuurType());
            materiaalLabel.setText(vp.getMateriaal());
            kortingLabel.setText(vp.getKorting() == null ? "" : vp.getKorting().toString());
            totaalLabel.setText(vp.getTotaal() == null ? "" : vp.getTotaal().toString());
        }
    }

    private void loadVerkoop() {
        if (getCurrentVerkoop() != null) {
            String num = " " + (verkoopIndex + 1) + "/" + verkoopArray.size();
            verkoopLabel.setText(num);
            verkoop1Label.setText(num);
            merkCombo.getEditor().setText(getCurrentVerkoop().getMontuurMerk());
            modelCombo.getEditor().setText(getCurrentVerkoop().getMontuurModel());
            kleurCombo.getEditor().setText(getCurrentVerkoop().getMontuurKleur());
            fillFieldWithValue(maatInput, getCurrentVerkoop().getMontuurMaat());
            fillFieldWithValue(prijsMontuurInput, getCurrentVerkoop().getMontuurPrijs());
            montuurTypeCombo.setValue(getCurrentVerkoop().getMontuurType());
            materiallCombo.setValue(getCurrentVerkoop().getMateriaal());
            soortGlasCombo.setValue(getCurrentVerkoop().getSoortGlas());

            diversenCombo.getEditor().setText(getCurrentVerkoop().getDiverse());
            fillFieldWithValue(idMontuurInput, getCurrentVerkoop().getIdMontuur());
            fillFieldWithValue(montuurDatumInput, getCurrentVerkoop().getVerkoopdatum());

            lPrijsGlasInput.setText(getCurrentVerkoop().getLPrijsGlas() == null ? "" : getCurrentVerkoop().getLPrijsGlas().toString());
            rPrijsGlasInput.setText(getCurrentVerkoop().getRPrijsGlas() == null ? "" : getCurrentVerkoop().getRPrijsGlas().toString());

            rLeverancierCombo.getEditor().setText(getCurrentVerkoop().getRLeverancier());
            lLeverancierCombo.getEditor().setText(getCurrentVerkoop().getLReverancier());
            rTypeGlasCombo.getEditor().setText(getCurrentVerkoop().getRTypeGlas());
            lTypeGlasCombo.getEditor().setText(getCurrentVerkoop().getLTypeGlas());
            rCoatingCombo.getEditor().setText(getCurrentVerkoop().getRCoating());
            lCoatingCombo.getEditor().setText(getCurrentVerkoop().getLCoating());
            rKleurGlasCombo.getEditor().setText(getCurrentVerkoop().getRKleurGlazen());
            lKleurGlasCombo.getEditor().setText(getCurrentVerkoop().getLKleurGlazen());
            fillFieldWithValue(rDiameterInput, getCurrentVerkoop().getRDiameter());
            fillFieldWithValue(lDiameterInput, getCurrentVerkoop().getLDiameter());
            fillFieldWithValue(breedteInput, getCurrentVerkoop().getBreedte());
            fillFieldWithValue(hoogteInput, getCurrentVerkoop().getHoogte());
            fillFieldWithValue(neusmaatInput, getCurrentVerkoop().getNeusmaat());
            soortGlasCombo.setValue(getCurrentVerkoop().getSoortGlas());
            fillFieldWithValue(kortingInput, getCurrentVerkoop().getKorting());
            fillFieldWithValue(totaalInput, getCurrentVerkoop().getTotaal());
            fillFieldWithValue(btwInput, getCurrentVerkoop().getTotalBtw());
            fillFieldWithValue(diversenPrijsInput, getCurrentVerkoop().getDiversePrijs());
        }
    }

    private void fillLastVerkoop(Verkoop vk) {
        if (vk != null) {
            r_leverancierLabel.setText(vk.getRLeverancier());
            l_leverancierLabel.setText(vk.getLReverancier());
            r_typeglasLabel.setText(vk.getRTypeGlas());
            l_typeglasLabel.setText(vk.getLTypeGlas());
            r_coatingLabel.setText(vk.getRCoating());
            l_coatingLabel.setText(vk.getLCoating());
            r_kleurglazenLabel.setText(vk.getRKleurGlazen());
            l_kleurglazenLabel.setText(vk.getLKleurGlazen());
            r_diameterLabel.setText(vk.getRDiameter().toString());
            l_diameterLabel.setText(vk.getLDiameter().toString());
            r_prijsglasLabel.setText(vk.getRPrijsGlas().toString());
            l_prijsglasLabel.setText(vk.getLPrijsGlas().toString());
            r_btwLabel.setText(vk.getRBtw().toString());
            l_btwLabel.setText(vk.getLBtw().toString());
            merkLabel.setText(vk.getMontuurMerk());
            modelLabel.setText(vk.getMontuurModel());
            kleurLabel.setText(vk.getMontuurKleur());
            maatLabel.setText(vk.getMontuurMaat());
            prijsmontuurLabel.setText(vk.getMontuurPrijs().toString());
            btwLabel.setText(vk.getMontuurBtw().toString());
            soortglasLabel.setText(vk.getSoortGlas());
            montuurtypeLabel.setText(vk.getMontuurType());
            materiaalLabel.setText(vk.getMateriaal());
            kortingLabel.setText(vk.getKorting().toString());
            totaalBtwLabel.setText(vk.getTotalBtw().toString());
            totaalLabel.setText(vk.getTotaal().toString());
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
        klantPane.setVisible(true);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(false);
        glazenPane.setVisible(false);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(false);
        setOnTop(klantPane);
    }

    @FXML
    private void oogmetingPress() {
        klantBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        klantPane.setVisible(false);
        oogmetingPane.setVisible(true);
        montuurPane.setVisible(false);
        glazenPane.setVisible(false);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(false);
        setOnTop(oogmetingPane);
    }

    @FXML
    private void montuurPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        klantPane.setVisible(false);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(true);
        glazenPane.setVisible(false);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(false);
        setOnTop(montuurPane);
    }

    @FXML
    private void glazenPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        mailingBtn.setSelected(false);
        klantPane.setVisible(false);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(false);
        glazenPane.setVisible(true);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(false);
        setOnTop(glazenPane);
    }

    @FXML
    private void mailingPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        artikelbeheerBtn.setSelected(false);
        klantPane.setVisible(false);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(false);
        glazenPane.setVisible(false);
        mailingPane.setVisible(true);
        artikelbeheerPane.setVisible(false);
        setOnTop(mailingPane);
    }

    @FXML
    private void artikelbeheerPress() {
        klantBtn.setSelected(false);
        oogmetingBtn.setSelected(false);
        montuurBtn.setSelected(false);
        glazenBtn.setSelected(false);
        mailingBtn.setSelected(false);
        klantPane.setVisible(false);
        oogmetingPane.setVisible(false);
        montuurPane.setVisible(false);
        glazenPane.setVisible(false);
        mailingPane.setVisible(false);
        artikelbeheerPane.setVisible(true);
        setOnTop(artikelbeheerPane);
    }
    
    /**
     * @return the currentBrilvoorschrift
     */
    private Brilvoorschrift getCurrentBrilvoorschrift() {
        return currentBrilvoorschrift;
    }

    /**
     * @param currentBrilvoorschrift the currentBrilvoorschrift to set
     */
    private void setCurrentBrilvoorschrift(Brilvoorschrift currentBrilvoorschrift) {
        this.currentBrilvoorschrift = currentBrilvoorschrift;
        brilvoorschriftIndex = getBrilvoorschriftArray().indexOf(this.currentBrilvoorschrift);
    }

    /**
     * @return the currentVerkoop
     */
    private Verkoop getCurrentVerkoop() {
        return currentVerkoop;
    }

    /**
     * @param currentVerkoop the currentVerkoop to set
     */
    private void setCurrentVerkoop(Verkoop currentVerkoop) {
        this.currentVerkoop = currentVerkoop;
        verkoopIndex = verkoopArray.indexOf(this.currentVerkoop);
    }

    /**
     * @return the brilvoorschriftArray
     */
    public static ArrayList<Brilvoorschrift> getBrilvoorschriftArray() {
        return brilvoorschriftArray;
    }

    private String getCurListEmails(Vector[] body, int col) {
        StringBuilder sb = new StringBuilder();
        Set set = new HashSet();
        //Vector[] body = klantGrid.getTableBody();
        Vector lines = body[1];
        for (int i = 0; i < lines.size(); i++) {
            Vector line = (Vector) lines.get(i);
            set.add(line.get(col));
        }
        for (Object o : set) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(o.toString());
        }
        return sb.toString();
    }

    private String getAgeRangeEmails() {
        StringBuilder condition = new StringBuilder();
        if (vanDeInput.getText() != null && vanDeInput.getText().length() > 0) {
            condition.append("months_between(now(),geboortedatum)/12 >= " + vanDeInput.getText());
        }
        if (totDeInput.getText() != null && totDeInput.getText().length() > 0) {
            if (condition.length() > 0) {
                condition.append(" and ");
            }
            condition.append("months_between(now(),geboortedatum)/12 <= " + totDeInput.getText());
        }
        if (condition.length() > 0) {
            condition.insert(0, "select distinct email from klant where ");
        }
        try {
            return getCurListEmails(OpticStore.getExchanger().getTableBody(condition.toString()), 0);
        } catch (RemoteException ex) {
            OpticStore.log(ex.getLocalizedMessage());
        }
        return "";
    }
}
