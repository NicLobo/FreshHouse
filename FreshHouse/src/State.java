package src;

public class State {
	private double lat = 0.0;
	private double lng = 0.0;
	private String state;
	private double hpi;
	private double pollution;
	private int year;
	private int ID = 0; 		//Alphabetical order of State position

	/*
	* @brief Constructor for State object with all need parameters for graphing.
	* @param latitude The state latitude as a double value.
	* @param longitude The state longitude as a double value.
	* @param S The String for the state name.
	* @param h The double HPI value for the state.
	* @param p The double pollution value for the state.
	* @param y The year as an inetegerfor the state.
	* @param id The ID as an ineteger for the state.
	* @return The State object.
	*/
    public State(double latitude, double longitude, String name, double h,double p,int y,int id) {
		lat = latitude;
		lng = longitude;   
		hpi = h;
   		pollution = p;
   		state = name;
		year = y;
		ID = id;
	}
	
	/*
	* @brief Constructor for State object with core parameters only.
	* @param h The double HPI value for the state.
	* @param p The double pollution value for the state.
	* @param S The String for the state name.
	* @param y The year as an ineteger for the state.
	* @return The State object.
	*/
    public State(double h,double p, String s, int y) {
		hpi = h;
   		pollution = p;
   		state = s;
		year = y;
    }

	/*
	* @brief Returns the State latitude.
	* @return The State latitude as a double.
	*/
	public double lat(){
		return lat;
	}

	/*
	* @brief Returns the State longitude.
	* @return The State longitude as a double.
	*/
	public double lng(){
		return lng;
	}
	
	/*
	* @brief Returns the State HPI.
	* @return The State HPI as a double.
	*/
    public double hpi(){
	   return hpi;
	}
	
	/*
	* @brief Returns the State pollution.
	* @return The State pollution as a double.
	*/
	public double pollution() {
	   return pollution;
	}

	/*
	* @brief Returns the State name.
	* @return The State name as a String.
	*/
    public String state() {
   		return state;
	}
	
	/*
	* @brief Returns the year.
	* @return The year as an integer.
	*/
    public int year() {
   		return year;
	}
	
	/*
	* @brief Returns the State ID.
	* @return The State ID as an integer.
	*/
	public int getID() {
		return ID;
	}
	 
	/*
	* @brief Gets the weight of an edge between two States, lower is higher value home.
	* @param prevState The state that you started in.
	* @return The edge weight inverse as a double value.
	*/
	public double homeValue(State prevState) {
		double dist = this.distance(prevState);
		return 1/(dist/100 + hpi/pollution);
	}

	/*
	* @brief Gets the distance between two States in km.
	* @param that The state that you are moving to.
	* @return The distance in km as a double value.
	*/
	public double distance(State that) {
		double radiusEarth = 6371;		//Earths radius in km
		double newStateLat = Math.toRadians(that.lat());
		double newStateLong = Math.toRadians(that.lng());
		double thisStateLat = Math.toRadians(this.lat());
		double thisStateLong = Math.toRadians(this.lng());
		double latDifference = Math.abs(newStateLat - thisStateLat);
		double longifference = Math.abs(newStateLong - thisStateLong);
		double temp1 = Math.sin(latDifference/2) * Math.sin(latDifference/2) + Math.cos(thisStateLat) * Math.cos(newStateLat) * Math.sin(longifference/2) * Math.sin(longifference/2);
		double temp2 = 2 * Math.atan2(Math.sqrt(temp1), Math.sqrt(1-temp1));
		return temp2 * radiusEarth;
	}

	/*
	* @brief Compares this State HPI with a paramater State HPI.
	* @param that The State that you are comparing to. 
	* @return A boolean, true if this State is greater that or equal to the parameter State's HPI, false otherwise.
	*/
    public boolean compareHpi(State that){
		if(this.hpi >= that.hpi()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	* @brief Compares this State pollution with a paramater State pollution.
	* @param that The State that you are comparing to. 
	* @return A boolean, true if this State is less that or equal to the parameter State's pollution, false otherwise.
	*/
    public boolean comparePollution(State that){
   	
		if(this.pollution <= that.pollution()) {
			return true;
		} else {
			return false;
		}
	}

	/*
	* @brief Compares this State with another State with both HPI and pollution.
	* @param that The State that you are comparing to. 
	* @return A boolean, true if this State is greater that or equal to the parameter State's hpi/pollution value.
	*/
    public boolean compareBoth(State that){
		
		double currentTotal = this.hpi/this.pollution;
		double newTotal = that.hpi/that.pollution;

		if(currentTotal >= newTotal )
			return true;
		else
			return false;
    }

	/*
	* @brief Compares this State name with a parameter State name to check if they are the same State.
	* @param that The State that you are comparing to. 
	* @return A boolean, true if the States have the same name, false otherwise.
	*/
    public boolean compareState(State that){
		System.out.println(this.state.compareTo(that.state()));
		if(this.state.compareTo(that.state()) <= 0) {
			return true;
		} else {
			return false; 
		}
	}
}