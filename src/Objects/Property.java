package Objects;

import java.util.concurrent.atomic.AtomicInteger;

public class Property {
    final private static AtomicInteger count = new AtomicInteger(3000);
    final private int property_ID;
    private Client client;
    private String type;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private double value;
    //TODO: add a property equal to VIN in car class

    public Property(Client client) {
        this.property_ID = count.incrementAndGet();
        this.client = client;

    }

    public int getProperty_ID() {
        return property_ID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
