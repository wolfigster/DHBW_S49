package matrikelnummer_2227314.s49.airplane.enginestages;

import matrikelnummer_2227314.s49.airplane.Impeller;

import java.util.ArrayList;
import java.util.List;

public abstract class Compression {

    private List<Impeller> impellers;

    public abstract String compress(String airflow);

    public Compression(int amountImpeller) {
        impellers = new ArrayList<>();
        for(int i = 0; i < amountImpeller; i++) {
            impellers.add(new Impeller());
        }
    }

    public List<Impeller> getImpellers() {
        return impellers;
    }
}
