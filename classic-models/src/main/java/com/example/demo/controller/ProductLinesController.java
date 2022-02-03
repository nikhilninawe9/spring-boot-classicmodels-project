package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping("/all-productLines")
	public String getAllPayments() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray orderdetailsObject = JsonParser
				.parseString(mapper.writeValueAsString(productLinesRepository.findAll())).getAsJsonArray();
		return orderdetailsObject.toString();
	}

}
