package Objects;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Quote {
    final private static AtomicInteger count = new AtomicInteger(40000);
    final private int quoteNumber;
    private double amount;
    private Date effectiveDate;
    private Date expireDate;
    private Date createdDate;

    //TODO: discussion:
    private String quoteType;

    public Quote(double amount, Date effectiveDate, Date expireDate, Date createdDate) {
        this.quoteNumber = count.incrementAndGet();
        this.amount = amount;
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.createdDate = createdDate;
    }

    public int getQuoteNumber() {
        return quoteNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getQuoteType() {
        return quoteType;
    }

    //TODO: Discussion here on the abstract method
    //public Car getQuotedCar();
}
