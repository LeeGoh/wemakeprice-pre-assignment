package com.preassignment.wemakeprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WemakepriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WemakepriceApplication.class, args);
	}

}
