package main;

import controller.ReclamatieController;
import view.ReclamatieView;

public class Main {
    public static void main(String[] args) {
        ReclamatieView  reclamatieView = new ReclamatieView();
        ReclamatieController reclamatieController = new ReclamatieController();
        reclamatieView.setController(reclamatieController);
        reclamatieView.afiseazaMeniu();

    }
}