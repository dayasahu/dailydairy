package com.dailydairy.delivery.constant;

public class Constant {

	public static final String CUSTOMER_SUB_QUERY="SELECT      customer.first_name, customer.last_name, customer.full_address,customer.phone_num,\n" + 
			"	customer.id AS customer_id,\n" + 
			"	customer.route_id custrRouteId, subscription.quantity,subscription.prodId,(\n" + 
			"	SELECT p.rate         FROM\n" + 
			"	catalougue p\n" + 
			"	WHERE             subscription.prodId=p.id)\n" + 
			"	AS rate,(SELECT              p.\n" + 
			"	productName FROM\n" + 
			"	catalougue p\n" + 
			"	WHERE             subscription.prodId=p.id)\n" + 
			"	AS productName,(SELECT              p.\n" + 
			"	unit FROM\n" + 
			"	catalougue p\n" + 
			"	WHERE             subscription.prodId=p.id)\n" + 
			"	AS unit,(SELECT              p.\n" + 
			"	type FROM\n" + 
			"	catalougue p\n" + 
			"	WHERE             subscription.prodId=p.id)\n" + 
			"	AS prodType,(SELECT              p.\n" + 
			"	rate FROM\n" + 
			"	catalougue p\n" + 
			"	WHERE             subscription.prodId=p.id)*\n" + 
			"	subscription.quantity AS\n" + 
			"	totalCost FROM\n" + 
			"	subscription         INNER\n" + 
			"	JOIN customer\n" + 
			"	ON subscription.custId=\n" + 
			"	customer.id WHERE subscription.isActive='Y'\n" + 
			"	AND customer.is_active='Y'";
	
	public static final String VACATION_QUERY="SELECT * FROM dailyDairy.vacation where end_date= CURDATE()";

}
