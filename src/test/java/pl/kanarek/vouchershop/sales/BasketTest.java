package pl.kanarek.vouchershop.sales;


import org.junit.Test;
import pl.kanarek.vouchershop.catalog.Product;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class BasketTest {

//    @Test
//    public void newlyCreatedBasketIsEmpty(){
//        Basket basket = new Basket();
//        assertThat(basket.isEmpty()).isTrue();
//    }
//
//    @Test
//    public void basetWithProductsIsNotEmpty(){
//        Basket basket = new Basket();
//        Product product1 = thereIsProduct("lego-8922");
//        basket.add(product1);
//
//        assertThat(basket.isEmpty()).isFalse();
//    }
//
//
//    @Test
//    public void itShowsProductsCount() {
//        Basket basket = new Basket();
//        Product product1 = thereIsProduct("lego-8922");
//        basket.add(product1);
//
//        Product product2 = thereIsProduct("lego-8923");
//        basket.add(product2);
//
//        assertThat(basket.getProductQuantity()).isEqualTo(2);
//
//    }
//
//    @Test
//    public void itShowsSingleLineForSameProductAddedTwice() {
//        Basket basket = new Basket();
//        Product product1 = thereIsProduct("lego-8922");
//        basket.add(product1);
//        basket.add(product1);
//        basket.add(product1);
//        assertThat(basket.getProductQuantity()).isEqualTo(1);
//
//    }
//
//    @Test
//    public void itCOntainsBasketLineQuantity() {
//        Basket basket = new Basket();
//        Product product1 = thereIsProduct("lego-8922");
//        Product product2 = thereIsProduct("lego-8923");
//
//        basket.add(product1);
//        basket.add(product1);
//        basket.add(product1);
//        basket.add(product2);
//
//        basketContainsProductWithQuantity(basket, product1, 3);
//        basketContainsProductWithQuantity(basket, product2, 1);
//
//    }
//
//    @Test
//    public void itAllowsToRemoveProduct() {
//        Basket basket = new Basket();
//        Product product1 = thereIsProduct("lego-8922");
//        basket.add(product1);
//        basket.add(product1);
//        basket.add(product1);
//
//        basket.remove(product1.getId());
//        basketContainsProductWithQuantity(basket, product1, 2);

//    }

    private void basketContainsProductWithQuantity(Basket basket, Product product1, int expected) {
        assertThat(basket.getBasketItems())
                .filteredOn(basketItem ->
                        basketItem.getProductId().equals(product1.getId()))
                .extracting(basketItem -> basketItem.getQuantity())
                .first()
                .isEqualTo(expected);
    }


    private Product thereIsProduct(String name) {
        Product product = new Product(UUID.randomUUID());
        product.setDescription(name);
        return product;
    }


}
