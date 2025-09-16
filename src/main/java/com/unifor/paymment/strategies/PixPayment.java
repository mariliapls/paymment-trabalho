package com.unifor.paymment.strategies;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class PixPayment implements PaymentStrategy {

    private String pixKey;
    private String beneficiary;

    public PixPayment(String pixKey, String beneficiary) {
        this.pixKey = pixKey;
        this.beneficiary = beneficiary;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if(pixKey == null || pixKey.isEmpty()){
            throw new PaymentException("Chave pix invalido! ");
        }

        System.out.println("Pagamento de R$ "
                + amount+ " realizado via pix "+ pixKey+ "para "+beneficiary);
    }

    @Override
    public String getPaymentDetails() {
    return "Pix: Chave "+pixKey+ "Beneficiario: "+beneficiary;
    }
}
