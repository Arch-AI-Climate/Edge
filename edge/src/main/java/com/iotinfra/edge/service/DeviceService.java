package com.iotinfra.edge.service;

import com.iotinfra.edge.component.LocalTokenCache;
import com.iotinfra.edge.model.Device;
import com.iotinfra.edge.model.SensorData;
import com.iotinfra.edge.repository.DeviceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeviceService {
	private final static Logger LOGGER = LoggerFactory.getLogger(DeviceService.class.getName());

	private final DeviceRepository deviceRepository;
	private final LocalTokenCache cache;

	public DeviceService(DeviceRepository deviceRepository, LocalTokenCache cache) {
		this.deviceRepository = deviceRepository;
		this.cache = cache;
	}

	public boolean validateSensorData(SensorData sensorData) {
		String id = sensorData.getId();
		String ownerId = sensorData.getOwnerId();
		String token = sensorData.getToken();

		if(!isPresentInCache(id, ownerId, token)) {
			LOGGER.info("Entry NOT found in cache: {}, {}, {}", id, ownerId, token);

			Optional<Device> res = deviceRepository.findByIdAndOwnerIdAndToken(id, ownerId, token);

			if(res.isPresent()) {  // device is in MongoDB & registered
				saveInCache(id, ownerId, token);
				return Boolean.TRUE;
			} else {  // device is not registered
				return Boolean.FALSE;
			}
		} else {
			LOGGER.info("Entry found in cache: {}, {}, {}", id, ownerId, token);
			return Boolean.FALSE;
		}
	}

	private Boolean isPresentInCache(String id, String ownerId, String token) {
		return cache.validateSensorData(id, ownerId, token);
	}

	private void saveInCache(String id, String ownerId, String token) {
		cache.put(id, ownerId, token);
	}
}
