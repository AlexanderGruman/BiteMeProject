package EnumsAndConstants;

public enum BranchLocation {
	North, Central, South, All;
	
	public static BranchLocation getEnum(String name) {
		switch(name) {
		case "North":
			return North;
		case "Central":
			return Central;
		case "South":
			return South;
		case "All":
			return All;
		default:
			return null;
		}
	}
	
	public String toString() {
		switch (this) { 
		case North:
			return "North";
		case Central:
			return "Central";
		case South:
			return "South";
		case All:
			return "All";
		default:
			return null;
		}
	}
}
