package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Order;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import client.ClientUI;
import gui.OrderDetailViewController;

public class StartPageController {
	
	
	@FXML
	private Button btnExit = null;
	
	@FXML
	private TextField orderNumberField;
	
	@FXML
	private Button submitOrderId=null;
	
	
	//submit button
	//read user input and send to server
	public void sumbitIdToServer(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window

		String userInput = orderNumberField.getText();
		//use clientUI's chat field, that is connected to the server to fowrard the order number
		ClientUI.requestOrderDetails("GET//" +userInput);
	}
	
	
	 public void start(Stage primaryStage) {
	        try {
	        	Parent root = FXMLLoader.load(getClass().getResource("/gui/StartPage.fxml"));
	            Scene scene = new Scene(root);
	            scene.getStylesheets().add(getClass().getResource("/gui/StartPage.css").toExternalForm());
	            primaryStage.setTitle("Start Page");
	            primaryStage.setScene(scene);
	            primaryStage.show();  
	        } catch (Exception e) {
	            System.err.println("Error loading FXML or CSS files.");
	            e.printStackTrace();
	        }     
	    }
	
	
		public void getExitBtn(ActionEvent event) throws Exception {
			System.exit(0);			
		}
		
		
	    public void openUp(Order myOrder) {
	        Platform.runLater(() -> { 
//	        	The error IllegalStateException: Not on FX application thread indicates that you're trying to update the JavaFX UI from a thread other than the JavaFX Application Thread. All JavaFX UI updates must occur on the JavaFX Application Thread.
//	        	To resolve this, you can use Platform.runLater, which ensures that the code runs on the JavaFX Application Thread. Here's how you can modify your openUp method in StartPageController:


	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/OrderDetailView.fxml"));
	                Parent root = loader.load();

	                OrderDetailViewController controller = loader.getController();
	                
	                //LOAD the order from sql into local field varuiable 
	                controller.loadOrder(myOrder);

	                Stage stage = new Stage();
	                stage.setTitle("Order Details");
	                stage.setScene(new Scene(root));
	                stage.show();
	            } catch (IOException e) {
	                System.out.println("OpenUp function failed");
	                e.printStackTrace();
	            }
	        });
	    }			
			
		
			
		public void exitApp(ActionEvent event) throws Exception {
			
			System.exit(0);
		
		}
			
			
			
	
		
		
		

	
}