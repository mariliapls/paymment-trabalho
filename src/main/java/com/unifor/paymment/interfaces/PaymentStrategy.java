package com.unifor.paymment.interfaces;

import com.unifor.paymment.exceptions.PaymentException;

public interface PaymentStrategy {
    public void pay(double amount) throws PaymentException;

    public String getPaymentDetails();
}
