package matrikelnummer_2227314.s49.mediator;

public class _MediatorApplet {
    public static void main(String... args) {
        IATCMediator atcMediator = new ATCMediator();
        Runway mainRunway = new Runway(atcMediator);

        atcMediator.registerRunway(mainRunway);

        Flight sparrow101 = new Flight(atcMediator);
        atcMediator.registerFlight(sparrow101);
        sparrow101.getReady();

        mainRunway.grantLandingPermission();
        sparrow101.grantLandingPermission();
    }
}
