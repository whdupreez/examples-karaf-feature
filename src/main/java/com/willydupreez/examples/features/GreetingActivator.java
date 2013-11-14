package com.willydupreez.examples.features;

import org.apache.camel.core.osgi.OsgiDefaultCamelContext;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreetingActivator implements BundleActivator {

	private static Logger log = LoggerFactory.getLogger(GreetingActivator.class);

	private OsgiDefaultCamelContext camelContext;

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		log.info("Starting");
		camelContext = new OsgiDefaultCamelContext(bundleContext);
		camelContext.addRoutes(new TimedConsoleGreetingRouteBuilder());
		camelContext.start();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("Stopping");
		camelContext.stop();
		camelContext = null;
	}

}
