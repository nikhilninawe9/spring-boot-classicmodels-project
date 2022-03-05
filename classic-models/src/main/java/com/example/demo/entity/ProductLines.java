package com.example.demo.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class ProductLines {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private String productLine;
	private String textDescription;
	private String htmlDescription;
	private byte[] image;

	public ProductLines() {
		super();
	}

	@Override
	public String toString() {
		return "ProductLines [productLine=" + productLine + ", textDescription=" + textDescription
				+ ", htmlDescription=" + htmlDescription + ", image=" + Arrays.toString(image) + "]";
	}

	public String getProductLine() {
		return productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public byte[] getImage() {
		return image;
	}

	public ProductLines(String productLine, String textDescription, String htmlDescription, byte[] image) {
		super();
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
		this.image = image;
	}

}
