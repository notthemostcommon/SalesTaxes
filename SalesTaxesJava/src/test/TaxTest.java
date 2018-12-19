package test;

import com.salestaxesjava.Tax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class TaxTest {

    @DisplayName("SalesTax for 24.99")
    @Test
    void testCalculateSalesTax(){

        double calcSalesTax = new Tax().calculateSalesTax(1, 24.99);

        Assertions.assertEquals(2.50, calcSalesTax);

    }

    @DisplayName("Import tax for 24.99")
    @Test
    void testCalculateImportTax(){

        double calcImpTax = new Tax().calculateImportTax(1, 24.99);

        Assertions.assertEquals(1.25, calcImpTax);

    }

    @DisplayName("Add sales and import tax")
    @Test
    void testAddTotalTax(){

        double calcImpTax = new Tax().calculateTotalItemTax(2.499, 1.2495);

        Assertions.assertEquals(3.7485, calcImpTax);

    }
}