package EnumsAndConstants;

public enum PaymentMethod {

	CreditCard,Cash;
	
	public static String getEnum(PaymentMethod method) {
		switch(method) {
		case CreditCard:
			return "Credit Card";
		case Cash:
			return "Cash";
		default:
			return "";
		}
	}
}
