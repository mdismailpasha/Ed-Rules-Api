package com.ismailit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ismailit.request.CitizenData;
import com.ismailit.response.PlanInfo;
import com.ismailit.service.CitizenService;

@RestController
public class RulesController {
	
	@Autowired
	private CitizenService service;
	
	@PostMapping("/rules")
	public PlanInfo execute(CitizenData request)
	{
		return service.executeRules(request);
	}
	

}
