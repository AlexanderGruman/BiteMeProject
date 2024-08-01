package logic.Users;


import EnumsAndConstants.*;


/**
 * Abstract class to describe a User.
 * 
 */
public abstract class User{
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private UserType userType;
	private BranchLocation mainBranch;
	private String id;
	private int isLoggedIn;
	
	
	//THIS DOESNT MATCH SQL TABLE
	private int refundCredit;
	
	
	
	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param userType
	 * @param mainBranch
	 */
	public User(String id, String userName, String password, String firstName, String lastName, String email,
			String phoneNumber, UserType userType, BranchLocation mainBranch)
	{
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userType = userType;
		this.mainBranch = mainBranch;
	}	
	
	public User() {
	}	

	public void setIsLoggedIn(int isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	public int getIsLoggedIn() {
		return isLoggedIn;
	}

	public String getPassword() {
		return password;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id=id;
	}


	public String getEmail() {
		return email;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public UserType getUserType() {
		return userType;
	}


	public BranchLocation getMainBranch() {
		return mainBranch;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public void setUserType(UserType userType) {
		this.userType = userType;
	}



	public void setMainBranch(BranchLocation mainBranch) {
		this.mainBranch = mainBranch;
	}




	public String getUserName() {
		return userName;
	}

	public String toString() {
		return id + " " + firstName + " " + lastName;
	}

	public int getRefundCredit() {
		return refundCredit;
	}

	public void setRefundCredit(int refundCredit) {
		this.refundCredit = refundCredit;
	}
	
	
}
