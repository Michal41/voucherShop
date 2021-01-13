package pl.kanarek.vouchershop.catalog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductCatalogHttpTest {
    @LocalServerPort
    int port;

    @Autowired
    ProductCatalog productCatalog;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Before
    public void emptyCatalo() {
        productCatalog.clean();
    }

    @Test
    public void itShowsAllPublishedProducts() {
        thereIsDraftProduct("draft product");
        ThereIsReadyToSellProduct("Product 1");
        ThereIsReadyToSellProduct("Product 2");



        var url = String.format("http://localhost:%s/api/products", port);
        ResponseEntity<Product[]> response =
                testRestTemplate.getForEntity(url, Product[].class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody()).hasSize(2)
                .extracting(p -> p.getDescription())
                .contains("Product 1", "Product 2")
                .doesNotContain("draft product");

    }

    private void ThereIsReadyToSellProduct(String name) {
        var prod = productCatalog.registerProduct();
        productCatalog.updateDetails(prod, name, name);
        productCatalog.applyPrice(prod, BigDecimal.valueOf(20.20));
    }

    private void thereIsDraftProduct(String name) {
        var prod = productCatalog.registerProduct();
        productCatalog.updateDetails(prod, name, name);
    }


}
