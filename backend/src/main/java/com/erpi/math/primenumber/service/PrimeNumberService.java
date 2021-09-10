package com.erpi.math.primenumber.service;

import java.util.List;

public interface PrimeNumberService {
	public List<Integer> getAllPrimeNumbersInRange(Integer numberRage);
	public Boolean isPrimeNumber(Integer number);
}
