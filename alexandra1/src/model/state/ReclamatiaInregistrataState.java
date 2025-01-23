package model.state;

import model.Reclamatie;

public class ReclamatiaInregistrataState implements ReclamatieState {
    @Override
    public void handleReclamatie(Reclamatie reclamatie) {
        System.out.println("Reclamația cu id-ul " + reclamatie.getId() +  " este inregistrata.");
    }
}
