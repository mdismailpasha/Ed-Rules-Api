package com.ismailit.service;

import org.springframework.stereotype.Service;

import com.ismailit.request.CitizenData;
import com.ismailit.response.PlanInfo;

@Service
public class CitizenService {

	public PlanInfo executeRules(CitizenData request) {
		PlanInfo response = new PlanInfo();
		Double income = request.getIncome();
		String planName = request.getPlanName();

		if ("SNAP".equals(planName)) {
			if (income <= 200) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.00);
				response.setStartDate("25-FEB-2021");
				response.setEndDate("25-MAY-2021");
			} else {
				response.setPlanStatus("DENIED");
				response.setDeniedReason("income is greater than actual");
			}
		} else if ("CCAP".equals(planName)) {
			String status = request.getKidsEliglble();

			if (income <= 200 && "YES".equals(status)) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.00);
				response.setStartDate("25-FEB-2021");
				response.setEndDate("25-MAY-2021");
			} else {
				response.setPlanStatus("DENIED");
				response.setDeniedReason("income is greater than actual or kids age above 18");
			}

		} else if ("Medicaid".equals(planName)) {
			if (income <= 300) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.00);
				response.setStartDate("25-FEB-2021");
				response.setEndDate("25-MAY-2021");
			} else {
				response.setPlanStatus("DENIED");
				response.setDeniedReason("income is greater than actual");
			}

		} else if ("Medicare".equals(planName)) {
			if (request.getAge() >= 65) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.00);
				response.setStartDate("25-FEB-2021");
				response.setEndDate("25-MAY-2021");
			} else {
				response.setPlanStatus("DENIED");
				response.setDeniedReason("Age condition is not matched");
			}

		} else if ("KW".equals(planName)) {
			String empStatus = request.getEmpStatus();
			if ("NO".equals(empStatus)) {
				response.setPlanStatus("APPROVED");
				response.setBenefitAmt(350.00);
				response.setStartDate("25-FEB-2021");
				response.setEndDate("25-MAY-2021");

			} else {
				response.setPlanStatus("DENIED");
				response.setDeniedReason("Employed");
			}

		}
		return response;

	}

}
