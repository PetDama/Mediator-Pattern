import java.util.List;
public class Client {
    private Mediator rideSharingApp;

    public Client(Mediator rideSharingApp) {
        this.rideSharingApp = rideSharingApp;
    }

    public void findAndChooseCar(int clientLocation) {
        List<Car> closestAvailableCars = rideSharingApp.findClosestAvailableCars(clientLocation);

        if(closestAvailableCars.isEmpty()) {
            System.out.println("No available cars");
        } else {
            System.out.println("Available cars:");
            for(Car car : closestAvailableCars) {
                System.out.println("Car at location " + car.getLocation() + " with distance " + car.getDistanceToLocation());
            }

            Car chosenCar = closestAvailableCars.get(0);
            ((RideSharingApp)rideSharingApp).addCarToTrips(chosenCar);
            System.out.println("Client chose car at location " + chosenCar.getLocation() + " for a trip with distance " + chosenCar.getDistanceToLocation());
        }
    }
}
