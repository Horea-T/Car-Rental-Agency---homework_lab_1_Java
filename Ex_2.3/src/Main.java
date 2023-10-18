import domain.Car;
import repository.Repository;
import service.CarService;
import ui.UserInterface;

public class Main {
    public static void main(String[] args){
        Repository repository = new Repository();
        CarService carService = new CarService(repository);

        Repository carRepository = new Repository();
        carRepository.addCar(new Car("1", "BMW", "530i", 2020));
        carRepository.addCar(new Car("2", "BMW", "X5", 2020));
        carRepository.addCar(new Car("3", "Mercedes", "SL 63s", 2023));
        carRepository.addCar(new Car("4", "Porsche", "911 Turbo S", 2023));
        carRepository.addCar(new Car("5", "Nissan", "GT-R", 2019));

        UserInterface userInterface = new UserInterface(carService);
        userInterface.Start();
    }
}