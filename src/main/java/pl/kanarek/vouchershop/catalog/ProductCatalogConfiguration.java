package pl.kanarek.vouchershop.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProductCatalogConfiguration {

    ProductCatalog myProductCatalog(){
        return new ProductCatalog();
    }

    @Bean
    ProductCatalog myFictureCatalog(){
        ProductCatalog catalog = new ProductCatalog();

        var p1 = catalog.registerProduct();
        catalog.applyPrice(p1,BigDecimal.TEN);
        catalog.updateDetails(p1,"this is description","url to image");


        return catalog;
    }
}
