package pl.kanarek.vouchershop.catalog;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID productId;
    private String description;
    private String picture;
    private BigDecimal price;

    public Product(UUID productId) {
        this.productId = productId;
    }

    public String getPicture(){
        return picture;
    }
    public String getId() {
        return "sample";
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description=description;
    }

    public void setPicture(String picture) {
        this.picture=picture;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
