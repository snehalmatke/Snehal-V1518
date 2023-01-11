package com.vst.host.contoller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.Count;
import org.hibernate.sql.Alias;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vst.host.exception.HostException;
import com.vst.host.model.HostDetails;
import com.vst.host.service.HostServiceImpl;
import com.vst.host.service.SequenceGeneratorService;

import jakarta.validation.Valid;

@RestController
public class HostController {

	@Autowired
	HostServiceImpl hostService;

	@Autowired
	SequenceGeneratorService sequenceservice;

	@Autowired
	MongoTemplate mongoTemplate;

	private static final Logger logger = LogManager.getLogger(HostController.class);

	@PostMapping("host")
	public String saveHostDetails(@Valid @RequestBody HostDetails hostdetails) // save data
	{
		hostdetails.setId(sequenceservice.getSequenceNumber(HostDetails.SEQUENCE_NAME)); // set sequence
		// Generate sequence

		hostdetails.setIsActiveSatus(true);
		// HostDetails obj = hostdetails;
		// if (obj.getCustomerId() > 0) {
		if (hostService.saveHostDetails(hostdetails)) {
			return "Data sucessfully save";
			// }
		} else
			throw new HostException("Customer id Should be positive");

		// logger.error("Data not save succesfully");

		// return "something wents wrong";
	}

	@GetMapping("hostD")
	public HostDetails getHostDetailById(@RequestParam("id") Integer id) { // get id
		HostDetails hstd = new HostDetails();
		if (hstd.isIsActiveSatus() == true) {
			return hostService.getHostId(id);
		}
		throw new HostException("Id not found");
	}

	@GetMapping("hostD/gdetails") // get all details
	public List<HostDetails> getAllDetails() {
		return hostService.findHostListService();

	}

	@DeleteMapping("DeleteDetails")
	public String deleteById(@RequestParam int id) // delete id
	{
		HostDetails obj = new HostDetails();
		if (obj.getId() > 0) {
			if (hostService.saveHostDetails(obj)) {
				return "Data sucessfully save";
			} else {
				throw new HostException("please enter valid ID");
			}
		} else
			return "Data not found";

	}

	@PutMapping("update")
	public String updateDetailsHost(@Valid @RequestParam("id") int id, @RequestBody HostDetails hostdetails) { // update
																												// data

		if (hostService.updateHost(id, hostdetails)) {
			return "updated successfully";
		} else {
			// return "something went wrong";
			throw new HostException("Something wents wrong");

		}

	}

	@GetMapping("hostname")
	public List<HostDetails> findByhostname(@RequestParam("hostName") String hostName) { // get host name
		return hostService.findByHostName(hostName);
	}

//	@GetMapping("customerId{id}")
//	public HostDetails findByCustomerId(@RequestParam("customerId") Integer customerId) { // get customer id
//		return hostService.findByCustomerId(customerId);
//	}

	@GetMapping("getdevice")
	public List<HostDetails> findByDevice(@RequestParam("device") String device) { // get device
		return hostService.findByDevice(device);
	}

	@GetMapping("manufacturingDate")
	public List<HostDetails> findByManufacturingDate(@RequestParam("manufacturingDate") String manufacturingDate) {// get
																													// manufacturing
																													// date
		return hostService.findByManufacturingDate(manufacturingDate);
	}

	@GetMapping("saleDate")
	public List<HostDetails> findBySaleDate(@RequestParam("saleDate") String saleDate) { // get sale date
		return hostService.findBySaleDate(saleDate);
	}

	@GetMapping("numberOfDevice")
	public List<HostDetails> findByNumberOfDevice(@RequestParam("numberOfDevice") String numberOfDevice) { // get number
																											// of
																											// device
		return hostService.findByNumberOfDevice(numberOfDevice);
	}
	
	@GetMapping("customerId")
	public List<HostDetails> findByCustomerId(@RequestParam("customerId") String customerId) { // get no of device
		//group
		GroupOperation groupByDept= Aggregation.group("customerId").count().as("count");
		System.out.println(groupByDept.toString());
		//matchopration
		MatchOperation matchOperation = Aggregation.match(new Criteria("count").is(customerId));
		System.out.println(matchOperation.toString());

		//sortopration
		SortOperation sortOpertaion = Aggregation.sort(Sort.by(Sort.Direction.DESC,"count"));
		System.out.println(sortOpertaion.toString());
		//Aggregation
		Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOpertaion);
		AggregationResults output = mongoTemplate.aggregate(aggregation, "HostDetails",HostDetails.class);
													
		System.out.println(aggregation.toString());
		System.out.println(output.toString());

		return output.getMappedResults();

	}

	@GetMapping("unitPrice")
	public List<HostDetails> findByUnitPrice(@RequestParam("unitPrice") String unitPrice) { // get unit price
		return hostService.findByUnitPrice(unitPrice);
	}

	@GetMapping("deviceType")
	public List<HostDetails> findByDeviceType(@RequestParam("deviceType") String deviceType) { // get device type
		return hostService.findByDeviceType(deviceType);
	}

	@GetMapping("adapterType")
	public List<HostDetails> findByAdapterType(@RequestParam("adapterType") String adaptorType) { // get adapter type
		return hostService.findByAdaptorType(adaptorType);
	}

	@GetMapping("deviceLogoName")
	public List<HostDetails> findByDeviceLogoName(@RequestParam("deviceLogoName") String deviceLogoName) {

		return hostService.findByDeviceLogoName(deviceLogoName);
	}

	@GetMapping("chargerCapacity")
	public List<HostDetails> findByChargercapcity(@RequestParam("chargerCapacity") String chargerCapacity) {

		return hostService.findByChargerCapacity(chargerCapacity);
	}

	@GetMapping("multiple")
	public boolean addMultipleData() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10000; i++) {
			HostDetails obj = new HostDetails();

			obj.setHostName("icon" + i);
			obj.setHostAddress("pune" + i);
			obj.setCustomerId(1 + i);
			obj.setDevice("charger" + i);
			obj.setManufacturingDate("12-12-2022" + i);
			obj.setSaleDate("2-3-2023" + i);
			obj.setNumberOfDevice("300" + i);
			obj.setUnitPrice("5.2" + i);
			obj.setDeviceType("mini USB" + i);
			obj.setAdaptorType("Type C" + i);
			obj.setDeviceLogoName("abc" + i);
			obj.setChargerCapacity("5V" + i);
			saveHostDetails(obj);
		}

		return true;
	}}


// Query criteria
//	@GetMapping("chargerCapacity")
//	public List<HostDetails> findByChargercapcity(@RequestParam("chargerCapacity") String chargerCapacity) {
//	Query query = new Query();
//	query.addCriteria(Criteria.where("chargerCapacity").is(chargerCapacity));
//	return mongoTemplate.find(query, HostDetails.class);
//}}

//	@GetMapping("/find/{minNumberOfDevice}/{maxNumberOfDevice}")
//	public List<HostDetails> findBySaleDateByNumberOfDeviceBetween(@PathVariable String minNumberOfDevice,@PathVariable String maxNumberOfDevice){
//		return hostService.findBySaleDateByNumberOfDeviceBetween(minNumberOfDevice, maxNumberOfDevice);
//	}}
