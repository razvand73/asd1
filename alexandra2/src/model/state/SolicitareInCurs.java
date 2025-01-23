package model.state;

import model.clase.Solicitare;

public class SolicitareInCurs implements Stare{
    @Override
    public void handleSolicitare(Solicitare solicitare) {
        System.out.println("Echipa plecata spre client, solicitarea este in curs de rezolvare");
    }
}
