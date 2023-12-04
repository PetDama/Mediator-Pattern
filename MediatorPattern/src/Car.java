public class Car extends Vehicle implements Comparable<Car>{
    private int distanceToLocation;
    private int location;
    public Car(int location, int distanceToLocation, Mediator mediator) {
        super(mediator);
        this.location = location;
        this.distanceToLocation = distanceToLocation;
    }

    public int getDistanceToLocation() {
        return distanceToLocation;
    }
    public int getLocation() {
        return location;
    }

    @Override
    public void sendNotification(String event) {
        mediator.notify(this, event);
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.getDistanceToLocation(), otherCar.getDistanceToLocation());
    }
}
