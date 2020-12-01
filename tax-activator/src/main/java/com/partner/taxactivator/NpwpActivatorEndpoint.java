package com.partner.taxactivator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.partner.npwp.activator.ActivateNpwpRequest;
import com.partner.npwp.activator.ActivateNpwpResponse;

@Endpoint
public class NpwpActivatorEndpoint {
	private static final Logger log = LoggerFactory.getLogger(NpwpActivatorEndpoint.class);
	private static final String NAMESPACE_URI = "http://partner.com/npwp/activator";

	// we utilize spring singleton
	private boolean internalRandomError;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "activateNpwpRequest")
	@ResponsePayload
	public ActivateNpwpResponse activateNpwp(@RequestPayload ActivateNpwpRequest request) throws Exception {
		ActivateNpwpResponse response = new ActivateNpwpResponse();

		// next random error
		internalRandomError = !internalRandomError;

		if (internalRandomError) {
			log.info("Internal Random error triggered!");
			throw new Exception("Internal Random error!");
		}

		// validation to check valid NPWP
		if (request.getNpwp().contains(".") && request.getNpwp().contains("-")) {
			response.setSuccess(true);
		}
		return response;
	}
}