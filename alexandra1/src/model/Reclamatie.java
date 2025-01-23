package model;

import model.datamapper.ComandaMapper;
import model.datamapper.ReclamatieMapper;
import model.observer.Observer;
import model.state.ReclamatieState;

import java.util.ArrayList;
import java.util.List;

//Subiectul
public class Reclamatie {
    private int id;
    private String descriere;
    private ReclamatieState state;
    private List<Observer> observers;
    private int idComanda;
    public Reclamatie(int id, String descriere, Integer idComanda) {
        this.id = id;
        this.descriere = descriere;
        this.observers = new ArrayList<>();
        this.idComanda = idComanda;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public Observer getObserver() {
      return observers.getLast();
    }

    public void setState(ReclamatieState state) {
        this.state = state;
        notifyObservers("Reclamatia a trecut in starea: " + state.getClass().getSimpleName());
    }

    public void salveazaReclamatie(String state) {
        ReclamatieMapper mapper = new ReclamatieMapper();
        mapper.salveazaReclamatieState(this, state);
    }

    public ReclamatieState getState() {
        return state;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        ComandaMapper comandaMapper = new ComandaMapper();
        var comenzi = comandaMapper.getComenzi();
        List<Produs> produse = new ArrayList<>();
        Client client = new Client("");
        for(Comanda comanda : comenzi){
            if(comanda.getId() == idComanda){
               produse = comanda.getProduseComandate();
               client = comanda.getClient();
            }
        }

        return "Reclamatie{" +
                "id=" + id +
                ", descriere='" + descriere + '\'' +
                ", Produse: " + produse +
                ", Client: " + client.getNume();
    }
}
