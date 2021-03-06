/**
 * 
 */
package br.com.rpires.Translator.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

/**
 * @author rodrigo.pires
 *
 */
@Service
public class MourceService implements IMourceService {
	
	private final Map<String, String> morseAlphabet = new HashMap<>();
	
	private final Pattern charsplit = Pattern.compile(" ");
	
	public MourceService() {
		morseAlphabet.put("", " ");
        morseAlphabet.put(".-", "A");
        morseAlphabet.put("-...", "B");
        morseAlphabet.put("-.-.", "C");
        morseAlphabet.put("-..", "D");
        morseAlphabet.put(".", "E");
        morseAlphabet.put("..-.", "F");
        morseAlphabet.put("--.", "G");
        morseAlphabet.put("....", "H");
        morseAlphabet.put("..", "I");
        morseAlphabet.put(".---", "J");
        morseAlphabet.put("-.-", "K");
        morseAlphabet.put(".-..", "L");
        morseAlphabet.put("--", "M");
        morseAlphabet.put("-.", "N");
        morseAlphabet.put("---", "O");
        morseAlphabet.put(".--.", "P");
        morseAlphabet.put("--.-", "Q");
        morseAlphabet.put(".-.", "R");
        morseAlphabet.put("...", "S");
        morseAlphabet.put("-", "T");
        morseAlphabet.put("..-", "U");
        morseAlphabet.put("...-", "V");
        morseAlphabet.put(".--", "W");
        morseAlphabet.put("-..-", "X");
        morseAlphabet.put("-.--", "Y");
        morseAlphabet.put("--..", "Z");
        morseAlphabet.put("-----", "0");
        morseAlphabet.put(".----", "1");
        morseAlphabet.put("..---", "2");
        morseAlphabet.put("...--", "3");
        morseAlphabet.put("....-", "4");
        morseAlphabet.put(".....", "5");
        morseAlphabet.put("-....", "6");
        morseAlphabet.put("--...", "7");
        morseAlphabet.put("---..", "8");
        morseAlphabet.put("----.", "9");
        morseAlphabet.put(".-.-.-", ".");
        morseAlphabet.put("--..--", ",");
        morseAlphabet.put("..--..", "?");
        morseAlphabet.put("-.-.--", "!");
        morseAlphabet.put("-....-", "-");
        morseAlphabet.put("-..-.", "/");
        morseAlphabet.put(".--.-.", "@");
        morseAlphabet.put("-.--.", "(");
        morseAlphabet.put("-.--.-", ")");
        morseAlphabet.put("/", " ");
	}

	@Override
	public String translateToMourse(String humanFrase) {
		return decodeLineToMourse(humanFrase);
	}

	@Override
	public String translateToHumanFrase(String mourseFrase) {
		return decodeLineToHuman(mourseFrase);
	}
	
	@Override
	public String translateBinaryToHumanFrase(String binary) {
		return convertBinaryToString(binary);
	}
	
	@Override
	public String translateHumanFraseToBinary(String humanFrase) {
		String frase = convertStringToBinary(humanFrase);
		return prettyBinary(frase, 8, " ");
	}
	
	@Override
	public String translateBinaryToMourse(String binary) {
		String humanFrase = convertBinaryToString(binary);
		return decodeLineToMourse(humanFrase);
	}

	@Override
	public String translateMourseToBinary(String mourseCode) {
		String humanFrase = decodeLineToHuman(mourseCode);
		return translateHumanFraseToBinary(humanFrase);
	}
	
	private String decodeLineToHuman(String line) {
        return charsplit.splitAsStream(line)
                   .map(letter -> morseAlphabet.get(letter))
                   .collect(Collectors.joining(""));
    }
	
	private String decodeLineToMourse(String line) {
		String result = "";
		char[] chars = line.toCharArray();
		for (int j = 0; j < chars.length; j++) {
			for (Map.Entry<String, String> entry : morseAlphabet.entrySet()) {
			    if (entry.getValue().equalsIgnoreCase(String.valueOf(chars[j]))) {
			    	result+= entry.getKey()+" ";
			    }
			}
		}
		return result;
		
    }
	
	public String convertBinaryToString(String binary) {
		
		String raw = Arrays.stream(binary.split(" "))
                .map(value -> Integer.parseInt(value, 2))
                .map(Character::toString)
                .collect(Collectors.joining());
		return raw;
		
	}
	
	public String convertStringToBinary(String humanFrase) {

        StringBuilder result = new StringBuilder();
        char[] chars = humanFrase.toCharArray();
        for (char aChar : chars) {
            result.append(
                    String.format("%8s", Integer.toBinaryString(aChar))   // char -> int, auto-cast
                            .replaceAll(" ", "0")                         // zero pads
            );
        }
        return result.toString();

    }

    public String prettyBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }

}
