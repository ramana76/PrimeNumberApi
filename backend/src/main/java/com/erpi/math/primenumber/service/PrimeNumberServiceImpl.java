package com.erpi.math.primenumber.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

@Service
public class PrimeNumberServiceImpl implements PrimeNumberService{

	@Override
	public List<Integer> getAllPrimeNumbersInRange(Integer numberRage) {
		// An array of Boolean values represents the index number is a prime or not
		Boolean primeNumberIndexArray[] = new Boolean[numberRage + 1];
		
		// Initially set all indexes to true
	    Arrays.fill(primeNumberIndexArray, true);
	    
	    // Start with 2 the smallest prime number
	    // and Enumerate the multiples of each number from 2 to numberRange
	    for (int primeIndex = 2; primeIndex * primeIndex <= numberRage; primeIndex++) {
	    	
	    	// Mark all the multiples of the given number as not Prime
	        if (primeNumberIndexArray[primeIndex]) {
	            for (int i = primeIndex * 2; i <= numberRage; i += primeIndex) {
	                primeNumberIndexArray[i] = false;
	            }
	        }
	    }
	    
	    List<Integer> primeNumbers = IntStream.range(2, primeNumberIndexArray.length)
						                .filter(i -> Arrays.asList(primeNumberIndexArray).get(i))
						                .mapToObj(Integer::valueOf)
						                .collect(Collectors.toList());

	    return primeNumbers;
	}

	@Override
	public Boolean isPrimeNumber(Integer number) {
		return IntStream.rangeClosed(2, (int) (Math.sqrt(number))).allMatch(n -> number % n != 0);
	}

}
