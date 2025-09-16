package com.unifor.paymment.strategies;

import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.interfaces.PaymentStrategy;

public class BoletoPayment implements PaymentStrategy {

    private String codigoBarras;
    private String beneficiario;

    public BoletoPayment(String codigoBarras, String beneficiario) {
        this.codigoBarras = codigoBarras;
        this.beneficiario = beneficiario;
    }

    @Override
    public void pay(double amount) throws PaymentException {
        if (codigoBarras == null || codigoBarras.isEmpty()) {
            throw new PaymentException("Código de barras inválido para boleto!");
        }

        System.out.println("Pagamento de R$ "
                + amount + " realizado via boleto. Código de barras: "
                + codigoBarras + " | Beneficiário: " + beneficiario);
    }

    @Override
    public String getPaymentDetails() {
        return "Boleto: Código de barras " + codigoBarras
                + " | Beneficiário: " + beneficiario;
    }
}
