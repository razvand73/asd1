package model.clase;

import model.observer.Observer;
import model.observer.Subject;
import model.state.Stare;

import java.util.List;

//Context
//Subiect
public class Solicitare implements Subject {
    private int id;
    private String locatie;
    private String problema;
    private Stare stareSolicitare;
    private List<Observer> observers;

    public Solicitare(String locatie, String problema, Stare stareSolicitare) {
        this.locatie = locatie;
        this.problema = problema;
        this.stareSolicitare = stareSolicitare;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }

    public Stare getStareSolicitare() {
        return stareSolicitare;
    }

    public void setStareSolicitare(Stare stareSolicitare) {
        this.stareSolicitare = stareSolicitare;
        notifyObservers("Solicitarea a trecut in starea " + stareSolicitare.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return "Solicitare{" +
                "id=" + id +
                ", locatie='" + locatie + '\'' +
                ", problema='" + problema + '\'' +
                ", stareSolicitare=" + stareSolicitare.getClass().getSimpleName() +
                '}';
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
