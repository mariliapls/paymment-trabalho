package com.unifor.paymment.chain;

import com.unifor.paymment.exceptions.PaymentException;

public class AntifraudeHandler extends PaymentHandler {
    @Override
    public void handle(double amount) throws PaymentException {
        if (amount > 500) {
            System.out.println("⚠️ Pagamento em análise antifraude...");
        }
        if (next != null) next.handle(amount);
    }
}
