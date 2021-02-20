package Objects;

import java.util.Date;

public class QuoteCar extends Quote{
    private Car quotedCar;

    public QuoteCar(double amount, Date effectiveDate, Date expireDate, Date createdDate, Car quotedCar) {
        super(amount, effectiveDate, expireDate, createdDate);
        this.quotedCar = quotedCar;
    }

    public Car getQuotedCar() {
        return quotedCar;
    }

    public void setQuotedCar(Car quotedCar) {
        this.quotedCar = quotedCar;
    }

}
