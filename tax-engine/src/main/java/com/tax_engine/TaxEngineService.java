package com.tax_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxEngineService {
	@Autowired
	private NpwpActivatorClient npwpActivatorClient;

	public boolean activate(String npwpToActivate) {
		Npwp npwp = new Npwp(npwpToActivate);
		return npwpActivatorClient.activate(npwp.format()).isSuccess();
	}
}
