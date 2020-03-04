package matrikelnummer_2227314.s49.mediator;

public interface IATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    boolean isLandingOk();
    void setLandingStatus(boolean status);
}
