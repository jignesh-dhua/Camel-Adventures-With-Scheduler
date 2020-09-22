package com.mycompany.samples.example.scheduler;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SchedulerRoute extends RouteBuilder {
    
	@Autowired
	private LogRoutePolicy logRoutePolicy;
	
	@Value("${scheduler.endpoint}")
	private String schedulerEndpoint;
	
	@Value("${webservice.endpoint}")
	private String webserviceEndpoint;
	
    @Override
    public void configure() throws Exception {
    	
    	from(schedulerEndpoint)
        .routePolicy(logRoutePolicy)


        .log("*** calling web service")
        .toD(webserviceEndpoint)
        
        .log("Response From Webservice: ${body}");
    }
}