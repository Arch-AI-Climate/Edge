package com.iotinfra.edge.repository;

import com.iotinfra.edge.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeviceRepository extends MongoRepository<Device, String> {
	Optional<Device> findByIdAndOwnerIdAndToken(String id, String ownerId, String token);
}
