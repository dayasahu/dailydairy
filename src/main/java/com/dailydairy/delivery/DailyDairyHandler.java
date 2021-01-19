package com.dailydairy.delivery;

import java.util.List;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.dailydairy.delivery.entity.Customer;

public class DailyDairyHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent,List<Customer>>{

}
