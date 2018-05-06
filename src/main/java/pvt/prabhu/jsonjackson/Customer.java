package pvt.prabhu.jsonjackson;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties("dateOfBirth")
public class Customer {

	private int id;
	private String name;
    private int empRefID;
    private List<Address> addresses;
    private long[] phoneNumbers;
    
    
	public Customer(int id, String name, int empRefID, List<Address> addresses, long[] phoneNumbers) {
		super();
		this.id = id;
		this.name = name;
		this.empRefID = empRefID;
		this.addresses = addresses;
		this.phoneNumbers = phoneNumbers;
	}


	public Customer() {
		super();
	}
    
    

    
}
