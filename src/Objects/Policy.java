package Objects;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

abstract class Policy {
    final private static AtomicInteger count = new AtomicInteger(80000);
    final private int policyNumber;
    //final private Quote quote;
    //private QuoteCar quoteCar;
    //private QuoteProperty quoteProperty;
    private Date effectiveDate;
    private Date createdDate;
    private Date expireDate;
    private double premium;
    private String paymentOption;

    public Policy() {
        this.policyNumber = count.incrementAndGet();
        //this.quoteCar = quoteCar;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }


}
