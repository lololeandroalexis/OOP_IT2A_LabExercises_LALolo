public class IncomeTax implements Tax {
    private double rate;

    public IncomeTax(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateTax(double amount) {
        return amount * rate;  
    }

    @Override
    public void displayTaxInfo() {
        System.out.println("Income tax calculated at " + (rate * 100) + "% rate.");
    }
}