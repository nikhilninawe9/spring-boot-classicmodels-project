package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/mod-data")
	public String getModifiedOfficeData() throws JsonSyntaxException, JsonProcessingException {
		JsonObject response = new JsonObject();
		getAllOffices();
		JsonArray offices = officeObj.get("officeDetails").getAsJsonArray();
		Iterator<JsonElement> office = offices.iterator();
		while (office.hasNext()) {
			JsonObject obj1 = office.next().getAsJsonObject();
			JsonArray employees = obj1.get("empDetails").getAsJsonArray();
			Iterator<JsonElement> employee = employees.iterator();
			while (employee.hasNext()) {
				JsonObject obj2 = employee.next().getAsJsonObject();
				String reportTo = obj2.get("extension").getAsString();
				if (reportTo.endsWith("28")) {
					obj2.remove("email");
				}
			}
		}
		response.add("offices", offices);
		return offices.toString();
	}

	@GetMapping("/mod1-data")
	public String getModifiedOfficeData1() throws JsonSyntaxException, JsonProcessingException {
		JsonObject response = new JsonObject();
		getAllOffices();
		JsonArray offices = officeObj.get("officeDetails").getAsJsonArray();
		Iterator<JsonElement> office = offices.iterator();
		while (office.hasNext()) {
			JsonObject obj1 = office.next().getAsJsonObject();
			String employees = obj1.get("country").getAsString();
			if (employees.equalsIgnoreCase("francE")) {
				JsonArray employee = obj1.get("empDetails").getAsJsonArray();
				employee.remove(1);
			}
		}
		response.add("offices", offices);
		return offices.toString();
	}

	@PutMapping("/mod/{address}/{email}")
	public String updateAddressAndEmail(@PathVariable String address, @PathVariable String email) {
		Integer num = officeRepository.updateCustomerAddressEmail(address, email);
		System.out.println(num);
		if (num > 0) {
			return "Office has been updated with address " + address + " and email " + email;
		} else {
			return "Something went wrong!..";
		}
	}

	@GetMapping("/all-the-offices")
	public String getCountOfJapanTerritoriesOffices() throws JsonSyntaxException, JsonProcessingException {
		getAllOffices();
		JsonArray offices = officeObj.get("officeDetails").getAsJsonArray();
		Iterator<JsonElement> office = offices.iterator();
		int count = 0;
		while (office.hasNext()) {
			JsonObject off = office.next().getAsJsonObject();
			String territory = off.get("territory").getAsString();
			if (territory.equalsIgnoreCase("na")) {
				count++;
			}
		}
		return "The number of offices in NA are " + count;
	}

	@GetMapping("/getModifiedOffices")
	public String getModifiedOffices() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray officeObject = JsonParser.parseString(mapper.writeValueAsString(officeRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> office = officeObject.iterator();
		JsonObject object1 = null;
		Integer officeCode = 0;
		String address, postalCode, state = " ";
		JsonObject obj1 = null;
		JsonArray array = new JsonArray();
		JsonObject response = new JsonObject();
		while (office.hasNext()) {
			obj1 = new JsonObject();
			object1 = office.next().getAsJsonObject();
			officeCode = object1.get("officeCode").getAsInt();
			obj1.addProperty("officeCode", officeCode);
			if (!object1.get("addressLine2").isJsonNull()) {
				address = object1.get("addressLine1").getAsString().concat(object1.get("addressLine2").getAsString());
				obj1.addProperty("address", address);
			} else {
				address = object1.get("addressLine1").getAsString();
				obj1.addProperty("address", address);
			}
			if (!object1.get("state").isJsonNull()) {
				state = object1.get("state").getAsString();
				obj1.addProperty("state", state);
			}
			postalCode = object1.get("postalCode").getAsString();
			int count = 1;
			if (postalCode.contains("-")) {
				String[] pc = postalCode.split("-");
				for (String pca : pc) {
					obj1.addProperty("pCode " + count, pca);
					count++;
				}
			} else if (postalCode.contains(" ")) {
				String[] pc = postalCode.split(" ");
				for (String pca : pc) {
					obj1.addProperty("pCode " + count, pca);
					count++;
				}
			} else {
				obj1.addProperty("pCode", postalCode);
			}
			array.add(obj1);
		}
		response.add("newOfficeData", array);
		return array.toString();
	}

	@GetMapping("/getOffice")
	public String getOfficeDataNullHandled() {
		JsonObject response = new JsonObject();
		List<Object[]> off = officeRepository.getOfficesWithNullHandled();
		Iterator<Object[]> office = off.iterator();
		JsonObject jo = null;
		String[] attr = new String[] { "officeCode", "address", "city", "country", "phone", "postalCode", "state" };
		JsonArray ja = new JsonArray();
		while (office.hasNext()) {
			jo = new JsonObject();
			Object[] o = office.next();
			for (int i = 0; i < attr.length; i++) {
				if (attr[i].equals("phone")) {
					String str1 = o[i].toString().replaceAll("\\s", ""); // to remove spaces from phone number.
					str1 = str1.replaceAll("[^a-zA-Z0-9]", ""); // to remove + sign from phone number.
					jo.addProperty(attr[i], str1);
				} else {
					jo.addProperty(attr[i], o[i].toString());
				}
			}
			ja.add(jo);
		}
		response.add("officeData", ja);
		return response.toString();
	}
}
