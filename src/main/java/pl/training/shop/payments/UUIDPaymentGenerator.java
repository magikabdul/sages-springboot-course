package pl.training.shop.payments;

import java.util.UUID;

public class UUIDPaymentGenerator {

    public String getNext() {
        return UUID.randomUUID().toString();
    }
}
