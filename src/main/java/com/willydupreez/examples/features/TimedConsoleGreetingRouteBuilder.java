package com.willydupreez.examples.features;

import java.util.Date;

import org.apache.camel.builder.RouteBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;

public class TimedConsoleGreetingRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {

		String greeting = "Hello @ " + DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ss");

		from("timer://greeting-timer?period=1000")
			.setBody(constant(greeting))
			.to("stream:out");
	}

}
