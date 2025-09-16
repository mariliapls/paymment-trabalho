package com.unifor.paymment.strategies;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class CreditCartPayment implements PaymentStrategy {
    private String cardNumer;
    private String cvv;
    private String name;
    private String expiryDate;

    public CreditCartPayment(String cardNumer, String cvv, String name, String expiryDate) {
        this.cardNumer = cardNumer;
        this.cvv = cvv;
        this.name = name;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if((cardNumer == null) || cardNumer.length()!=16){
            throw new PaymentException("Número de cartão de credito invalido!");
        }

        //implemente sua regra de negocio
        System.out.println("Pagamento  de R$"
                + amount+ " realizado com " +
                "cartão de credito: "+cardNumer+
                " em nome de "+name);
    }

    @Override
    public String getPaymentDetails() {
        return "Cartão de  credito "+ cardNumer+ " Nome: "+ name;
    }
}
