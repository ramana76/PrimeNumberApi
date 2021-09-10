package com.erpi.math.primenumber;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.erpi.math.primenumber.dto.PrimeNumberApiRequest;
import com.erpi.math.primenumber.service.PrimeNumberService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class PrimeNumberApiApplicationTests {
	@Autowired
    private MockMvc mockMvc;
	@Autowired
	private PrimeNumberService primeNumberService;
	
	private List PRIME_NUMBERS_FOR_RANGEOF30 = Arrays.asList(new int[]{2,3,5,7,11,13,17,19,23,29}); 
	private int PRIME_NUMBER = 29;
	private int NOT_A_PRIME_NUMBER = 30;
	
	@Test
    public void TestGetPrimeNumbersInRange() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		PrimeNumberApiRequest apiRequest = new PrimeNumberApiRequest(30);

        mockMvc.perform(post("/api/primenumber/getPrimeNumbersInRange")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(apiRequest)))
                .andDo(print())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$", hasSize(PRIME_NUMBERS_FOR_RANGEOF30.size())))
                .andExpect(jsonPath("$[0]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(0)))
                .andExpect(jsonPath("$[1]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(1)))
                .andExpect(jsonPath("$[2]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(2)))
                .andExpect(jsonPath("$[3]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(3)))
                .andExpect(jsonPath("$[4]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(4)))
                .andExpect(jsonPath("$[5]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(5)))
                .andExpect(jsonPath("$[6]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(6)))
                .andExpect(jsonPath("$[7]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(7)))
                .andExpect(jsonPath("$[8]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(8)))
                .andExpect(jsonPath("$[9]").value(PRIME_NUMBERS_FOR_RANGEOF30.get(9)))
                .andExpect(status().isOk());
    }
	
	@Test
    public void TestIsPrimeNumberWithValidPrimeNumber() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		PrimeNumberApiRequest apiRequest = new PrimeNumberApiRequest(PRIME_NUMBER);

        mockMvc.perform(post("/api/primenumber/isPrimeNumber")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(apiRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("true"));
    }
	
	@Test
    public void TestIsPrimeNumberWithInValidPrimeNumber() throws Exception {
		
		ObjectMapper objectMapper = new ObjectMapper();
		PrimeNumberApiRequest apiRequest = new PrimeNumberApiRequest(NOT_A_PRIME_NUMBER);

        mockMvc.perform(post("/api/primenumber/isPrimeNumber")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(apiRequest)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("false"));
    }

}
