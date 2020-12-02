package com.tax_engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.tax_engine.Npwp;

class NpwpTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testFormatWithUnformattedKodeShouldReturnFormattedKode() {
		Npwp npwp = new Npwp("0123456789012345");
		assertEquals("01.234.567.8-901.234", npwp.format());
	}

	@Test
	void testFormatWithformattedKodeShouldReturnFormattedKode() {
		Npwp npwp = new Npwp("01.234.567.8-901.234");
		assertEquals("01.234.567.8-901.234", npwp.format());
	}
}
