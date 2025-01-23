package model.datamapper;

import model.Client;
import model.Comanda;
import model.Reclamatie;
import model.state.ReclamatiaInregistrataState;
import model.state.ReclamatieInAnalizaState;
import model.state.ReclamatieSolutionataState;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReclamatieMapper {
    private static final String FILE_PATH = "src/reclamatii.txt";
    private static List<Reclamatie> listaReclamati = new ArrayList<>();

    public void salveazaReclamatieState(Reclamatie reclamatie, String stare) {
        List<String> fileLines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line.trim());
                fileLines.add(line);
                String descriere = br.readLine();
                fileLines.add(descriere);
                fileLines.add(br.readLine());
                String status = br.readLine();
                if (id == reclamatie.getId()) {
                    fileLines.add(stare);
                    found = true;
                    listaReclamati.clear();
                } else {
                    fileLines.add(status);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Eroare la citirea fișierului: " + e.getMessage(), e);
        }

        if (found) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (String fileLine : fileLines) {
                    bw.write(fileLine);
                    bw.newLine();
                }
                listaReclamati = incarcaReclamatii();
            } catch (IOException e) {
                throw new RuntimeException("Eroare la scrierea fișierului: " + e.getMessage(), e);
            }
        }
    }


    public List<Reclamatie> incarcaReclamatii() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line.trim());
                String descriere = br.readLine().trim();
                int idComanda = Integer.parseInt(br.readLine().trim());
                Reclamatie reclamatie = new Reclamatie(id, descriere, idComanda);
                String stare = br.readLine().trim();
                if(stare.equals("Inregistrata")){
                    reclamatie.setState(new ReclamatiaInregistrataState());
                }
                else if(stare.equals("Solutionata")){
                    reclamatie.setState(new ReclamatieSolutionataState());
                }
                else if(stare.equals("In analiza")){
                    reclamatie.setState(new ReclamatieInAnalizaState());
                }
                ComandaMapper comandaMapper = new ComandaMapper();
                var comenzi = comandaMapper.getComenzi();
                for(Comanda comanda : comenzi){
                    if(comanda.getId() == idComanda){
                        reclamatie.addObserver(comanda.getClient());
                        break;
                    }
                }
                listaReclamati.add(reclamatie);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listaReclamati;
    }

}