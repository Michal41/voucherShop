package pl.kanarek.vouchershop.catalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductCatalog {
    //private HashMap<String, Product> products;
    private final ProductStorage products;

    public ProductCatalog(ProductStorage productStorage) {
        //this.products = new HashMap<String, Product>();
        this.products = productStorage;
    }

    public String registerProduct() {
        Product newProduct = new Product(UUID.randomUUID());
        products.save(newProduct);
        return newProduct.getId();
    }

    public boolean isExist(String productId) {
        return products.isExists(productId);
    }

    public Product load(String productId) {
        return products.load(productId);
    }

    public void updateDetails(String productId, String productDescription, String productPicture) {
        Product loaded = products.load(productId);
        loaded.setDescription(productDescription);
        loaded.setPicture(productPicture);
    }

    public void applyPrice(String productId, BigDecimal price) {
        Product loaded = products.load(productId);
        loaded.setPrice(price);


    }

    public List<Product> allPublished() {
        return products.allProducts()
                .stream()
                .filter(product -> product.getDescription() !=null)
                .filter(product -> product.getPrice() != null)
                .collect(Collectors.toList());
    }
}
