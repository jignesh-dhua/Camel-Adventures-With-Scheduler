package com.mycompany.samples.example.scheduler;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {

			@Override
			public void beforeApplicationStart(CamelContext camelContext) {
				camelContext.getGlobalOptions().put("http.proxyHost", "ouparray.oup.com");				
				camelContext.getGlobalOptions().put("http.proxyPort", "8080");
			}

			@Override
			public void afterApplicationStart(CamelContext camelContext) {
			
			}
		};
	}
}