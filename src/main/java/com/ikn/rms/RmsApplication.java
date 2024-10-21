package com.ikn.rms;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RmsApplication.class, args);
	}
		
		@Bean
		public ModelMapper createModelMapper() 
		{
			ModelMapper m = new ModelMapper();
			m.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			return m;
			
		}
		
		 @Bean
		    public  RestTemplate restTemplate()
		 {
		        return new RestTemplate();
		  }
		
	
}
