package com.unifor.paymment.chain;

import com.unifor.paymment.exceptions.PaymentException;

public class SaldoHandler extends PaymentHandler {
    @Override
    public void handle(double amount) throws PaymentException {
        if (amount > 1000) {
            throw new PaymentException("Saldo insuficiente!");
        }
        if (next != null) next.handle(amount);
    }
}
