package FactoryDesignAssignment;
import java.util.logging.Logger;

public class HardcodeDataProvider implements DataProvider{

	private static final Logger logger = Logger.getLogger(HardcodeDataProvider.class.getName());
	
	public  String provideData() {
		// TODO Auto-generated method stub
		String randomName = "Sathya";
		logger.info("Data is hardcoded");
		return randomName;
		
	}

}
