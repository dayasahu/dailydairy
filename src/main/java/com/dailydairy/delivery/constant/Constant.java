package com.dailydairy.delivery.constant;

public class Constant {

	public static final String CUSTOMER_SUB_QUERY="SELECT \r\n" + 
			"    customer.first_name,\r\n" + 
			"    customer.id AS customer_id,\r\n" + 
			"    customer.route_id custrRouteId,\r\n" + 
			"    \r\n" + 
			"    subscription.quantity,\r\n" + 
			"    subscription.prodId,\r\n" + 
			"    (SELECT \r\n" + 
			"            p.rate\r\n" + 
			"        FROM\r\n" + 
			"            catalougue p\r\n" + 
			"        WHERE\r\n" + 
			"            subscription.prodId = p.id) AS rate,\r\n" + 
			"    (SELECT \r\n" + 
			"            p.productName\r\n" + 
			"        FROM\r\n" + 
			"            catalougue p\r\n" + 
			"        WHERE\r\n" + 
			"            subscription.prodId = p.id) AS productName,\r\n" + 
			"    (SELECT \r\n" + 
			"            p.unit\r\n" + 
			"        FROM\r\n" + 
			"            catalougue p\r\n" + 
			"        WHERE\r\n" + 
			"            subscription.prodId = p.id) AS unit,\r\n" + 
			"    (SELECT \r\n" + 
			"            p.type\r\n" + 
			"        FROM\r\n" + 
			"            catalougue p\r\n" + 
			"        WHERE\r\n" + 
			"            subscription.prodId = p.id) AS prodType,\r\n" + 
			"    (SELECT \r\n" + 
			"            p.rate\r\n" + 
			"        FROM\r\n" + 
			"            catalougue p\r\n" + 
			"        WHERE\r\n" + 
			"            subscription.prodId = p.id) * subscription.quantity AS totalCost\r\n" + 
			"FROM\r\n" + 
			"    subscription\r\n" + 
			"        INNER JOIN\r\n" + 
			"    customer ON subscription.custId = customer.id\r\n" + 
			"WHERE\r\n" + 
			"    subscription.isActive = 'Y'\r\n" + 
			"        AND customer.is_active = 'Y'";
	
	public static final String VACATION_QUERY="SELECT * FROM dailyDairy.vacation where end_date= CURDATE()";

}
