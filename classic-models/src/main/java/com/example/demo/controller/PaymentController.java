package com.example.demo.controller;

import java.sql.Date;
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

}
