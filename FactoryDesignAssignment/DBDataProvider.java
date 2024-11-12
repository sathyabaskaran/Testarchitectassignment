package FactoryDesignAssignment;
import java.util.logging.Logger;

public class DBDataProvider implements DataProvider{

	private static final Logger logger = Logger.getLogger(DBDataProvider.class.getName());
	
	public  String provideData() {
		// TODO Auto-generated method stub
		logger.info("Data supplied from database");
		return "DBname";
		
	}

}
