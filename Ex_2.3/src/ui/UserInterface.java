package ui;
import domain.Car;
import repository.Repository;
import service.CarService;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private CarService carService;
    private Scanner scanner;

    public UserInterface(CarService carService){
        this.carService = carService;
        this.scanner = new Scanner(System.in);
    }

    public void Start() {
        while (true) {
            System.out.println("Welcome to the Car Rental Agency !");
            System.out.println("1. Add a new car.");
            System.out.println("2. Update a car.");
            System.out.println("3. Delete a car.");
            System.out.println("4. Add damage to a car.");
            System.out.println("5. Remove damage from a car.");
            System.out.println("6. List all cars.");
            System.out.println("7. Find cars by make.");
            System.out.println("8. Make a reservation.");
            System.out.println("9. Cancel a reservation.");
            System.out.println("10. List all reservations.");
            System.out.println("11. Exit.");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter Car_ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("Enter car's manufacturer: ");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter car's model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter car's year: ");
                    int year = scanner.nextInt();
                    Car newCar = new Car(carId, manufacturer, model, year);
                    Repository.addCar(newCar);
                    System.out.println("Car added successfully to the list.");
                    break;

                case 2:
                    System.out.print("Enter Car_ID: ");
                    String carIdToUpdate = scanner.nextLine();
                    System.out.print("Enter car's manufacturer: ");
                    String manufacturerToUpdate = scanner.nextLine();
                    System.out.print("Enter car's model: ");
                    String modelToUpdate = scanner.nextLine();
                    System.out.print("Enter car's year: ");
                    int yearToUpdate = scanner.nextInt();
                    Car updatedCar = new Car(carIdToUpdate, manufacturerToUpdate, modelToUpdate, yearToUpdate);
                    Repository.update(updatedCar);
                    System.out.println("Car updated successfully in the list.");
                    break;

                case 3:
                    System.out.print("Enter Car_ID: ");
                    String carIdToDelete = scanner.nextLine();
                    Repository.delete(carIdToDelete);
                    System.out.println("Car deleted successfully from the list.");
                    break;

                case 4:
                    System.out.print("Enter Car_ID: ");
                    String carIdToAddDamage = scanner.nextLine();
                    System.out.print("Please enter the damage description: ");
                    String damageDescription = scanner.nextLine();
                    Repository.addDamage(carIdToAddDamage, damageDescription);
                    System.out.println("Damage added successfully to the report.");
                    break;

                case 5:
                    System.out.print("Enter Car_ID: ");
                    String carIdToRemoveDamage = scanner.nextLine();
                    System.out.print("Please enter the damage description: ");
                    String damageDescriptionToRemove = scanner.nextLine();
                    Repository.removeDamage(carIdToRemoveDamage, damageDescriptionToRemove);
                    System.out.println("Damage removed successfully from the report.");
                    break;

                case 6:
                    List<Car> allCars = Repository.getAll();
                    if (allCars.isEmpty()) {
                        System.out.println("No cars were found in the system.");
                    } else {
                        System.out.println("List of all agency's cars:");
                        for (Car car : allCars) {
                            System.out.println("ID: " + car.getId());
                            System.out.println("Manufacturer: " + car.getManufacturer());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            if (car.hasDamages()) {
                                System.out.println("Damages:");
                                String[] damages = car.getDamages();
                                for (String damage : damages) {
                                    System.out.println("- " + damage);
                                }
                            } else {
                                System.out.println("There are no damages reported for this car.");
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 7:
                    System.out.print("Enter car manufacturer: ");
                    String manufacturerToFind = scanner.nextLine();

                    List<Car> carsByManufacturer = Repository.findByManufacturer(manufacturerToFind);

                    if (carsByManufacturer.isEmpty()) {
                        System.out.println("No cars were found for manufacturer: " + manufacturerToFind);
                    } else {
                        System.out.println("List of cars for the provided manufacturer " + manufacturerToFind + ":");
                        for (Car car : carsByManufacturer) {
                            System.out.println("ID: " + car.getId());
                            System.out.println("Manufacturer: " + car.getManufacturer());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println();
                        }
                    }
                    break;

                case 8:
                    System.out.print("Enter Car_ID for reservation: ");
                    String carIdToReserve = scanner.nextLine();
                    boolean reservationSuccess = carService.createReservation(carIdToReserve);

                    if (reservationSuccess) {
                        System.out.println("Reservation was made successfully.");
                    } else {
                        System.out.println("Reservation failed. Car couldn't be found or it is already reserved. Please try again.");
                    }
                    break;

                case 9:
                    System.out.print("Enter Car_ID for cancellation: ");
                    String carIdToCancel = scanner.nextLine();
                    boolean cancelSuccess = carService.cancelReservation(carIdToCancel);

                    if (cancelSuccess) {
                        System.out.println("Reservation was canceled successfully.");
                    } else {
                        System.out.println("Cancellation failed. Car couldn't be found or it is not reserved. Please try again.");
                    }
                    break;

                case 10:
                    List<Car> reservedCars = carService.getReservedCars();

                    if (reservedCars.isEmpty()) {
                        System.out.println("No reservations were found.");
                    } else {
                        System.out.println("List of all reservations:");
                        for (Car car : reservedCars) {
                            System.out.println("Car_ID: " + car.getId());
                            System.out.println("Manufacturer: " + car.getManufacturer());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Year: " + car.getYear());
                            System.out.println();
                        }
                    }
                    break;

                case 11:
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
            }
        }
    }
}
