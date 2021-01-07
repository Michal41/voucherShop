package pl.kanarek.vouchershop;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import pl.kanarek.vouchershop.catalog.HashMapProductStorage;
import pl.kanarek.vouchershop.catalog.JdbcProductStorage;
import pl.kanarek.vouchershop.catalog.ProductCatalog;

@SpringBootApplication
public class App {

    public static void main(String[] args){
        System.out.println("Hello word");

//        ProductCatalog catalog;
//
//        if (System.getenv("ENV").equals("dev")){
//            catalog = new ProductCatalog(new HashMapProductStorage());
//        }else {
//            catalog = new ProductCatalog( new JdbcProductStorage());
//        }

        SpringApplication.run(App.class, args);

    }
}


