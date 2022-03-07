package com.micropro.common.demo.controller;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.micropro.common.demo.common.ConnectionUtility;
import com.micropro.common.demo.entity.DemoSignagesEntity;
import com.micropro.common.demo.model.generated.DemoSignagesModel.DemoSignagesBody;
import com.micropro.common.demo.model.generated.DemoSignagesModel.InsignbdndtlBody;
import com.micropro.common.demo.model.generated.DemoSignagesModel.InsignbdnhdrBody;
import com.micropro.common.demo.model.generated.DemoSignagesModel.InsignbdntaxtrnBody;
import com.micropro.custom.services.CrudService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Api(description = ".", tags = { "Demo Signages APIs" })
@RequestMapping("/rest")
public class DemoSignagesController extends CrudService<DemoSignagesBody> {

	private @Autowired DemoSignagesEntity demoSignagesEntity;

	Map<String, String> errormsg; // <Field, Error_msg>
	HttpServletRequest hRequest;

	private @Autowired ConnectionUtility utility;

	@ResponseStatus(code = HttpStatus.OK)
	@PostMapping(path = "/demo_signages", consumes = "application/json")
	@ApiOperation(value = "CRUD operation on Insignbdnhdr entity", httpMethod = "POST")
	@ApiResponse(code = 200, message = "Returns a 200 response code if a Insignbdnhdr entity has been created successfully")
	public String crudReq(@RequestBody @Validated DemoSignagesBody body, HttpServletRequest request) {
		hRequest = request;
		String response;
		if (request.getHeader("rightId") == null || request.getHeader("rightId").equals("0")) {
			response = "Error";
			errormsg = new HashMap<>();
			errormsg.put("rightId", "'rightId' required in request header");
		} else {
			// CRUD operation
			response = crud(body);
		}

		// Response Body
		if (response.equals("Error")) {
			throw new ValidationException(new JSONObject(errormsg).toString());
		} else {
			return response;
		}
	}

	@Override
	public boolean preCrudValidate(DemoSignagesBody body) {
		errormsg = new HashMap<>();

		InsignbdnhdrBody insignbdnhdr = body.getInsignbdnhdr();
		if (insignbdnhdr.getLastoperation() == null) {
			errormsg.put("lastoperation", "lastoperation is required");
		} else if (insignbdnhdr.getLastoperation().equals("INSERT") || insignbdnhdr.getLastoperation().equals("UPDATE")
				|| insignbdnhdr.getLastoperation().equals("DELETE")) {
			// to do
		} else {
			errormsg.put("insignbdnhdr.lastoperation", "lastoperation should be 'INSERT', 'UPDATE' or 'DELETE'");
		}

		List<InsignbdndtlBody> insignbdndtlList = insignbdnhdr.getInsignbdndtl();
		if (insignbdndtlList == null) {
			throw new NullPointerException("insignbdnhdr.insignbdndtl[] required");
		}
		for (InsignbdndtlBody insignbdndtl : insignbdndtlList) {
			if (insignbdndtl.getLastoperation() == null) {
				errormsg.put("insignbdndtl.lastoperation", "lastoperation is required");
			} else if (insignbdndtl.getLastoperation().equals("INSERT")
					|| insignbdndtl.getLastoperation().equals("UPDATE")
					|| insignbdndtl.getLastoperation().equals("DELETE")) {
			} else {
				errormsg.put("insignbdndtl.lastoperation", "lastoperation should be 'INSERT', 'UPDATE' or 'DELETE'");
			}

		}

		for (InsignbdndtlBody insignbdndtl : insignbdndtlList) {
			List<InsignbdntaxtrnBody> insignbdntaxtrnList = insignbdndtl.getInsignbdntaxtrn();
			if (insignbdntaxtrnList == null) {
				throw new NullPointerException("insignbdndtl.insignbdntaxtrn[] required");
			}
			for (InsignbdntaxtrnBody insignbdntaxtrn : insignbdntaxtrnList) {
				if (insignbdntaxtrn.getLastoperation() == null) {
					errormsg.put("insignbdntaxtrn.lastoperation", "lastoperation is required");
				} else if (insignbdntaxtrn.getLastoperation().equals("INSERT")
						|| insignbdntaxtrn.getLastoperation().equals("UPDATE")
						|| insignbdntaxtrn.getLastoperation().equals("DELETE")) {
				} else {
					errormsg.put("insignbdntaxtrn.lastoperation",
							"lastoperation should be 'INSERT', 'UPDATE' or 'DELETE'");
				}
			}
		}

		return errormsg.isEmpty();
	}

	@Override
	public String crudImpl(DemoSignagesBody body) {
		try {
			return demoSignagesEntity.crud(hRequest, body);
		} catch (JsonProcessingException e) {
			throw new CustomException("Invalid Json body");
		}
	}

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/demo_signages/{INSIGNBDNHDRID}", produces = "application/json")
	@ApiOperation(value = "Retrieve a Insignbdnhdr entity with a specified 'INSIGNBDNHDRID' column value", httpMethod = "GET")
	@ApiResponse(code = 200, message = "Returns a 200 response code if a Insignbdnhdr entity has been retrieved successfully")
	public String get(@PathVariable(name = "INSIGNBDNHDRID") long insignbdnhdrid, HttpServletRequest request) {
		return demoSignagesEntity.get(request, insignbdnhdrid);
	}

	@Override
	public Connection getConnection() {
		return utility.getConnection();
	}

}