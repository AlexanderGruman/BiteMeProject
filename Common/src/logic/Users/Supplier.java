package logic.Users;

import EnumsAndConstants.*;

public class Supplier extends User {
    private String RestauarantName;

    public Supplier(String userName, String password, String firstName, String lastName, String email,
                    String phoneNumber, UserType userType, BranchLocation mainBranch, String id, int isLoggedIn, String RestauarantName) {
        super(userName, password, firstName, lastName, email, phoneNumber, userType, mainBranch, id, isLoggedIn);
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
