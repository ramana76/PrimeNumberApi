package com.erpi.math.primenumber.dto;

import java.io.Serializable;

public class PrimeNumberApiRequest implements Serializable{
	private Integer numberOrRange;

	public PrimeNumberApiRequest() {
		
	}
	public PrimeNumberApiRequest(Integer numberOrRange) {
		this.numberOrRange = numberOrRange;
	}
	public int getNumberOrRange() {
		return numberOrRange;
	}

	public void setNumberOrRange(Integer numberRange) {
		this.numberOrRange = numberRange;
	}
}
