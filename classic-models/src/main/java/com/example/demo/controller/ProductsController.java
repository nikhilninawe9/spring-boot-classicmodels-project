package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderDetailsRepository;
import com.example.demo.repository.ProductLinesRepository;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class ProductsController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductLinesRepository productLinesRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	JsonObject entireProduct = new JsonObject();

	@GetMapping("/get-entire-products")
	public String getEntireProducts() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray productLinesObject = JsonParser
				.parseString(mapper.writeValueAsString(productLinesRepository.findAll())).getAsJsonArray();
		JsonArray orderDetailsObject = JsonParser
				.parseString(mapper.writeValueAsString(orderDetailsRepository.findAll())).getAsJsonArray();
		JsonArray prodData = JsonParser.parseString(mapper.writeValueAsString(productRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> product = prodData.iterator();
		String prodCode1 = "";
		String prodCode2 = "";
		String prodLine1 = "";
		String prodLine2 = "";
		JsonArray finalArr = new JsonArray();
		while (product.hasNext()) {
			JsonArray ordArr1 = new JsonArray();
			JsonArray proLArr2 = new JsonArray();
			JsonObject obj1 = product.next().getAsJsonObject();
			prodCode1 = obj1.get("productCode").getAsString();
			prodLine1 = obj1.get("productLine").getAsString();
			Iterator<JsonElement> productLine = productLinesObject.iterator();
			while (productLine.hasNext()) {
				JsonObject obj3 = productLine.next().getAsJsonObject();
				prodLine2 = obj3.get("productLine").getAsString();
				if (prodLine1.equalsIgnoreCase(prodLine2)) {
					proLArr2.add(obj3);
					obj1.add("productLinesData", proLArr2);
				}
			}
			Iterator<JsonElement> order = orderDetailsObject.iterator();
			while (order.hasNext()) {
				JsonObject obj2 = order.next().getAsJsonObject();
				prodCode2 = obj2.get("productCode").getAsString();
				if (prodCode1.equalsIgnoreCase(prodCode2)) {
					ordArr1.add(obj2);
					obj1.add("orderDetailsData", ordArr1);
				}
			}
			finalArr.add(obj1);
		}
		entireProduct.add("productsData", finalArr);
		return entireProduct.toString();
	}
}
