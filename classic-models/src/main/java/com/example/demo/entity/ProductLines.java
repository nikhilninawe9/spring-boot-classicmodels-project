package com.example.demo.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Component
@JsonInclude(Include.ALWAYS)
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "productlines")
public class ProductLines implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productLineNumber;
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	@Lob // for image
	private byte[] image;

	public ProductLines() {
		super();
	}

	public ProductLines(Integer productLineNumber, String productLine, String textDescription, String htmlDescription,
			byte[] image) {
		super();
		this.productLineNumber = productLineNumber;
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}

	public Integer getProductLineNumber() {
		return productLineNumber;
	}

	public void setProductLineNumber(Integer productLineNumber) {
		this.productLineNumber = productLineNumber;
	}

	public String getProductLine() {
		return productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "ProductLines [productLineNumber=" + productLineNumber + ", productLine=" + productLine
				+ ", textDescription=" + textDescription + ", htmlDescription=" + htmlDescription + ", image="
				+ Arrays.toString(image) + "]";
	}

}
