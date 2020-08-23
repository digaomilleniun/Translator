/**
 * 
 */
package br.com.rpires.Translator.controller;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpires.Translator.service.IMourceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

/**
 * @author rodrigo.pires
 *
 */
@RestController
@RequestMapping(value = "/mourseController")
@CrossOrigin
@ApiResponses(
        value = {
        		@ApiResponse(responseCode = "200", description = "Operation performed successfully"),
        		@ApiResponse(responseCode = "500", description = "Internal error"),
        		@ApiResponse(responseCode = "400", description = "Bad Request"),
        		@ApiResponse(responseCode = "401", description = "Unauthorized")})
public class MourseController {
	
	@Autowired
	private IMourceService mourceService;

	@Operation(summary = "Trasnlate to human frase")
	@GetMapping(value = "translate/human")
	public ResponseEntity<String> convertToHumanFrase(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Mourse coude", required = true) String mourseCode) {
		return ResponseEntity.ok(mourceService.translateToHumanFrase(mourseCode));
	}
	
	@Operation(summary = "Translate to mourse code")
	@GetMapping(value = "translate/mourse")
	public ResponseEntity<String> convertToMourse(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Human frase", required = true) String humanFrase) {
		return ResponseEntity.ok(mourceService.translateToMourse(humanFrase));
	}
	
	@Operation(summary = "Translate to human frase")
	@GetMapping(value = "translate/binary/human")
	public ResponseEntity<String> convertBinaryToHumanFrase(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Binary value", required = true) String binary) {
		return ResponseEntity.ok(mourceService.translateBinaryToHumanFrase(binary));
	}
	
	@Operation(summary = "Translate to binary")
	@GetMapping(value = "translate/human/binary")
	public ResponseEntity<String> convertHumanFraseToBinary(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Human frase", required = true) String humanFrase) {
		return ResponseEntity.ok(mourceService.translateHumanFraseToBinary(humanFrase));
	}
	
	@Operation(summary = "Translate to mourse code")
	//@GetMapping(value = "translate/binary/mourse/code")
	public ResponseEntity<String> convertBinaryToMourse(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Binary value", required = true) String binary) {
		return ResponseEntity.ok(mourceService.translateBinaryToMourse(binary));
	}
	
	@Operation(summary = "Translate to binary")
	//@GetMapping(value = "translate/mourse/binary/code")
	public ResponseEntity<String> convertMourseToBinary(
			@RequestParam(required = true) @NotBlank @Parameter(description = "Mourse coude", required = true) String mourseCode) {
		return ResponseEntity.ok(mourceService.translateMourseToBinary(mourseCode));
	}
}
