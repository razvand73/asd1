package model.command;

import model.clase.Angajat;
import model.clase.Client;
import model.clase.Solicitare;
import model.state.SolicitareAcceptata;
import model.state.SolicitareInCurs;
import model.state.SolicitareTransmisa;
import model.state.Stare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//Active Record
public class ManagerComenzi {
    private static List<Comanda> comenzi = new ArrayList<Comanda>();
    private static final String FILE_PATH = "src/comenzi.txt";
    private final static Map<String, Stare> stariMap =Map.of(
            "Acceptata", new SolicitareAcceptata(),
            "In curs", new SolicitareInCurs(),
            "Transmisa", new SolicitareTransmisa()
            );
    public static void adaugaComanda(Comanda comanda) {
        comenzi.add(comanda);
    }

    public static void proceseazaComenzi(){
        for (Comanda comanda : comenzi) {
            comanda.execute();
        }
        comenzi.clear();
    }

    public static List<Solicitare> preluareComenzi(){
        List<Solicitare> solicitari = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while((line = br.readLine()) != null){
                List<String> tokens = Arrays.asList(line.split(","));
                int id = Integer.parseInt(tokens.get(0));
                String numeClient = tokens.get(1);
                String locatie = tokens.get(2);
                String problema = tokens.get(3);
                String numeAngajat = tokens.get(4);
                String stareSolicitare = tokens.get(5);
                Client client = new Client(numeClient);
                Angajat angajat = new Angajat(numeAngajat);
                if(stariMap.containsKey(stareSolicitare)){
                    ComandaDeplasare comanda = (ComandaDeplasare) client.creazaComanda(problema,locatie, angajat,
                            stariMap.get(stareSolicitare));
                    Solicitare solicitare = comanda.getSolicitare();
                    solicitare.setId(id);
                    solicitari.add(solicitare);
                    ManagerComenzi.adaugaComanda(comanda);
                }
            }
            ManagerComenzi.proceseazaComenzi();
            return solicitari;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
