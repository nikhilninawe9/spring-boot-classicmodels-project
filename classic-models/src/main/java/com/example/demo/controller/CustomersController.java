package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customers;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.repository.PaymentsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class CustomersController {
	JsonObject entireCustomerDetails = new JsonObject();

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PaymentsRepository paymentsRepository;
	@Autowired
	private OrdersRepository orderRepository;

	@GetMapping("/all-custs")
	public List<Customers> getCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/getcust-withorder")
	public String getFullCustData() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray allCustomers = JsonParser.parseString(mapper.writeValueAsString(customerRepository.findAll()))
				.getAsJsonArray();
		JsonArray ordersObject = JsonParser.parseString(mapper.writeValueAsString(orderRepository.findAll()))
				.getAsJsonArray();
		JsonArray paymentsObject = JsonParser.parseString(mapper.writeValueAsString(paymentsRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> customer = allCustomers.iterator();
		int custNum1 = 0;
		int custNum2 = 0;
		JsonArray finArr = new JsonArray();
		while (customer.hasNext()) {
			JsonArray arr1 = new JsonArray();
			JsonArray arr2 = new JsonArray();
			JsonObject obj1 = customer.next().getAsJsonObject();
			custNum1 = obj1.get("customerNumber").getAsInt();
			Iterator<JsonElement> pay = paymentsObject.iterator();
			while (pay.hasNext()) {
				JsonObject obj22 = pay.next().getAsJsonObject();
				custNum2 = obj22.get("customerNumber").getAsInt();
				if (custNum1 == custNum2) {
					arr1.add(obj22);
					obj1.add("customerPayments", arr1);
				}
			}
			Iterator<JsonElement> order = ordersObject.iterator();
			while (order.hasNext()) {
				JsonObject obj2 = order.next().getAsJsonObject();
				custNum2 = obj2.get("customerNumber").getAsInt();
				if (custNum1 == custNum2) {
					arr2.add(obj2);
					obj1.add("orderData", arr2);
				}
			}
			finArr.add(obj1);
		}
		entireCustomerDetails.add("customerDetails", finArr);
		return entireCustomerDetails.toString();
	}

	// Getting the mixed data from database in the form of objects logic.
	@GetMapping("/cust-selected-data1")
	public String getSelectedData1() throws JsonSyntaxException, JsonProcessingException {
		List<Object[]> details = customerRepository.getCustDetails3();
		List<Map<String, Object>> entry2 = new ArrayList<>();
		List<String> attributes = new ArrayList<>(
				Arrays.asList("addressLine1", "addressLine2", "country", "amount", "cheaqueNumber"));
		for (Object[] s : details) {
			Map<String, Object> entry1 = new HashMap<>();
			for (int i = 0; i <= 4; i++) {
				entry1.put(attributes.get(i), s[i]);
			}
			entry2.add(entry1);
		}
		ObjectMapper mapper = new ObjectMapper();
		JsonArray entries = JsonParser.parseString(mapper.writeValueAsString(entry2)).getAsJsonArray();
		JsonObject response = new JsonObject();
		response.add("mixedData", entries);
		return response.toString();
	}

	@GetMapping("/cust-selected-data2")
	public String getSelectedData2() throws JsonSyntaxException, JsonProcessingException {
		List<Object[]> details = customerRepository.getCustomerDataAddressNotNull();
		List<Map<String, Object>> entry2 = new ArrayList<>();
		List<String> attributes = new ArrayList<>(
				Arrays.asList("customerNumber", "customerName", "paymentDate", "orderDate", "orderStatus"));
		for (Object[] s : details) {
			Map<String, Object> entry1 = new HashMap<>();
			for (int i = 0; i <= 4; i++) {
				entry1.put(attributes.get(i), s[i]);
			}
			entry2.add(entry1);
		}
		ObjectMapper mapper = new ObjectMapper();
		JsonArray entries = JsonParser.parseString(mapper.writeValueAsString(entry2)).getAsJsonArray();
		JsonObject response = new JsonObject();
		response.add("customerOrderPaymentData", entries);
		return response.toString();
	}

	@GetMapping("/cust-credit-limit-data")
	public String getCustomerCreditLimitData() throws JsonSyntaxException, JsonProcessingException {
		List<Object[]> details = customerRepository.getCustomerCreditLimitData();
		List<Map<String, Object>> entry2 = new ArrayList<>();
		List<String> attributes = new ArrayList<>(Arrays.asList("avgCreditLimit", "country"));
		for (Object[] s : details) {
			Map<String, Object> entry1 = new HashMap<>();
			for (int i = 0; i <= 1; i++) {
				entry1.put(attributes.get(i), s[i]);
			}
			entry2.add(entry1);
		}
		ObjectMapper mapper = new ObjectMapper();
		JsonArray entries = JsonParser.parseString(mapper.writeValueAsString(entry2)).getAsJsonArray();
		JsonObject response = new JsonObject();
		response.add("customerCreditLimitData", entries);
		return response.toString();
	}
}
