package view;

import model.Client;
import model.Reclamatie;
import controller.ReclamatieController;
import model.state.ReclamatiaInregistrataState;
import model.state.ReclamatieInAnalizaState;
import model.state.ReclamatieSolutionataState;
import model.state.ReclamatieState;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReclamatieView {
    private ReclamatieController controller;
    private static Map<String, ReclamatieState> stateMap = Map.of(
            "Inregistrata", new ReclamatiaInregistrataState(),
            "Solutionata", new ReclamatieSolutionataState(),
            "In analiza", new ReclamatieInAnalizaState()
    );
    public void afiseazaMeniu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Meniu Reclamatie ===");
            System.out.println("1. Vizualizeaza solicitarile");
            System.out.println("2. Cauta reclamatie dupa ID");
            System.out.println("3. Filtreaza dupa stare");
            System.out.println("4. Modifica solcitarea");
            System.out.println("0. Ieșire");
            System.out.print("Alege o opțiune: ");
            int optiune = Integer.parseInt(scanner.nextLine());
            switch (optiune) {
                case 1 -> vizualizeazaSolicitarile();
                case 2 -> cautaSolicitarea();
                case 3 -> filtreazaSolicitarea();
                case 4 -> modificaSolicitarea();
                case 0 -> {
                    System.out.println("La revedere!");
                    return;
                }
                default -> System.out.println("Opțiune invalidă!");
            }
        }
    }

    private void filtreazaSolicitarea() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            System.out.println("\n=== Filtreaza solicitarea ===");
            System.out.print("Introdu starea reclamatiei(In analiza, Solutionata, Inregistrata): ");

            String stareaReclamatiei = scanner.nextLine();
            if(stateMap.containsKey(stareaReclamatiei)){
                validInput = true;
                List<Reclamatie> solicitari = controller.getSolicitari();
                for (Reclamatie reclamatie : solicitari) {
                    if(reclamatie.getState().getClass().equals(stateMap.get(stareaReclamatiei).getClass())){
                        System.out.println(reclamatie);
                    }
                }
            }
            else {
                System.out.println("Input invalid. Vă rugăm introduceți o stare validă.");
            }
        }

    }

    private void vizualizeazaSolicitarile() {
        List<Reclamatie> solicitari = controller.getSolicitari();
        for (Reclamatie reclamatie : solicitari) {
            System.out.println(reclamatie);
            reclamatie.getState().handleReclamatie(reclamatie);
        }
    }

    private Reclamatie cautaSolicitarea() {
        int id = -1;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);
        while (!validInput) {
            System.out.print("Introduceți un ID valid (număr întreg): ");
            if (scanner.hasNextInt()) {
                id = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Input invalid. Vă rugăm să introduceți un număr întreg.");
                scanner.next();
            }
        }
        Reclamatie reclamatie = controller.cautaReclamatia(id);
        if(reclamatie != null) {
            System.out.println(reclamatie);
            reclamatie.getState().handleReclamatie(reclamatie);
            return reclamatie;
        }
        else{
            System.out.println("Nu s-a găsit nicio reclamație cu ID-ul: " + id);
        }
        return null;
    }

    private void modificaSolicitarea() {
        Reclamatie reclamatie = cautaSolicitarea();
        if (reclamatie != null) {
            boolean validInput = false;
            Scanner scanner = new Scanner(System.in);

            while (!validInput) {
                System.out.print("Noua stare a comenzii (ex: In analiza, Inregistrata, Solutionata): ");
                String starea = scanner.nextLine();

                if (stateMap.containsKey(starea)) {
                    validInput = true;
                    reclamatie.setState(stateMap.get(starea));
                    reclamatie.salveazaReclamatie(starea);
                    ReclamatieController.setReclamatii(null);
                } else {
                    System.out.println("Input invalid. Vă rugăm introduceți o stare validă.");
                }
            }
        }
    }


    public void setController(ReclamatieController controller) {
        this.controller = controller;
    }
}
