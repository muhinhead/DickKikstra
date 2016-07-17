/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.User;
import com.dk.orm.dbobject.ForeignKeyViolationException;
import com.dk.util.FXutils;
import java.net.URL;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author nick
 */
public class FXMLusersFormController implements Initializable {

    @FXML
    private HBox buttonBox;
    @FXML
    private TextField firstNameInput;
    @FXML
    private TextField lastNameInput;
    @FXML
    private TextField initialsInput;
    @FXML
    private TextField loginInput;
    @FXML
    private PasswordField pwdInput1;
    @FXML
    private PasswordField pwdInput2;
    @FXML
    private CheckBox adminCB;
    @FXML
    private Label idLabel;
    private User editedUser;
    private int userIdx;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userIdx = findCurUser(FXMLmainController.currentUser);
        loadUser();
        Node firstButton = FXutils.createButton(getClass(), "first.png", new Runnable() {
            @Override
            public void run() {
                userIdx = findCurUser(FXMLmainController.getUsers().get(0));
                loadUser();
            }
        });
        Node prevButton = FXutils.createButton(getClass(), "prev.png", new Runnable() {
            @Override
            public void run() {
                if (userIdx > 0) {
                    userIdx = findCurUser(FXMLmainController.getUsers().get(userIdx - 1));
                    loadUser();
                }
            }
        });
        Node nextButton = FXutils.createButton(getClass(), "next.png", new Runnable() {
            @Override
            public void run() {
                if (userIdx < FXMLmainController.getUsers().size() - 1) {
                    userIdx = findCurUser(FXMLmainController.getUsers().get(userIdx + 1));
                    loadUser();
                }
            }
        }
        );
        Node lastButton = FXutils.createButton(getClass(), "last.png", new Runnable() {
            @Override
            public void run() {
                userIdx = findCurUser(FXMLmainController.getUsers().get(FXMLmainController.getUsers().size() - 1));
                loadUser();
            }
        });
        Node addButton = FXutils.createButton(getClass(), "add.png", new Runnable() {
            @Override
            public void run() {
                editedUser = null;
                userIdx = -1;
                loadUser();
            }
        });
        Node okButton = FXutils.createButton(getClass(), "ok.png", new Runnable() {
            @Override
            public void run() {
                try {
                    saveEditedUser();
                } catch (Exception ex) {
                    OpticStore.logAndShowErrorMessage(ex);
                }
            }
        });
        Node delButton = FXutils.createButton(getClass(), "delete.png", new Runnable() {
            @Override
            public void run() {
                if (editedUser.equals(FXMLmainController.currentUser)) {
                    OpticStore.logAndShowErrorMessage("kunt u niet zelf verwijderen!");
                } else {
                    if (OpticStore.yesOrNoDialog(
                            "Bent u zeker dat u wilt verwijderen van dit record?\n(user_id=" + editedUser.getUserId() + ")")) {
                        try {
                            OpticStore.getExchanger().deleteObject(editedUser);
                            FXMLmainController.getUsers().remove(editedUser);
                            userIdx = findCurUser(FXMLmainController.currentUser);
                            loadUser();
                        } catch (RemoteException ex) {
                            OpticStore.logAndShowErrorMessage(ex);
                        }
                    }
                }
            }
        });
        buttonBox.getChildren().add(firstButton);
        buttonBox.getChildren().add(prevButton);
        buttonBox.getChildren().add(nextButton);
        buttonBox.getChildren().add(lastButton);
        buttonBox.getChildren().add(addButton);
        buttonBox.getChildren().add(okButton);
        buttonBox.getChildren().add(delButton);
    }

    private void loadUser() {
        firstNameInput.setText("");
        lastNameInput.setText("");
        initialsInput.setText("");
        loginInput.setText("");
        pwdInput1.setText("");
        pwdInput2.setText("");
        adminCB.setSelected(false);
        if (editedUser != null) {
            firstNameInput.setText(editedUser.getFirstName());
            lastNameInput.setText(editedUser.getLastName());
            initialsInput.setText(editedUser.getInitials());
            loginInput.setText(editedUser.getLogin());
            pwdInput1.setText(editedUser.getPasswd());
            adminCB.setSelected(editedUser.getIsAdmin().intValue() == 1);
            idLabel.setText("" + (userIdx + 1) + "/" + FXMLmainController.getUsers().size());
        } else {
            idLabel.setText("?/" + FXMLmainController.getUsers().size());
        }
    }

    private void saveEditedUser() throws ForeignKeyViolationException, SQLException, RemoteException {
        boolean wasNew = false;
        if (editedUser == null) {
            wasNew = true;
            editedUser = new User(null);
            editedUser.setUserId(0);
            editedUser.setNew(true);
        }
        if (pwdInput1.getText().equals(pwdInput2.getText())) {
            editedUser.setFirstName(firstNameInput.getText());
            editedUser.setLastName(lastNameInput.getText());
            editedUser.setInitials(initialsInput.getText());
            editedUser.setLogin(loginInput.getText());
            editedUser.setPasswd(pwdInput1.getText());
            editedUser.setIsAdmin(adminCB.isSelected() ? 1 : 0);
            editedUser = (User) OpticStore.getExchanger().saveDbObject(editedUser);
            if (wasNew) {
                FXMLmainController.getUsers().add(editedUser);
            }
            userIdx = findCurUser(editedUser);
            loadUser();
        } else {
            OpticStore.logAndShowErrorMessage("Wachtwoorden komen niet overeen!");
            pwdInput2.requestFocus();
        }
    }

    private int findCurUser(User searched) {
        int n = 0;
        for (User u : FXMLmainController.getUsers()) {
            if (u.getUserId().intValue() == searched.getUserId().intValue()) {
                editedUser = u;
                return n;
            }
            n++;
        }
        return -1;
    }

}
