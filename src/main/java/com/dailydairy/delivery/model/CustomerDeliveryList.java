package com.dailydairy.delivery.model;

import java.util.List;

public class CustomerDeliveryList {

	List<CustomerSubscr> custOnVacation;
	List<CustomerSubscr> custAvailable;
	public List<CustomerSubscr> getCustOnVacation() {
		return custOnVacation;
	}
	public void setCustOnVacation(List<CustomerSubscr> custOnVacation) {
		this.custOnVacation = custOnVacation;
	}
	public List<CustomerSubscr> getCustAvailable() {
		return custAvailable;
	}
	public void setCustAvailable(List<CustomerSubscr> custAvailable) {
		this.custAvailable = custAvailable;
	}
	
	
}
