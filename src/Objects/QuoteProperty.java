package Objects;

import java.util.Date;

public class QuoteProperty extends Quote{
    private Property quotedProperty;
    public QuoteProperty(double amount, Date effectiveDate, Date expireDate, Date createdDate, Property quotedProperty) {
        super(amount, effectiveDate, expireDate, createdDate);
        this.quotedProperty = quotedProperty;
    }

    public Property getQuotedProperty() {
        return quotedProperty;
    }

    public void setQuotedProperty(Property quotedProperty) {
        this.quotedProperty = quotedProperty;
    }

}
