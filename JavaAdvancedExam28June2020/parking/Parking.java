package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        return this.data.removeIf(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model));
    }

    public Car getLatestCar() {
        Car latestCar = null;
        for (Car car : data) {
            if (latestCar == null || car.getYear() > latestCar.getYear()) {
                latestCar = car;
            }
        }
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        for (Car currentCar : data) {
            if (currentCar.getManufacturer().equals(manufacturer)
                    && currentCar.getModel().equals(model)) {
                car = currentCar;
            }
        }
        return car;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder output = new StringBuilder("The cars are parked in " + this.type + ":")
                .append(System.lineSeparator());
        for (Car car : data) {
            output.append(car).append(System.lineSeparator());
        }
        return output.toString();
    }

}
