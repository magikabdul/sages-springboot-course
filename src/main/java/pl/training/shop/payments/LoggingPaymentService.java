package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

@Log
@RequiredArgsConstructor
@Component
public class LoggingPaymentService implements PaymentService {

    public static final String LOG_FORMAT = "A new payment of %s has been initiated";
    private final FakePaymentService paymentService;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        Payment payment = paymentService.process(paymentRequest);
        log.info(createLogEntry(payment));
        return payment;
    }

    private String createLogEntry(Payment payment) {
        return String.format(LOG_FORMAT, payment.getMoney());
    }
}
