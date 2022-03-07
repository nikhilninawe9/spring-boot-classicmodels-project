package com.micropro.common.demo.entity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.micropro.common.demo.common.ConnectionUtility;

import com.micropro.common.demo.model.generated.DemoTestModel.AdaddmstBody;

@Component
public class DemoTestEntity {

	private @Autowired ConnectionUtility utility;

	public String crud(HttpServletRequest request, AdaddmstBody body) throws JsonProcessingException {
		String token = request.getHeader("authorization").split(" ")[1];
		String rightId = request.getHeader("rightId");

		ObjectMapper mapper = new ObjectMapper();
		String reqBody = "{\"adaddmst\":"  + mapper.writeValueAsString(body) + "}";

		return utility.executeProcedureOnPool(rightId, token, reqBody, request.getRequestURL().toString());
	}

	public String get(HttpServletRequest request, long id) {
		JsonObject response = new JsonObject();

		// Root Entity
		String query = "SELECT * FROM adaddmst where adaddmstid = " + id;

		JsonArray data = utility.executeQueryOnPool(query, request);
		if(data.size() > 0) {
			response = (JsonObject) data.get(0);
		}

		return response.toString();
	}

}