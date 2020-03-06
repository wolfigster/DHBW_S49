package matrikelnummer_2227314.s49.airplane.cockpit;

import matrikelnummer_2227314.s49.airplane.cockpit.command.IPilotCommand;
import matrikelnummer_2227314.s49.airplane.cockpit.command.Pilot;

public class Cockpit {

    private Pilot pilot;
    private IPilotCommand pilotCommand;
    private BordComputer bordComputer;

    public Cockpit(Pilot pilot) {
        this.pilot = pilot;
    }

    public void setPilotCommand(IPilotCommand pilotCommand) {
        this.pilotCommand = pilotCommand;
    }

    public void pressButton() {
        System.out.println("--- Pilot pressed button");
        pilotCommand.execute();
    }

    public void setBordComputer(BordComputer bordComputer) {
        this.bordComputer = bordComputer;
    }

    public BordComputer getBordComputer() {
        return bordComputer;
    }

    public String toString() {
        return "Your pilot for today's flight is " + pilot.getName();
    }

    public Pilot getPilot() {
        return pilot;
    }
}
