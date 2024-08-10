module com.example.footballsimulator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;


    opens com.example.footballsimulator to javafx.fxml;
    exports com.example.footballsimulator;
}