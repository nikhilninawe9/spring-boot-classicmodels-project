package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderDetailsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class OrderDetailsController {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	@GetMapping("/gatAllorderDetails")
	public String getAllOrderDetails() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray orderObject = JsonParser.parseString(mapper.writeValueAsString(orderDetailsRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> order = orderObject.iterator();
		JsonObject obj = null;
		Double totalPriceEachProduct = 0.0;
		while (order.hasNext()) {
			obj = order.next().getAsJsonObject();
			Double price = obj.get("priceEach").getAsDouble();
			Integer quantity = obj.get("quantityOrdered").getAsInt();
			totalPriceEachProduct = price * quantity;
			obj.addProperty("totalPricePerOrder", totalPriceEachProduct);
		}
		return orderObject.toString();
	}
}
