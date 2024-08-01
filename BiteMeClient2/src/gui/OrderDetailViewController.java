package gui;

import java.io.IOException;

import client.ClientUI;
import javafx.application.Platform;
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



public class OrderDetailViewController {
	private Order myOrder;
	
	@FXML
	private Button btnBack = null;
	
	@FXML
	private Button btnUpdate = null;
	
	@FXML
	private TextField RstField;
	
	@FXML
	private TextField OrdNumField;
	
	@FXML
	private TextField OrdLField;
	
	@FXML
	private TextField AddyField;
	
	@FXML
	private TextField PriceField;
	
	
	//function to recieve order from client and display new windows with filled fields
	
	public void loadOrder(Order externalOrder) {
		myOrder = externalOrder;
		this.RstField.setText(myOrder.getRestaurants());
		this.OrdNumField.setText(String.valueOf(myOrder.getOrder_number()));
		this.OrdLField.setText(String.valueOf(myOrder.getOrder_list_number()));
		this.AddyField.setText(myOrder.getOrder_adress());
		this.PriceField.setText(String.valueOf(myOrder.getTotal_price()));
		
	}
	
	
	 public void start(Stage primaryStage) {
	        try {
	   
	        	Parent root = FXMLLoader.load(getClass().getResource("/gui/OrderDetailView.fxml"));
	            Scene scene = new Scene(root);
	            scene.getStylesheets().add(getClass().getResource("/gui/OrderDetailView.css").toExternalForm());
	            primaryStage.setTitle("Start Page");
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        	
	            
	        } catch (Exception e) {
	            System.err.println("Error loading FXML or CSS files.");
	            e.printStackTrace();
	        }
	        
	    }
	 
	 
	 public void backToStart(ActionEvent event) {
		 ((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary window
		 Platform.runLater(() -> { 
			 try {
	             FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/StartPage.fxml"));
	             Parent root = loader.load();
	
	             StartPageController controller = loader.getController();
	             
	        
	
	             Stage stage = new Stage();
	             stage.setTitle("Choose order");
	             stage.setScene(new Scene(root));
	             stage.show();
	         } catch (IOException e) {
	             System.out.println("OrderDetailViewController.java backToStart(); failed to start new windows");
	             e.printStackTrace();
	         }
		 });
	 }
	 
		
			
			
	 public void updateDbRequest(ActionEvent event) {

	        String newAddress = AddyField.getText();
	        String newPrice = PriceField.getText();
	        String PK = OrdNumField.getText();

	        // Run the update request in a separate thread to prevent blocking the UI
	        new Thread(() -> {
	            try {
	                ClientUI.requestOrderUpdate("POST//" + PK + "//" + newPrice + "//" + newAddress);
	                // Update the UI on the JavaFX Application Thread
	                Platform.runLater(() -> {
	                    // You can update the UI here if needed
	                });
	            } catch (Exception e) {
	                Platform.runLater(() -> {
	                    System.err.println("Error updating order.");
	                    e.printStackTrace();
	                });
	            }
	        }).start();
	    }

			
			
		






}
