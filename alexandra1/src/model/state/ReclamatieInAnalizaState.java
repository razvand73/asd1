package model.state;

import model.Reclamatie;

public class ReclamatieInAnalizaState implements ReclamatieState {
    @Override
    public void handleReclamatie(Reclamatie reclamatie) {
        System.out.println("Reclamația cu id-ul " + reclamatie.getId() + " este in analiza.");
    }
}
