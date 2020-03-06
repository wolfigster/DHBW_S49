package matrikelnummer_2227314.s49.airplane.cockpit.command;

import matrikelnummer_2227314.s49.airplane.Engine;
import matrikelnummer_2227314.s49.airplane.cockpit.Cockpit;

public class Pilot {

    private String name;
    private Cockpit cockpit;

    public Pilot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCockpit(Cockpit cockpit) {
        this.cockpit = cockpit;
    }

    public void startSimulation() {
        cockpit.setPilotCommand(new StartSimulationPilotCommand(cockpit.getBordComputer()));
        cockpit.pressButton();
    }

    public void shutdownEngine(Engine engine) {
        //TODO HIER MUSS NOCH WAS GEMACHT WERDEN DER COMMAND FALLS EIN TRIEBWERK AUSFÄLLT MUSS DER PILOT DIE KACKE AUSSCHALTEN
        cockpit.setPilotCommand(new EngineShutdownCommand(engine));
        cockpit.pressButton();
    }

}
