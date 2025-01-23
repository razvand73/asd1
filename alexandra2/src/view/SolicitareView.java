package view;

import java.util.Scanner;

public class SolicitareView {
    private Scanner scanner;

    public SolicitareView() {
        this.scanner = new Scanner(System.in);
    }

    public void afisareMeniu(){
        System.out.println(" \n=== Meniu Solicitari ===");
        System.out.println("1: Vizualizeaza solicitarile");
        System.out.println("2: Cauta solicitare dupa ID ");
        System.out.println("3: Filtreaza dupa stare ");
        System.out.println("4: Modifica starea solicitarii");
        System.out.println("0: Inchide");
        System.out.print("Alege o optiune: ");
    }

    public String obtineInputUtilizator(){
        return scanner.nextLine();
    }
}
