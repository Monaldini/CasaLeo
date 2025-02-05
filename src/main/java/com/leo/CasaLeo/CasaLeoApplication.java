package com.leo.CasaLeo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.leo.CasaLeo.service.*;

@SpringBootApplication
@Service
public class CasaLeoApplication {
	@Autowired
	private RawMaterialService rawMaterialService;

	public static void main(String[] args) {
		SpringApplication.run(CasaLeoApplication.class, args);
	}
		  

		    
		    
	}


