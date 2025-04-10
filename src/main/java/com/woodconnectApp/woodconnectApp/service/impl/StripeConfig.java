package com.woodconnectApp.woodconnectApp.service.impl;

import org.springframework.context.annotation.Configuration;

import com.stripe.Stripe;

@Configuration
public class StripeConfig {
	public StripeConfig() {
        Stripe.apiKey = "pk_test_51R9Unl4PrKWbCQtii8gmO4NX90Mu8WYKJDwAR2UGt0xtIqzhBU4lF8YWY2hItKlrxX688QzvIFk6lpINcZ0eg5xB00DdIC1vEd"; // Replace with your actual secret key
    }
}
