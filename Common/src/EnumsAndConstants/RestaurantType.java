package EnumsAndConstants;

public enum RestaurantType {
    Italian, Asian, Fastfood, Other;

    public static RestaurantType getEnum(String name) {
        switch (name) {
            case "Italian":
                return Italian;
            case "Asian":
                return Asian;
            case "Fastfood":
                return Fastfood;
            case "Other":
                return Other;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case Italian:
                return "Italian";
            case Asian:
                return "Asian";
            case Fastfood:
                return "Fastfood";
            case Other:
                return "Other";
            default:
                return null;
        }
    }
}
