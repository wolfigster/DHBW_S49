package matrikelnummer_2227314.s49.airplane.enginestages;

public class AirIntake {

    public String inhale(String airflow) {
        return airflow.replaceAll("aa", "2a").replaceAll("bb", "2b");
    }
}
