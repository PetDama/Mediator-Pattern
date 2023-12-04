import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.List;

public class RideSharingApp implements Mediator {
    private List<Car> cars;
    private List<Scooter> scooters;
    private List<Car> carsInTrips = new ArrayList<>();

    public RideSharingApp() {
        cars = new ArrayList<>();
        scooters = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addScooter(Scooter scooter) {
        scooters.add(scooter);
    }

    @Override
    public void notify(TransportationMean transportationMean, String event) {
        System.out.println("Notification: " + event);
    }

    @Override
    public List<Car> findClosestAvailableCars(int clientLocation) {
        List<Car> availableCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.isAvailable() && !carsInTrips.contains(car)) {
                availableCars.add(car);
            }

            if(availableCars.size() == 3) {
                break;
            }
        }

        availableCars.sort((car1, car2) -> {
            int distance1 = car1.getDistanceToLocation();
            int distance2 = car2.getDistanceToLocation();

            return Integer.compare(distance1, distance2);
        });

        return availableCars;
    }

    public void addCarToTrips(Car car) {
        carsInTrips.add(car);
        car.setAvailable(false);
    }

    public void removeCarFromTrips(Car car) {
        carsInTrips.remove(car);
    }
}
