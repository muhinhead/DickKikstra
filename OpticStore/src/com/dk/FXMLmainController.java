/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.orm.User;
import com.dk.orm.dbobject.DbObject;
import com.dk.util.AutoCompleteComboBoxListener;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialogs;
import javafx.scene.control.PasswordField;

/**
 *
 * @author nick
 */
public class FXMLmainController implements Initializable {

    private static ArrayList<User> users = null;
    public static User currentUser = null;
    static PasswordField staticPwdField;

    /**
     * @return the users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    @FXML
    private ComboBox userCB;
    @FXML
    private PasswordField pwdField;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        Object itm = userCB.getValue();
        currentUser = null;
        for (User u : getUsers()) {
            if (u.getLogin().equals(itm) && u.getPasswd().equals(pwdField.getText())) {
                currentUser = u;
                break;
            }
        }
        if (currentUser == null) {
            Dialogs.showErrorDialog(OpticStore.mainStage, "Toegang geweigerd!", "Fout", "Oh!");
            //Platform.exit();
        } else {
            //OpticStore.mainApp.resize2(1100.0, 800.0);
            if(currentUser.getIsAdmin().intValue()!=1) {
                FXMLDashboardController.adminNode.setVisible(false);
            }
            OpticStore.mainApp.hideLoginAndShowDashboard();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        staticPwdField = pwdField;
        userCB.getItems().clear();
        new AutoCompleteComboBoxListener(userCB);
    }

    void setData() throws RemoteException {
        DbObject[] lst = OpticStore.getExchanger().getDbObjects(User.class, null, "login");
        users = new ArrayList<User>(lst.length);
        for (int i=0; i<lst.length; i++) {
            getUsers().add((User) lst[i]);
            userCB.getItems().add(((User) lst[i]).getLogin());
        }
    }
}
