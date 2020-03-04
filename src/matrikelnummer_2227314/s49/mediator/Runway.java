package matrikelnummer_2227314.s49.mediator;

public class Runway implements ICommand {
    private IATCMediator atcMediator;

    public Runway(IATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        atcMediator.setLandingStatus(true);
    }

    @Override
    public void grantLandingPermission() {
        System.out.println("landing permission granted");
        atcMediator.setLandingStatus(true);
    }
}
