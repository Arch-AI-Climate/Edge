package com.iotinfra.edge.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashMap;
import java.util.Map;

public class SensorData {

	private String id;
	private Long timestamp;
	private String ownerId;
	private String token;

	private Map<String, Object> extraFields = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@JsonGetter
	public Map<String, Object> getExtraFields() {
		return extraFields;
	}

	public void setExtraFields(Map<String, Object> extraFields) {
		this.extraFields = extraFields;
	}

	@JsonSetter
	public void setExtraFields(String key, Object value) {
		this.extraFields.put(key, value);
	}

	@Override
	public String toString() {
		return "SensorData{" +
			"id='" + id + '\'' +
			", timestamp=" + timestamp +
			", tenantId='" + ownerId + '\'' +
			", token='" + token + '\'' +
			", extraFields=" + extraFields +
			'}';
	}
}
