package FactoryDesignAssignment;

import java.util.logging.Logger;

import com.github.javafaker.Faker;

public class FakerDataprovider implements DataProvider {
	
private static final Logger logger = Logger.getLogger(ExcelDataprovider.class.getName());
	
	public  String provideData() {
		// TODO Auto-generated method stub
		
		Faker faker = new Faker();
		
		String randomName = faker.name().firstName();
		logger.info("Data supplied from faker");
		return randomName;
		

}
}
