package matrikelnummer_2227314.s49;

import matrikelnummer_2227314.s49.airplane.Airplane;

public class Application {
    public static final boolean debugMessages = false; // für mehr und genaueren Output auf true setzen
    public static void main(String... args) {
        Airplane airplane = new Airplane("Airbus A380");
        airplane.start();
    }
}
