package com.micropro.common.demo.entity;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.micropro.common.demo.common.ConnectionUtility;
import com.micropro.common.demo.model.generated.DemoSignagesModel.DemoSignagesBody;

//Dao layer
@Component
public class DemoSignagesEntity {

	private @Autowired ConnectionUtility utility;

	public String crud(HttpServletRequest request, DemoSignagesBody body) throws JsonProcessingException {
		String token = request.getHeader("authorization").split(" ")[1];
		String rightId = request.getHeader("rightId");

		ObjectMapper mapper = new ObjectMapper();
		String reqBody = mapper.writeValueAsString(body);

		return utility.executeProcedureOnPool(rightId, token, reqBody, request.getRequestURL().toString());
	}

	public String get(HttpServletRequest request, long id) {
		JsonObject response = new JsonObject();

		// Root Entity
		String query = "SELECT * FROM insignbdnhdr where insignbdnhdrid = " + id;

		JsonArray data = utility.executeQueryOnPool(query, request);
		if (data.size() > 0) {
			JsonObject insignbdnhdr = (JsonObject) data.get(0);

			// Map Entity 1
			query = "SELECT * FROM insignbdndtl where insignbdnhdrid = " + id;
			data = utility.executeQueryOnPool(query, request);

			JsonArray insignbdndtlArray = new JsonArray();
			for (int i = 0; i < data.size(); i++) {
				JsonObject insignbdndtl = (JsonObject) data.get(i);

				// Child Entity 1
				//
				query = "SELECT * FROM insignbdntaxtrn where insignbdndtlid = "
						+ insignbdndtl.get("insignbdndtlid").getAsString();
				JsonArray insignbdntaxtrnArray = utility.executeQueryOnPool(query, request);
				insignbdndtl.add("insignbdntaxtrn", insignbdntaxtrnArray);

				insignbdndtlArray.add(insignbdndtl);
			}
			insignbdnhdr.add("insignbdndtl", insignbdndtlArray);

			response.add("insignbdnhdr", insignbdnhdr);
		}

		return response.toString();
	}

}