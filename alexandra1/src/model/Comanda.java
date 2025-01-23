package model;

import java.util.List;

public class Comanda {
    private int id;
    private Client client;
    private List<Produs> produseComandate;

    public Comanda(int id, Client client) {
        this.id = id;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Produs> getProduseComandate() {
        return produseComandate;
    }

    public void setProduseComandate(List<Produs> produseComandate) {
        this.produseComandate = produseComandate;
    }
}
