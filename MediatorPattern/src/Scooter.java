public class Scooter extends Vehicle{
    private double chargeLevel;
    public Scooter(double chargeLevel, Mediator mediator) {
        super(mediator);
        this.chargeLevel = chargeLevel;
    }

    public double getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public void sendNotification(String event) {
        mediator.notify(this, event);
    }
}
