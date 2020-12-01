package com.tax_engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.tax_engine.tax_activator.wsdl.ActivateNpwpRequest;
import com.tax_engine.tax_activator.wsdl.ActivateNpwpResponse;

public class NpwpActivatorClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(NpwpActivatorClient.class);

	public ActivateNpwpResponse activate(String npwp) {

		ActivateNpwpRequest request = new ActivateNpwpRequest();
		request.setNpwp(npwp);

		log.info("Requesting location for " + npwp);

		ActivateNpwpResponse response = (ActivateNpwpResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8081/ws/activator", request,
				new SoapActionCallback("http://partner.com/npwp/activator/activateNpwpRequest"));

		return response;
	}

}