package matrikelnummer_2227314.s49.airplane;

import matrikelnummer_2227314.s49.airplane.cockpit.BordComputer;
import matrikelnummer_2227314.s49.airplane.cockpit.Cockpit;
import matrikelnummer_2227314.s49.airplane.cockpit.command.Pilot;

public class Airplane {

    private String name;
    private BordComputer bordComputer;
    private Cockpit cockpit;
    private Pilot pilot;

    public Airplane(String name) {
        this.name = name;
        this.bordComputer = new BordComputer();
        this.pilot = new Pilot("Carsten Müller");
        this.cockpit = new Cockpit(pilot);
        cockpit.setBordComputer(bordComputer);
    }

    public void start() {
        System.out.println(cockpit.toString());
        pilot.setCockpit(cockpit);
        pilot.startSimulation();
    }
}
