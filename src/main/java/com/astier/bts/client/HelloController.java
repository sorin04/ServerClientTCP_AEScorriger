package com.astier.bts.client;



import com.astier.bts.client.tcp.TCP;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.scene.paint.Color.*;

public class HelloController implements Initializable {
    public Button button;
    public Button connecter;
    public Button deconnecter;
    public TextField textFieldIP;
    public TextField textFieldPort;
    public TextField textFieldRequette;
    public Circle voyant;
    public TextArea textAreaReponses;
    public TCP tcp;
    static boolean enRun = false;
    String adresse, port;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(event -> {
            try {
                envoyer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        connecter.setOnAction(event -> {
            try {
                connecter();
            } catch (UnknownHostException e) {
                throw new RuntimeException(e);
            }
        });
        deconnecter.setOnAction(event -> {
            try {
                deconnecter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        voyant.setFill(RED);

    }


    private void envoyer() throws InterruptedException {
        String requette = textFieldRequette.getText();
        if (requette.equalsIgnoreCase("exit")) {
            tcp.deconnection();
        }
        if (!requette.isEmpty()) {
            try {
                tcp.requette(requette);
            } catch (IOException ex) {
                Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private void deconnecter() throws InterruptedException {
        if (enRun) {
            tcp.deconnection();
            enRun = false;
        }
    }

    private void connecter() throws UnknownHostException {
        String adresseDuServeur = textFieldIP.getText();
        String portDuServeur = textFieldPort.getText();
        //instance de objet avec constructeurs @IP et prot du serveur ssi ils existent
        if (!adresseDuServeur.isEmpty() && !portDuServeur.isEmpty()) {
            if (!enRun) {
                tcp = new TCP(InetAddress.getByName(adresseDuServeur), Integer.parseInt(portDuServeur), this);
                tcp.connection();
                voyant.setFill(LIME);
                enRun = true;
            }
        }
    }


}