/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dk;

import com.dk.remote.IMessageSender;
import com.dk.rmi.DbConnection;
import com.dk.rmi.ExchangeFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.WritableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Dialogs;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

/**
 *
 * @author Nick Mukhin
 */
public class OpticStore extends Application {

    private static final String APPNAME = "OpticStore";
    private static Properties props;
    private static final String PROPERTYFILENAME = APPNAME + ".config";
    public static final String KLANTLIST = "select "
            + "klant_id \"id klant\","
            + "aanhef \"aanhef\","
            + "voorletters \"voorletters\","
            + "tussenvoegsel \"tussenvoegsel\","
            + "achternaam \"achternaam\","
            + "geboortedatum \"geboortedatum\" from klant order by klant_id";
    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static Logger logger;
    private static FileHandler fh;
    private static IMessageSender exchanger;
    private static Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
    private StackPane rootPane;
    private Parent loginPane;
    private Parent dashboardPane;
    private double loginWidth;
    private double loginHeight;
    static Stage mainStage;
    static OpticStore mainApp;

    /**
     * @return the exchanger
     */
    public static IMessageSender getExchanger() {
        return exchanger;
    }

    public static String getVersion() {
        return "0.1";
    }

    static WritableValue<Double> writableWidth = new WritableValue<Double>() {
        @Override
        public Double getValue() {
            return mainStage.getWidth();
        }

        @Override
        public void setValue(Double value) {
            mainStage.setWidth(value);
            mainStage.setX((primScreenBounds.getWidth() - value) / 2);
            mainStage.setY((primScreenBounds.getHeight() - mainStage.getHeight()) / 4);
            mainStage.show();
        }
    };
    static WritableValue<Double> writableHeight = new WritableValue<Double>() {
        @Override
        public Double getValue() {
            return mainStage.getHeight();
        }

        @Override
        public void setValue(Double value) {
            mainStage.setHeight(value);
            mainStage.setX((primScreenBounds.getWidth() - mainStage.getWidth()) / 2);
            mainStage.setY((primScreenBounds.getHeight() - value) / 4);
            mainStage.show();
        }
    };

    public static String readProperty(String key, String deflt) {
        if (null == props) {
            props = new Properties();
            try {
                File propFile = new File(PROPERTYFILENAME);
                if (!propFile.exists() || propFile.length() == 0) {
                    String curPath = propFile.getAbsolutePath();
                    curPath = curPath.substring(0,
                            curPath.indexOf(PROPERTYFILENAME)).replace('\\', '/');
                    props.setProperty("user", "admin");
                    props.setProperty("userPassword", "admin");
                    propFile.createNewFile();
                } else {
                    props.load(new FileInputStream(propFile));
                }
                DbConnection.setProps(props);
            } catch (IOException e) {
                log(e);
                return deflt;
            }
        }
        return props.getProperty(key, deflt);
    }

    public static Properties getProperties() {
        return props;
    }

    public static void saveProps() {
        if (props != null) {
//            if (getCurrentUser() != null) {
//                props.setProperty("LastLogin", getCurrentUser().getLogin());
//            }
            props.setProperty("ServerAddress", props.getProperty("ServerAddress", "localhost:1099"));
        }
        //Preferences userPref = Preferences.userRoot();
        saveProperties();
    }

    public static void saveProperties() {
        try {
            if (props != null) {
                props.store(new FileOutputStream(PROPERTYFILENAME),
                        "-----------------------");
            }
        } catch (IOException e) {
            logAndShowErrorMessage(e.getLocalizedMessage() + new File(PROPERTYFILENAME).getAbsolutePath());
        }
    }

    public static void log(String msg) {
        log(msg, null);
    }

    public static void log(Throwable th) {
        log(null, th);
    }

    private static void log(String msg, Throwable th) {
        if (logger == null) {
            try {
                logger = Logger.getLogger(APPNAME);
                fh = new FileHandler("%h/" + APPNAME + ".log", 1048576, 10, true);
                logger.addHandler(fh);
                logger.setLevel(Level.ALL);
                SimpleFormatter formatter = new SimpleFormatter();
                fh.setFormatter(formatter);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.log(Level.SEVERE, msg, th);
    }

    public static void logAndShowErrorMessage(String msg) {
        log(msg);
        Dialogs.showErrorDialog(mainApp.mainStage, msg, "Fout", "Helaas!");
    }

    public static boolean yesOrNoDialog(String msg) {
        Dialogs.DialogResponse ans = Dialogs.showConfirmDialog(mainApp.mainStage, msg,
                null, "Aandacht", Dialogs.DialogOptions.YES_NO);
        return ans == Dialogs.DialogResponse.YES;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        mainApp = this;
        mainStage = stage;
        rootPane = new StackPane();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        if (initExchanger()) {
            FXMLLoader dbLoader = new FXMLLoader(getClass().getResource("FXMLDashboard.fxml"));
            dashboardPane = (Parent) dbLoader.load();
            dashboardPane.setVisible(false);
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("FXMLmain.fxml"));
            loginPane = (Parent) loginLoader.load();
            FXMLmainController loginController = loginLoader.getController();

            rootPane.getChildren().add(dashboardPane);
            rootPane.getChildren().add(loginPane);

            Scene scene = new Scene(rootPane, 440, 200);
            stage.setScene(scene);
            stage.show();

            loginController.setData();
            mainStage.setTitle("Login");

            loginWidth = mainStage.getWidth();
            loginHeight = mainStage.getHeight();
        }
    }

    public void swapLoginAndDashboard(final boolean showLogin) {
        Timeline fade = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rootPane.opacityProperty(), 1.0)),
                new KeyFrame(new Duration(400), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        loginPane.setVisible(showLogin);
                        dashboardPane.setVisible(!showLogin);
                        if(showLogin)
                            loginPane.requestLayout();
                        else
                            dashboardPane.requestLayout();
                        Timeline fadeIn = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(rootPane.opacityProperty(), 0.0)),
                                new KeyFrame(new Duration(400), new KeyValue(rootPane.opacityProperty(), 1.0)));
                        fadeIn.play();
                    }
                }, new KeyValue(rootPane.opacityProperty(), 0.0)));
        fade.play();
        mainStage.setTitle(showLogin?"Login":"de oogkas");
    }
    
    
    public void hideLoginAndShowDashboard() {
        resize2(1200.0, 750.0);
        swapLoginAndDashboard(false);
    }

    public void hideDashboardAndShowLogin() {
        mainApp.resize2(mainApp.getLoginWidth(), mainApp.getLoginHeight());
        swapLoginAndDashboard(true);
    }
    
    public void resize2(double ww, double hh) {
        resize(mainStage.getWidth(), mainStage.getHeight(), ww, hh);
    }

    public static void resize(double w, final double h, double ww, final double hh) {
        Timeline widthIncrease = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(OpticStore.writableWidth, w)),
                new KeyFrame(new Duration(400), new KeyValue(OpticStore.writableWidth, ww)));
        widthIncrease.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Timeline heightIncrease = new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(OpticStore.writableHeight, h)),
                        new KeyFrame(new Duration(400), new KeyValue(OpticStore.writableHeight, hh)));
                heightIncrease.play();

            }
        });
        widthIncrease.play();
    }

    /**
     * @return the loginWidth
     */
    public double getLoginWidth() {
        return loginWidth;
    }

    /**
     * @return the loginHeight
     */
    public double getLoginHeight() {
        return loginHeight;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private boolean initExchanger() {
        String connectString = readProperty("JDBCconnection", "jdbc:hsqldb:file:~/hsqldb/OpticStore");
        exchanger = ExchangeFactory.getExchanger(connectString, props);
        return getExchanger() != null;
    }

}
