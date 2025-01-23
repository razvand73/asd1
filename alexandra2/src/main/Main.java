package main;

import model.command.ManagerComenzi;
import presenter.SolicitarePresenter;
import view.SolicitareView;

public class Main {
    public static void main(String[] args) {
        SolicitareView sv = new SolicitareView();
        SolicitarePresenter sp = new SolicitarePresenter(sv);
        sp.ruleazaAplicatia();

    }
}