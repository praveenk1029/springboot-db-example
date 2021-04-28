package com.practice.springbootdbexample;

import com.practice.springbootdbexample.model.Employee;
import com.practice.springbootdbexample.service.EmployeeService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import org.springframework.boot.context.embedded.LocalServerPort;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class SpringbootDbExampleApplicationTests {

	@Autowired
	protected MockMvc mockMvc;
	@Autowired
	protected TestRestTemplate testRestTemplate;
	@Autowired
	protected EmployeeService employeeService;
	/*@LocalServerPort
	private int port;*/
	HttpHeaders httpHeaders = new HttpHeaders();

	@Test
	public void setUp(){
		System.out.println("mockMvc:::"+mockMvc);
	}

	@Test
	public void retrieveEmployee() throws Exception {
		Employee employee = employeeService.findByEmpId(2);
		System.out.println("Employee:::"+employee.getEmpFirstName());
	}

	//Testing with MockMvc
	@Test
	@Sql("/test.sql")
	public void testEmployeeJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/rest/employee/getEmployee/2")
		.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.empFirstName", Matchers.is("Allen")));
	}

	/*@Test
	@Sql("/test.sql")
	public void testGetEmployee(){
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<String> response = testRestTemplate
				.exchange(createURLWithPort("/rest/employee/getEmployee/9"),
						HttpMethod.GET, entity, String.class);
		System.out.println("response.getHeaders()::::"+response.getHeaders());
		System.out.println("response.getBody():::::::"+response.getBody());
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}*/

//	private String createURLWithPort(String uri) {
//		return "http://localhost:" + port + uri;
//	}

}
