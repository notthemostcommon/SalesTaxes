package com.salestaxesjava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {

    public ArrayList<String> readFile(String textFile) {

        ArrayList<String> parsedWords = new ArrayList<>();

        // methods for using the BufferedReader discovered and used from
        // https://www.caveofprogramming.com/java/java-file-reading-and-writing-files-in-java.html
        // The name of the file to open.
        String fileName = textFile;

        // This will reference one line at a time
        String line = null;

        try {

            // FileReader reads text files in the default encoding.
            java.io.FileReader fileReader = new java.io.FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Temp placeholder for orderData
            ArrayList<String> fileContents = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {

                if (line.trim().length() == 0)
                    continue;

                // parse each line to extract individual field
                parsedWords.add(line);

            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");

        }

        return parsedWords;

    }

}


