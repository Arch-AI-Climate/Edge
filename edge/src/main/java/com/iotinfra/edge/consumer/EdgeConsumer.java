package com.iotinfra.edge.consumer;

import com.iotinfra.edge.model.SensorData;
import com.iotinfra.edge.service.DeviceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/*
 * Validate the information coming from IoT devices in a specific topic
 *
 */
@Component
public class EdgeConsumer {
	private final static Logger LOGGER = LoggerFactory.getLogger(EdgeConsumer.class);

	private final DeviceService deviceService;
	private final Processor processor;

	public EdgeConsumer(DeviceService deviceService, Processor processor) {
		this.deviceService = deviceService;
		this.processor = processor;
	}

	@StreamListener(Processor.INPUT)
	public void handle(SensorData sensorData) {
		if(deviceService.validateSensorData(sensorData)) {
			LOGGER.info("Sensor Data : {}", sensorData);
			sensorData.setToken(null);
			processor.output().send(MessageBuilder.withPayload(sensorData).build());
		} else {
			LOGGER.info("Rejected sensor dataa : {}", sensorData);
		}
	}
}
