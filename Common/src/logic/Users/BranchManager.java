package logic.Users;

import EnumsAndConstants.*;

/**
 * BranchManager class, extends user
 */
public class BranchManager extends User {

    public BranchManager(String userName, String password, String firstName, String lastName,
                         String email, String phoneNumber, UserType userType, BranchLocation mainBranch, String id, int isLoggedIn) {
        super(userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch, id, isLoggedIn);
    }
}
