public class TaxDemo {
    public static void main(String[] args) {
        Tax incomeTax = new IncomeTax(0.20);  
        Tax salesTax = new SalesTax(0.08);    

        double income = 50000;
        double purchase = 1000;

        System.out.println("Income Tax on $" + income + ": $" + incomeTax.calculateTax(income));
        incomeTax.displayTaxInfo();

        System.out.println("Sales Tax on $" + purchase + ": $" + salesTax.calculateTax(purchase));
        salesTax.displayTaxInfo();  

        Tax.generalTaxRule();
    }
}