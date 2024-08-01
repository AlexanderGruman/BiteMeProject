package logic.Users;

import EnumsAndConstants.BranchLocation;
import EnumsAndConstants.UserType;

public class Supplier extends User {
	private String RestauarantName;

	public Supplier(String id, String userName, String password, String firstName, String lastName, String email,
			String phoneNumber, UserType userType, BranchLocation mainBranch, String RestauarantName) {
		super(id, userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch);
		this.setUserType(UserType.Supplier);
		this.setRestaurantName(RestauarantName);
	}

	public String getRestaurantName() {
		return RestauarantName;
	}

	public void setRestaurantName(String restauarantName) {
		RestauarantName = restauarantName;
	}

}
