package matrikelnummer_2227314.s49.airplane;

import matrikelnummer_2227314.s49.airplane.cockpit.BordComputer;
import matrikelnummer_2227314.s49.airplane.cockpit.Cockpit;
import matrikelnummer_2227314.s49.airplane.cockpit.command.Pilot;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.ControlModule;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.IControlModule;

import java.util.ArrayList;
import java.util.List;

public class Airplane {

    private String name;
    private BordComputer bordComputer;
    private Cockpit cockpit;
    private Pilot pilot;
    private List<Engine> engines;
    private List<IControlModule> controlModules;

    public Airplane(String name) {
        this.name = name;

        engines = new ArrayList<>();
        controlModules = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            IControlModule controlModule = new ControlModule();
            Engine engine = new Engine(controlModule, EngineType.ROLLS_ROYCE_TRENT_900);
            controlModule.registerEngine(engine);
            controlModules.add(controlModule);
            engines.add(engine);
        }
        this.pilot = new Pilot("Carsten Müller");
        this.cockpit = new Cockpit(pilot);
        this.bordComputer = new BordComputer(this.cockpit, controlModules, engines);
        cockpit.setBordComputer(bordComputer);
    }

    public void start() {
        System.out.println(cockpit.toString());
        pilot.setCockpit(cockpit);
        pilot.startSimulation();

        for(Engine engine : engines) {
            System.out.println(engine.toString());
        }
    }

    public String getName() {
        return name;
    }

    public BordComputer getBordComputer() {
        return bordComputer;
    }

    public Cockpit getCockpit() {
        return cockpit;
    }

    public Pilot getPilot() {
        return pilot;
    }
}
