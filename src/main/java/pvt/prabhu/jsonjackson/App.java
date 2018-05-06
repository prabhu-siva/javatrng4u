package pvt.prabhu.jsonjackson;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public class App {
	public static void main(String[] args) {
		
		
		customerSerilization();
		System.out.println("Coming back");
		customerDeserilization();
		
		
	}

	private static void customerDeserilization() {
		try {
			System.out.println("DeSerilization...");
			byte[] jsonData = Files.readAllBytes(Paths.get(
					"C:\\Users\\prabh\\imcs-workspace\\MavenProjects\\jsonjackson\\src\\main\\resources\\Customer.json"));
			ObjectMapper objectMapper = new ObjectMapper();
			Customer prabhu = (Customer)objectMapper.readValue(jsonData, Customer.class);
			System.out.println("Customer Object\n" + prabhu);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	private static void customerSerilization() {
		System.out.println("Serilization...");
		List<Address> addresses = new ArrayList<Address>();
		Address homeAddress = new Address("MacArthur", "iriving", 98345);
		Address officeAddress = new Address("N MacArthur", "iriving", 98345);
		addresses.add(homeAddress);
		addresses.add(officeAddress);
		long[] phoneNumbers = new long[] { 894384923, 234354324 };
		Customer prabhu = new Customer(1, "Prabhu", 2, addresses, phoneNumbers);

		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		try {

			objectMapper.writeValue(System.out, prabhu);
			objectMapper.writeValue(new PrintWriter(
					"C:\\Users\\prabh\\imcs-workspace\\MavenProjects\\jsonjackson\\src\\main\\resources\\Customer.json"),
					prabhu);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
