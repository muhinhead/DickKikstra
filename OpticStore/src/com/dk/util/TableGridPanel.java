package com.dk.util;

import com.dk.remote.IMessageSender;
import java.rmi.RemoteException;
import java.util.Vector;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/**
 *
 * @author Nick Mukhin
 */
public class TableGridPanel extends BorderPane {

    private final TableView tableView;
    private EventHandler<ActionEvent> addAction = null;
    private EventHandler<ActionEvent> editAction = null;
    private EventHandler<ActionEvent> delAction = null;
    private Vector[] tableBody;
    private IMessageSender exchanger;
    private String select;

    public TableGridPanel(Vector[] tableBody,
            EventHandler<ActionEvent> addAction, EventHandler<ActionEvent> editAction,
            EventHandler<ActionEvent> delAction) {
        super();
        this.tableBody = tableBody;
        tableView = new TableView();
        buildData();
        setCenter(tableView);
        setActions(addAction, editAction, delAction);
    }

    public TableGridPanel(Vector[] tableBody) {
        this(tableBody, null, null, null);
    }

    public TableGridPanel(IMessageSender exch, String select) throws RemoteException {
        this(exch.getTableBody(select), null, null, null);
        exchanger = exch;
        this.select = select;
    }

    public void reload() throws RemoteException {
        if (exchanger != null && select != null) {
            tableBody = exchanger.getTableBody(select);
            buildData();
        }
    }

    public void reload(String select) throws RemoteException {
        if (exchanger != null && select != null) {
            this.select = select;
            tableBody = exchanger.getTableBody(select);
            buildData();
        }
    }

    public void unselect() {
        tableView.getSelectionModel().clearSelection();
    }

    public void setActions(EventHandler<ActionEvent> addAction, EventHandler<ActionEvent> editAction,
            EventHandler<ActionEvent> delAction) {
        BorderPane rightPanel = new BorderPane();
        GridPane upperPane = new GridPane();
        upperPane.setAlignment(Pos.CENTER);

        if (addAction != null) {
            Button addBtn;
            upperPane.add(addBtn = new Button("Add"), 0, 0);
            addBtn.setOnAction(addAction);
            addBtn.setMaxWidth(Double.MAX_VALUE);
        }
        if (editAction != null) {
            Button editBtn;
            upperPane.add(editBtn = new Button("Edit"), 0, 1);
            editBtn.setOnAction(editAction);
            editBtn.setMaxWidth(Double.MAX_VALUE);
        }
        if (delAction != null) {
            Button delBtn;
            upperPane.add(delBtn = new Button("Delete"), 0, 2);
            delBtn.setOnAction(delAction);
            delBtn.setMaxWidth(Double.MAX_VALUE);
        }

        rightPanel.setTop(upperPane);
        setRight(rightPanel);
    }

    private void buildData() {
        ObservableList<Object> data = FXCollections.observableArrayList();
        Vector headers = getTableBody()[0];
        Vector lines = getTableBody()[1];
        getTableView().getColumns().clear();
        for (int c = 0; c < headers.size(); c++) {
            final int j = c;
            TableColumn col = new TableColumn((String) headers.get(c));
            col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
                    return new SimpleStringProperty(param.getValue().get(j).toString());
                }
            });
            getTableView().getColumns().add(col);
            //col.setPercentageWidth(1.0/headers.size());
        }
        for (int l = 0; l < lines.size(); l++) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int c = 0; c < headers.size(); c++) {
                String ceil = (String) ((Vector) lines.get(l)).get(c);
                row.add(rpad(ceil, headers.get(c).toString().length()));
            }
            data.add(row);
        }
        getTableView().setItems(data);
//        for (Object obj : getTableView().getColumns()) {
//            TableColumn col = (TableColumn) obj;
//            col.setPrefWidth(100.0/headers.size());
//        }
    }

    public void scrollToID(int id) {
        ObservableList itms = getTableView().getItems();
        int r = 0;
        for (Object itm : itms) {
            ObservableList<String> row = (ObservableList<String>) itm;
            if (id == Integer.parseInt(row.get(0).trim())) {
                getTableView().scrollTo(r);
                getTableView().getSelectionModel().select(r);
                break;
            }
            r++;
        }
    }

    private static String rpad(String c, int l) {
        if (c.length() < l) {
            StringBuilder sb = new StringBuilder(c);
            for (int i = c.length(); i < l; i++) {
                sb.append(' ');
            }
            sb.append(" ");
            return sb.toString();
        }
        return c;
    }

    public void fillBySelect(IMessageSender exch, String select) throws RemoteException {
        tableBody = exch.getTableBody(select);
        buildData();
    }

    /**
     * @return the tableBody
     */
    public Vector[] getTableBody() {
        return tableBody;
    }

    /**
     * @return the tableView
     */
    public TableView getTableView() {
        return tableView;
    }
}
