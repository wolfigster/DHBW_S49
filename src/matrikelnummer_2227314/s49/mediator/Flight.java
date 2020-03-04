package matrikelnummer_2227314.s49.mediator;

public class Flight implements ICommand {
    private IATCMediator atcMediator;

    public Flight(IATCMediator atcMediator) {
        this.atcMediator = atcMediator;
    }

    @Override
    public void grantLandingPermission() {
        if(atcMediator.isLandingOk()) {
            System.out.println("landing mode");
            atcMediator.setLandingStatus(true);
        } else System.out.println("waiting to Land");
    }

    public void getReady() {
        System.out.println("ready");
    }
}
