package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxPolicy {
    Tax calculateTax(RequestItem item);

}
