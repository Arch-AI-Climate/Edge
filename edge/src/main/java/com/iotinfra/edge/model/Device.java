package com.iotinfra.edge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document("device")
public class Device {

	@Id
	private String id;          // id for the device
	private String ownerId;		// id for the owner of the device(person or organization)
	private String token;       // secret key used to validate messages and the device


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Device device = (Device) o;
		return Objects.equals(id, device.id) && Objects.equals(ownerId, device.ownerId) && Objects.equals(token, device.token);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, ownerId, token);
	}
}
