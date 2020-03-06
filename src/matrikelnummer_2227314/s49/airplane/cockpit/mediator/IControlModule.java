package matrikelnummer_2227314.s49.airplane.cockpit.mediator;

import matrikelnummer_2227314.s49.airplane.Engine;

public interface IControlModule {
    void registerEngine(Engine engine);
    Engine getEngine();
    boolean isEngineOk();
    void setEngineStatus(boolean status);
}
