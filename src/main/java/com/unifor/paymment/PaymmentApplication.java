package com.unifor.paymment;

import com.unifor.paymment.builders.BoletoPaymentBuilder;
import com.unifor.paymment.chain.AntifraudeHandler;
import com.unifor.paymment.chain.PaymentHandler;
import com.unifor.paymment.chain.SaldoHandler;
import com.unifor.paymment.context.PaymentContext;
import com.unifor.paymment.exceptions.PaymentException;
import com.unifor.paymment.factories.PaymentFactory;
import com.unifor.paymment.interfaces.PaymentStrategy;
import com.unifor.paymment.strategies.BoletoPayment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymmentApplication.class, args);

		try {
			// Pagamento com Cartão de crédito
			PaymentStrategy creditCard = PaymentFactory.createPayment(
					"creditcard",
					"1234567812345678",
					"123",
					"Jully Emerson",
					"12/26"
			);
			PaymentContext context1 = new PaymentContext(creditCard);
			context1.executePayment(55.17);

			// Pagamento via PIX
			PaymentStrategy pix = PaymentFactory.createPayment(
					"pix",
					"joaooliveira@gmail.com",
					"Joao Oliveira"
			);
			PaymentContext context2 = new PaymentContext(pix);
			context2.executePayment(150);

			// Pagamento via Boleto
			PaymentStrategy boletoFactory = PaymentFactory.createPayment(
					"boleto",
					"34191.79001 01043.510047 91020.150008 5 12340000010000",
					"Universidade de Fortaleza"
			);
			PaymentContext context3 = new PaymentContext(boletoFactory);
			context3.executePayment(250.75);

			// Builder
			System.out.println("\n=== Pagamento com Builder ===");
			BoletoPayment boletoBuilder = new BoletoPaymentBuilder()
					.setCodigoBarras("23790.12345 60001.234567 89012.345678 1 12340000015000")
					.setBeneficiario("Loja de Livros Online")
					.build();
			boletoBuilder.pay(300.00);

			// Chain of Responsibility
			System.out.println("\n=== Validações com Chain of Responsibility ===");
			PaymentHandler chain = new SaldoHandler();
			chain.setNext(new AntifraudeHandler());
			chain.handle(400.0); // passa pelas duas validações

		} catch (PaymentException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
