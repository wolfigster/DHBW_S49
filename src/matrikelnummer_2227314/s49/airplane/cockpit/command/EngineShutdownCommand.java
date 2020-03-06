package matrikelnummer_2227314.s49.airplane.cockpit.command;

import matrikelnummer_2227314.s49.airplane.Engine;

public class EngineShutdownCommand implements IPilotCommand {

    private Engine engine;

    public EngineShutdownCommand(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void execute() {
        engine.shutdown();
    }
}
