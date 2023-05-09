package com.example.demo3;

import Controller.LeaseController;
import Model.DataStorage;
import Model.Lease;
import Model.Observer;
import Model.Property;
//import Model.RentalManagementSystem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class EndLeasePageController implements Initializable {

    public static DataStorage storage = new DataStorage();
    ArrayList<String> list = new ArrayList<>();
    public static LeaseController leaseController = new LeaseController();
    @FXML
    private Button endLease_ReasonButton;

    @FXML
    private TextField endLease_leaseID;

    @FXML
    private ComboBox<String> endLease_reasonToEnd;


@FXML
public void submitEndLease(ActionEvent event){
    Alert alert;
    Alert alert1;
    list.clear();
    String searchLeaseID = endLease_leaseID.getText();

    String reason = endLease_reasonToEnd.getSelectionModel().getSelectedItem();
    list.clear();
    list.add(searchLeaseID);
    list.add(reason);

    leaseController.endLease(list);

    alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Lease " + searchLeaseID + " Ended.");
    alert.setHeaderText(null);
    alert.setContentText("The property is ready for " + reason);
    alert.showAndWait();

    if (reason.equalsIgnoreCase("Relisting")){
        alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Sending Email");
        alert1.setHeaderText(null);
        for (Observer potentialCustomer: storage.getPotentialCustomers()){
            potentialCustomer.sendEmail();

        }
        alert1.setContentText("Email sent to customers.");
        alert1.showAndWait();
    }


}

    public void populateLeasePreview(Lease lease) {
        endLease_leaseID.setText(Integer.toString(lease.getLeaseID()));

           }
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        endLease_reasonToEnd.getItems().addAll( "Relisting", "Renovation");
        endLease_reasonToEnd.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {

            }
        });
    }
}
