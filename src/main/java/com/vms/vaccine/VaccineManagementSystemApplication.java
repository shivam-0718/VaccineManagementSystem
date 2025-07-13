package com.vms.vaccine;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Vaccine Management System Application",
				version = "1.0",
				description = "This application will ." +
						"manage Vaccine information records " +
						"and it can be used for following operations, " +
						"including registration, updating, retrieval and deletion of vaccine records."
		),
		servers = @Server(
				url = "http://localhost:8484/vaccine-manager",
				description = "This application is available in the following URL location."
		)
)
public class VaccineManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineManagementSystemApplication.class, args);
	}


}
