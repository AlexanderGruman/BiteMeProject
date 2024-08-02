package EnumsAndConstants;

public enum OrderStatus {
	Pending, Approved, Recieved;
	
	public static OrderStatus getEnum(String name) {
		switch(name) {
		case "Pending":
			return Pending;
		case "Approved":
			return Approved;
		case "Recieved":
			return Recieved;
		default:
			return null;
		}
	}
	
	public String toString() {
		switch (this) { 
		case Pending:
			return "Pending";
		case Approved:
			return "Approved";
		case Recieved:
			return "Recieved";
		default:
			return null;
		}
	}
}
