package com.vst.host.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.vst.host.exception.HostException;
import com.vst.host.model.HostDetails;
import com.vst.host.repository.HostRepo;

import jakarta.transaction.Transactional;

@Service
public class HostServiceImpl implements HostServiceInteface {

	@Autowired
	HostRepo hrepo;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Override
	@Transactional // to avoid rollback on listed exceptions
	public boolean saveHostDetails(HostDetails hostdetails) {
		hrepo.save(hostdetails);
		return true;
	}

	@Override
	public HostDetails getHostId(Integer id) {
		HostDetails hdetails = hrepo.findByIdAndIsActiveSatus(id);
		if (hdetails.isIsActiveSatus() == true) {
			return hdetails;
		}
		return hdetails;

	}

	@Override
	@Transactional
	public boolean deleteById(Integer id) {

		HostDetails hostdetails = hrepo.findByIdAndIsActiveSatus(id);
		if (hostdetails != null) {
			hostdetails.setIsActiveSatus(false);
			hrepo.save(hostdetails);
			return true;
		} else
			throw new HostException("Data not found");
	}

	
	@Override
	public boolean updateHost(Integer id, HostDetails hostdetails) {
		HostDetails obj = hrepo.findById(id).get();
		if (hostdetails.getHostName() != null) {
			obj.setHostName(hostdetails.getHostName());
		}
		if (hostdetails.getHostAddress() != null) {
			obj.setHostAddress(hostdetails.getHostAddress());
		}
		if (hostdetails.getCustomerId() != 0) {
			obj.setCustomerId(hostdetails.getCustomerId());
		}
		if (hostdetails.getDevice() != null) {
			obj.setDevice(hostdetails.getDevice());
		}
		if (hostdetails.getManufacturingDate() != null) {
			obj.setManufacturingDate(hostdetails.getManufacturingDate());
		}
		if (hostdetails.getSaleDate() != null) {
			obj.setSaleDate(hostdetails.getSaleDate());
		}
		if (hostdetails.getNumberOfDevice() != null) {
			obj.setNumberOfDevice(hostdetails.getNumberOfDevice());
		}
		if (hostdetails.getUnitPrice()!= null) {
			obj.setUnitPrice(hostdetails.getUnitPrice());
		}
		if (hostdetails.getDeviceType() != null) {
			obj.setDeviceType(hostdetails.getDeviceType());
		}
		if (hostdetails.getAdaptorType() != null) {
			obj.setAdaptorType(hostdetails.getAdaptorType());
		}
		if (hostdetails.getDeviceLogoName() != null) {
			obj.setDeviceLogoName(hostdetails.getDeviceLogoName());
		}
		if (hostdetails.getChargerCapacity() != null) {
			obj.setChargerCapacity(hostdetails.getChargerCapacity());
		}

		hrepo.save(obj);
		return true;

	}

	@Override
	public List<HostDetails> findHostListService() {
		return hrepo.findAll();

	}

	@Override
	public List<HostDetails> findByHostName(String hostName) {
		return hrepo.findByHostName(hostName);
	}

	@Override
	public List<HostDetails> findByHostAddress(String hostAddress) {
		return hrepo.findByHostAddress(hostAddress);
	}

	@Override
	public HostDetails findByCustomerId(Integer customerId) {
		return hrepo.findByCustomerId(customerId).get(0);
	}

	@Override
	public List<HostDetails> findByDevice(String device) {
		return hrepo.findByDevice(device);
	}

	@Override
	public List<HostDetails> findByManufacturingDate(String manufacturingDate) {
		return hrepo.findByManufacturingDate(manufacturingDate);
	}

	@Override
	public List<HostDetails> findBySaleDate(String saleDate) {
		return hrepo.findBySaleDate(saleDate);
	}

	@Override
	public List<HostDetails> findByNumberOfDevice(String numberOfDevice) {
		return hrepo.findByNumberOfDevice(numberOfDevice);
	}

	@Override
	public List<HostDetails> findByUnitPrice(String unitPrice) {
		return hrepo.findByUnitPrice(unitPrice);
	}

	@Override
	public List<HostDetails> findByDeviceType(String deviceType) {
		return hrepo.findByDevice(deviceType);
	}

	@Override
	public List<HostDetails> findByAdaptorType(String adaptorType) {
		return hrepo.findByAdaptorType(adaptorType);
	}

	@Override
	public List<HostDetails> findByDeviceLogoName(String deviceLogoName) {
		return hrepo.findByDeviceLogoName(deviceLogoName);
	}

	@Override
	public List<HostDetails> findByChargerCapacity(String chargerCapacity) {
		return hrepo.findByChargerCapacity(chargerCapacity);
	}
//	@Override
//	public List<HostDetails> findBySaleDateByNumberOfDeviceBetween(String minNumberOfDevice, String maxNumberOfDevice) {
//		// TODO Auto-generated method stub
//		return hrepo.findBySaleDateByNumberOfDeviceBetween(minNumberOfDevice, maxNumberOfDevice);
//	}
//	

	public void getMessageToTopic(String message) {
		kafkaTemplate.send("Host", message);
	}


	@KafkaListener(topics="Host",groupId="HostGroup")
	public void listenToTopic(String recevideMessage) {
	System.out.println("The message recevide is" + recevideMessage);
	}

	
}
