package client;

import java.io.IOException;

import gui.ManagementHomePageController;
import gui.BusinessCustomerHomePageController;
import gui.ConnectionPageController;
import gui.CustomerHomeController;
import gui.LoginPageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import logic.CommMessage;
import logic.Restaurant;
import logic.items;
import logic.Orders.Delivery;
import logic.Orders.Order;
import logic.Users.User;

public class ClientUI extends Application {

	public static ClientController chat; // only one instance
	public static ChatClient client;
	private User user;
	private Restaurant restaurant;
	private Delivery delivery;
	private Order order;
	private items currentitem;
	private String msg;
	

	//////// ---> Login page controller methods <--- ////////

	public void openUserGUI(User user) {
		this.user = user;
		String fxmlStringPath = "";
		String title = "";
		Object controller = null;
		switch(user.getUserType()) {
		case Customer:
			fxmlStringPath = "/gui/CustomerHomePage.fxml";
			title = "Customer home page";
			controller= new CustomerHomeController(user);
			break;
		case BusinessCustomer:
			fxmlStringPath = "/gui/BusinessCustomerHomePage.fxml";
			title = "Business Customer home page";
			controller= new BusinessCustomerHomePageController(user);
			break;
		case BranchManager:
			fxmlStringPath = "/gui/ManagementHomePage.fxml";
			title = "Management home page";
			controller= new ManagementHomePageController(user);
			break;
		case CEO:
			fxmlStringPath = "/gui/ManagementHomePage.fxml";
			title = "Management home page";
			controller= new ManagementHomePageController(user);
			break;
		case Supplier:
			this.restaurant.setSupplierId(user.getId());
			fxmlStringPath = "/gui/SupplierHomePage.fxml";
			title = "Supplier home page";
			// add constructor !!!!!
			break;
		default:
			System.out.println("User type not found");
		}
		guiConverter(title, fxmlStringPath, controller);
	}
	
	
	public void closeAppAfterDisconnectClient() {
		System.exit(0);	
	}
	
	public void closeUserGUI(User user) {
		guiConverter("Login Page", "/gui/LoginPage.fxml");
	}
	
	public void SendLoggoutRequest(CommMessage commMessage)
	{
		chat.accept(commMessage);
	}

	//////// ---> Personal page controller methods <--- ////////
	public void sendUserPersonalData(CommMessage commMessage) {
		chat.accept(commMessage.toString());
	}

	/////////////////////////////////////////

	public static void main(String args[]) throws Exception {
		// launch start method
		launch(args);
	}

	//////// ---> PickRestaurantpage controller methods <--- ////////
	public void SendRestaurantData(CommMessage commMessage) {
		chat.accept(commMessage.toString());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// new GUI - start page
		ConnectionPageController aFrame = new ConnectionPageController();
		aFrame.start(primaryStage);
	}
	//////// ---> Cart page controller methods <--- ////////
	public void GetOrderData(CommMessage commMessage)
	{
		chat.accept(commMessage.toString());
	}

	// create connection to server.
	public boolean newConnection(String ip, int port){
		try {
			chat = new ClientController(ip, port);
			return true;
		}
		catch (IOException ex) {
			return false;
		}
	}
	

	public void guiConverter(String title, String fxmlStringPath, Object controller) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlStringPath));
			loader.setController(controller);
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle(title);
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			System.out.println(title + ": failed to open");
			e.printStackTrace();
		}
	}
	public void RequestData(CommMessage comm)
	{
		chat.accept(comm);
	}

	public void reciveMsgToGui(String msg) {
		this.msg = msg;
	}

	public String ReturnMsgToGui() {
		return msg;
	}
	
	public User getUser() {
		return user;
	}
	
	public void showMsgInLoginPage(String errorMsg){
		LoginPageController.getInstance().showErrorInLoginPageController(errorMsg);
	}

}
