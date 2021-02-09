package pl.kanarek.vouchershop.sales;

import org.junit.Before;
import org.junit.Test;
import pl.kanarek.vouchershop.catalog.ProductCatalog;
import pl.kanarek.vouchershop.catalog.ProductCatalogConfiguration;
import pl.kanarek.vouchershop.sales.basket.Basket;
import pl.kanarek.vouchershop.sales.basket.InMemoryBasketStorage;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class CollectionProductTest {
    private InMemoryBasketStorage basketStorage;
    private CurrentCustomerContext userContext;
    private String customerId;
    private ProductCatalog productCatalog;

    @Before
    public void setUp() {
        this.basketStorage = new InMemoryBasketStorage();
        this.customerId = UUID.randomUUID().toString();
        this.userContext = () -> customerId;
        this.productCatalog = thereIsProductCatalog();
    }





    @Test
    public void ItAllowAddProductToBasket(){
        SalesFacade salesModule = thereIsSalesModule();
        String productid = thereIsProductAvailable();

        String customerId = thereIsCustomerWhoIsDoingSomeShoping();

        salesModule.addToBasket(productid);

        thereIsXProductsInCustomerBasket(0,customerId);


    }

    private String thereIsProductAvailable() {
        String productId = productCatalog.registerProduct();
        productCatalog.applyPrice(productId, BigDecimal.valueOf(10.20));
        productCatalog.updateDetails(productId, "info", "image");
        return productId;

    }
    private static ProductCatalog thereIsProductCatalog() {
        return new ProductCatalogConfiguration().myProductCatalog();
    }

    private SalesFacade thereIsSalesModule() {
        return new SalesFacade(userContext, basketStorage, productCatalog);
    }

    private String thereIsCustomerWhoIsDoingSomeShoping() {
        var id = UUID.randomUUID().toString();
        this.customerId = id;
        return  id;
    }

    private void thereIsXProductsInCustomerBasket(int productsCount, String customerId) {
        Basket basket = basketStorage.getBasket(customerId).orElse(Basket.empty());
        assertThat(basket.getProductQuantity()).isEqualTo(productsCount);
    }
}
