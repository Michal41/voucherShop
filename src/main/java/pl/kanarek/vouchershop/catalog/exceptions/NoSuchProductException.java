package pl.kanarek.vouchershop.catalog.exceptions;

public class NoSuchProductException extends ProductCatalogException {
    public NoSuchProductException(String message) {
        super(message);
    }
}
