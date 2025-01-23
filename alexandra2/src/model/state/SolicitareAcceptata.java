package model.state;

import model.clase.Solicitare;

public class SolicitareAcceptata implements Stare {
    @Override
    public void handleSolicitare(Solicitare solicitare) {
        System.out.println("Solicitare acceptata, echipa este disponibila.");
    }
}
