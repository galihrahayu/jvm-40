package com.tax_engine;
public class Npwp {
	private String kode;

	public Npwp(String kode) {
		this.kode = kode;
		
		// make sure we get unformat kode
		this.kode = this.kode.replaceAll("[.-]", "");
	}

	public String getKode() {
		return kode;
	}

	public void setKode(String kode) {
		this.kode = kode;
	}

	public String format() {
		return String.format("%s%s.%s%s%s.%s%s%s.%s-%s%s%s.%s%s%s", 
				this.kode.charAt(0), 
				this.kode.charAt(1),
				this.kode.charAt(2), 
				this.kode.charAt(3), 
				this.kode.charAt(4), 
				this.kode.charAt(5), 
				this.kode.charAt(6),
				this.kode.charAt(7), 
				this.kode.charAt(8), 
				this.kode.charAt(9), 
				this.kode.charAt(10),
				this.kode.charAt(11), 
				this.kode.charAt(12), 
				this.kode.charAt(13), 
				this.kode.charAt(14));
	}
}
