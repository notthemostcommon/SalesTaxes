package com.salestaxesjava;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class PurchasedList {

    private FileReader fileReader = new FileReader();
    private ArrayList<String> fileContents = fileReader.readFile("input.txt");

    List<PurchasedItem> formatParsedWords() {
//        System.out.println("parsedwords " + Arrays.deepToString(fileContents.toArray()));

        // variables to capture data from the file
        String input = "0";
        int quantity = 1;
        String itemName = "";
        double price = 0;
        ArrayList<String> arrOfOrders;
        List<PurchasedItem> parsedPurchasedList = new ArrayList<>();


        // loop through the contents of each line from the file
        for (int x = 0; x <= fileContents.size() - 1; x++) {
            arrOfOrders = sentenceToWords(fileContents.get(x));

//            System.out.println("arrayOfOrders " + arrOfOrders.get(0));
//            System.out.println("fileContents " + fileContents.get(0));

            // get input value
            if (arrOfOrders.get(0).equals("Input")) {
                String inputValue = arrOfOrders.get(1);

                // cast as int and remove colon
                input = inputValue.substring(0, inputValue.length() - 1);

            } else {

                // get quantity from each line
                quantity = Integer.parseInt(arrOfOrders.get(0));

                // get item name from each line
                itemName = between(fileContents.get(x), arrOfOrders.get(0), "at");

                // get price for item
                price = Double.parseDouble(after(fileContents.get(x), "at"));
            }

            // create purchasedItem object
            PurchasedItem purchasedItem = new PurchasedItem(input, quantity, itemName, price);

            // add purchased item to parsedPurchasedList array
            parsedPurchasedList.add(purchasedItem);
        }
//        System.out.println(parsedPurchasedList);

        return parsedPurchasedList;


    }

    // https://stackoverflow.com/questions/37646469/split-arraylist-of-sentences-into-words-store-the-words-into-new-arraylist
    // method splits sentence string and creates index for each word
    private ArrayList<String> sentenceToWords(String s) {
        String[] sentence = s.split(" ");
        ArrayList<String> words = new ArrayList<>();

        Collections.addAll(words, sentence);
        return words;
    }

    // code from https://www.dotnetperls.com/between-before-after-java
    // methods to parse substrings
    private String between(String value, String a, String b) {
        // Return a substring between the two strings.
        int posA = value.indexOf(a);
        if (posA == -1) {
            return "";
        }
        int posB = value.lastIndexOf(b);
        if (posB == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= posB) {
            return "";
        }
        return value.substring(adjustedPosA, posB);
    }

    private String after(String value, String a) {
        // Returns a substring containing all characters after a string.
        int posA = value.lastIndexOf(a);
        if (posA == -1) {
            return "";
        }
        int adjustedPosA = posA + a.length();
        if (adjustedPosA >= value.length()) {
            return "";
        }
        return value.substring(adjustedPosA);
    }

}
