module com.example.kynguyenpnv23_finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;

    opens com.example.kynguyen_pnv23_finalproject to javafx.fxml;
    opens com.example.kynguyen_pnv23_finalproject.models to javafx.base;
    exports com.example.kynguyen_pnv23_finalproject;
}