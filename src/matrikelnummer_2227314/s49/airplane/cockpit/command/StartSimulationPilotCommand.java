package matrikelnummer_2227314.s49.airplane.cockpit.command;

import matrikelnummer_2227314.s49.airplane.cockpit.BordComputer;

public class StartSimulationPilotCommand implements IPilotCommand {

    BordComputer bordComputer;

    public StartSimulationPilotCommand(BordComputer bordComputer) {
        this.bordComputer = bordComputer;
    }

    @Override
    public void execute() {
        bordComputer.startSimulation();
    }
}
