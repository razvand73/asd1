package controller;

import model.Reclamatie;
import model.datamapper.ReclamatieMapper;

import java.util.ArrayList;
import java.util.List;

public class ReclamatieController {
    private static List<Reclamatie> reclamatii;
    private static final ReclamatieMapper mapper = new ReclamatieMapper();
    public List<Reclamatie> getSolicitari(){
        if(reclamatii != null){
            reclamatii.clear();
        }
        reclamatii = mapper.incarcaReclamatii();
        return reclamatii;
    }

    public Reclamatie cautaReclamatia(int id) {
        if(reclamatii == null){
            reclamatii = mapper.incarcaReclamatii();
        }
        for (Reclamatie r : reclamatii) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    public static void setReclamatii(List<Reclamatie> reclamatii) {
        ReclamatieController.reclamatii = reclamatii;
    }
}
