package com.unifor.paymment.builders;

import com.unifor.paymment.strategies.BoletoPayment;

public class BoletoPaymentBuilder {
    private String codigoBarras;
    private String beneficiario;

    public BoletoPaymentBuilder setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
        return this;
    }

    public BoletoPaymentBuilder setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
        return this;
    }

    public BoletoPayment build() {
        return new BoletoPayment(codigoBarras, beneficiario);
    }
}
