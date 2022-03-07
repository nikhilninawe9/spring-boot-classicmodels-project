package com.micropro.common.demo.custom;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.micropro.common.demo.common.ConnectionUtility;
import com.micropro.custom.services.ExceptionHandlingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * Generated code <p>
 * This controller contains custom code.<p>
 * This file is safe to edit.
 * 
 * @author Micropro
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(description = ".", tags = { "Custom APIs" })
@RequestMapping("/rest")
public class CustomController extends ExceptionHandlingService {

	@Autowired
	private ConnectionUtility utility;

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/connection_pool_state", produces = "application/json")
	@ApiOperation(value = "Retrieve connection pool state", httpMethod = "GET")
	@ApiResponse(code = 200, message = "Returns a 200 response code if pool state has been retrieved successfully")
	public String getPoolState() {
		JsonObject response = new JsonObject();

		response.addProperty("activeConnections", utility.getActiveConnectionCount());
		response.addProperty("idleConnections", utility.getIdleConnectionCount());
		response.addProperty("totalConnection", utility.getTotalConnectionCount());

		return response.toString();
	}

	@Override
	public Connection getConnection() {
		return utility.getConnection();
	}

}