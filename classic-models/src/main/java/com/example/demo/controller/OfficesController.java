package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmployeesRepository;
import com.example.demo.repository.OfficesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class OfficesController {
	@Autowired
	private OfficesRepository officeRepository;
	@Autowired
	private EmployeesRepository employeesRepository;
	JsonObject officeObj = new JsonObject();;

	@GetMapping("/all-offc")
	public String getAllPayments() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray offObject = JsonParser.parseString(mapper.writeValueAsString(officeRepository.findAll()))
				.getAsJsonArray();
		return offObject.toString();
	}

	@GetMapping("/get-all-off")
	public String getAllOffices() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray officeObject = JsonParser.parseString(mapper.writeValueAsString(officeRepository.findAll()))
				.getAsJsonArray();
		JsonArray employeeObject = JsonParser.parseString(mapper.writeValueAsString(employeesRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> office = officeObject.iterator();
		int officeNum1 = 0;
		int officeNum2 = 0;
		JsonArray empArr = null;
		JsonArray finalArr = new JsonArray();
		while (office.hasNext()) {
			empArr = new JsonArray();
			JsonObject offData = office.next().getAsJsonObject();
			officeNum1 = offData.get("officeCode").getAsInt();
			Iterator<JsonElement> employeeDetails = employeeObject.iterator();
			while (employeeDetails.hasNext()) {
				JsonObject empDet = employeeDetails.next().getAsJsonObject();
				officeNum2 = empDet.get("officeCode").getAsInt();
				if (officeNum1 == officeNum2) {
					empArr.add(empDet);
					offData.add("empDetails", empArr);
				}
			}
			finalArr.add(offData);
		}
		officeObj.add("officeDetails", finalArr);
		return officeObj.toString();
	}

}
