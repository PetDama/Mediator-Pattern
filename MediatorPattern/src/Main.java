public class Main {
    public static void main(String[] args) {
           Mediator mediator = new RideSharingApp();

           Car car1 = new Car(30, 0, mediator);
              Car car2 = new Car(40, 0, mediator);
                Car car3 = new Car(50, 0, mediator);

        ((RideSharingApp) mediator).addCar(car1);
        ((RideSharingApp) mediator).addCar(car2);
        ((RideSharingApp) mediator).addCar(car3);

        Client client = new Client(mediator);
        client.findAndChooseCar(60);
    }
}