package presenter;

import model.command.ManagerComenzi;
import view.SolicitareView;

import java.util.Scanner;

public class SolicitarePresenter {
    private SolicitareView view;

    public SolicitarePresenter(SolicitareView view) {
        this.view = view;
    }

    public void ruleazaAplicatia(){
        while(true){
            view.afisareMeniu();
            String input = view.obtineInputUtilizator();
            switch(input){
                case "1" -> afiseazaSolicitari();
                case "2" -> cautaSolicitare();
                case "3" -> filtreazaSolicitari();
                case "4" -> modificaSolicitare();
                case "0" -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Optiune invalida!");

            }

        }
    }


    public void afiseazaSolicitari(){
        var solicitari = ManagerComenzi.preluareComenzi();
        for(var s : solicitari){
            System.out.println(s);
        }
    }
    public void cautaSolicitare(){}

    private void modificaSolicitare() {
    }

    private void filtreazaSolicitari() {
    }

}
