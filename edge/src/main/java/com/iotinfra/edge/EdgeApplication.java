package com.iotinfra.edge;

import com.iotinfra.edge.model.Device;
import com.iotinfra.edge.repository.DeviceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EdgeApplication implements CommandLineRunner {
	private final DeviceRepository repository;

	public EdgeApplication(DeviceRepository repository) {
		this.repository = repository;
	}


	public static void main(String[] args) {
		SpringApplication.run(EdgeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Device device = new Device();
		device.setId("1");
		device.setOwnerId("1");
		device.setToken("123");

		this.repository.save(device);
	}






}
