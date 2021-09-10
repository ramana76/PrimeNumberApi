package com.erpi.math.primenumber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.erpi.math.primenumber.dto.PrimeNumberApiRequest;
import com.erpi.math.primenumber.service.PrimeNumberService;

@RestController
@RequestMapping("/api/primenumber")
public class PrimeNumberController{

	@Autowired
	private PrimeNumberService primeNumberService;

	@RequestMapping(value = "/getPrimeNumbersInRange", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<Integer>> getAllPrimeNumbersInRange(@RequestBody PrimeNumberApiRequest apiRequest) {

		return new ResponseEntity<List<Integer>>(primeNumberService.getAllPrimeNumbersInRange(apiRequest.getNumberOrRange()), HttpStatus.OK);
	}

	@PostMapping("/isPrimeNumber")
	public Boolean isPrimeNumber(@RequestBody PrimeNumberApiRequest apiRequest) {
		return primeNumberService.isPrimeNumber(apiRequest.getNumberOrRange());
	}

}
