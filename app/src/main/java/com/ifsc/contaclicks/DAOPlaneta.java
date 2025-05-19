package com.ifsc.contaclicks;

import java.util.ArrayList;

public class DAOPlaneta {
    public ArrayList<Planeta> listplanetas;

    public DAOPlaneta() {
        listplanetas = new ArrayList<>();

        String[] nomes = {"Mercúrio", "Vênus", "Terra", "Marte", "Júpiter", "Saturno", "Urano", "Netuno"};
        Integer[] fotos = {
                R.drawable.mercury, R.drawable.venus, R.drawable.earth,
                R.drawable.mars, R.drawable.jupter, R.drawable.saturn,
                R.drawable.uranus, R.drawable.neptune
        };

        for (int i = 0; i < nomes.length; i++) {
            listplanetas.add(new Planeta(nomes[i], fotos[i]));
        }
    }
}
