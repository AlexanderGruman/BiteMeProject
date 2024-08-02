package logic.Users;

import java.io.File;

import EnumsAndConstants.*;

/**
 * BranchManager class, extends user
 */
public class BranchManager extends User{

	public BranchManager(String userName, String password, String firstName, String lastName,
			String id, String email, String phoneNumber, UserType userType,
			BranchLocation mainBranch) 
	{
		super(id, userName, password, firstName, lastName, email, phoneNumber,
				userType, mainBranch);

	}
	
}
