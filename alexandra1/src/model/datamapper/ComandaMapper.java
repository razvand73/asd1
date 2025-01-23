package model.datamapper;

import model.Client;
import model.Comanda;
import model.Produs;
import model.Reclamatie;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComandaMapper {
    private static final String FILE_PATH = "src/comenzi.txt";

    public List<Comanda> getComenzi(){
        List<Comanda> comenzi = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))){
            String line;
            while ((line = br.readLine()) != null) {
                if(line.length() <= 2){
                    int id = Integer.parseInt(line.trim());
                    String nameClient = br.readLine().trim();
                    Client client = new Client(nameClient);
                    Comanda comanda = new Comanda(id,client);
                    comenzi.add(comanda);
                }
                else{
                    List<Produs> produse = new ArrayList<>();
                    String[] tokens = line.split(",");
                    int len = tokens.length;
                    for(int i = 0; i < len; i+=2){
                        String denumire = tokens[i].trim();
                        int cantitate = Integer.parseInt(tokens[i+1].trim());
                        Produs produs = new Produs(denumire, cantitate);
                        produse.add(produs);
                    }
                    comenzi.getLast().setProduseComandate(produse);
                }
            }
            return comenzi;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
