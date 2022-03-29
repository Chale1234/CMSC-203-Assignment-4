import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany mgmt;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		mgmt = new ManagementCompany("Amanuel PLC", "1234", 24);
		
		//student add three properties, with plots, to mgmt co
		Property testProp1 = new Property("Property1","Rockville",500,"TA Amanuel", 1,1,1,1);
		Property testProp2 = new Property("Property2","Silver Spring",600,"TA Amanuel", 5,5,3,3);
		Property testProp3 = new Property("Property3","Bethesda",700,"Ta Amanuel", 9,9,1,1);
		
		mgmt.addProperty(testProp1);
		mgmt.addProperty(testProp2);
		mgmt.addProperty(testProp3);
	}

	@After
	public void tearDown() {
		mgmt = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(3, mgmt.addProperty("Property4", "Silver Spring", 300, "A Addis"), .001);
		//student should add property with 8 args
		assertEquals(4, mgmt.addProperty("Property5", "Bethsda",500, "A Amanuel", 8, 8, 1, 1), .001);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		//assertEquals(-1, mgmt.addProperty("Fake Property", "Washington DC", 700, "A Wodnesh", 3, 3, 1, 1), .001);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertTrue(mgmt.maxRentProp().split("\n")[3].contains("700"));
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(1800, mgmt.totalRent(), .001);
	}

 }