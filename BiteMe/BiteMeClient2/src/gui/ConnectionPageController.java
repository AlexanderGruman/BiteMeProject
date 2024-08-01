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
import logic.Orders.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import client.ClientUI;

public class ConnectionPageController {
	
	
	@FXML
	private Button btnConnect = null;
	
	@FXML
	private TextField ipField;
	
	@FXML
	private Button submitOrderId = null;
	
	private ClientUI client;
	
	public void connectToServer(ActionEvent event) throws Exception {
		((Node)event.getSource()).getScene().getWindow().hide();

		String ipDestination = ipField.getText();
		
		client.newConnection(ipDestination);
		openUpStart();
	}
	
	
	 public void start(Stage primaryStage) {
	        try {
	        	Parent root = FXMLLoader.load(getClass().getResource("/gui/LoginPage.fxml"));
	            Scene scene = new Scene(root);
	            scene.getStylesheets().add(getClass().getResource("/gui/LoginPage.css").toExternalForm());
	            primaryStage.setTitle("Login Page");
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
		
		
	    public void openUpStart() {
	        Platform.runLater(() -> { 
//	        	The error IllegalStateException: Not on FX application thread indicates that you're trying to update the JavaFX UI from a thread other than the JavaFX Application Thread. All JavaFX UI updates must occur on the JavaFX Application Thread.
//	        	To resolve this, you can use Platform.runLater, which ensures that the code runs on the JavaFX Application Thread. Here's how you can modify your openUp method in StartPageController:


	            try {
	                FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginPage.fxml"));
	                Parent root = loader.load();

	                Stage stage = new Stage();
	                stage.setTitle("Connection Page");
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