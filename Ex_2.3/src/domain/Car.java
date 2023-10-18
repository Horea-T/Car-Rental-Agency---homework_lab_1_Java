package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String id;
    private String manufacturer;
    private String model;
    private int year;
    private boolean hasDamages;
    private List<String> damages;
    private boolean reserved;

    public Car(String id, String manufacturer, String model, int year) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.hasDamages = false;
        this.damages = new ArrayList<>();
        this.reserved = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean hasDamages() {
        return hasDamages;
    }

    public String[] getDamages() {
        return damages.toArray(new String[0]);
    }

    public void addDamage(String description) {
        damages.add(description);
        hasDamages = true;
    }

    public void removeDamage(String description) {
        damages.remove(description);
        if (damages.isEmpty()) {
            hasDamages = false;
        }
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
