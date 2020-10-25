package pl.kanarek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

public class ProductCatalogTest {
    @Test
    public void itAllowToRegisterNewProduct(){
        ProductCatalog catalog = therIsProductCatalog();

        string productId = catalog.registerProduct();

        Assert.assertTrue(catalog.isExist(productId

        ));
    }

}
