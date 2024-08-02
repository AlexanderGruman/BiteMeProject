package logic.Users;

import EnumsAndConstants.*;

public class Customer extends User {

    public Customer() {
        super();
    }

    public Customer(String userName, String password, String firstName, String lastName, String email,
                    String phoneNumber, UserType userType, BranchLocation mainBranch, String id, int isLoggedIn) {
        super(userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch, id, isLoggedIn);
        this.setUserType(UserType.Customer);
    }
}
