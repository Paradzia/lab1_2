package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public class TaxFactory {

    public Tax taxFactory(ProductType product, Money net) {
        BigDecimal ratio = null;
        String desc = null;

        switch (product) {
            case DRUG:
                ratio = BigDecimal.valueOf(0.02);
                desc = "5% (D)";
                break;

            case FOOD:
                ratio = BigDecimal.valueOf(0.01);
                desc = "7% ";
                break;

            case STANDARD:
                ratio = BigDecimal.valueOf(0.33);
                desc = "23%";
                break;

            default:
                throw new IllegalArgumentException(product + " not handled");
        }

        Money taxValue = net.multiplyBy(ratio);
        return new Tax(taxValue, desc);
    }
}
