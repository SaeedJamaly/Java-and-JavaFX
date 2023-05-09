package com.example.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    TenantPageController tenantPageController;
    PropertyPageController propertyPageController;
    LeasePageController leasePageController;

    public HomeController(){
        this.tenantPageController = new TenantPageController();
        this.propertyPageController = new PropertyPageController();
        this.leasePageController = new LeasePageController();
    }
    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonLeaseMain;

    @FXML
    private Button buttonPaymentMain;

    @FXML
    private Button buttonPropertyMain;

    @FXML
    private Button buttonTenantMain;

    @FXML
    private AnchorPane homeMainForm;

    public void close(){
        System.exit(0);
    }

    private double x = 0;
    private double y = 0;

    public void tenantMainMenu() {

    try {
    buttonTenantMain.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("TenantPage.fxml"));
    Stage stage = new Stage();
    Scene scene = new Scene(root);
    stage.setTitle("Tenant");
    stage.setScene(scene);
    stage.show();

    root.setOnMousePressed((MouseEvent event) -> {
        x = event.getSceneX();
        y = event.getSceneY();
    });
    } catch(Exception e){e.printStackTrace();}

                }

    public void propertyMainMenu() {

        try {
            buttonPropertyMain.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("PropertyPage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Property");
            stage.setScene(scene);
            stage.show();

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
        } catch(Exception e){e.printStackTrace();}

    }

    public void leaseMainMenu() {

        try {
            buttonLeaseMain.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("LeasePage.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setTitle("Lease");
            stage.setScene(scene);
            stage.show();

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });
        } catch(Exception e){e.printStackTrace();}

    }
}