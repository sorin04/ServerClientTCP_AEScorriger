package com.astier.bts.client.modeles;

import java.net.InetAddress;

public class Connexion {
    private InetAddress adresseServeur;
    private int portTCP,portUDP;

    public Connexion(InetAddress adresseServeur, int portTCP, int portUDP) {
        this.adresseServeur = adresseServeur;
        this.portTCP = portTCP;
        this.portUDP = portUDP;
    }

    public InetAddress getAdresseServeur() {
        return adresseServeur;
    }

    public void setAdresseServeur(InetAddress adresseServeur) {
        this.adresseServeur = adresseServeur;
    }

    public int getPortTCP() {
        return portTCP;
    }

    public void setPortTCP(int portTCP) {
        this.portTCP = portTCP;
    }

    public int getPortUDP() {
        return portUDP;
    }

    public void setPortUDP(int portUDP) {
        this.portUDP = portUDP;
    }
}
