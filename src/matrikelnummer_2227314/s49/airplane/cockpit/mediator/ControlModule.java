package matrikelnummer_2227314.s49.airplane.cockpit.mediator;

import matrikelnummer_2227314.s49.airplane.Engine;

public class ControlModule implements IControlModule {

    private Engine engine;
    private boolean status;

    @Override
    public void registerEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Engine getEngine() {
        return engine;
    }

    @Override
    public boolean isEngineOk() {
        return status;
    }

    @Override
    public void setEngineStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        return engine + " - " + status;
    }
}
