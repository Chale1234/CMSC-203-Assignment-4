

/**
 *  Class: CMSC203 CRN 21464
 Program: Assignment #4
 Instructor: Professor Ahmed Tarik
 Summary of Description: (This program lets the user create 
 a management company and add the properties managed by the company to its list. 
 Assume the maximum number of properties handled by the company is 5. ) 
 Due Date: 03/27/2022 
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 programmer : Enchalew Abebe
*/



public class ManagementCompany {
	
	// creating an instance field for management company classes

  private final int MAX_PROPERTY = 5;
  private final int MAX_WIDTH = 10;
  private final int MAX_DEPTH = 10;
  private Property[] properties;
  private double mgmFeePer;
  private String name;
  private String taxID;
  private Plot plot;

  // creating a default consturctor for the class called mangagement comapny 
  public ManagementCompany() {
    this.name = "";
    this.taxID = "";
    this.mgmFeePer = 0;
    this.plot = new Plot();
    this.properties = new Property[MAX_PROPERTY];
  }
  // creating constructor for mangament company class with its attributes with default plot
  public ManagementCompany(String name, String taxID, double mgmFeePer) {
    this.mgmFeePer = mgmFeePer;
    this.taxID = taxID;
    this.name = name;
    this.plot = new Plot(0,0,MAX_WIDTH, MAX_DEPTH);
    this.properties = new Property[MAX_PROPERTY];
  }
  
  // creating a constructor for the managment company class with its attributes and with plot

  public ManagementCompany(String name, String taxID, double mgmFeePer, 
      int x, int y, int width, int depth) {
    this.name = name;
    this.taxID = taxID;
    this.mgmFeePer = mgmFeePer;
    this.plot = new Plot(x,y,width,depth);
    this.properties = new Property[MAX_PROPERTY];
  }

  /**
   * add property to the array
   * 
   * @param property
   * @return return to -2 if the property is equals to null
   * if property is not equals to null return to negative 4 
   * if the property is full return to negative 1
   */
  public int addProperty(Property property) {
    if (property == null) {
      return -2;
    }
    // if property is not the company plot, put the property out of the array and return  negative -3
    if (!plot.encompasses(property.getPlot())) {
      //System.out.println(plot.getWidth() + " " + plot.getDepth());
      //System.out.println(property.getPlot().getWidth() + " " + property.getPlot().getDepth());
      return -3;
    }
    /** using the for loop and if statment to validate whetehr the property overlap or not
    * if the property at the index is not null, add one and 
    * if the property at the index is overlaping, then return negative 4
    * else return to the index
    */
    for (int i = 0;i < properties.length;i++) {
      if (properties[i] != null) {
        if (properties[i].getPlot().overlaps(property.getPlot())) {
          return -4;
        }
      } else {
        properties[i]=property;
        return i;
      } 
    }
      return -1;
  }
  // add property with a default plot  and return them
  public int addProperty(String propertyName, String city, double rent, String ownerName) {
    return addProperty(new Property(propertyName, city, rent, ownerName));
  }
  // add property wth attributes and  and return them with custome plot
  public int addProperty(String propertyName, String city, double rent, String ownerName,
      int x, int y, int width, int depth) {
    return addProperty(new Property(propertyName, city, rent, ownerName, x, y, width, depth));
  }
  /**
   * using the for loop and if statment to add the total amount of the rent
   * @return the totals
   */
  public double totalRent() {
    double total = 0;
    for (int i=0;i<properties.length;i++) {
      if (properties[i]==null) {
        break;
      }
      total += properties[i].getRentAmount();
    }
    return total;
  }
  // get the index with the maximum rent amount and return the index
  private int maxPropertyRentIndex() {
    int index = -1;
    double max = 0;
    for (int i = 0;i<properties.length;i++) {
      if (properties[i]==null) {
        break;
      }
      if (properties[i].getRentAmount() > max) {
        max = properties[i].getRentAmount();
        index = i;
      }
    }
    return index;
  }
  // get the property with maximum rent and return the information with maximum rent
  public String maxRentProp() {
    double max =0;
    Property prop1 = properties[0];
    for (Property prop : properties) {
    	if (prop !=null) {
    		if (prop.getRentAmount() > max) {
    			max = prop.getRentAmount();
    			prop1 = prop;
    		
    		
    		}
    	}
    }
    return prop1.toString();
  }
  // get the display property index and return to properties
  private String displayPropertyAtIndex(int index) {
    return properties[index].toString();
  }
  
   
  /** 
   * Get all properties array with its attributes
   * @return  the list of properties and the total managment fee
   */
  @Override
  public String toString() {

    String listOfProperties = "";
    for (int i = 0; i < MAX_PROPERTY; i++) {
      if (properties[i]==null) {
        break;
      } 
      listOfProperties += properties[i] + "\n"; 
    }
    return "List of the properties for " + name + ", taxID: " + taxID
        + "\n"
        + listOfProperties +  "\n"
        + "total management Fee: " + (totalRent() * mgmFeePer / 100);
  }

  /**Get maximum property 
   * @return the MAX_PROPERTY
   */
  public int getMAX_PROPERTY() {
    return MAX_PROPERTY;
  }
  // get plot and return to it
  public Plot getPlot() {
    return plot;
  }
  // get the name and return to it
  public String getName() {
    return name;
  }

  
}