package logic.Users;

import EnumsAndConstants.*;

public class CEO extends User {

    public CEO() {
        super();
    }

    public CEO(String userName, String password, String firstName, String lastName, String email,
               String phoneNumber, UserType userType, BranchLocation mainBranch, String id, int isLoggedIn) {
        super(userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch, id, isLoggedIn);
        this.setUserType(UserType.CEO);
    }
}
