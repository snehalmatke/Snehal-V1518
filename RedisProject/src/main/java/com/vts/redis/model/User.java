package com.vts.redis.model;

import java.io.Serializable;
import javax.persistence.Id;
import org.springframework.data.redis.core.RedisHash;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
@ToString
public class User implements Serializable {
	
	private static final long serialVersionUID = -2826833026430986403L;
	
	@Id
	private int id;
	private String lastName;
	private String firstName;
	private String emailId;
	private int age;
	
}
