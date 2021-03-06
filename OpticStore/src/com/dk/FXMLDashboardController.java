/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.Brilvoorschrift;
import com.dk.orm.Klant;
import com.dk.orm.Verkoop;
import com.dk.orm.dbobject.ComboItem;
import com.dk.orm.dbobject.DbObject;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.util.FXutils;
import com.dk.util.SelectModifier;
import com.dk.util.TableGridPanel;
import com.sun.javafx.collections.ObservableListWrapper;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 *
 * @author nick
 */
public class FXMLDashboardController implements Initializable {

    private static final String FILL_THIS_FIELD = "dit veld invullen";
    private static final String graylabelStyle = "-fx-background-color: gray;";
    private static final String ELKE = "--elke--";

    @FXML
    private HBox logoutBox;

    @FXML
    private VBox adminBox;

    @FXML
    private VBox searchClientBox;

    @FXML
    private AnchorPane innerAnchorPane;
    @FXML
    private AnchorPane innerSrcAnchorPane;
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

//    @FXML
//    private VBox detailsVbox;
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
    private Label datumRefractieLbl;
    @FXML
    private Label oogmetingDoorLbl;

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
    private ComboBox oogmetinggDoorCombo;
    @FXML
    private TextField datumRefractieInput;
    @FXML
    private TextField srcDate1Input;
    @FXML
    private TextField srcDate2Input;

    @FXML
    private TabPane mainTabPane;
    @FXML
    private TabPane klantTabPane;

    @FXML
    private Tab zoekenTab;
    @FXML
    private Tab klantTab;

    @FXML
    private Tab oogmetingTab;
    @FXML
    private Tab montuurTab;
    @FXML
    private Tab glazenTab;
    @FXML
    private Tab mailingTab;
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
    private Button anamneseButton;
    @FXML
    private TextArea anamneseField;
    @FXML
    private HBox navigationBox;
    @FXML
    private Label vidLabel;

    @FXML
    private HBox montuurNavigationBox;
    @FXML
    private HBox glazenNavigationBox;

    @FXML
    private Label idMontuur;

    @FXML
    private Label verkoopLabel;
    @FXML
    private Label verkoop1Label;
    @FXML
    private ComboBox merkCombo;
    @FXML
    private ComboBox srcMerkCombo;
    @FXML
    private ComboBox modelCombo;
    @FXML
    private ComboBox srcModelCombo;
    @FXML
    private ComboBox kleurCombo;
    @FXML
    private ComboBox srcKleurCombo;
    @FXML
    private TextField maatInput;
    @FXML
    private TextField srcMaatInput;
    @FXML
    private TextField prijsMontuurInput;
    @FXML
    private TextField srcPrijs1MontuurInput;
    @FXML
    private TextField srcPrijs2MontuurInput;
    @FXML
    private ComboBox montuurTypeCombo;
    @FXML
    private ComboBox srcMontuurTypeCombo;
    @FXML
    private ComboBox materiallCombo;
    @FXML
    private ComboBox srcMateriallCombo;
    @FXML
    private ComboBox diversenCombo;
    @FXML
    private ComboBox srcDiversenCombo;
    @FXML
    private TextField idMontuurInput;
    @FXML
    private TextField srcIdMontuurInput;
    @FXML
    private TextField montuurDatumInput;

    @FXML
    private ComboBox rLeverancierCombo;
    @FXML
    private ComboBox lLeverancierCombo;
    @FXML
    private ComboBox srcLeverancierCombo;
    @FXML
    private ComboBox rTypeGlasCombo;
    @FXML
    private ComboBox lTypeGlasCombo;
    @FXML
    private ComboBox srcTypeGlasCombo;
    @FXML
    private ComboBox rCoatingCombo;
    @FXML
    private ComboBox lCoatingCombo;
    @FXML
    private ComboBox srcCoatingCombo;
    @FXML
    private ComboBox rKleurGlasCombo;
    @FXML
    private ComboBox lKleurGlasCombo;
    @FXML
    private ComboBox srcKleurGlasCombo;
    @FXML
    private ComboBox soortGlasCombo;

    @FXML
    private RadioButton rRndsJa;
    @FXML
    private RadioButton rRndsNee;
    @FXML
    private RadioButton lRndsJa;
    @FXML
    private RadioButton lRndsNee;
    @FXML
    private RadioButton srcRndsJa;
    @FXML
    private RadioButton srcRndsNee;
    @FXML
    private RadioButton srcRndsElke;

    @FXML
    private TextField rDiameterInput;
    @FXML
    private TextField lDiameterInput;
    @FXML
    private TextField srcDiameter1Input;
    @FXML
    private TextField srcDiameter2Input;
    @FXML
    private TextField rPrijsGlasInput;
    @FXML
    private TextField lPrijsGlasInput;
    @FXML
    private TextField srcPrijs1GlasInput;
    @FXML
    private TextField srcPrijs2GlasInput;
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
    private HBox srcBtnBox;
    @FXML
    private Label rowsFoundLabel;

    private TextField[] searchFields = null;
    private TableGridPanel klantGrid = null;
    private int selectedKlantID = 0;
    private int selectedVorkoopID = 0;
    private Node editClientNode;
    private Node delClientNode;
    //private static Tab fisrtPane;

    private Brilvoorschrift currentBrilvoorschrift = null;
    private static ArrayList<Brilvoorschrift> brilvoorschriftArray = new ArrayList<Brilvoorschrift>();
    private int brilvoorschriftIndex;

    private Verkoop currentVerkoop = null;
    private static ArrayList<Verkoop> verkoopArray = new ArrayList<Verkoop>();
    private int verkoopIndex;

//    static void expandeFirst() {
//        if (fisrtPane != null) {
//            fisrtPane.setExpanded(true);
//        }
//    }
    public static Node adminNode;
    private TableGridPanel srcVerkoopGrid;

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
        //clearTab2();
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
            lbl.setText("");
        }
        voorlettersInput.setText("");
        emailInput.setText("");
        achternaamInput.setText("");
        emailsInput.setText("");
        emailssInput.setText("");

        oogmetingTab.setDisable(true);
        montuurTab.setDisable(true);
        glazenTab.setDisable(true);
        mailingTab.setDisable(true);
        anamneseButton.setDisable(true);

        klantIDfield.setDisable(false);
        if (withDeselect) {
            klantGrid.unselect();
        }
        clearTab2();
        clearTab3();
        clearTab4();
    }

    private void clearTab2() {
        vidLabel.setText("");
        FXutils.clearTextFields(new TextInputControl[]{
            odSphInput, odCylInput, odAsInput, odAddInput, odNabijInput,
            odPrInput, odBasisInput, odPr1Input, odBasis1Input,
            odVisInput, odPdDnInput, odLhInput, odHaInput, odIodInput,
            osSphInput, osCylInput, osAsInput, osAddInput, osNabijInput,
            osPrInput, osBasisInput, osPr1Input, osBasis1Input,
            osVisInput, osPdDnInput, osLhInput, osHaInput, osIodInput,
            oogmetinggDoorCombo.getEditor(),
            anamneseField
        });
//        oogmetinggDoorCombo.getEditor().setText("");
        datumRefractieInput.setText(OpticStore.dateFormat.format(Calendar.getInstance().getTime()));
    }

    private void clearTab4() {
        verkoop1Label.setText("");
        FXutils.clearTextFields(new TextInputControl[]{
            rLeverancierCombo.getEditor(), lLeverancierCombo.getEditor(),
            rTypeGlasCombo.getEditor(), lTypeGlasCombo.getEditor(),
            rCoatingCombo.getEditor(), lCoatingCombo.getEditor(),
            rKleurGlasCombo.getEditor(), lKleurGlasCombo.getEditor(),
            breedteInput, hoogteInput, neusmaatInput
        });
        soortGlasCombo.setValue("");
        rDiameterInput.setText("0");
        lDiameterInput.setText("0");
        rPrijsGlasInput.setText("0.0");
        lPrijsGlasInput.setText("0.0");
        kortingInput.setText("0.0");
        totaalInput.setText("0.0");
        btwInput.setText("0.0");
        rRndsNee.setSelected(true);
        lRndsNee.setSelected(true);
    }

    private void clearTab3() {
        verkoopLabel.setText("");
        idMontuur.setText("new");
        merkCombo.getEditor().setText("");
        modelCombo.getEditor().setText("");
        kleurCombo.getEditor().setText("");
        maatInput.setText("");
        prijsMontuurInput.setText("");
        montuurTypeCombo.setValue("");
        materiallCombo.setValue("");
        diversenCombo.setValue("");
        idMontuurInput.setText("");
        diversenPrijsInput.setText("0.0");
        montuurDatumInput.setText(OpticStore.dateFormat.format(Calendar.getInstance().getTime()));
        fillCombos();
    }

    private void goLastTab2() {
        if (getBrilvoorschriftArray().size() > 0) {
            setCurrentBrilvoorschrift(getBrilvoorschriftArray().get(getBrilvoorschriftArray().size() - 1));
            loadBrilvoorschrift();
        } else {
            clearTab2();
        }
    }

    private void goLastTab3() {
        if (verkoopArray.size() > 0) {
            setCurrentVerkoop(verkoopArray.get(verkoopArray.size() - 1));
            loadVerkoop();
        } else {
            clearTab3();
            clearTab4();
        }
    }

    private void goFirstTab2() {
        if (getBrilvoorschriftArray().size() > 0) {
            setCurrentBrilvoorschrift(getBrilvoorschriftArray().get(0));
            loadBrilvoorschrift();
        } else {
            clearTab2();
        }
    }

    private void goFirstTab3() {
        if (verkoopArray.size() > 0) {
            setCurrentVerkoop(verkoopArray.get(0));
            loadVerkoop();
        } else {
            clearTab3();
            clearTab4();
        }
    }

    private void goPrevTab2() {
        if (brilvoorschriftIndex > 0) {
            setCurrentBrilvoorschrift(getBrilvoorschriftArray().get(brilvoorschriftIndex - 1));
            loadBrilvoorschrift();
        }
    }

    private void goPrevTab3() {
        if (verkoopIndex > 0) {
            setCurrentVerkoop(verkoopArray.get(verkoopIndex - 1));
            loadVerkoop();
        }
    }

    private void goNextTab2() {
        if (brilvoorschriftIndex < getBrilvoorschriftArray().size() - 1) {
            setCurrentBrilvoorschrift(getBrilvoorschriftArray().get(brilvoorschriftIndex + 1));
            loadBrilvoorschrift();
        }
    }

    private void goNextTab3() {
        if (verkoopIndex < verkoopArray.size() - 1) {
            setCurrentVerkoop(verkoopArray.get(verkoopIndex + 1));
            loadVerkoop();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        oogmetingTab.setDisable(true);
        montuurTab.setDisable(true);
        glazenTab.setDisable(true);
        mailingTab.setDisable(true);

        ToggleGroup group = new ToggleGroup();
        klantRB.setSelected(true);
        klantRB.setToggleGroup(group);
        listRB.setToggleGroup(group);
        ageRB.setToggleGroup(group);

        //fisrtPane = zoekenPane;
        FXutils.setAutyoCompleteCombos(new ComboBox[]{
            merkCombo, modelCombo, kleurCombo, diversenCombo,
            srcMerkCombo, srcModelCombo, srcKleurCombo, srcDiversenCombo
        });
        fillCombos();

        FXutils.RestrictNumbersFields(new TextField[]{
            odSphInput, odCylInput, odAsInput, odAddInput, odNabijInput,
            odPrInput, odBasisInput, odPr1Input, odBasis1Input,
            odVisInput, odLhInput, odHaInput, odIodInput,
            osSphInput, osCylInput, osAsInput, osAddInput, osNabijInput,
            osPrInput, osBasisInput, osPr1Input, osBasis1Input,
            osVisInput, osLhInput, osHaInput, osIodInput,
            //oogmetinggDoorInput,
            rDiameterInput, lDiameterInput,
            rPrijsGlasInput, lPrijsGlasInput,
            srcPrijs1MontuurInput, srcPrijs2MontuurInput,
            srcDiameter1Input, srcDiameter2Input,
            srcPrijs1GlasInput, srcPrijs2GlasInput,
            breedteInput, hoogteInput, neusmaatInput, kortingInput, diversenPrijsInput,
            vanDeInput, totDeInput
        });

        adminNode = FXutils.createButton(getClass(), "admin.png", new Runnable() {
            @Override
            public void run() {
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
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex.getLocalizedMessage());
                }
            }
        });
        adminBox.getChildren().add(adminNode);

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
                String newSelect = addWhereKlantCondition();
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

        searchClientNode = FXutils.createButton(getClass(), "search.png", new Runnable() {
            @Override
            public void run() {
                String newSelect = addWhereVerkoopCondition();
                try {
                    srcVerkoopGrid.reload(newSelect);
                    rowsFoundLabel.setText("" + srcVerkoopGrid.getTableBody()[1].size());
                } catch (RemoteException ex) {
                    OpticStore.logAndShowErrorMessage(ex);
                }
            }
        });
        srcBtnBox.getChildren().add(searchClientNode);
        clearClientNode = FXutils.createButton(getClass(), "clear.png", new Runnable() {
            @Override
            public void run() {
                clearSrcForm();
            }

        });
        srcBtnBox.getChildren().add(clearClientNode);

        try {
            //innerSrcAnchorPane
            srcVerkoopGrid = new TableGridPanel(OpticStore.getExchanger(), OpticStore.VERKOOPLIST);
            rowsFoundLabel.setText("" + srcVerkoopGrid.getTableBody()[1].size());
            innerSrcAnchorPane.setTopAnchor(srcVerkoopGrid, 10.0);
            innerSrcAnchorPane.setLeftAnchor(srcVerkoopGrid, 400.0);
            innerSrcAnchorPane.setRightAnchor(srcVerkoopGrid, 0.0);
            innerSrcAnchorPane.setBottomAnchor(srcVerkoopGrid, 10.0);
            innerSrcAnchorPane.getChildren().add(srcVerkoopGrid);
            srcVerkoopGrid.getTableView().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

                @Override
                public void changed(ObservableValue ov, Object oldSelection, Object newSelection) {
                    if (newSelection == null) {
                        selectedVorkoopID = 0;
                    } else {
                        ObservableListWrapper itm = (ObservableListWrapper) newSelection;
                        selectedVorkoopID = Integer.parseInt(itm.get(0).toString().trim());
                    }
                }
            });
            srcVerkoopGrid.getTableView().setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                        try {
                            Verkoop vk = (Verkoop) OpticStore.getExchanger().loadDbObjectOnID(Verkoop.class, selectedVorkoopID);
                            mainTabPane.getSelectionModel().selectFirst();
                            klantTabPane.getSelectionModel().selectFirst();
                            loadKlantFrom(vk.getKlantId(),vk.getPK_ID().intValue());
                        } catch (RemoteException ex) {
                            OpticStore.logAndShowErrorMessage(ex);
                        }
                    }
                }
            });
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex);
        }

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

        Node firstButton = FXutils.createButton(getClass(), "first.png", new Runnable() {
            @Override
            public void run() {
                goFirstTab2();
            }
        });
        Node prevButton = FXutils.createButton(getClass(), "prev.png", new Runnable() {
            @Override
            public void run() {
                goPrevTab2();
            }
        });
        Node nextButton = FXutils.createButton(getClass(), "next.png", new Runnable() {
            @Override
            public void run() {
                goNextTab2();
            }
        }
        );
        Node lastButton = FXutils.createButton(getClass(), "last.png", new Runnable() {
            @Override
            public void run() {
                goLastTab2();
            }
        });
        Node addButton = FXutils.createButton(getClass(), "add.png", new Runnable() {
            @Override
            public void run() {
                setCurrentBrilvoorschrift(null);
                clearTab2();
            }
        });
        Node okButton = FXutils.createButton(getClass(), "ok.png", new Runnable() {
            @Override
            public void run() {
                try {
                    boolean added = false;
                    if (getCurrentBrilvoorschrift() == null) {
                        setCurrentBrilvoorschrift(new Brilvoorschrift(null));
                        getCurrentBrilvoorschrift().setBrilvoorschriftId(0);
                        getCurrentBrilvoorschrift().setNew(true);
                        added = true;
                    }
                    fillCurrentBrilvoorschriftAndSave();
                    if (added) {
                        getBrilvoorschriftArray().add(getCurrentBrilvoorschrift());
                        goLastTab2();
                    }
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex);
                }
            }
        });
        Node delButton = FXutils.createButton(getClass(), "delete.png", new Runnable() {
            @Override
            public void run() {
                if (getCurrentBrilvoorschrift() != null && OpticStore.yesOrNoDialog("Bent u zeker dat u wilt verwijderen van dit record?\n(brilvoorschrift_id="
                        + getCurrentBrilvoorschrift().getPK_ID() + ")")) {
                    try {
                        OpticStore.getExchanger().deleteObject(getCurrentBrilvoorschrift());
                        getBrilvoorschriftArray().remove(getCurrentBrilvoorschrift());
                        goLastTab2();
                    } catch (RemoteException ex) {
                        OpticStore.logAndShowErrorMessage(ex);
                    }
                }
            }
        });

        navigationBox.getChildren().add(firstButton);
        navigationBox.getChildren().add(prevButton);
        navigationBox.getChildren().add(nextButton);
        navigationBox.getChildren().add(lastButton);
        navigationBox.getChildren().add(addButton);
        navigationBox.getChildren().add(okButton);
        navigationBox.getChildren().add(delButton);

        firstButton = FXutils.createButton(getClass(), "first.png", firstVerkoopAction());
        prevButton = FXutils.createButton(getClass(), "prev.png", prevVerkoopAction());
        nextButton = FXutils.createButton(getClass(), "next.png", nextVerkoopAction());
        lastButton = FXutils.createButton(getClass(), "last.png", lastVerkoopAction());
        addButton = FXutils.createButton(getClass(), "add.png", addVerkoopAction());
        okButton = FXutils.createButton(getClass(), "ok.png", okVerkoopAction());
        delButton = FXutils.createButton(getClass(), "delete.png", delVerkoopAction());
        montuurNavigationBox.getChildren().add(firstButton);
        montuurNavigationBox.getChildren().add(prevButton);
        montuurNavigationBox.getChildren().add(nextButton);
        montuurNavigationBox.getChildren().add(lastButton);
        montuurNavigationBox.getChildren().add(addButton);
        montuurNavigationBox.getChildren().add(okButton);
        montuurNavigationBox.getChildren().add(delButton);

        firstButton = FXutils.createButton(getClass(), "first.png", firstVerkoopAction());
        prevButton = FXutils.createButton(getClass(), "prev.png", prevVerkoopAction());
        nextButton = FXutils.createButton(getClass(), "next.png", nextVerkoopAction());
        lastButton = FXutils.createButton(getClass(), "last.png", lastVerkoopAction());
        addButton = FXutils.createButton(getClass(), "add.png", addVerkoopAction());
        okButton = FXutils.createButton(getClass(), "ok.png", okVerkoopAction());
        delButton = FXutils.createButton(getClass(), "delete.png", delVerkoopAction());
        glazenNavigationBox.getChildren().add(firstButton);
        glazenNavigationBox.getChildren().add(prevButton);
        glazenNavigationBox.getChildren().add(nextButton);
        glazenNavigationBox.getChildren().add(lastButton);
        glazenNavigationBox.getChildren().add(addButton);
        glazenNavigationBox.getChildren().add(okButton);
        glazenNavigationBox.getChildren().add(delButton);

        montuurTypeCombo.getItems().add("correctie");
        montuurTypeCombo.getItems().add("zon");

        srcMontuurTypeCombo.getItems().add(ELKE);
        srcMontuurTypeCombo.getItems().add("correctie");
        srcMontuurTypeCombo.getItems().add("zon");

        materiallCombo.getItems().add("metaal");
        materiallCombo.getItems().add("kunststof");
        materiallCombo.getItems().add("nylor");
        materiallCombo.getItems().add("randloos");

        srcMateriallCombo.getItems().add(ELKE);
        srcMateriallCombo.getItems().add("metaal");
        srcMateriallCombo.getItems().add("kunststof");
        srcMateriallCombo.getItems().add("nylor");
        srcMateriallCombo.getItems().add("randloos");

        soortGlasCombo.getItems().add("enkelvoudig");
        soortGlasCombo.getItems().add("multifocaal");
        soortGlasCombo.getItems().add("leesbril");
        soortGlasCombo.getItems().add("computerbril");
    }

    private Runnable firstVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                goFirstTab3();
            }
        };
    }

    private Runnable prevVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                goPrevTab3();
            }
        };
    }

    private Runnable nextVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                goNextTab3();
            }
        };
    }

    private Runnable lastVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                goLastTab3();
            }
        };
    }

    private Runnable addVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                setCurrentVerkoop(null);
                clearTab3();
                clearTab4();
            }
        };
    }

    private Runnable okVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    boolean added = false;
                    if (getCurrentVerkoop() == null) {
                        setCurrentVerkoop(new Verkoop((Connection) null));
                        getCurrentVerkoop().setVerkoopId(0);
                        getCurrentVerkoop().setNew(true);
                        added = true;
                    }
                    fillCurrentVerkoopAndSave();
                    if (added) {
                        verkoopArray.add(getCurrentVerkoop());
                        goLastTab3();
                    } else {
                        loadVerkoop();
                    }
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex);
                }
            }
        };
    }

    private Runnable delVerkoopAction() {
        return new Runnable() {
            @Override
            public void run() {
                if (getCurrentVerkoop() != null && OpticStore.yesOrNoDialog("Bent u zeker dat u wilt verwijderen van dit record?\n(vorkoop_id="
                        + getCurrentVerkoop().getPK_ID() + ")")) {
                    try {
                        OpticStore.getExchanger().deleteObject(getCurrentBrilvoorschrift());
                        verkoopArray.remove(getCurrentVerkoop());
                        goLastTab3();
                    } catch (RemoteException ex) {
                        OpticStore.logAndShowErrorMessage(ex);
                    }
                }
            }
        };
    }

    private static void fillCombos(ComboBox[] cbs, String select, boolean withID) {
        Vector[] v;
        try {
            for (ComboBox cb : cbs) {
                cb.getItems().clear();
            }
            v = OpticStore.getExchanger().getTableBody(select);
            Vector lines = v[1];
            for (int i = 0; i < lines.size(); i++) {
                Vector line = (Vector) lines.get(i);
                for (ComboBox cb : cbs) {
                    if (withID) {
                        cb.getItems().add(new ComboItem(Integer.parseInt((String) line.get(0)), (String) line.get(1)));
                    } else {
                        cb.getItems().add((String) line.get(0));
                    }
                }
            }
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex);
        }
    }

    private static void fillCombo(ComboBox cb, String select, boolean withID) {
        fillCombos(new ComboBox[]{cb}, select, withID);
    }

    private void fillCombos() {
        fillCombo(oogmetinggDoorCombo, "select distinct oogmeting_door from brilvoorschrift", false);
        fillCombos(new ComboBox[]{merkCombo, srcMerkCombo}, "select distinct montuur_merk from verkoop order by montuur_merk", false);
        fillCombos(new ComboBox[]{modelCombo, srcModelCombo}, "select distinct montuur_model from verkoop order by montuur_model", false);
        fillCombos(new ComboBox[]{kleurCombo, srcKleurCombo}, "select distinct montuur_kleur from verkoop order by montuur_kleur", false);
        //fillCombos(new ComboBox[]{srcModelCombo, srcKleurCombo}, "select distinct montuur_model from verkoop order by montuur_model", false);
        fillCombos(new ComboBox[]{diversenCombo, srcDiversenCombo}, "select distinct diverse from verkoop order by diverse", false);
        fillCombos(new ComboBox[]{lLeverancierCombo, rLeverancierCombo, srcLeverancierCombo},
                "select distinct l_reverancier from verkoop "
                + "union select distinct r_leverancier from verkoop", false);
        fillCombos(new ComboBox[]{lTypeGlasCombo, rTypeGlasCombo, srcTypeGlasCombo}, "select distinct l_type_glas from verkoop "
                + "union select distinct r_type_glas from verkoop", false);
        fillCombos(new ComboBox[]{lCoatingCombo, rCoatingCombo, srcCoatingCombo}, "select distinct l_coating from verkoop "
                + "union select distinct r_coating from verkoop", false);
        fillCombos(new ComboBox[]{lKleurGlasCombo, rKleurGlasCombo, srcKleurGlasCombo}, "select distinct l_kleur_glazen from verkoop "
                + "union select distinct r_kleur_glazen from verkoop", false);
    }

    private static Integer ifNullInteger(TextField tf) {
        if (tf != null && tf.getText() != null) {
            try {
                return Integer.parseInt(tf.getText());
            } catch (NumberFormatException ne) {
                tf.setText("0");
            }
        }
        return 0;
    }

    private static Double ifNullDouble(TextField tf) {
        if (tf != null && tf.getText() != null) {
            try {
                if (tf.getText().isEmpty()) {
                    return 0.0;
                }
                return Double.parseDouble(tf.getText().replace(",", "."));
            } catch (Exception ne) {
                OpticStore.log(ne);
                tf.setText("0.0");
            }
        }
        return 0.0;
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

    private void loadVerkoopList(Klant klant, int verkoopID) throws RemoteException {
        verkoopArray.clear();
        setCurrentVerkoop(null);
        if (klant != null) {
            DbObject[] recs = OpticStore.getExchanger().getDbObjects(Verkoop.class,
                    "klant_id=" + klant.getKlantId(), "verkoop_id");
            int n = 0;
            int pos = recs.length - 1;
            for (DbObject rec : recs) {
                verkoopArray.add((Verkoop) rec);
                if (verkoopID == rec.getPK_ID().intValue()) {
                    pos = n;
                }
                n++;
            }
            if (verkoopArray.size() > 0) {
                setCurrentVerkoop(verkoopArray.get(pos));
            }
        }
        loadLastVerkoop();
        loadVerkoop();
    }

    private static void fillFieldWithValue(TextField fld, Object val) {
        fillFieldWithValue(fld, val, true);
    }

    private static void fillFieldWithValue(TextField fld, Object val, boolean noPlus) {
        if (val == null) {
            fld.setText("");
        } else if (val instanceof java.util.Date) {
            fld.setText(OpticStore.dateFormat.format(val));
        } else if (val instanceof Integer) {
            fld.setText(val.toString());
        } else if (val instanceof Double) {
            if (noPlus) {
                fld.setText(OpticStore.decFormat.format(((Double) val).doubleValue()));
            } else {
                fld.setText(OpticStore.decSignedFormat.format(((Double) val).doubleValue()));
            }
        } else {
            fld.setText(val.toString());
        }
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
            fillFieldWithValue(odCylInput, getCurrentBrilvoorschrift().getOdCyl(), false);
            fillFieldWithValue(osCylInput, getCurrentBrilvoorschrift().getOsCyl(), false);
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
            fillFieldWithValue(odSphInput, getCurrentBrilvoorschrift().getOdSph(), false);
            fillFieldWithValue(osSphInput, getCurrentBrilvoorschrift().getOsSph(), false);
            fillFieldWithValue(odVisInput, getCurrentBrilvoorschrift().getOdVis());
            fillFieldWithValue(osVisInput, getCurrentBrilvoorschrift().getOsVis());
            //fillFieldWithValue(oogmetinggDoorInput, getCurrentBrilvoorschrift().getOogmetingDoor());
            oogmetinggDoorCombo.getEditor().setText(getCurrentBrilvoorschrift().getOogmetingDoor());
            anamneseField.setText(getCurrentBrilvoorschrift().getAnamnese());
        }
    }

    private void loadVerkoop() {
        if (getCurrentVerkoop() != null) {
            String num = " " + (verkoopIndex + 1) + "/" + verkoopArray.size();
            verkoopLabel.setText(num);
            verkoop1Label.setText(num);
            idMontuur.setText(getCurrentVerkoop().getPK_ID().toString());
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
            rRndsJa.setSelected(getCurrentVerkoop().getRRandscherp() != null && getCurrentVerkoop().getRRandscherp() == 1);
            lRndsJa.setSelected(getCurrentVerkoop().getLRandscherp() != null && getCurrentVerkoop().getLRandscherp() == 1);
            rRndsNee.setSelected(getCurrentVerkoop().getRRandscherp() == null || getCurrentVerkoop().getRRandscherp() == 0);
            lRndsNee.setSelected(getCurrentVerkoop().getLRandscherp() == null || getCurrentVerkoop().getLRandscherp() == 0);
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

    private void fillCurrentVerkoopAndSave() throws SQLException, ForeignKeyViolationException, ParseException, RemoteException {
        if (getCurrentVerkoop().isNew()) {
            getCurrentVerkoop().setKlantId(selectedKlantID);
        }
        getCurrentVerkoop().setDiverse(diversenCombo.getEditor().getText());
        getCurrentVerkoop().setDiversePrijs(ifNullDouble(diversenPrijsInput)); //TODO - 
        //getCurrentVerkoop().setDiverseBtw(0.0); //TODO - calc
        getCurrentVerkoop().setIdMontuur(idMontuurInput.getText());
        getCurrentVerkoop().setKorting(ifNullDouble(kortingInput)); //TODO
        //getCurrentVerkoop().setLBtw(0.0); //TODO - glazen calc
        getCurrentVerkoop().setLCoating(lCoatingCombo.getEditor().getText());
        getCurrentVerkoop().setLDiameter(ifNullInteger(lDiameterInput));
        getCurrentVerkoop().setLKleurGlazen(lKleurGlasCombo.getEditor().getText());
        getCurrentVerkoop().setLPrijsGlas(ifNullDouble(lPrijsGlasInput));
        getCurrentVerkoop().setLReverancier(lLeverancierCombo.getEditor().getText());
        getCurrentVerkoop().setLTypeGlas(lTypeGlasCombo.getEditor().getText());
        getCurrentVerkoop().setMateriaal(materiallCombo.getValue().toString());
//        getCurrentVerkoop().setMontuurBtw(0.0); //TODO - calc
//        getCurrentVerkoop().setKorting(0.0); //TODO - 
        getCurrentVerkoop().setMontuurKleur(kleurCombo.getEditor().getText());
        getCurrentVerkoop().setMontuurMaat(maatInput.getText());
        getCurrentVerkoop().setMontuurMerk(merkCombo.getEditor().getText());
        getCurrentVerkoop().setMontuurModel(modelCombo.getEditor().getText());
        getCurrentVerkoop().setMontuurPrijs(ifNullDouble(prijsMontuurInput));
        getCurrentVerkoop().setMontuurType(montuurTypeCombo.getValue().toString());
        //getCurrentVerkoop().setRBtw(0.0); //TODO - glazen calc
        getCurrentVerkoop().setRCoating(rCoatingCombo.getEditor().getText());
        getCurrentVerkoop().setRDiameter(ifNullInteger(rDiameterInput));
        getCurrentVerkoop().setRRandscherp(rRndsJa.isSelected() ? 1 : 0);
        getCurrentVerkoop().setLRandscherp(lRndsJa.isSelected() ? 1 : 0);
        getCurrentVerkoop().setRKleurGlazen(rKleurGlasCombo.getEditor().getText());
        getCurrentVerkoop().setRPrijsGlas(ifNullDouble(rPrijsGlasInput));
        getCurrentVerkoop().setRLeverancier(rLeverancierCombo.getEditor().getText());
        getCurrentVerkoop().setRTypeGlas(rTypeGlasCombo.getEditor().getText());
        getCurrentVerkoop().setBreedte(ifNullInteger(breedteInput));
        getCurrentVerkoop().setHoogte(ifNullInteger(hoogteInput));
        getCurrentVerkoop().setNeusmaat(ifNullInteger(neusmaatInput));
        getCurrentVerkoop().setSoortGlas(soortGlasCombo.getValue().toString());
//        getCurrentVerkoop().setTotaal(999.0); //TODO - calc
//        getCurrentVerkoop().setTotalBtw(0.0); //TODO - calc
        if (montuurDatumInput.getText() != null && !montuurDatumInput.getText().isEmpty()) {
            java.util.Date dt = OpticStore.dateFormat.parse(montuurDatumInput.getText());
            getCurrentVerkoop().setVerkoopdatum(new Date(dt.getTime()));
        }
        getCurrentVerkoop().setKorting(ifNullDouble(kortingInput));
        setCurrentVerkoop((Verkoop) OpticStore.getExchanger().saveDbObject(getCurrentVerkoop()));
        loadVerkoop();
        fillLastVerkoop(verkoopArray.get(verkoopArray.size() - 1));
    }

    private void fillCurrentBrilvoorschriftAndSave() throws SQLException, ForeignKeyViolationException, ParseException, RemoteException {
        if (getCurrentBrilvoorschrift().isNew()) {
            getCurrentBrilvoorschrift().setKlantId(selectedKlantID);
        }
        getCurrentBrilvoorschrift().setAnamnese(anamneseField.getText());
        if (!datumRefractieInput.getText().isEmpty()) {
            java.util.Date dt = OpticStore.dateFormat.parse(datumRefractieInput.getText());
            getCurrentBrilvoorschrift().setDatumRefractie(new Date(dt.getTime()));
        } else {
            getCurrentBrilvoorschrift().setDatumRefractie(null);
        }
        getCurrentBrilvoorschrift().setOdAdd(ifNullDouble(odAddInput));
        getCurrentBrilvoorschrift().setOsAdd(ifNullDouble(odAddInput));
        getCurrentBrilvoorschrift().setOdAs(ifNullInteger(odAsInput));
        getCurrentBrilvoorschrift().setOsAs(ifNullInteger(osAsInput));
        getCurrentBrilvoorschrift().setOdBasis(ifNullInteger(odBasisInput));
        getCurrentBrilvoorschrift().setOsBasis(ifNullInteger(osBasisInput));
        getCurrentBrilvoorschrift().setOdBasis1(ifNullInteger(odBasis1Input));
        getCurrentBrilvoorschrift().setOsBasis1(ifNullInteger(osBasis1Input));
        getCurrentBrilvoorschrift().setOdCyl(ifNullDouble(odCylInput));
        getCurrentBrilvoorschrift().setOsCyl(ifNullDouble(osCylInput));
        getCurrentBrilvoorschrift().setOdHa(ifNullInteger(odHaInput));
        getCurrentBrilvoorschrift().setOsHa(ifNullInteger(osHaInput));
        getCurrentBrilvoorschrift().setOdIod(ifNullInteger(odIodInput));
        getCurrentBrilvoorschrift().setOsIod(ifNullInteger(osIodInput));
        getCurrentBrilvoorschrift().setOdLh(ifNullInteger(odLhInput));
        getCurrentBrilvoorschrift().setOsLh(ifNullInteger(osLhInput));
        getCurrentBrilvoorschrift().setOdNabil(ifNullDouble(odNabijInput));
        getCurrentBrilvoorschrift().setOsNabil(ifNullDouble(osNabijInput));
        getCurrentBrilvoorschrift().setOdPddn(odPdDnInput.getText());
        getCurrentBrilvoorschrift().setOsPddn(osPdDnInput.getText());
        getCurrentBrilvoorschrift().setOdPr(ifNullInteger(odPrInput));
        getCurrentBrilvoorschrift().setOsPr(ifNullInteger(osPrInput));
        getCurrentBrilvoorschrift().setOdPr1(ifNullInteger(odPr1Input));
        getCurrentBrilvoorschrift().setOsPr1(ifNullInteger(osPr1Input));
        getCurrentBrilvoorschrift().setOdSph(ifNullDouble(odSphInput));
        getCurrentBrilvoorschrift().setOsSph(ifNullDouble(osSphInput));
        getCurrentBrilvoorschrift().setOdVis(ifNullDouble(odVisInput));
        getCurrentBrilvoorschrift().setOsVis(ifNullDouble(osVisInput));
        getCurrentBrilvoorschrift().setOogmetingDoor(oogmetinggDoorCombo.getEditor().getText());//oogmetinggDoorInput.getText());
        setCurrentBrilvoorschrift((Brilvoorschrift) OpticStore.getExchanger().saveDbObject(getCurrentBrilvoorschrift()));
    }

    @FXML
    private void handleSendEmailButton() {
        String email = klantRB.isSelected() ? emailInput.getText() : (listRB.isSelected() ? emailsInput.getText() : emailssInput.getText());
        //System.out.println("!!EMAIL:"+email);
        if (email == null || email.trim().length() == 0) {
            OpticStore.logAndShowErrorMessage("E-mail address is empty");
        } else {
            try {
                //HostServices hostService = OpticStore.mainApp.getHostServices();
                String emailArg = "mailto:" + email + "?subject="
                        + (emailSubjectField.getText() == null ? "" : emailSubjectField.getText())
                        + "&body=" + (emailBodyField.getText() == null ? "" : emailBodyField.getText().replace("\"", "\\\""));
                //hostService.showDocument(emailArg);
                System.out.println("!!!: " + "open \"" + emailArg + "\"");
                Process res = Runtime.getRuntime().exec(new String[]{"open", emailArg});//"open \""+emailArg+"\"");
                InputStream ers = res.getErrorStream();
                InputStream sout = res.getInputStream();
                res.waitFor();
//                int b;
//                System.out.println("\n!!!ERR:!!!");
//                while((b=ers.read()) != -1) {
//                    System.out.print((char)b);
//                }
//                System.out.println("\n!!!OUT:!!!");
//                while((b=sout.read()) != -1) {
//                    System.out.print((char)b);
//                }

            } catch (Exception e) {
                OpticStore.logAndShowErrorMessage(e.getMessage());
            }
        }
    }

    @FXML
    private void handleEmailTabSelected() {
        if (klantRB.isSelected()) {
            handleKlantRBaction();
        } else if (listRB.isSelected()) {
            handleListRBaction();
        } else {
            handleAgeRBaction();
        }
    }

    @FXML
    private void handleKlantRBaction() {
        emailInput.setText(emailField.getText());
        emailsInput.setText("");
        emailssInput.setText("");
    }

    @FXML
    private void handleListRBaction() {
        emailInput.setText("");
        emailsInput.setText(SelectModifier.getCurListEmails(klantGrid.getTableBody(), 6));
        emailssInput.setText("");
    }

    @FXML
    private void handleAgeRBaction() {
        emailInput.setText("");
        emailsInput.setText("");
        emailssInput.setText(SelectModifier.getAgeRangeEmails(vanDeInput, totDeInput));
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
            OpticStore.logAndShowErrorMessage(ex);
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

    private String addWhereKlantCondition() {
        return SelectModifier.modifyKlantCondition(klantIDfield, aanhefField,
                voorlettersField, tussenvoegselField, achternaamField,
                adresField, huisnummerField, postcodeField, plaatsField,
                landField, gebortedatumField, telefonField, mobileField, emailField);
    }

    private String addWhereVerkoopCondition() {
        return SelectModifier.modifyVerkoopCondition(srcDate1Input, srcDate2Input,
                srcMerkCombo, srcModelCombo, srcKleurCombo, srcMaatInput,
                srcPrijs1MontuurInput, srcPrijs2MontuurInput, srcMontuurTypeCombo,
                srcMateriallCombo, srcDiversenCombo, srcIdMontuurInput, srcLeverancierCombo,
                srcTypeGlasCombo, srcCoatingCombo, srcKleurGlasCombo, srcDiameter1Input,
                srcDiameter2Input, srcRndsJa, srcRndsNee, srcPrijs1GlasInput, srcPrijs2GlasInput);
    }
    
    private void loadKlantFrom(int selectedKlantID) {
        loadKlantFrom(selectedKlantID, 0);
    }
    
    private void loadKlantFrom(int selectedKlantID, int verkoopID) {
        try {
            clearKlantForm(false);
            Klant klant = (Klant) OpticStore.getExchanger().loadDbObjectOnID(Klant.class, selectedKlantID);
            if (klant != null) {
                klantIDfield.setDisable(true);
                String klid;
                klantIDfield.setText(klid = klant.getKlantId().toString());
                aanhefField.setText(klant.getAanhef() == null ? "" : klant.getAanhef());

                voorlettersInput.setText(klant.getVoorletters() == null ? "" : klant.getVoorletters());
                achternaamInput.setText(klant.getAchternaam() == null ? "" : klant.getAchternaam());

                voorlettersField.setText(klant.getVoorletters() == null ? "" : klant.getVoorletters());
                tussenvoegselField.setText(klant.getTussenvoegsel() == null ? "" : klant.getTussenvoegsel());
                achternaamField.setText(klant.getAchternaam() == null ? "" : klant.getAchternaam());
                adresField.setText(klant.getAdres() == null ? "" : klant.getAdres());
                huisnummerField.setText(klant.getHuisnummer() == null ? "" : klant.getHuisnummer());
                postcodeField.setText(klant.getPostcode() == null ? "" : klant.getPostcode());
                plaatsField.setText(klant.getPlaats() == null ? "" : klant.getPlaats());
                landField.setText(klant.getLand() == null ? "" : klant.getLand());
                if (klant.getGeboortedatum() != null) {
                    gebortedatumField.setText(OpticStore.dateFormat.format(klant.getGeboortedatum()));
                }
                String tlfn;
                telefonField.setText(tlfn = klant.getTelefoon() == null ? "" : klant.getTelefoon());
                String mbl;
                mobileField.setText(mbl = klant.getMobiel() == null ? "" : klant.getMobiel());
                String eml;
                emailField.setText(eml = klant.getEmail() == null ? "" : klant.getEmail());
                emailInput.setText(eml);
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
                loadVerkoopList(klant, verkoopID);
                oogmetingTab.setDisable(false);
                montuurTab.setDisable(false);
                glazenTab.setDisable(false);
                mailingTab.setDisable(false);
                anamneseButton.setDisable(false);
            }
        } catch (RemoteException ex) {
            OpticStore.logAndShowErrorMessage(ex);
        }
    }

    private void enableLoadKlantOperations(boolean enable) {
        editClientNode.setDisable(!enable);
        delClientNode.setDisable(!enable);
    }

    private String getLastSellDate(Integer klantId) throws RemoteException {
        Verkoop vk = SelectModifier.getLastVerkoop(klantId);
        if (vk != null) {
            fillLastVerkoop(vk);
            Date dt = vk.getVerkoopdatum();
            return dt == null ? "" : OpticStore.dateFormat.format(dt);
        }
        return "geen verkoop";
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

    private void loadLastBrilvoorschrift() throws RemoteException {
        if (getBrilvoorschriftArray().size() > 0) {
            Brilvoorschrift bs = getBrilvoorschriftArray().get(getBrilvoorschriftArray().size() - 1);
            Date dt = bs.getDatumRefractie();
            datumRefractieLbl.setText(OpticStore.dateFormat.format(dt));
            oogmetingDoorLbl.setText(bs.getOogmetingDoor());
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

    private void clearSrcForm() {
        FXutils.clearTextFields(new TextInputControl[]{
            srcDate1Input, srcDate2Input, srcMaatInput,
            srcIdMontuurInput,
            srcPrijs1MontuurInput, srcPrijs2MontuurInput,
            srcDiameter1Input, srcDiameter2Input,
            srcPrijs1GlasInput, srcPrijs2GlasInput,
            srcMerkCombo.getEditor(), srcModelCombo.getEditor(),
            srcKleurCombo.getEditor(), srcDiversenCombo.getEditor(),
            srcLeverancierCombo.getEditor(), srcTypeGlasCombo.getEditor(),
            srcCoatingCombo.getEditor(), srcKleurGlasCombo.getEditor()
        });
        srcRndsElke.setSelected(true);
        srcMontuurTypeCombo.setValue("");
        srcMateriallCombo.setValue("");
    }
}
