public abstract class Vehicle extends TransportationMean{
    public Vehicle(Mediator mediator) {
        super(mediator);
    }

    public abstract void sendNotification(String event);
}
