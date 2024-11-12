package FactoryDesignAssignment;
import java.util.logging.Logger;

public class APIDataProvider implements DataProvider{

	private static final Logger logger = Logger.getLogger(APIDataProvider.class.getName());
	
	public  String provideData() {
		// TODO Auto-generated method stub
		logger.info("Data supplied from api");
		return "APIname";
		
	}

}
