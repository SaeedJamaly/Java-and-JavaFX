package com.example.demo3;


//import Views.AdminView;

import Controller.LeaseController;
import Model.DataStorage;
import Model.Lease;
import Model.Property;
import Model.Tenant;
import javafx.collections.FXCollections;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class LeasePageController implements Initializable {

    public static DataStorage storage = new DataStorage();
    public static LeaseController leaseController = new LeaseController();
    EndLeasePageController endLeasePageController = new EndLeasePageController();
    PaymentPageController paymentPageController = new PaymentPageController();
    ArrayList<String> list = new ArrayList<>();
    ArrayList<Lease> leaseList = new ArrayList<>();


    @FXML
    private Button addLease_addBtn;

    @FXML
    private Button addLease_clearBtn;

    @FXML
    private TableColumn<Lease, Property> addLease_col_propertyID1;

    @FXML
    private TableColumn<Lease, Tenant> addLease_col_tenantID1;

    @FXML
    private TableColumn<Lease, LocalDate> addLease_col_endDate;

    @FXML
    private TableColumn<Lease, LocalDate> addLease_col_endDate1;

    @FXML
    private TableColumn<Lease, Integer> addLease_col_leaseID;

    @FXML
    private TableColumn<Lease, Integer> addLease_col_leaseID1;

    @FXML
    private TableColumn<Lease, Property> addLease_col_propertyID;

    @FXML
    private TableColumn<Lease, Double> addLease_col_rentAmount;

    @FXML
    private TableColumn<Lease, Double> addLease_col_rentAmount1;

    @FXML
    private TableColumn<Lease, LocalDate> addLease_col_startDate;

    @FXML
    private TableColumn<Lease, LocalDate> addLease_col_startDate1;

    @FXML
    private TableColumn<Lease, String> addLease_col_status;

    @FXML
    private TableColumn<Lease, String> addLease_col_status1;

    @FXML
    private TableColumn<Lease, Tenant> addLease_col_tenantID;

    @FXML
    private Button addLease_deleteBtn;

    @FXML
    private Button addLease_displayAllBtn;

    @FXML
    private Button addLease_displayBtn;

    @FXML
    private TextField addLease_endDate;

    @FXML
    private TextField addLease_leaseID;

    @FXML
    private TextField addLease_propertyID;

    @FXML
    private TextField addLease_rentAmount;

    @FXML
    private TextField addLease_startDate;

    @FXML
    private TextField addLease_tenantID;

    @FXML
    private TableView<Lease> addLease_tableView;

    @FXML
    private TableView<Lease> addLease_tableView1;

    @FXML
    private Button buttonAddLease;

    @FXML
    private Button buttonDisplayAllLeases;

    @FXML
    private Button buttonEndLease;

    @FXML
    private Button buttonHome;

    @FXML
    private Button close;

    @FXML
    private AnchorPane displayAllLeases_form;

    @FXML
    private AnchorPane lease_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

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

        if (event.getSource() == buttonAddLease) {
            lease_form.setVisible(true);
            displayAllLeases_form.setVisible(false);


            buttonAddLease.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonDisplayAllLeases.setStyle("-fx-background-color:transparent");


        } else if (event.getSource() == buttonDisplayAllLeases) {
            lease_form.setVisible(false);
            displayAllLeases_form.setVisible(true);


            buttonDisplayAllLeases.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonAddLease.setStyle("-fx-background-color:transparent");

        }

    }
//    private static List<Lease> leases2 = new ArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        addLease_col_leaseID.setCellValueFactory(new PropertyValueFactory<Lease, Integer>("leaseID"));
        addLease_col_propertyID.setCellValueFactory(new PropertyValueFactory<Lease, Property>("property"));
        addLease_col_tenantID.setCellValueFactory(new PropertyValueFactory<Lease, Tenant>("tenant"));
        addLease_col_startDate.setCellValueFactory(new PropertyValueFactory<Lease, LocalDate>("startDate"));
        addLease_col_endDate.setCellValueFactory(new PropertyValueFactory<Lease, LocalDate>("endDate"));
        addLease_col_rentAmount.setCellValueFactory(new PropertyValueFactory<Lease, Double>("amount"));

        addLease_col_leaseID1.setCellValueFactory(new PropertyValueFactory<Lease, Integer>("leaseID"));
        addLease_col_propertyID1.setCellValueFactory(new PropertyValueFactory<Lease, Property>("property"));
        addLease_col_tenantID1.setCellValueFactory(new PropertyValueFactory<Lease, Tenant>("tenant"));
        addLease_col_startDate1.setCellValueFactory(new PropertyValueFactory<Lease, LocalDate>("startDate"));
        addLease_col_endDate1.setCellValueFactory(new PropertyValueFactory<Lease, LocalDate>("endDate"));
        addLease_col_rentAmount1.setCellValueFactory(new PropertyValueFactory<Lease, Double>("amount"));
    }

    /**
     * Reset form fields
     */
    void resetFormFields() {
        addLease_leaseID.setText("");
        addLease_propertyID.setText("");
        addLease_tenantID.setText("");
        addLease_rentAmount.setText("");
        addLease_startDate.setText("");
        addLease_endDate.setText("");

    }

    public void addLease(ActionEvent event) {

        try {
            Alert alert;
            if (addLease_propertyID.getText().isEmpty()
                    || addLease_tenantID.getText().isEmpty()
                    || addLease_leaseID.getText().isEmpty()
                    || addLease_rentAmount.getText().isEmpty()
                    || addLease_startDate.getText().isEmpty()
                    || addLease_endDate.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                list.clear();

                list.add(addLease_propertyID.getText());
                list.add(addLease_tenantID.getText());
                list.add(addLease_leaseID.getText());
                list.add(addLease_startDate.getText());
                list.add(addLease_endDate.getText());
                list.add(addLease_rentAmount.getText());


                leaseController.addLease(list);

                addLease_tableView.setItems( FXCollections.observableList(storage.getLeases()) );

                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                resetFormFields();
            }

        } catch (Exception e) {
            e.toString();
        }
    }

    @FXML
    public void displayAllLeases() {
        addLease_tableView1.setItems( FXCollections.observableList(storage.getLeases()) );
        addLease_tableView1.refresh();
    }

    public void displayPayed(){
        leaseList.clear();
        for (Lease l: storage.getLeases()){
            if(l.getPaymentStatus()){
                leaseList.add(l);
            }
        }
        addLease_tableView1.setItems( FXCollections.observableList(leaseList) );
        addLease_tableView1.refresh();
    }

    @FXML
    void endLease(ActionEvent e) throws Exception {
        Alert alert;
        Lease selectedLease = addLease_tableView1.getSelectionModel().getSelectedItem();


        // Do nothing if there is no property selected
        if (selectedLease == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please Select a lease to end");
            alert.showAndWait();

                 }

        // Display an error popup if selected property is not available for rent
        else {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want end this lease");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("EndLeasePage.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("End Lease");
                stage.setScene(scene);
                stage.show();


                // Access the rent property view's controller
                EndLeasePageController controller = loader.getController();
                // Populate the property preview grid pane with selected property details summary
                controller.populateLeasePreview(selectedLease);
                //Allow access to the selected property from the rent view's controller
                stage.setUserData(selectedLease);

                stage.setScene(scene);
                stage.show();
            }
        }
    }

    @FXML
    void makePayment(ActionEvent e) throws Exception {
        Alert alert;
        Lease selectedLease = addLease_tableView1.getSelectionModel().getSelectedItem();


        // Do nothing if there is no property selected
        if (selectedLease == null) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please Select a Lease to pay");
            alert.showAndWait();

        }

        // Display an error popup if selected property is not available for rent
        else {

            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to pay for this lease");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("PaymentPage.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                Scene scene = new Scene(root);
                stage.setTitle("Make Payment");

                PaymentPageController controller = loader.getController();
                // Populate the property preview grid pane with selected property details summary
                controller.populatePaymentPreview(selectedLease);
                //Allow access to the selected property from the rent view's controller
                stage.setUserData(selectedLease);

                stage.setScene(scene);
                stage.show();
            }
        }
    }
}