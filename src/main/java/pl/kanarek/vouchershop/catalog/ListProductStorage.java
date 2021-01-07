package pl.kanarek.vouchershop.catalog;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ListProductStorage implements ProductStorage {
    private final ArrayList<Product> products;

    public ListProductStorage() {
        this.products = new ArrayList<>();
    }

    @Override
    public void save(Product newProduct) {
        products.add(newProduct);
    }

    @Override
    public boolean isExists(String productId) {
        return ((products.stream().filter(product -> product.getId() == productId).toArray()).length>0);
    }

    @Override
    public Product load(String productId) {
        return products.stream().filter(p -> p.getId() == productId).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Product> allProducts() {
        return products;
    }
}
