package pl.kanarek.vouchershop.catalog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatalogController {
    private final ProductCatalog catalog;

    public CatalogController(ProductCatalog catalog) {
        this.catalog = catalog;
    }

    @GetMapping("/api/prodcuts")
    public List<Product> allProducts(){
        return catalog.allPublished();
    }
}
