package com.vst.host.model;


import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
@NoArgsConstructor
@Document(collection = "hostDetails")
public class HostDetails {

	@Transient // not going to participate with table
	public static final String SEQUENCE_NAME = "host_sequense";

	@Id
	private int id;

	@NotNull
	private String hostName;
	
	private String hostAddress;

	
	@NotNull(message = "please Enter CustomerId")
	@Positive(message = "customerid should be positive")
	private int customerId;
	private String device;

	@Pattern(regexp = ("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"), message = "Enter valid date")
	// @DateTimeFormat
	private String manufacturingDate;

	@Pattern(regexp = ("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$"), message = "Enter valid date")
	// @DateTimeFormat
	private String saleDate;

	@NotNull(message = "Please Enter Valid Data")
	private String numberOfDevice;

	@NotNull
	private String unitPrice;

	private String deviceType;

	private String adaptorType;

	@Size(min = 4, max = 10, message = "deviceLogoName must be mininum 4 character and maximum 10 character! ")
	private String deviceLogoName;

	private String chargerCapacity;

	private boolean IsActiveSatus = true;

}
