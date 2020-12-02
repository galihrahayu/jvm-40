package com.tax_engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tax_engine.tax_activator.wsdl.ActivateNpwpResponse;

@RestController
public class TaxEngineController {

	@Autowired
	private TaxEngineService taxEngineService;

	@GetMapping("/activate/{npwp}")
	ActivateNpwpResponse activate(@PathVariable String npwp) {
		return taxEngineService.activate(npwp);
	}
}
