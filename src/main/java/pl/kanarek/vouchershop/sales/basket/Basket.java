package pl.kanarek.vouchershop.sales.basket;

import pl.kanarek.vouchershop.catalog.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket {
    private final Map<String, Product> products;
    private final Map<String, Integer> productsQuantities;
    public Basket() {
        this.products = new HashMap<>();
        this.productsQuantities = new HashMap<>();
    }

    public static Basket empty() {
        return new Basket();
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public void add(Product product) {
        if (isInBasket(product)){
            IncreaseProductQuantity(product);
        }else{
            putProductToBasket(product);

        }

    }

    private void putProductToBasket(Product product) {
        productsQuantities.put(product.getId(),1);
        products.put(product.getId(), product);
    }

    private void IncreaseProductQuantity(Product product) {
        productsQuantities.put(product.getId(),
                productsQuantities.get(product.getId())+1);
    }

    private boolean isInBasket(Product product) {
        return productsQuantities.containsKey(product.getId());
    }

    public int getProductQuantity() {
        return products.size();
    }

    public List<BasketItem> getBasketItems() {
        return productsQuantities.entrySet().stream().map(e ->
                new BasketItem(e.getKey(), e.getValue())).collect(Collectors.toList());
    }

    public void remove(String productId) {

    }
}
