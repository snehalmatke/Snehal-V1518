package com.vst.host.service;

import java.util.List;

import com.vst.host.model.HostDetails;

public interface HostServiceInteface {

	public boolean saveHostDetails(HostDetails hostdetails);

	public HostDetails getHostId(Integer id);

	public List<HostDetails> findHostListService();

	public boolean deleteById(Integer id);

	public boolean updateHost(Integer id, HostDetails hostdetails);

	public List<HostDetails> findByHostName(String hostName);

	public List<HostDetails> findByHostAddress(String hostAddress);

	public HostDetails findByCustomerId(Integer customerId);

	public List<HostDetails> findByDevice(String device);

	public List<HostDetails> findByManufacturingDate(String manufacturingDate);

	public List<HostDetails> findBySaleDate(String saleDate);

	public List<HostDetails> findByNumberOfDevice(String numberOfDevice);

	public List<HostDetails> findByUnitPrice(String unitPrice);

	public List<HostDetails> findByDeviceType(String deviceType);

	public List<HostDetails> findByAdaptorType(String adaptorType);

	public List<HostDetails> findByDeviceLogoName(String deviceLogoName);

	public List<HostDetails> findByChargerCapacity(String chargerCapacity);
	
	//public List<HostDetails> findBySaleDateByNumberOfDeviceBetween(String minNumberOfDevice, String maxNumberOfDevice);

	
	
	

}
