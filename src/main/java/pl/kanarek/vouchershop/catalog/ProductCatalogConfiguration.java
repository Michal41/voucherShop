package pl.kanarek.vouchershop.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {

    ProductCatalog myProductCatalog(){
        return new ProductCatalog(new HashMapProductStorage());
    }

    @Bean
    ProductStorage myHashMapProductStorage() {
        return new HashMapProductStorage();
    }

    @Bean
    ProductCatalog myFictureCatalog(ProductStorage productStorage){
        ProductCatalog catalog = new ProductCatalog(productStorage);

        var p1 = catalog.registerProduct();
        catalog.applyPrice(p1,BigDecimal.TEN);
        catalog.updateDetails(p1,"this is description","url to image");


        return catalog;
    }
}
