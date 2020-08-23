/**
 * 
 */
package br.com.rpires.Translator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * @author rodrigo.pires
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void convertMourseToHumanFrase() {
		String expected = "Rodrigo";
		String mourseCode = ".-. --- -.. .-. .. --. --- ";
		String url = "http://localhost:" + port + "/mourseController/translate/human?mourseCode=" + mourseCode;
		String humanFrase = this.restTemplate.getForObject(url, String.class);
		assertEquals(expected.toUpperCase(), humanFrase);
	}
	
	@Test
	void convertHumanToMourse() {
		String expected = ".-. --- -.. .-. .. --. --- ";
		String humanFrase = "Rodrigo";
		String url = "http://localhost:" + port + "/mourseController/translate/mourse?humanFrase=" + humanFrase;
		String mourseCode = this.restTemplate.getForObject(url, String.class);
		assertEquals(expected, mourseCode);
	}
	
}
