package model;

public class Produs {
    private String denumireProdus;
    private int cantitateProdus;

    public Produs(String denumireProdus, int cantitateProdus) {
        this.denumireProdus = denumireProdus;
        this.cantitateProdus = cantitateProdus;
    }

    public String getDenumireProdus() {
        return denumireProdus;
    }

    public void setDenumireProdus(String denumireProdus) {
        this.denumireProdus = denumireProdus;
    }

    public int getCantitateProdus() {
        return cantitateProdus;
    }

    public void setCantitateProdus(int cantitateProdus) {
        this.cantitateProdus = cantitateProdus;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "denumireProdus='" + denumireProdus + '\'' +
                ", cantitateProdus=" + cantitateProdus +
                '}';
    }

}
