public class SalesTax implements Tax {
    private double rate;

    public SalesTax(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateTax(double amount) {
        return amount * rate;  
    }
}