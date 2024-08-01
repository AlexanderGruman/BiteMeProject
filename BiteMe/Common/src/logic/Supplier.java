package logic;

import EnumsAndConstants.BranchLocation;
import EnumsAndConstants.UserType;
import logic.Users.User;

public class Supplier extends User {
	private String RestauarantName;

	public Supplier(String id, String userName, String password, String firstName, String lastName, String email,
			String phoneNumber, UserType userType, BranchLocation mainBranch, String RestauarantName) {
		super(id, userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch);
		this.setUserType(UserType.Supplier);
		this.setRestauarantName(RestauarantName);
	}

	public String getRestauarantName() {
		return RestauarantName;
	}

	public void setRestauarantName(String restauarantName) {
		RestauarantName = restauarantName;
	}

}
