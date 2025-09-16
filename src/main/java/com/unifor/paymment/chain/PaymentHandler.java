package com.unifor.paymment.chain;

import com.unifor.paymment.exceptions.PaymentException;

public abstract class PaymentHandler {
    protected PaymentHandler next;

    public PaymentHandler setNext(PaymentHandler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(double amount) throws PaymentException;
}
