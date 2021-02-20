package Objects;

import java.util.concurrent.atomic.AtomicInteger;

public class Car {
    final private static AtomicInteger count = new AtomicInteger(3000);
    final private int car_ID;
    private Client client;
    private String make;
    private String model;
    private int year;
    private String color;
    private String VIN;
    private String plateNumber;

    public Car(Client client, String VIN) {
        this.car_ID = count.incrementAndGet();
        this.client = client;
        this.VIN = VIN;
    }

    public int getCar_ID() {
        return car_ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
}
