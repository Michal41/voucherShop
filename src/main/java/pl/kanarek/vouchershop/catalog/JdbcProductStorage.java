package pl.kanarek.vouchershop.catalog;

import pl.kanarek.vouchershop.catalog.ProductStorage;

import java.util.List;

public class JdbcProductStorage implements ProductStorage {

    @Override
    public void save(Product newProduct) {

    }

    @Override
    public boolean isExists(String productId) {
        return false;
    }

    @Override
    public Product load(String productId) {
        return null;
    }

    @Override
    public List<Product> allProducts() {
        return null;
    }
}
