package com.salestaxesjava;

import java.util.Arrays;

public class PurchasedItem {

    private String input;
    private int quantity;
    private String itemName;
    private double price;

    public PurchasedItem(String input, int quantity, String itemName, double price) {
        this.input = input;
        this.quantity = quantity;
        this.itemName = itemName;
        this.price = price;
    }


    // create method to determine if item exists in the exempt list
    private boolean contains(String[] arr, String item) {
        return Arrays.asList(arr).contains(item);
    }

    // method evaluates if purchased item is tax exempt
    public boolean isSalesTaxExempt(String item) {

        // array of items that are tax-exempt
        String[] taxExempt = {"book",
                "chocolate bar",
                "packet of headache pills",
                "imported box of chocolates", "box of imported chocolates"};

        return contains(taxExempt, item.trim());

    }

    // methods evaluates if purchased item is "imported"
    // method looks for the word "imported" to return true
    public boolean isImportTaxed(String item) {
        return item.toLowerCase().contains("imported");
    }

    @Override
    public String toString() {
        return "PurchasedItem" + "\n" + "{" +
                "input=" + input +
                "," + "\n" + "quantity=" + quantity +
                "," + "\n" + " itemName='" + itemName +
                "," + "\n" + " price=" + price +
                '}' + "\n";
    }

    String getInput() {
        return input;
    }

    double getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    public String getItemName() {
        return itemName;
    }

}
