package com.partner.taxactivator;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.partner.npwp.activator.ActivateNpwpRequest;
import com.partner.npwp.activator.ActivateNpwpResponse;

@Endpoint
public class NpwpActivatorEndpoint {
	private static final String NAMESPACE_URI = "http://partner.com/npwp/activator";

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "activateNpwpRequest")
	@ResponsePayload
	public ActivateNpwpResponse activateNpwp(@RequestPayload ActivateNpwpRequest request) {
		ActivateNpwpResponse response = new ActivateNpwpResponse();

		// validation to check valid NPWP
		if (request.getNpwp().contains(".") && request.getNpwp().contains("-")) {
			response.setSuccess(true);
		}
		return response;
	}
}