package com.tax_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.retry.annotation.Backoff;

@Service
public class TaxEngineService {
	@Autowired
	private NpwpActivatorClient npwpActivatorClient;

	@Retryable(value = {
			SoapFaultClientException.class }, maxAttempts = 2, backoff = @Backoff(delay = 100, maxDelay = 500))
	public boolean activate(String npwpToActivate) {
		Npwp npwp = new Npwp(npwpToActivate);
		return npwpActivatorClient.activate(npwp.format()).isSuccess();
	}
}
