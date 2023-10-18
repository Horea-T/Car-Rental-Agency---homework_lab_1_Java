package repository;
import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static List<Car> cars = new ArrayList<Car>();

    public static void addCar(Car car){
        cars.add(car);
    }

    public static Car getID(String id){
        for(Car car : cars){
            if(car.getId().equals(id)){
                return car;
            }
        }
        return null;
    }

    public static void update(Car car){
        for(Car c : cars){
            if(c.getId().equals(car.getId())){
                c.setManufacturer(car.getManufacturer());
                c.setModel(car.getModel());
                c.setYear(car.getYear());
            }
        }
    }

    public static void delete(String id) {
        Car carToRemove = null;
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                carToRemove = car;
                break; // Exit the loop as we've found the car to delete
            }
        }

        if (carToRemove != null) {
            cars.remove(carToRemove);
        }
    }

    public static List<Car> findByManufacturer(String manufacturer){
        List<Car> carsByManufacturer = new ArrayList<Car>();
        for(Car car : cars){
            if(car.getManufacturer().equals(manufacturer)){
                carsByManufacturer.add(car);
            }
        }
        return carsByManufacturer;
    }

    public static List<Car> getAll() {
        return cars;
    }

    public static void addDamage(String id, String description) {
        Car car = getID(id);
        if (car != null) {
            car.addDamage(description);
        }
    }

    public static void removeDamage(String id, String description) {
        Car car = getID(id);
        if (car != null) {
            car.removeDamage(description);
        }
    }
}


