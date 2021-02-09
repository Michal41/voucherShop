package pl.kanarek.vouchershop.sales;

import pl.kanarek.vouchershop.catalog.Product;
import pl.kanarek.vouchershop.catalog.ProductCatalog;
import pl.kanarek.vouchershop.sales.basket.Basket;
import pl.kanarek.vouchershop.sales.basket.InMemoryBasketStorage;

public class SalesFacade {
    private final CurrentCustomerContext currentSystemContext;
    private final InMemoryBasketStorage basketStorage;
    private final ProductCatalog productCatalog;

    public SalesFacade(CurrentCustomerContext currentSystemContext, InMemoryBasketStorage basketStorage, ProductCatalog productCatalog) {
        this.currentSystemContext = currentSystemContext;
        this.basketStorage = basketStorage;
        this.productCatalog = productCatalog;
    }


    public void addToBasket(String productid) {
        Basket basket = basketStorage.getBasket(getCurrentCustomerId())
                .orElse(Basket.empty());
        Product product = productCatalog.load(productid);
        basketStorage.addForCustomer(getCurrentCustomerId(), basket);

    }

    private String getCurrentCustomerId() {
        return currentSystemContext.getCustomerId();
    }

}
