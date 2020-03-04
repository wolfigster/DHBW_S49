package matrikelnummer_2227314.s49.mediator;

public class ATCMediator implements IATCMediator {
    private Flight flight;
    private Runway runway;
    public boolean status;

    @Override
    public void registerRunway(Runway runway) {
        this.runway = runway;
    }

    @Override
    public void registerFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public boolean isLandingOk() {
        return status;
    }

    @Override
    public void setLandingStatus(boolean status) {
        this.status = status;
    }

    public String toString() {
        return flight + " - " + runway + " - " + status;
    }
}
