package hello;

public class Quote {

    private final String symbol;

    private double  ticker;

    public Quote(String symbol) {
        this.symbol = symbol;
        this.ticker = Util.getUnderLyingPrice(symbol);
    }

    // Not used
    public String getSymbol() { return symbol; }

    public double getTicker() { return ticker; }
}