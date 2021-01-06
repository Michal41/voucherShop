package pl.kanarek.vouchershop.catalog;

import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class ListProductStorageTest {
    @Test
    public void itAllowAddProduct(){
        ProductStorage productStorage = new ListProductStorage();
        Product product = thereIsProduct();

        productStorage.save(product);

        Assert.assertTrue(productStorage.isExists(product.getId()));

    }

    private Product thereIsProduct() {
        return new Product(UUID.randomUUID());
    }

    @Test
    public void itAllowToLoadProduct(){
        ProductStorage productStorage = new ListProductStorage();
        Product product = thereIsProduct();

        product.setDescription("desc");

        productStorage.save(product);
        Product loaded = productStorage.load(product.getId());
        Assert.assertTrue(loaded.getDescription().equals("desc"));


    }

    @Test
    public void itAllowLoadAllProducts(){
        ProductStorage productStorage = new ListProductStorage();
        Product product1 = thereIsProduct();
        Product product2 = thereIsProduct();
        productStorage.save(product1);
        productStorage.save(product2);
        Assert.assertTrue(productStorage.allProducts().toArray().length==2);

    }
    @Test
    public void itAllowCheckIfProductExists(){
        ProductStorage productStorage = new ListProductStorage();
        Product product = thereIsProduct();
        productStorage.save(product);

        Assert.assertTrue(productStorage.isExists(product.getId()));

    }

}
