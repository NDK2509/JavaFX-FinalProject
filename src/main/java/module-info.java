module com.example.kynguyenpnv23_finalproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.kynguyen_pnv23_finalproject to javafx.fxml;
    exports com.example.kynguyen_pnv23_finalproject;
}