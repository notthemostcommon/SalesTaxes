package com.salestaxesjava;


public class Tax {

    private double totalItemTax;
    private double itemSalesTax;
    private double itemImportTax;
    private final double salesTaxRate = .1;
    private final double importTaxRate = .05;

    public double getTotalItemTax() {
        return totalItemTax;
    }

    // method to calculate 10% sales tax
    public double calculateSalesTax(int quantity, double price) {
        itemSalesTax = (quantity * price) * salesTaxRate;
        System.out.println("salestax " + roundToFraction(itemSalesTax, 20));
        return roundToFraction(itemSalesTax, 20);
    }

    // method to calculate 5% import tax
    public double calculateImportTax(int quantity, double price) {
        itemImportTax = (quantity * price) * importTaxRate;
        System.out.println("importtax " + roundToFraction(itemImportTax, 20));
        return roundToFraction(itemImportTax, 20);
    }

    // method to calculate total tax on item
    public double calculateTotalItemTax(double salesTax, double impTax){
//         return totalItemTax =  roundToFraction((salesTax + impTax), 20) ;
        return totalItemTax = salesTax + impTax;
    }

    private static double roundToFraction(double x, double fraction) {
        return (double) Math.round(x * fraction) / fraction;
    }

}
