/**
 * 
 */
package br.com.rpires.Translator.service;

/**
 * @author rodrigo.pires
 *
 */
public interface IMourceService {

	/**
	 * Translate human frase to mourse code
	 * 
	 * @param humanFrase
	 * @return Mourse code
	 */
	public String translateToMourse(String humanFrase);
	
	/**
	 * Translate mourse code to human frase
	 * 
	 * @param mourseCode
	 * @return Human frase
	 */
	public String translateToHumanFrase(String mourseCode);
	
	/**
	 * Translate binary to human frase
	 * 
	 * @param binary
	 * @return Human frase
	 */
	public String translateBinaryToHumanFrase(String binary);
	
	/**
	 * Translate human frase to binary
	 * 
	 * @param humanFrase
	 * @return binary
	 */
	public String translateHumanFraseToBinary(String humanFrase);
	
	/**
	 * Translate binary to mourse code
	 * 
	 * @param binary
	 * @return mourse code
	 */
	public String translateBinaryToMourse(String binary);
	
	/**
	 * Translate mourse code to binary
	 * 
	 * @param mourse code
	 * @return binary
	 */
	public String translateMourseToBinary(String mourseCode);
}
