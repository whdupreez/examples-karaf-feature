/**
 *    Copyright 2013 Willy du Preez
 *    
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *    
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
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
