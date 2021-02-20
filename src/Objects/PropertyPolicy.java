package Objects;

public class PropertyPolicy extends Policy{
    private QuoteProperty quoteProperty;

    public PropertyPolicy(QuoteProperty quoteProperty) {
        super();
        this.quoteProperty = quoteProperty;
    }

    public QuoteProperty getQuoteProperty() {
        return quoteProperty;
    }

    public void setQuoteProperty(QuoteProperty quoteProperty) {
        this.quoteProperty = quoteProperty;
    }
}
