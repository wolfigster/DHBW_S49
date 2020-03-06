package matrikelnummer_2227314.s49.airplane;

import matrikelnummer_2227314.s49.Application;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.IControlModuleCommand;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.IControlModule;
import matrikelnummer_2227314.s49.airplane.enginestages.*;

public class Engine implements IControlModuleCommand {

    private IControlModule controlModule;
    private EngineType engineType;
    private double rpm;
    private double maxRPM;
    private boolean isOn;

    private AirIntake airIntake1 = new AirIntake();
    private AirIntake airIntake2 = new AirIntake();
    private CompressionI compressionI = new CompressionI();
    private CompressionII compressionII = new CompressionII();
    private CompressionIII compressionIII = new CompressionIII();
    private Combustion combustion = new Combustion();
    private Exhaust exhaust = new Exhaust();

    private String airflow = "aaaabbaabbbbaa";

    public Engine(IControlModule controlModule, EngineType engineType) {
        this.rpm = 0;
        this.maxRPM = 2550;
        this.controlModule = controlModule;
        this.engineType = engineType;
        this.isOn = true;
        controlModule.setEngineStatus(true);
    }

    @Override
    public void increaseRPM(double rpm) {
        if(isOn) this.rpm += rpm;
        simulateAirflow(rpm);
    }

    @Override
    public void decreaseRPM(double rpm) {
        if(isOn) this.rpm -= rpm;
        simulateAirflow(rpm);
    }

    private void simulateAirflow(double rpm) {
        if(Application.debugMessages) System.out.println(this.toString());
        if(rpm >= 60) {
            String airflow1 = airIntake1.inhale(airflow);
            String airflow2 = airIntake2.inhale(airflow);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow1: " + airflow1);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow2: " + airflow2);
            airflow1 = compressionI.compress(airflow1);
            airflow2 = compressionI.compress(airflow2);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow1: " + airflow1);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow2: " + airflow2);
            airflow1 = compressionII.compress(airflow1);
            airflow2 = compressionII.compress(airflow2);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow1: " + airflow1);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow2: " + airflow2);
            airflow1 = compressionIII.compress(airflow1);
            airflow2 = compressionIII.compress(airflow2);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow1: " + airflow1);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow2: " + airflow2);
            airflow1 = combustion.ignite(airflow1);
            airflow2 = combustion.ignite(airflow2);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow1: " + airflow1);
            if(Application.debugMessages) System.out.println("Engine " + hashCode() + " : airflow2: " + airflow2);
            airflow1 = exhaust.eject(airflow1, this.rpm);
            airflow2 = exhaust.eject(airflow2, this.rpm);
            System.out.println("Engine " + hashCode() + ": airflow1: " + airflow1);
            System.out.println("Engine " + hashCode() + ": airflow2: " + airflow2);
        } else if(rpm <= 60 && isOn) {
            System.out.println("Engine " + hashCode() + ": rpm under 60");
        } else {
            System.out.println("Engine " + hashCode() + ": is out of order");
        }
    }

    public void shutdown() {
        this.isOn = false;
        rpm = 0;
    }

    public double getRPM() {
        return this.rpm;
    }

    public double getMaxRPM() {
        return maxRPM;
    }

    public String hitByBird() {
        return ">>> Engine " + hashCode() + " was hit by a bird";
    }

    public String toString() {
        return "Engine " + hashCode() + " EngineType: " + this.engineType + ((this.isOn) ? " in use" : " out of order") + " with " + this.rpm + " RPM (" + this.rpm * 0.4 + "km/h) EngineStatus: " + controlModule.isEngineOk();
    }
}
