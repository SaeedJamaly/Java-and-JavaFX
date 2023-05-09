package com.example.demo3;

import Model.DataStorage;
import Model.PotentialCustomer;
import Model.Property;
//import Model.RentalManagementSystem;
//import Model.RentalUnit;
import Model.Tenant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

//import static Model.RentalManagementSystem.getATenant;

public class PotentialTenantPage  {

    public static DataStorage storage = new DataStorage();
    public static PotentialCustomer potentialCustomer = new PotentialCustomer();

    @FXML
    private Button addPTButton;

    @FXML
    private TextField addPT_propertyID;

    @FXML
    private TextField addPT_tenantID;

    @FXML
    public void submitPotentialTenant(ActionEvent event){
        Alert alert;
        int searchPropertyID;
        int searchTenantID;

        searchPropertyID= Integer.parseInt(addPT_propertyID.getText());
        searchTenantID= Integer.parseInt(addPT_tenantID.getText());

        Tenant tenant = storage.findTenantByID(searchTenantID);
        potentialCustomer.attach(tenant);


        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Adding to waiting list.");
        alert.setHeaderText(null);
        alert.setContentText("Tenant " + searchTenantID + " added to the waiting list.");
        alert.showAndWait();
        //addPotentialTenant(searchTenantID,searchPropertyID );

        resetFormFields();
    }

    void resetFormFields() {
        addPT_propertyID.setText("");
        addPT_tenantID.setText("");
     }

}
