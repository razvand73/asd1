package model.clase;

public class Angajat {
    private String nume;

    public Angajat(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void preiaSolicitarea(Solicitare solicitare) {
        System.out.println("Angajatul " + nume + " a preluat solicitarea si a transmis o cerere de " +
                "deplasare la " + solicitare.getLocatie());
    }
}
