package model.state;

import model.clase.Solicitare;

public class SolicitareTransmisa implements Stare {

    @Override
    public void handleSolicitare(Solicitare solicitare) {
        System.out.println("Solicitare transmisa.");    }
}
