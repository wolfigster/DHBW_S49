package matrikelnummer_2227314.s49.airplane.enginestages;

import matrikelnummer_2227314.s49.Application;

public class Exhaust {

    public String eject(String airflow, double rpm) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < rpm * 0.4; i++) {
            stringBuilder.append("s");
        }
        return (Application.debugMessages) ? rpm * 0.4 + "x " + stringBuilder.toString() : stringBuilder.toString();
    }
}
