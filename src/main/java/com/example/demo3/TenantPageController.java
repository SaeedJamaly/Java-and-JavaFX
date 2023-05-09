package com.example.demo3;

//import Views.AdminView;

//import Model.Person;
import Controller.TenantController;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TenantPageController implements Initializable {


    public static DataStorage storage = new DataStorage();
    public static TenantController tenantController = new TenantController();


    @FXML
    private Button addTenant_addBtn;

    @FXML
    private Button addTenant_clearBtn;

    @FXML
    private TableView<Tenant> tableView;

    @FXML
    private TableColumn<Tenant, Integer> addTenant_col_TenantID;

    @FXML
    private TableColumn<Tenant, Integer> addTenant_col_TenantID1;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_email;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_email1;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_firstName;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_firstName1;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_lastName;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_lastName1;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_phoneNmb;

    @FXML
    private TableColumn<Tenant, String> addTenant_col_phoneNmb1;

    @FXML
    private Button addTenant_deleteBtn;

    @FXML
    private Button addTenant_displayBtn;

    @FXML
    private TableView<Tenant> addTenant_tableView;

    @FXML
    private TableView<Tenant> addTenant_tableView1;

    @FXML
    private TextField addTenant_tenantID;

    @FXML
    private TextField addTenant_firstName;

    @FXML
    private TextField addTenant_lastName;

    @FXML
    private TextField addTenant_phoneNmb;

    @FXML
    private TextField addTenant_email;

    @FXML
    private Button buttonAddTenant;

    @FXML
    private Button buttonDisplayAllTenants;

    @FXML
    private Button buttonHome;

    @FXML
    private Button close;

    @FXML
    private AnchorPane displayAllTenants_form;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button minimize;

    @FXML
    private AnchorPane tenant_form;

    @FXML
    private Label username;


//    @FXML
//    void addEmployeeSearch(KeyEvent event) {
//
//    }

//    @FXML
//    void addEmployeeSelect(MouseEvent event) {
//
//    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);
    }


    private double x = 0;
    private double y = 0;

    public void backToHomeMenu()  {
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
} catch (Exception e){e.printStackTrace();}
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == buttonAddTenant) {
            tenant_form.setVisible(true);
            displayAllTenants_form.setVisible(false);


            buttonAddTenant.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonDisplayAllTenants.setStyle("-fx-background-color:transparent");


        } else if (event.getSource() == buttonDisplayAllTenants) {
            tenant_form.setVisible(false);
            displayAllTenants_form.setVisible(true);


            buttonDisplayAllTenants.setStyle("-fx-background-color:linear-gradient(to bottom right, #3a4368, #28966c);");
            buttonAddTenant.setStyle("-fx-background-color:transparent");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // addTenantList = addEmployeeListData();

        addTenant_col_TenantID.setCellValueFactory(new PropertyValueFactory<Tenant,Integer>("ID"));
        addTenant_col_firstName.setCellValueFactory(new PropertyValueFactory<Tenant,String>("firstName"));
        addTenant_col_lastName.setCellValueFactory(new PropertyValueFactory<Tenant,String>("lastName"));
        addTenant_col_email.setCellValueFactory(new PropertyValueFactory<Tenant,String>("email"));
        addTenant_col_phoneNmb.setCellValueFactory(new PropertyValueFactory<Tenant,String>("phoneNumber"));

        addTenant_col_TenantID1.setCellValueFactory(new PropertyValueFactory<Tenant,Integer>("ID"));
        addTenant_col_firstName1.setCellValueFactory(new PropertyValueFactory<Tenant,String>("firstName"));
        addTenant_col_lastName1.setCellValueFactory(new PropertyValueFactory<Tenant,String>("lastName"));
        addTenant_col_email1.setCellValueFactory(new PropertyValueFactory<Tenant,String>("email"));
        addTenant_col_phoneNmb1.setCellValueFactory(new PropertyValueFactory<Tenant,String>("phoneNumber"));

    }

    @FXML
    public void addTenant(ActionEvent event) {

        try {
            Alert alert;
            if (addTenant_tenantID.getText().isEmpty()
                    || addTenant_firstName.getText().isEmpty()
                    || addTenant_lastName.getText().isEmpty()
                    || addTenant_email.getText().isEmpty()
                    || addTenant_phoneNmb.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                Tenant tenant = new Tenant(Integer.parseInt(addTenant_tenantID.getText()), addTenant_firstName.getText(), addTenant_lastName.getText(), addTenant_phoneNmb.getText(), addTenant_email.getText());

                storage.getTenants().add(tenant);

                addTenant_tableView.setItems( FXCollections.observableList(storage.getTenants()) );


                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Added!");
                alert.showAndWait();

                resetFormFields();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteTenant(ActionEvent event)
    {
        Tenant selectedTenant = addTenant_tableView.getSelectionModel().getSelectedItem();
        tenantController.remove(selectedTenant.getID());
        addTenant_tableView.refresh();
    }

    /**
     * Reset form fields
     */
    void resetFormFields() {
        addTenant_email.setText("");
        addTenant_phoneNmb.setText("");
        addTenant_firstName.setText("");
        addTenant_lastName.setText("");
        addTenant_tenantID.setText("");
    }

    @FXML
    public void displayAllTenants() {
        addTenant_tableView1.setItems( FXCollections.observableList(storage.getTenants()) );
        addTenant_tableView1.refresh();
    }
}
