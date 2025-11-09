public interface Tax {
    double calculateTax(double amount);  
    default void displayTaxInfo() {  
        System.out.println("Tax calculation completed.");
    }

    static void generalTaxRule() { 
        System.out.println("Taxes must be paid annually.");
    }
}