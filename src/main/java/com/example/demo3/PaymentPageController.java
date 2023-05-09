package com.example.demo3;

import Controller.LeaseController;
import Model.Lease;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class PaymentPageController {

    ArrayList<String> list = new ArrayList<>();
    public static LeaseController leaseController = new LeaseController();

    @FXML
    private Button addPaymentButton;

    @FXML
    private TextField addPayment_propertyID;

    @FXML
    private TextField addPayment_tenantID;

    public void populatePaymentPreview(Lease lease) {
        addPayment_propertyID.setText(Integer.toString(lease.getProperty().getID()));
        addPayment_tenantID.setText(Integer.toString(lease.getTenant().getID()));

        //propertyPrice.setText(String.valueOf(property.getPrice()));
    }

    @FXML
    public void submitPayment(ActionEvent event){
        Alert alert;

        list.clear();
        String searchPropertyID;
        String searchTenantID;

        searchPropertyID= addPayment_propertyID.getText();
        searchTenantID= addPayment_tenantID.getText();
        list.add(searchPropertyID);
        list.add(searchTenantID);
        leaseController.pay(list);

        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Successful Payment");
        alert.setHeaderText(null);
        alert.setContentText("Payment was successful for property ");
        alert.showAndWait();

        //addPotentialTenant(searchTenantID,searchPropertyID );

        resetFormFields();
    }

    public String getPropertyID(){
        return addPayment_propertyID.getText();
    }
    public String getTenantID(){
        return addPayment_tenantID.getId();
    }
    void resetFormFields() {
        addPayment_propertyID.setText("");
        addPayment_tenantID.setText("");
    }
}