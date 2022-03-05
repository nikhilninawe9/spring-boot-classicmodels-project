package com.example.demo.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CustomersController extends Thread {
	JsonObject entireCustomerDetails = new JsonObject();

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PaymentsRepository paymentsRepository;
	@Autowired
	private OrdersRepository orderRepository;
//	@Autowired
//	private CustomersController controller;

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
			for (int i = 0; i < attributes.size(); i++) {
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
			for (int i = 0; i < attributes.size(); i++) {
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
			for (int i = 0; i < attributes.size(); i++) {
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

//	@PutMapping("/update/{name}/{status}")
//	public String updateCustomer(@PathVariable String name, @PathVariable String status) {
//		String msg = "";
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = new Date();
//		Integer i = customerRepository.updateCustomerData(dateformat.format(date), name, status);
//		if (i > 0) {
//			msg = "Customer data has been updated successfully!..";
//		} else {
//			msg = "Updation failed!..";
//		}
//		return msg;
//	}

//	@GetMapping("/entire-customer-manipulated")
//	public String showCustomers() throws JsonSyntaxException, JsonProcessingException {
//		getFullCustData();
//		JsonArray customers = entireCustomerDetails.get("customerDetails").getAsJsonArray();
//		Iterator<JsonElement> customer = customers.iterator();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date date = new Date(0);
//		while (customer.hasNext()) {
//			JsonObject cust = customer.next().getAsJsonObject();
//			cust.remove("customerPayments");
//			cust.remove("orderData");
//			cust.addProperty("customerDate", dateformat.format(date));
//		}
//		return customers.toString();
//	}

	@GetMapping("/get-avg-by-year")
	public String getAvg() throws JsonSyntaxException, JsonProcessingException {

		List<Object[]> listOfAvg = customerRepository.getAvgByYear();
		Iterator<Object[]> avgs = listOfAvg.iterator();
		List<Map<String, Object>> entries = new ArrayList<>();
		List<String> attributes = new ArrayList<>(Arrays.asList("average", "years"));
		while (avgs.hasNext()) {
			Map<String, Object> entry = new HashMap<>();
			Object[] avg = avgs.next();
			for (int i = 0; i < attributes.size(); i++) {
				Object o = avg[i];
				entry.put(attributes.get(i), o);
			}
			entries.add(entry);
		}
		ObjectMapper mapper = new ObjectMapper();
		JsonArray entries1 = JsonParser.parseString(mapper.writeValueAsString(entries)).getAsJsonArray();
		JsonObject response = new JsonObject();
		response.add("customerCreditLimitData", entries1);
		return response.toString();
	}

	List<String> attributes = new ArrayList<>(Arrays.asList("total price", "product line"));

	// prodLine must be in [Motorcycles,Classic Cars,Trucks and Buses,Vintage
	// Cars,Planes,Trains,Ships]
	@GetMapping("/get-total-by-pline/{prodLine}")
	public String getTotal(@PathVariable String prodLine) throws JsonSyntaxException, JsonProcessingException {
		List<String> attributes = new ArrayList<>(Arrays.asList("total price", "product line"));
		List<Object[]> o = customerRepository.getTotalByProductLine(prodLine);
		Map<String, Object> entry = new HashMap<>();
		Object[] o1 = o.get(0);
		for (int i = 0; i < attributes.size(); i++) {
			entry.put(attributes.get(i), o1[i]);
		}
		ObjectMapper mapper = new ObjectMapper();
		JsonObject entries1 = JsonParser.parseString(mapper.writeValueAsString(entry)).getAsJsonObject();
		JsonObject response = new JsonObject();
		response.add("totalPricePerProdLine", entries1);
		return response.toString();
	}

	@GetMapping("/getaddressByStart/{name}")
	public String getAddressWithCustomerName(@PathVariable String name)
			throws JsonSyntaxException, JsonProcessingException {
		List<Customers> o = customerRepository.getAddressWithCustomerName(name);
		ObjectMapper mapper = new ObjectMapper();
		JsonArray entries1 = JsonParser.parseString(mapper.writeValueAsString(o)).getAsJsonArray();
		if (entries1.size() != 0) {
			JsonObject response = new JsonObject();
			response.add("customerByAddress", entries1);
			return response.toString();
		} else {
			return "No customers are available with given name: " + name;
		}
	}

	// Has to be modified [Not working!..]
	@GetMapping("/date77/{date}")
	public Integer getAmountByPaymentDates(@PathVariable Date date)
			throws JsonSyntaxException, JsonProcessingException {
		Integer amount = customerRepository.getAmountByPaymentDates(date);
		return amount;
	}

	// for group by query
	@GetMapping("/getData_modified")
	public String getData() {
		List<Object[]> data = customerRepository.getDatax1();
		Iterator<Object[]> mData = data.iterator();
		String[] attr = new String[] { "average", "customerNumber", "addressess", "country" };
		JsonObject obj1 = null;
		JsonArray ja = new JsonArray();
		JsonObject response = new JsonObject();
		while (mData.hasNext()) {
			obj1 = new JsonObject();
			Object[] o = mData.next();
			for (int i = 0; i < attr.length; i++) {
				obj1.addProperty(attr[i], o[i].toString());
			}
			ja.add(obj1);
		}
		response.add("customerAvgAddress", ja);
		return response.toString();
	}

	// get customer data with country not case sensitive
	@GetMapping("/getCustWithCoun/{country}")
	public String getAllC(@PathVariable String country) throws JsonSyntaxException, JsonProcessingException {
		List<String> countriesFromDb = customerRepository.getCountries();
		String response = "";
		JsonArray cListFinal = null;
		for (String c : countriesFromDb) {
			if (c.equalsIgnoreCase(country)) {
				List<Customers> cList = customerRepository.getCustwithCountry(country);
				ObjectMapper mapper = new ObjectMapper();
				cListFinal = JsonParser.parseString(mapper.writeValueAsString(cList)).getAsJsonArray();
				response = cListFinal.toString();
				return response;
			}
		}
		response = "Data from given country " + country + " is not present!...";
		return response;
	}

	// Getting the number of customers with 0 credit limits.
	@GetMapping("/getCustomerWith0CreitLimit")
	public String getCW0() {
		List<Customers> customers = customerRepository.findAll();
		int counter = 0;
		for (Customers c : customers) {
			if (c.getCreditLimit() == 0) {
				counter++;
			}
		}
		return "Customers with 0 credit limit is " + counter;
	}

}
