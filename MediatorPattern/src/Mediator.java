import java.util.List;

public interface Mediator {
    void notify(TransportationMean transportationMean, String event);
    List<Car> findClosestAvailableCars(int clientLocation);
//    List<Scooter> findClosestScooters(int clientLocation, int tripDistance);
}
