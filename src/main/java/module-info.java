module com.astier.bts.client {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires com.google.gson;
    requires googleauth;
    requires org.apache.commons.codec;


    opens com.astier.bts.client to javafx.fxml;
    exports com.astier.bts.client;
}