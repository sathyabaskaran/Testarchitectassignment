package FactoryDesignAssignment;


public class DataFactory {
	

	
	public  static String switchDataProvider(DataSource datasource)
	{
		switch (datasource)
		{
		   case excel:
			  return new ExcelDataprovider().provideData();
		   case faker:
			  return  new FakerDataprovider().provideData();
		   case db:
			  return new DBDataProvider().provideData();
		   case api:
			  return new APIDataProvider().provideData();
		   case hardcoded:
			  return new HardcodeDataProvider().provideData();
			default:
				throw new IllegalArgumentException("supplied data source is not supported");
		
		}
		
	}

}
