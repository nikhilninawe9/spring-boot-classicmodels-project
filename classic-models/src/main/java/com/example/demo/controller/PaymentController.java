package com.example.demo.controller;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Payments;
import com.example.demo.repository.PaymentsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class PaymentController {
	@Autowired
	private PaymentsRepository paymentsRepository;

	@GetMapping("/all-payments")
	public String getAllPayments() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray airlinesObject = JsonParser.parseString(mapper.writeValueAsString(paymentsRepository.findAll()))
				.getAsJsonArray();
		return airlinesObject.toString();
	}

	@GetMapping("/avg-amount")
	public String getAvgAmt() {
		Double avg = paymentsRepository.getAvgAmt();
		return "The average payment amount is " + avg;
	}

	@GetMapping("/get-date")
	public String getdate() {
		Date date = paymentsRepository.getDate();
		return "The date is " + date;
	}

	@GetMapping("/amount-in-time/{time1}/{time2}")
	public String getTxnId(@PathVariable Date time1, @PathVariable Date time2) {
		Double amount = paymentsRepository.getTotalAmountInDuration(time1, time2);
		return "Total amount in duration between " + time1 + " and " + time2 + " is " + amount;
	}

	@GetMapping("/amount-at-time/{time1}")
	public List<Payments> getPaymentDataDateWise(@PathVariable Date time1) {
		List<Payments> paymentsData = paymentsRepository.getPaymentDataDatewise(time1);
		return paymentsData;
	}

	@GetMapping("/number-of-payments/{time1}")
	public String getNumberOfPaymentsAtTime(@PathVariable Date time1) {
		Integer count = paymentsRepository.getNumberOfPaymentsAtTime(time1);
		return "The number of payment occured at date " + time1 + " is " + count;
	}

	@GetMapping("/txn-date/{num}")
	public String getDateByCustNum(@PathVariable Integer num) {
		Date date = null;
		try {
			date = paymentsRepository.getDateByCustNum(num);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (date != null) {
			return "The transaction date of Customer Number " + num + " is " + date;
		} else {
			return "No transaction happened of given customer number " + num;
		}
	}

	@GetMapping("/get-cust-num/from/{from}/to/{to}")
	public String getCustomerNumbers(@PathVariable Integer from, @PathVariable Integer to) {
		List<Integer> numberOfCustomers = paymentsRepository.getCustomerNumbers(from, to);
		return "The number of customers between payment amounts " + from + " and " + to + " is " + numberOfCustomers;
	}

	@GetMapping("/get-cust-num-dates/{time1}/{time2}")
	public String getCustNumInSDates(@PathVariable Date time1, @PathVariable Date time2) {
		List<Integer> custNumbers = paymentsRepository.getCustomerNumbersTxnInSelectedDates(time1, time2);
		return "The List of customers who has done transaction between dates " + time1 + " and " + time2 + " is "
				+ custNumbers;
	}

	@GetMapping("/get-date1")
	public String getDate1() {
		Date date = paymentsRepository.getDate1();
		return date.toString();
	}

	@GetMapping("/get-by-year/{year}")
	public String getPaymentYearwise(@PathVariable String year) throws JsonSyntaxException, JsonProcessingException {
		List<Payments> pay = paymentsRepository.getPaymentYearwise(year);
		ObjectMapper mapper = new ObjectMapper();
		JsonArray paymentsObject = JsonParser.parseString(mapper.writeValueAsString(pay)).getAsJsonArray();
		return paymentsObject.toString();
	}

	@GetMapping("/payment-date77/{date}")
	public String getPaymentsByPaymentDates(@PathVariable Date date)
			throws JsonSyntaxException, JsonProcessingException {
		List<Payments> payment = paymentsRepository.getPaymentsByEntirePaymentDates(date);
		return payment.toString();
	}

	@GetMapping("/get-by-month/{month}")
	public String getPaymentMonthwise(@PathVariable String month) throws JsonSyntaxException, JsonProcessingException {
		List<Payments> pay = paymentsRepository.getPaymentDataMonthwise(month);
		ObjectMapper mapper = new ObjectMapper();
		JsonArray paymentsObject = JsonParser.parseString(mapper.writeValueAsString(pay)).getAsJsonArray();
		return paymentsObject.toString();
	}

	// When mixed data we need to display as json
	@GetMapping("/getDataPayCustomerwise")
	public String getPayCWise() throws JsonSyntaxException, JsonProcessingException {
		List<Object[]> arr = paymentsRepository.getPaymentDataCustomerWise1();
		String[] attr = new String[] { "customer_number", "amount", "check_number", "payment_date" };
		Iterator<Object[]> paymentDetail = arr.iterator();

		Object[] pd = null;
		JsonObject o = null;
		JsonArray ja = new JsonArray();
		JsonObject response = new JsonObject();

		int cNumber = 0;
		double amount = 0;
		Date dateed = null;
		while (paymentDetail.hasNext()) {
			o = new JsonObject();
			pd = paymentDetail.next();
			for (int i = 0; i < pd.length; i++) {
				if (attr[i].equals("customer_number")) {
					cNumber = (Integer) pd[i];
					o.addProperty(attr[i], cNumber);
				} else if (attr[i].equals("amount")) {
					amount = (Double) pd[i];
					o.addProperty(attr[i], amount);
				} else if (attr[i].equals("payment_date")) {
					dateed = (Date) pd[i];
					o.addProperty(attr[i], dateed.toString());
				} else if (attr[i].equals("check_number")) {
					o.addProperty(attr[i], pd[i].toString());
				}
			}
			ja.add(o);
			response.add("customerPaymentDetails", ja);
		}
		return response.toString();
	}

	@GetMapping("/get-by-day/{day}")
	public String getPaymentDaywise(@PathVariable String day) throws JsonSyntaxException, JsonProcessingException {
		List<Payments> pay = paymentsRepository.getPaymentDataDaywise(day);
		if (pay != null) {
			ObjectMapper mapper = new ObjectMapper();
			JsonArray paymentsObject = JsonParser.parseString(mapper.writeValueAsString(pay)).getAsJsonArray();
			return paymentsObject.toString();
		} else {
			return "No payments founds on: " + day;
		}
	}
}
