package br.com.rpires.Translator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.rpires.Translator.service.IMourceService;

@SpringBootTest
class TranslatorApplicationTests {
	
	@Autowired
	private IMourceService mourceService;

	@Test
	void convertToHumanFrase() {
		String expected = "Rodrigo";
		String mourseCode = ".-. --- -.. .-. .. --. --- ";
		String humanFrase = mourceService.translateToHumanFrase(mourseCode);
		assertEquals(expected.toUpperCase(), humanFrase);
	}
	
	@Test
	void convertToMourse() {
		String expected = ".-. --- -.. .-. .. --. --- ";
		String humanFrase = "Rodrigo";
		String mourseCode = mourceService.translateToMourse(humanFrase);
		assertEquals(expected, mourseCode);
	}
	
	@Test
	void convertBinaryToHumanFrase() {
		String expectedHuman = "Rodrigo";
		String binary = "01010010 01101111 01100100 01110010 01101001 01100111 01101111";
		String humanFrase = mourceService.translateBinaryToHumanFrase(binary);
		assertEquals(expectedHuman, humanFrase);
	}
	
	@Test
	void convertHumanFraseToBinary() {
		String expectedBinary = "01010010 01101111 01100100 01110010 01101001 01100111 01101111";
		String human = "Rodrigo";
		String binary = mourceService.translateHumanFraseToBinary(human);
		assertEquals(expectedBinary, binary);
	}

}
