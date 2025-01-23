package model.command;

import model.clase.Angajat;
import model.clase.Solicitare;
import model.state.Stare;

public class ComandaDeplasare implements Comanda {
    private Angajat angajat;
    private Solicitare solicitare;

    public ComandaDeplasare(Angajat angajat,String problema, String locatie, Stare stare) {
        this.angajat = angajat;
        this.solicitare = new Solicitare(locatie, problema,stare);
    }

    public Solicitare getSolicitare() {
        return solicitare;
    }

    @Override
    public void execute() {
        this.angajat.preiaSolicitarea(this.solicitare);
    }
}
