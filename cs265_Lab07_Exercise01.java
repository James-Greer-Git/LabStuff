package cs265;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;

public class DataProvider_Template {

	// test data
	private static Object[][] testData = new Object[][] {
			// id, variable1, variable2, ... variableN, expected
			{"T1.1", true, true, TicketType.Economy, 20},
			{"T1.2", true, false, TicketType.Economy, 10},
			{"T1.3", false, true, TicketType.Economy, 10},
			{"T1.4", false, false, TicketType.Economy, 5},
			{"T2.1", true, true, TicketType.Business, 10},
			{"T2.2", true, false, TicketType.Business, 5},
			{"T2.3", false, true, TicketType.Business, 5},
			{"T2.4", false, false, TicketType.Business, 0},
			{"T3.1", true, true, TicketType.First, 0},
			{"T3.2", true, false, TicketType.First, 0},
			{"T3.3", false, true, TicketType.First, 0},
			{"T3.4", false, false, TicketType.First, 0} 
	};

	@DataProvider(name = "data")
	public Object[][] getTestData() {
		return testData;
	}

	@Test(dataProvider = "data")
	public void test(String id, String variable1, String variable2, String variableN, int expected) {
		// assertEquals(actual, expected);
	}
}
