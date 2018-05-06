package pvt.prabhu.jsonjackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
public class Address {
     
    private String street;
    private String city;
    
    @JsonIgnore
    private int zipcode;
    

	public Address(String street, String city, int zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
	}


	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
     
  
}