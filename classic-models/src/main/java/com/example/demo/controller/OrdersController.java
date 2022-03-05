package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderDetailsRepository;
import com.example.demo.repository.OrdersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private OrderDetailsRepository ordersDetailsRepository;
	JsonObject orderDetails1 = new JsonObject();

	@GetMapping("/all-order-json")
	public String getpays() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray orderObject = JsonParser.parseString(mapper.writeValueAsString(ordersRepository.findAll()))
				.getAsJsonArray();
		JsonArray orderDetailsObject = JsonParser
				.parseString(mapper.writeValueAsString(ordersDetailsRepository.findAll())).getAsJsonArray();
		Iterator<JsonElement> order = orderObject.iterator();
		JsonArray arr = new JsonArray();
		String prodLinenum1 = "";
		String prodLinenum2 = "";
		while (order.hasNext()) {
			JsonObject ord = order.next().getAsJsonObject();
			prodLinenum1 = ord.get("orderNumber").getAsString();
			Iterator<JsonElement> orderDetails = orderDetailsObject.iterator();
			while (orderDetails.hasNext()) {
				JsonObject ordDet = orderDetails.next().getAsJsonObject();
				prodLinenum2 = ordDet.get("orderNumber").getAsString();
				if (prodLinenum1.equalsIgnoreCase(prodLinenum2)) {
					ord.add("orderExtraData", ordDet);
					arr.add(ord);
				}
			}
		}
		orderDetails1.add("orderData", arr);
		return orderDetails1.toString();
	}

}
