package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.EmployeesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeesRepository employeeRepository;

	@GetMapping("/all-emp")
	public String getAllEmployees() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray empObject = JsonParser.parseString(mapper.writeValueAsString(employeeRepository.findAll()))
				.getAsJsonArray();
		return empObject.toString();
	}

	@GetMapping("/emp-by-number/{eNum}")
	public String getEmpByNumber(@PathVariable Integer eNum) throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonObject empObject = JsonParser
				.parseString(mapper.writeValueAsString(employeeRepository.getEmpByNumber(eNum))).getAsJsonObject();
		return empObject.toString();
	}

	@PutMapping("/update-emp/{firstname}/{lastname}/{eNum}")
	public String updateEmp(@PathVariable String firstname, @PathVariable String lastname, @PathVariable Integer eNum) {
		employeeRepository.updateEmp(firstname, lastname, eNum);
		return "Employee has been updated successfully of eNumber: " + eNum;
	}

}
