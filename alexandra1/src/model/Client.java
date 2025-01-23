package model;

import model.observer.Observer;

//obsrvator concret
public class Client implements Observer {
    private String nume;

    public Client(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Override
    public void update(String mesaj) {
        System.out.println(nume + " a primit notificarea: " + mesaj);
    }
}
