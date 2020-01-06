package com.practice.springbootdbexample;

import com.practice.springbootdbexample.controller.EmployeeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class SpringbootDbExampleApplicationTests {

	@Autowired
	protected TestRestTemplate testRestTemplate;
	HttpHeaders httpHeaders = new HttpHeaders();

	@LocalServerPort
	private int port;

	@Test
	@Sql("/test.sql")
	public void testGetEmployee(){
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<String> response = testRestTemplate
				.exchange(createURLWithPort("/rest/employee/getEmployee"),
						HttpMethod.GET, entity, String.class);
		System.out.println("response.getHeaders()::::"+response.getHeaders());
		System.out.println("response.getBody():::::::"+response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
