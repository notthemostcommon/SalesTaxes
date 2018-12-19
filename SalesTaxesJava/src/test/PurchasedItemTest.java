package test;

import com.salestaxesjava.PurchasedItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class PurchasedItemTest {


    @DisplayName("TaxExempt for chocolate bar is true")
    @Test
    void testTaxExemptTrue() {

        PurchasedItem purchasedChocBar = new PurchasedItem("1", 1, "chocolate bar", .85);
        boolean chocolateBar = purchasedChocBar.isSalesTaxExempt(purchasedChocBar.getItemName());
        System.out.println(chocolateBar);
        assumeTrue(chocolateBar);

    }

    @DisplayName("TaxExempt for music cd is false")
    @Test
    void testTaxExemptFalse() {

        PurchasedItem purchasedMusicCd = new PurchasedItem("1", 1, "music cd", .85);
        boolean musicCD = purchasedMusicCd.isSalesTaxExempt(purchasedMusicCd.getItemName());
        assumeFalse(musicCD);

    }

    @DisplayName("TaxExempt for bottle of perfume bar is false")
    @Test
    void testTaxExempt2True() {

        PurchasedItem purchasedImpChoc = new PurchasedItem("1", 1, "box of imported chocolates", .85);
        boolean importedChoc = purchasedImpChoc.isImportTaxed(purchasedImpChoc.getItemName());
        assumeTrue(importedChoc);

    }

    private String testA = "imported bottle of perfume";
    private String testB = "imparted bottle of perfume";
    private String testC = "Imported bottle of perfume";
    private String testD = "chocolate bar";
    private PurchasedItem importTestA = new PurchasedItem("1", 1, testA, .85);
    private PurchasedItem importTestB = new PurchasedItem("1", 1, testB, .85);
    private PurchasedItem importTestC = new PurchasedItem("1", 1, testC, .85);
    private PurchasedItem importTestD = new PurchasedItem("1", 1, testD, .85);


    @DisplayName("Imported items tests")
    @Test
    void testImportTaxTrue() {

        assumeTrue(importTestA.isImportTaxed(importTestA.getItemName()));
        assumeFalse(importTestB.isImportTaxed(importTestB.getItemName()));
        assumeTrue(importTestC.isImportTaxed(importTestC.getItemName()));
        assumeFalse(importTestD.isImportTaxed(importTestD.getItemName()));

    }

}