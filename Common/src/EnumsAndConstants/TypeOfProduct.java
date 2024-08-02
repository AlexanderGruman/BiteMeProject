package EnumsAndConstants;

public enum TypeOfProduct {
    Salad, MainCourse, Dessert, Drink, Side;

    public static TypeOfProduct getEnum(String name) {
        switch (name) {
            case "Salad":
                return Salad;
            case "MainCourse":
                return MainCourse;
            case "Dessert":
                return Dessert;
            case "Drink":
                return Drink;
            case "Side":
                return Side;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case Salad:
                return "Salad";
            case MainCourse:
                return "MainCourse";
            case Dessert:
                return "Dessert";
            case Drink:
                return "Drink";
            case Side:
                return "Side";
            default:
                return null;
        }
    }
}
