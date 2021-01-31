package pl.kanarek.vouchershop.sales;

public class BasketItem {
    private final String productId;
    private final Integer quantitty;

    public BasketItem(String productId, Integer quantitty) {
        this.productId = productId;
        this.quantitty = quantitty;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantitty;
    }
}
