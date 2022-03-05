package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ProductLines;
import com.example.demo.repository.ProductLinesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class ProductLinesController {
	@Autowired
	private ProductLinesRepository productLinesRepository;

	@Autowired
	private ProductLines productLines;

	@GetMapping("/all-productLines")
	public String getAllPayments() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray orderdetailsObject = JsonParser
				.parseString(mapper.writeValueAsString(productLinesRepository.findAll())).getAsJsonArray();
		return orderdetailsObject.toString();
	}

	// Saving just the image file..
	@PostMapping("/insertImgDescription")
	public String saveImageDescription(@RequestParam("file") MultipartFile file) throws IOException {
		productLines.setProductLineNumber(8);
		productLines.setHtmlDescription("Brief about classic cars.");
		productLines.setImage(file.getBytes());
		productLines.setProductLine("Classic World War cars!..");
		productLines.setTextDescription(
				"A classic car is an older car, typically 25 years or older, though definitions vary.\"\r\n"
						+ "						+ \"[note 1] The common theme is of an older car of historical interest to be collectible and tend \"\r\n"
						+ "						+ \"to be restored rather than scrapped. Classic cars are a subset of a broader category of \"\r\n"
						+ "						+ \"\\\"collector cars\\\" (which includes both restored classic cars vehicles and newer exotic vehicles). \"\r\n"
						+ "						+ \"A subset of what is considered classic cars are known as antique cars (manufactured before 1980) \"\r\n"
						+ "						+ \"or vintage cars (manufactured pre-World War II.[1]");
		productLinesRepository.save(productLines);
		return "Image and description has been saved. ";
	}

	// Here we need to convert the image into byte code [base64] any paste that
	// binary string to the image attribute.
	// We can see the datatypes or annotations from class file.
	@PostMapping("/addProductLine")
	private String saveProductLine(@RequestBody ProductLines productLines) throws IOException {
		productLinesRepository.save(productLines);
		return "Image and description has been saved. ";
	}

}
