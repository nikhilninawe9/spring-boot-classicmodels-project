package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Component
@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customerNumber")
	private Integer customerNumber;
	@Column(name = "checkNumber")
	private String checkNumber;
	@Column(name = "paymentDate")
	private Date paymentDate;
	@Column(name = "amount")
	private Double amount;

	public Payments() {
		super();
	}

	public Payments(Integer customerNumber, String checkNumber, Date paymentDate, Double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public Integer getCustomerNumber() {
		return customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public Double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Payments [customerNumber=" + customerNumber + ", checkNumber=" + checkNumber + ", paymentDate="
				+ paymentDate + ", amount=" + amount + "]";
	}

}
