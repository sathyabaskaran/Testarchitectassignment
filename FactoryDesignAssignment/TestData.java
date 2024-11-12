package FactoryDesignAssignment;

public class TestData {

	public static void main(String[] args) {
		
		//System.out.println("name from excel " + DataFactory.switchDataProvider(DataSource.excel));
		System.out.println("name from faker : " + DataFactory.switchDataProvider(DataSource.faker));
		System.out.println("name from db : " + DataFactory.switchDataProvider(DataSource.db));
		System.out.println("name from api : " +DataFactory.switchDataProvider(DataSource.api));
		System.out.println("name hardcoded : " + DataFactory.switchDataProvider(DataSource.hardcoded));
		

	}

}
