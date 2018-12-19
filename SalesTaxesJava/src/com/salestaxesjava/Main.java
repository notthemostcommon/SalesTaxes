package com.salestaxesjava;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<PurchasedItem> purchasedList = new PurchasedList().formatParsedWords();
        Tax tax = new Tax();
        Map<Integer, List<PurchasedItem>> map = new HashMap<>();

        // group purchased items by input value
        for (PurchasedItem purchasedItem : purchasedList) {
            Integer key = Integer.parseInt(purchasedItem.getInput());

            if (map.containsKey(key)) {
                List<PurchasedItem> list = map.get(key);
                list.add(purchasedItem);

            } else {
                List<PurchasedItem> list = new ArrayList<>();
                list.add(purchasedItem);
                map.put(key, list);
            }

        }
        for (int i = 1; i < map.size() + 1; i++) {

            // outer loop prints "output 'i'" and tracks total from each input
            double totalTax = 0;
            double subTotal = 0;
            System.out.println("Output " + map.get(i).get(i - 1).getInput() + ":");

            for (int j = 1; j < map.get(i).size(); j++) {

                // inner loop prints each item with quantity and price including tax
                double itemTotalTax;
                double itemSalesTax = 0;
                double itemImportTax = 0;
                double itemTotal;

                int quantity = map.get(i).get(j).getQuantity();
                String itemName = map.get(i).get(j).getItemName();
                double price = map.get(i).get(j).getPrice();

                // check if item is tax exempt
                boolean salesTaxExempt = map.get(i).get(j).isSalesTaxExempt(itemName);

                // method calculates sales tax if item is not exempt
                if (!salesTaxExempt) {
                    itemSalesTax = tax.calculateSalesTax(quantity, price);

                }

                // check if item is imported
                boolean isImportTaxed = map.get(i).get(j).isImportTaxed(itemName);

                // method calculates import tax if item is imported
                if (isImportTaxed) {
                    itemImportTax = tax.calculateImportTax(quantity, price);

                }

                itemTotalTax = tax.calculateTotalItemTax(itemSalesTax, itemImportTax);
                totalTax = totalTax + itemTotalTax;
                totalTax = roundToFraction(totalTax, 100);

                itemTotal = price + itemTotalTax;
//                itemTotal = formatAndRound((price + itemTotalTax), 2);

                // format total price into 2 digit currency
                String itemTotalFormatted = String.format("%.2f", itemTotal);

                subTotal = subTotal + itemTotal;

                // prints item name and formatted total price for item
                System.out.println(quantity + itemName + " : " + itemTotalFormatted);

            }

            // formats tax into 2 digit currency
            String taxFormatted = String.format("%.2f", totalTax);

            // prints slaes tax and total price
            System.out.println("Sales tax : " + taxFormatted + "\n" +
                    "Total: " + formatAndRound(subTotal, 2) + "\n");
        }

    }


    // helper method to round total to the nearest 100th
    private static double formatAndRound(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    // method rounds to nearest .05
    private static double roundToFraction(double x, double fraction) {
        return (double) Math.round(x * fraction) / fraction;
    }

}
