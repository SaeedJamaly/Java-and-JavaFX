package com.example.demo3;


//import Views.AdminView;

import Controller.PropertyController;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PropertyPageController implements Initializable {

    ArrayList<String> list = new ArrayList<>();
    ArrayList<Property> propertyList = new ArrayList<>();
    public static PropertyController propertyController = new PropertyController();
    public static DataStorage storage = new DataStorage();



    @FXML
    private ComboBox<String> addProperty_propertyType;
    @FXML
    private Button addProperty_addBtn;

    @FXML
    private TextField addProperty_address;

    @FXML
    private TextField addProperty_city;

    @FXML
    private Button addProperty_clearBtn;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_PropertyID1;

    @FXML
    private TableColumn<Property, String> addProperty_col_address;

    @FXML
    private TableColumn<Property, String> addProperty_col_address1;

    @FXML
    private TableColumn<Property, String> addProperty_col_city;

    @FXML
    private TableColumn<Property, String> addProperty_col_city1;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_nbrBath;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_nbrBath1;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_nbrBed;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_nbrBed1;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_propertyID;

    @FXML
    private TableColumn<Property, String> addProperty_col_propertyType;

    @FXML
    private TableColumn<Property, String> addProperty_col_propertyType1;

    @FXML
    private TableColumn<Property, String> addProperty_col_unitNumber;

    @FXML
    private TableColumn<Property, String> addProperty_col_unitNumber1;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_zip;

    @FXML
    private TableColumn<Property, Integer> addProperty_col_zip1;

    @FXML
    private Button addProperty_deleteBtn;

    @FXML
    private Button addProperty_displayAllBtn;

    @FXML
    private Button addProperty_displayBtn;

    @FXML
    private Button addProperty_displayRentedBtn;

    @FXML
    private Button addProperty_displayVacantBtn;

    @FXML
    private TextField addProperty_nbrBed;

    @FXML
    private TextField addProperty_propertyID;

//    @FXML
//    private TextField addProperty_propertyType;

    @FXML
    private TextField addProperty_unitNumber;

    @FXML
    private TextField addProperty_nbrBath;

    @FXML
    private TableView<Property> addProperty_tableView;

    @FXML
    private TableView<Property> addProperty_tableView1;

    @FXML
    private TextField addProperty_zip;

    @FXML
    private Button buttonAddProperty;

    @FXML
    private Button buttonDisplayAllProperties;

    @FXML
    private Button buttonDisplayAllRentedProperties;

    @FXML
    private Button buttonDisplayAllVacantProperties;

    @FXML
    private Button buttonHome;

    @FXML
    private Button close;

    @FXML
    private AnchorPane displayAllProperties_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private AnchorPane property_form;

    @FXML
    private Label username;


    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }


    private double x = 0;
    private double y = 0;

    public void backToHomeMenu() {
        try {
            buttonHome.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void switchForm(ActionEvent event) {

        if (event.getSource() == buttonAddProperty) {
            property_form.setVisible(true);
            displayAllProperties_form.setVisible(false);


            buttonAddProperty.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonDisplayAllProperties.setStyle("-fx-background-color:transparent");


        } else if (event.getSource() == buttonDisplayAllProperties) {
            property_form.setVisible(false);
            displayAllProperties_form.setVisible(true);


            buttonDisplayAllProperties.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonAddProperty.setStyle("-fx-background-color:transparent");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // addTenantList = addEmployeeListData();
        addProperty_propertyType.getItems().addAll("Apartment", "Condo", "House");

        addProperty_col_propertyType.setCellValueFactory(new PropertyValueFactory<Property, String>("type"));
        addProperty_col_propertyID.setCellValueFactory(new PropertyValueFactory<Property, Integer>("ID"));
        addProperty_col_city.setCellValueFactory(new PropertyValueFactory<Property, String>("city"));
        addProperty_col_address.setCellValueFactory(new PropertyValueFactory<Property, String>("address"));
        addProperty_col_zip.setCellValueFactory(new PropertyValueFactory<Property, Integer>("zip"));
        addProperty_col_nbrBed.setCellValueFactory(new PropertyValueFactory<Property, Integer>("noOfBedrooms"));
        addProperty_col_nbrBath.setCellValueFactory(new PropertyValueFactory<Property, Integer>("noOfBathrooms"));
        addProperty_col_unitNumber.setCellValueFactory(new PropertyValueFactory<Property, String>("unitNo"));

        addProperty_col_propertyType1.setCellValueFactory(new PropertyValueFactory<Property, String>("type"));
        addProperty_col_PropertyID1.setCellValueFactory(new PropertyValueFactory<Property, Integer>("ID"));
        addProperty_col_city1.setCellValueFactory(new PropertyValueFactory<Property, String>("city"));
        addProperty_col_address1.setCellValueFactory(new PropertyValueFactory<Property, String>("address"));
        addProperty_col_zip1.setCellValueFactory(new PropertyValueFactory<Property, Integer>("zip"));
        addProperty_col_nbrBed1.setCellValueFactory(new PropertyValueFactory<Property, Integer>("noOfBedrooms"));
        addProperty_col_nbrBath1.setCellValueFactory(new PropertyValueFactory<Property, Integer>("noOfBathrooms"));
        addProperty_col_unitNumber1.setCellValueFactory(new PropertyValueFactory<Property, String>("unitNo"));
    }

    @FXML
    public void addProperty(ActionEvent event) {
        try {
            Alert alert;
            if (addProperty_propertyID.getText().isEmpty()
                    || addProperty_city.getText().isEmpty()
                    || addProperty_zip.getText().isEmpty()
                    || addProperty_address.getText().isEmpty()
                    || addProperty_nbrBed.getText().isEmpty()
                    || addProperty_propertyType.getSelectionModel().getSelectedItem() == null
                    || addProperty_nbrBath.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                if (addProperty_unitNumber.getText().isEmpty()) {
                    addProperty_unitNumber.setText(" ");
                }
                list.clear();

                list.add(addProperty_propertyType.getSelectionModel().getSelectedItem());
                list.add(addProperty_propertyID.getText());
                list.add(addProperty_address.getText());
                list.add(addProperty_city.getText());
                list.add(addProperty_zip.getText());
                list.add(addProperty_nbrBed.getText());
                list.add(addProperty_nbrBath.getText());
                list.add(addProperty_unitNumber.getText());

                propertyController.add(list);

                addProperty_tableView.setItems( FXCollections.observableList(storage.getProperties()) );

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                resetFormFields();
            }
        }
        catch (Exception e) {
            e.toString();
        }
    }

    /**
     * Reset form fields
     */
    void resetFormFields() {
        addProperty_propertyID.setText("");
        addProperty_city.setText("");
        addProperty_zip.setText("");
        addProperty_address.setText("");
        addProperty_nbrBed.setText("");
        addProperty_unitNumber.setText("");
        addProperty_nbrBath.setText("");
        addProperty_col_unitNumber.setText("");

    }

    @FXML
    public void deleteProperty(ActionEvent event) {
        Property selectedTenant = addProperty_tableView.getSelectionModel().getSelectedItem();
        propertyController.remove(selectedTenant.getID());
        addProperty_tableView.refresh();
    }

    @FXML
    public void displayAllProperties() {
        addProperty_tableView1.setItems( FXCollections.observableList(storage.getProperties()) );
        addProperty_tableView1.refresh();
    }

    @FXML
    public void displayRentedUnits() {
        propertyList.clear();
        for (Property p: storage.getProperties()){
            if (p.getStatus() == 3){
                propertyList.add(p);
            }

        }
        addProperty_tableView1.setItems( FXCollections.observableList(propertyList) );
        addProperty_tableView1.refresh();
    }
    @FXML
    public void displayVacantUnits() {
        propertyList.clear();
        for (Property p: storage.getProperties()){
            if ( p.getStatus() != 3 ){
                propertyList.add(p);
            }

        }
        addProperty_tableView1.setItems( FXCollections.observableList(propertyList) );
        addProperty_tableView1.refresh();
    }

    @FXML
    void rentProperty(ActionEvent e) throws Exception {
        Alert alert;
        //    Property selectedProperty = addProperty_tableView.getSelectionModel().getSelectedItem();
        Property selectedProperty1 = addProperty_tableView1.getSelectionModel().getSelectedItem();


        // Do nothing if there is no property selected
        if (selectedProperty1 == null)
        //              ||selectedProperty1 == null )
        {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please Select a Property to rent");
            alert.showAndWait();

            //  return;
        }

        // Display an error popup if selected property is not available for rent
        if (selectedProperty1.getStatus() !=1)
        //               ||!selectedProperty1.getAvailable())
        {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText( "Property is not available for rent at the moment. Do you want to subscribe for the updates?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PotentialTenantPage.fxml"));
                Parent root = loader.load();

                //   Parent root = FXMLLoader.load(getClass().getResource("LeasePage.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Potential Tenant");
                stage.setScene(scene);
                stage.show();


            }


        } else {
            // Go to rent property view if a property is selected
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LeasePage.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Lease");
            stage.setScene(scene);
            stage.show();
////////////////////////////////////////////////
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("LeasePage.fxml"));
//            Parent parent = loader.load();
//
//            Scene scene = new Scene(parent);
//            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

//            // Access the rent property view's controller
//            LeasePageController controller = loader.getController();
//            // Populate the property preview grid pane with selected property details summary
//            controller.populatePropertyPreview(selectedProperty1);
//            //Allow access to the selected property from the rent view's controller
//            stage.setUserData(selectedProperty1);
//
//            stage.setScene(scene);
//            stage.show();
        }
    }
}