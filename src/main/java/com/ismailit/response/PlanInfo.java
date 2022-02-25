package com.ismailit.response;

import lombok.Data;

@Data
public class PlanInfo {
	
	private String name;
	private String planName;
	private String ssn;
	private String planStatus;
	private String deniedReason;
	private Double benefitAmt;
	private String startDate;
	private String endDate;

}
