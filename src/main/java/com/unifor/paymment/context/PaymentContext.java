package com.unifor.paymment.context;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;;
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount){
        try{
            paymentStrategy.pay(amount);
        }catch(PaymentException e){
            System.out.println("Erro au efetuar pagamento!");
        }
    }
}
