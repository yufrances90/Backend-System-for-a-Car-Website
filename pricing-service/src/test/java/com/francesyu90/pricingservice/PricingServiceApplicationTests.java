package com.francesyu90.pricingservice;

import com.francesyu90.pricingservice.models.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class PricingServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllPrices() {

		String url = "http://localhost:" + this.port + "/prices";

		ResponseEntity<Map> result = this.restTemplate.getForEntity(url,
				Map.class);

		Assertions.assertEquals(result.getStatusCode().value(), 200);

		Map<String, Object> resultMap = result.getBody();

		Map<String, Object> embeddedMap = (Map) resultMap.get(
				"_embedded");

		List<Price> priceList = (List<Price>) embeddedMap.get("prices");

		Assertions.assertTrue(priceList.isEmpty());
	}

}
