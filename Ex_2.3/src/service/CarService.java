package service;

import domain.Car;
import repository.Repository;
import java.util.ArrayList;
import java.util.List;

public class CarService {
    private Repository repository;
    private List<Car> reservedCars;

    public CarService(Repository repository) {
        this.repository = repository;
        this.reservedCars = new ArrayList<>();
    }

    public boolean createReservation(String carId) {
        Car car = repository.getID(carId);
        if (car != null) {
            if (!car.isReserved()) {
                car.setReserved(true);
                reservedCars.add(car);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public boolean cancelReservation(String carId) {
        Car car = repository.getID(carId);
        if (car != null) {
            if (car.isReserved()) {
                car.setReserved(false);
                reservedCars.remove(car);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }


    public List<Car> getReservedCars() {
        return reservedCars;
    }
}
