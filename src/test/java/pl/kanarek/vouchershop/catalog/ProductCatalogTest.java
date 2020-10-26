package pl.kanarek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogTest {

    public static final String NONE_EXIST_ID = "noneExistId";
    public static final String PRODUCT_PICTURE = "http://nice-picture";
    public static final String PRODUCT_DESCRIPTION = "My nice product";

    @Test
    public void itAllowToRegisterNewProduct(){
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.registerProduct();

        Assert.assertTrue(catalog.isExist(productId));
        Assert.assertFalse(catalog.isExist(NONE_EXIST_ID));


    }
    @Test
    public void itAllowToLoadCreatedProduct(){
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.registerProduct();
        Product loaded = catalog.load(productId);


        Assert.assertEquals(loaded.getId(), productId);
    }
    @Test
    public void itAllowsToFillDetails(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();
        Product loaded = catalog.load(productId);

        catalog.updateDetails(productId,PRODUCT_DESCRIPTION, PRODUCT_PICTURE);

        Assert.assertEquals(loaded.getPicture(), PRODUCT_PICTURE);
        Assert.assertEquals(loaded.getDescription(), PRODUCT_DESCRIPTION);

    }

    @Test
    public void itAllowsToFillPrise(){
        ProductCatalog catalog = thereIsProductCatalog();
        String productId = catalog.registerProduct();
        Product loaded = catalog.load(productId);

        catalog.applyPrice(productId, BigDecimal.TEN);

        Assert.assertEquals(loaded.getPrice(), BigDecimal.TEN);

    }

    @Test
    public void itAllowsListAllProducts(){
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.registerProduct();
        catalog.applyPrice(productId, BigDecimal.TEN);
        catalog.updateDetails(productId,PRODUCT_DESCRIPTION, PRODUCT_PICTURE);


        List<Product> all = catalog.allPublished();
        Assert.assertEquals(1,all.size());



    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }

}
