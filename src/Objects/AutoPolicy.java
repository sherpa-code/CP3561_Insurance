package Objects;

public class AutoPolicy extends Policy{
    private QuoteCar quoteCar;

    public AutoPolicy(QuoteCar quoteCar) {
        super();
        this.quoteCar = quoteCar;
    }

    public QuoteCar getQuoteCar() {
        return quoteCar;
    }

    public void setQuoteCar(QuoteCar quoteCar) {
        this.quoteCar = quoteCar;
    }
}
