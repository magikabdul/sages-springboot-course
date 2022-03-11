package pl.training.shop;

import lombok.extern.java.Log;
import pl.training.shop.payments.FakePaymentService;
import pl.training.shop.payments.IncrementaPaymentIdGenerator;
import pl.training.shop.payments.LocalMoney;
import pl.training.shop.payments.LoggingPaymentService;
import pl.training.shop.payments.PaymentRequest;

@Log
public class Application {

    public static void main(String[] args) {
        var paymentIdGenerator = new IncrementaPaymentIdGenerator();

        var fakePaymentService = new FakePaymentService(paymentIdGenerator);
        var paymentService = new LoggingPaymentService(fakePaymentService);
        var paymentRequest = PaymentRequest.builder()
                .money(LocalMoney.of(1_000))
                .build();
        var payment = paymentService.process(paymentRequest);

        log.info(payment.toString());
    }
}
