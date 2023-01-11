package com.vst.host.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.vst.host.model.HostDetails;

public interface HostRepo extends MongoRepository<HostDetails, Integer> {

	@Query("{'hostName':{'$regex':'?0','$options':'i'}}")
	public List<HostDetails> findByHostName(String hostName);

	public List<HostDetails> findByHostAddress(String hostAddress);

	public List<HostDetails> findByCustomerId(Integer customerId);

	public List<HostDetails> findByDevice(String device);

	public List<HostDetails> findByManufacturingDate(String manufacturingDate);

	public List<HostDetails> findBySaleDate(String saleDate);
	
	public List<HostDetails> findByNumberOfDevice(String numberOfDevice);

	public List<HostDetails> findByUnitPrice(String unitPrice);

	public List<HostDetails> findByDeviceType(String deviceType);

	public List<HostDetails> findByAdaptorType(String adaptorType);

	public List<HostDetails> findByDeviceLogoName(String deviceLogoName);

	//@Query(value ="{'chargerCapacity':{$gte:?0}}")
	//@Query("{'chargerCapacity':?0}")
	public List<HostDetails> findByChargerCapacity(String chargerCapacity);

	public HostDetails findByIdAndIsActiveSatus(Integer id);
	
	//@Query("{'numberOfDevice':{'$gte' : '?0','lt': '?1'}}")
	//public List<HostDetails> findBySaleDateByNumberOfDeviceBetween(String minNumberOfDevice, String maxNumberOfDevice);
	
	

}
