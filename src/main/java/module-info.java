module com.example.demo3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires fontawesomefx;
    requires java.xml;

    opens com.example.demo3 to javafx.fxml;
    opens Model to javafx.fxml;
   // opens Model.Tenant to javafx.fxml;

    exports com.example.demo3;
    exports Model;
    exports SetDemo;
    opens SetDemo to javafx.fxml;
    //exports Model.Tenant;
}