package model.clase;

import model.command.Comanda;
import model.command.ComandaDeplasare;
import model.observer.Observer;
import model.state.Stare;

//observator concret
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

    public Comanda creazaComanda(String problema, String locatie, Angajat angajatResponsabil, Stare stare) {
        System.out.println("Clientul " + nume + " a descris problema: " + problema + " " +
                " la " + locatie);
        return new ComandaDeplasare(angajatResponsabil, problema, locatie, stare);
    }

    @Override
    public void update(String mesaj) {
        System.out.println("Clientul " + nume + " a primit notificare: " + mesaj);
    }
}
