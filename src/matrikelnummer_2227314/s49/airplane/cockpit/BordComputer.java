package matrikelnummer_2227314.s49.airplane.cockpit;

import matrikelnummer_2227314.s49.Application;
import matrikelnummer_2227314.s49.airplane.Engine;
import matrikelnummer_2227314.s49.airplane.EngineType;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.ControlModule;
import matrikelnummer_2227314.s49.airplane.cockpit.mediator.IControlModule;
import matrikelnummer_2227314.s49.airplane.elements.RootElement;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class BordComputer {

    private List<IControlModule> controlModules;
    private List<Engine> engines;
    private String phase = "";

    public BordComputer() {
        controlModules = new ArrayList<>();
        engines = new ArrayList<>();

        for(int i = 0; i < 4; i++) {
            IControlModule controlModule = new ControlModule();
            Engine engine = new Engine(controlModule, EngineType.ROLLS_ROYCE_TRENT_900);
            controlModule.registerEngine(engine);
            controlModules.add(controlModule);
            engines.add(engine);
        }
    }

    public void startSimulation() {
        parking();
        taxi();
        takeOff();
        climb();
        descent();
        landing();
    }

    private void parking() {
        phase = "parking";
        System.out.println("--- Phase: Parking");
    }

    private void taxi() {
        phase = "taxi";
        System.out.println("--- Phase: Taxi");
        increaseRPM(5, 10);
    }

    private void takeOff() {
        phase = "takeOff";
        System.out.println("--- Phase: TakeOff");
        increaseRPM(8, 30);
    }

    private void climb() {
        phase = "climb";
        System.out.println("--- Phase: Climb");
        increaseRPM(15, 40);
    }

    private void descent() {
        phase = "descent";
        System.out.println("--- Phase: Descent");
        decreaseRPM(22, 25);
    }

    private void landing() {
        phase = "landing";
        System.out.println("--- Phase: Landing");
        decreaseRPM(5, 60);
        System.out.println("--- Phase: Landed");
    }


    Random random = new Random();

    private void increaseRPM(int seconds, int kmh) {
        for(int i = 0; i < seconds; i++) {
            try {
                for(Engine engine : engines) {
                    if(phase.equals("climb") && random.nextFloat() <= 0.005) {
                        for(IControlModule controlModule : controlModules) {
                            if(controlModule.getEngine().equals(engine)) {
                                controlModule.setEngineStatus(false);

                            }
                        }
                    }
                    if(engine.getRPM() + (2.5 * kmh) <= engine.getMaxRPM()) engine.increaseRPM(2.5 * kmh);
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!Application.debugMessages) {
            for (Engine engine : engines) {
                System.out.println(engine.toString());
            }
        }
    }

    private void decreaseRPM(int seconds, int kmh) {
        for(int i = 0; i < seconds; i++) {
            try {
                for(Engine engine : engines) {
                    if(engine.getRPM() - (2.5 * kmh) >= 2.5 * kmh) engine.decreaseRPM(2.5 * kmh);
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!Application.debugMessages) {
            for (Engine engine : engines) {
                System.out.println(engine.toString());
            }
        }
    }

    public final ListIterator<Engine> listEngines() {
        return engines.listIterator();
    }
}
