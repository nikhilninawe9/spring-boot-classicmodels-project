package com.example.demo.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.OrderDetailsRepository;
import com.example.demo.repository.ProductLinesRepository;
import com.example.demo.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

@RestController
public class ProductsController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductLinesRepository productLinesRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	JsonObject entireProduct = new JsonObject();

	@GetMapping("/get-entire-products")
	public String getEntireProducts() throws JsonSyntaxException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		JsonArray productLinesObject = JsonParser
				.parseString(mapper.writeValueAsString(productLinesRepository.findAll())).getAsJsonArray();
		JsonArray orderDetailsObject = JsonParser
				.parseString(mapper.writeValueAsString(orderDetailsRepository.findAll())).getAsJsonArray();
		JsonArray prodData = JsonParser.parseString(mapper.writeValueAsString(productRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> product = prodData.iterator();
		String prodCode1 = "";
		String prodCode2 = "";
		String prodLine1 = "";
		String prodLine2 = "";
		JsonArray finalArr = new JsonArray();
		while (product.hasNext()) {
			JsonArray ordArr1 = new JsonArray();
			JsonArray proLArr2 = new JsonArray();
			JsonObject obj1 = product.next().getAsJsonObject();
			prodCode1 = obj1.get("productCode").getAsString();
			prodLine1 = obj1.get("productLine").getAsString();
			Iterator<JsonElement> productLine = productLinesObject.iterator();
			while (productLine.hasNext()) {
				JsonObject obj3 = productLine.next().getAsJsonObject();
				prodLine2 = obj3.get("productLine").getAsString();
				if (prodLine1.equalsIgnoreCase(prodLine2)) {
					proLArr2.add(obj3);
					obj1.add("productLinesData", proLArr2);
				}
			}
			Iterator<JsonElement> order = orderDetailsObject.iterator();
			while (order.hasNext()) {
				JsonObject obj2 = order.next().getAsJsonObject();
				prodCode2 = obj2.get("productCode").getAsString();
				if (prodCode1.equalsIgnoreCase(prodCode2)) {
					ordArr1.add(obj2);
					obj1.add("orderDetailsData", ordArr1);
				}
			}
			finalArr.add(obj1);
		}
		entireProduct.add("productsData", finalArr);
		return entireProduct.toString();
	}

	@GetMapping("/get-fanct-named-product")
	public String getFancyProducts() throws JsonSyntaxException, JsonProcessingException {
		JsonObject response = new JsonObject();
		JsonObject objProd = null;
		Double buyPrice = 0.0;
		String customizedString = "";
		Double msrp = 0.0;
		JsonArray ja = new JsonArray();
		ObjectMapper mapper = new ObjectMapper();
		JsonArray prodData = JsonParser.parseString(mapper.writeValueAsString(productRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> product = prodData.iterator();
		while (product.hasNext()) {
			objProd = product.next().getAsJsonObject();
			objProd.remove("productLine");
			msrp = objProd.get("msrp").getAsDouble();
			buyPrice = objProd.get("buyPrice").getAsDouble();
			objProd.addProperty("balance", msrp + buyPrice);
			customizedString = objProd.get("productName").getAsString();
			StringBuilder b = new StringBuilder(customizedString);
			b.append(" I am number 1!. ");
			objProd.addProperty("customizedProductName", b.toString());
			ja.add(objProd);
		}
		response.add("newProductData", ja);
		return response.toString();
	}

	@GetMapping("/getProductNamesOnly")
	public String getProductsonly() throws JsonSyntaxException, JsonProcessingException {
		JsonObject object = null;
		ObjectMapper mapper = new ObjectMapper();
		JsonArray prodArr = new JsonArray();
		JsonArray prodData = JsonParser.parseString(mapper.writeValueAsString(productRepository.findAll()))
				.getAsJsonArray();
		Iterator<JsonElement> product = prodData.iterator();
		int count = 1;
		while (product.hasNext()) {
			object = product.next().getAsJsonObject();
			JsonObject stringObj = new JsonObject();
			String field = object.get("productName").getAsString();
			StringBuffer newField = new StringBuffer(field);
			newField.append(" The car product!..");
			stringObj.addProperty("newProductSrNumber", count);
			if (newField.toString().contains("Ford") == true) {
				stringObj.addProperty("newProductCompanyName", "Ford");
			} else if (newField.toString().contains("Cadillac") == true) {
				stringObj.addProperty("newProductCompanyName", "Cadillac");
			} else if (newField.toString().contains("Toyota") == true) { //
				stringObj.addProperty("newProductCompanyName", "Toyota");
			}
			String prodLine = object.get("productLine").getAsString();
			if (prodLine.trim().equalsIgnoreCase("classic cars")) {
				stringObj.addProperty("newVehicleCategory", "Classic");
			}
			// This returns array.
			String[] prodLineS = newField.toString().split(" ");
			int counter = 1;
			for (String p : prodLineS) {
				stringObj.addProperty("Number " + counter, p);
				counter++;
			}
			stringObj.addProperty("newProductName", newField.toString());
			prodArr.add(stringObj);
			count++;
		}
		return prodArr.toString();
	}

}
