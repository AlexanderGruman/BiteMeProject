package EnumsAndConstants;

public class CommandConstants {

	/**
	 * Login for user;
	 **   
	 * if Succeeded - get user in the dataFromServer;
	 **   
	 * if not - see msg;
	 * @param messageForServer add userName
	 * @param messageForServer add password
	 * @returns isSucceeded true/false
	 */
	public static final String loginCommand = "Login";
	
	/**
	 * Log out the user.
	 * 
	 * If succeeded - user session is terminated.
	 * 
	 * If not - see msg;
	 * @param messageForServer add user name
	 * @param messageForServer add password
	 * @returns isSucceeded true/false
	 */
	public static final String logOutCommand = "LogOut";
	
	/**
	 * Open a new account.
	 * 
	 * If succeeded - new account details in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param ObjectForServer add new User object
	 * @returns isSucceeded true/false
	 */
	public static final String openNewAccountCommand = "openNewAccount";

	/**
	 * Get the list of restaurants.
	 * 
	 * If succeeded - list of restaurants in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add location details or preferences
	 * @returns isSucceeded true/false
	 */
	public static final String getRestaurantsCommand = "GetRestaurants";

	/**
	 * Register a new business customer.
	 * 
	 * If succeeded - new business customer details in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add business customer details
	 * @returns isSucceeded true/false
	 */
	public static final String newBusinessCustomerCommand = "NewBusinessCustomer";

	/**
	 * Update the status of an order.
	 * 
	 * If succeeded - updated order status in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add order ID and new status
	 * @returns isSucceeded true/false
	 */
	public static final String updateOrderStatusCommand = "UpdateOrderStatus";

	/**
	 * Register a new supplier.
	 * 
	 * If succeeded - new supplier details in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add supplier details
	 * @returns isSucceeded true/false
	 */
	public static final String newSupplierCommand = "NewSupplier";

	/**
	 * Update the order as received.
	 * 
	 * If succeeded - updated order received status in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add order ID and received status
	 * @returns isSucceeded true/false
	 */
	public static final String updateOrderReceivedCommand = "UpdateOrderReceived";

	/**
	 * Get the quarterly report.
	 * 
	 * If succeeded - quarterly report details in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add quarter and year details
	 * @returns isSucceeded true/false
	 */
	public static final String getQuarterReportCommand = "GetQuarterReport";

	/**
	 * Get the monthly report.
	 * 
	 * If succeeded - monthly report details in the dataFromServer.
	 * 
	 * If not - see msg;
	 * @param messageForServer add month and year details
	 * @returns isSucceeded true/false
	 */
	public static final String getMonthlyReportCommand = "GetMonthlyReport";
}
