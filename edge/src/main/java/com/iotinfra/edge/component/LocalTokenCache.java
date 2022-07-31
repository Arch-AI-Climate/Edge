package com.iotinfra.edge.component;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/*
 * Check if device is registered/cached
 */
@Component
public class LocalTokenCache {
	private final Map<String, Boolean> cache = new HashMap<>();

	public void put(String id, String ownerId, String token) {
		String key = id + ownerId + token;
		this.cache.put(key, Boolean.TRUE);
	}

	public Boolean validateSensorData(String id, String ownerId, String token) {
		String key = id + ownerId + token;
		return this.cache.getOrDefault(key, Boolean.FALSE);
	}
}
