package gui;

import java.io.IOException;

import client.ClientUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Orders.Order;

public class StartPageController {
    
    @FXML
    private Button btnExit = null;
    
    @FXML
    private TextField orderNumberField;
    
    //@FXML
    //private TextArea recordsErrorBox;
    
    @FXML
    private Button submitOrderId = null;
    
    public static OrderDetailViewController orderDetailViewController;
    private static Stage orderDetailStage;
    private static StartPageController instance;

    public StartPageController() {
        instance = this;
    }

    public static StartPageController getInstance() {
        return instance;
    }

    // Submit button to read user input and send to server
    public void sumbitIdToServer(ActionEvent event) throws Exception {
        String userInput = orderNumberField.getText();
        ClientUI.requestOrderDetails("GET/" + userInput);
    }
    
    // Method to update or open OrderDetailView
    public void openUp(Order myOrder) {
        Platform.runLater(() -> {
            try {
                if (orderDetailViewController == null || orderDetailStage == null) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/OrderDetailView.fxml"));
                    Parent root = loader.load();
                    orderDetailViewController = loader.getController();
                    orderDetailStage = new Stage();
                    orderDetailStage.setTitle("Order Details");
                    orderDetailStage.setScene(new Scene(root));
                }
                
                orderDetailViewController.loadOrder(myOrder);
                
                if (!orderDetailStage.isShowing()) {
                    orderDetailStage.show();
                }
                
            } catch (IOException e) {
                System.out.println("OpenUp function failed");
                e.printStackTrace();
            }
        });
    }

    public void displayUpdateFailedMessage() {
        // Implement logic to display the failure message to the user
        System.out.println("Order update failed. Please try again.");
    }
    
    public void exitApp(ActionEvent event) throws Exception {
        ClientUI.chat.accept("disconnect");
    	System.exit(0);
    }
    
    //to add method to show error box 
    //@FXML
    //public void showRecordError(){
    //	Platform.runLater(() -> {
    //		recordsErrorBox.appendText(message + "\n");
    //	});
    //}
    
    @FXML
    public void exitApplication(ActionEvent event) {
        //serverDB.closeDBconnection();
//        ServerUI.stopServer();
//        System.exit(0);
        try {
			this.exitApp(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}
