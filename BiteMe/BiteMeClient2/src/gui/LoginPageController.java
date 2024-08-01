package gui;

import java.io.IOException;
import java.util.ArrayList;

import EnumsAndConstants.CommandConstants;
import client.ClientUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.CommMessage;

public class LoginPageController {

    @FXML
    private Button btnExit = null;
    
    @FXML
    private Button btnLogin = null;
    
    @FXML
    private TextField userName;
    
    @FXML
    private TextField password;
    @FXML
    private Text error;
    
    private static LoginPageController instance;
    private static Stage LoginStage;
    private ClientUI client;
    
    public LoginPageController() {
        instance = this;
    }

    // singelton for the login page
    public static LoginPageController getInstance() {
        return instance;
    }
    
    
    // Submit button to read user input and send to server
    public void sumbitCredentialsToServer(ActionEvent event) throws Exception {
        String userInput = userName.getText();
        String passInput = password.getText();
        ArrayList<String> sendToServer = new ArrayList<String>();
        sendToServer.add(userInput);
        sendToServer.add(passInput);
        client.RequestData(new CommMessage(CommandConstants.Login,sendToServer));
        
        ((Node)event.getSource()).getScene().getWindow().hide();
    }
    
    public void logoutPressed(ActionEvent event) throws Exception {
        ArrayList<String> sendToServer = new ArrayList<String>();
        sendToServer.add(client.user.getUserName());
        sendToServer.add(client.user.getPassword());
    	client.SendLoggoutRequest(new CommMessage(CommandConstants.Login,sendToServer));
    }
    
  
//    public void successfullLogin(User user)
//    {
//    	if(permissions.equals("customer"))
//    	{
//			client.guiConverter("customer home page", "/gui/UserHomePage.fxml");
//    	}
//    	//after adding the restaurant page
//    	else if(permissions.equals("restaurant"))
//    	{
//    		client.guiConverter("restaurant home page", "/gui/.fxml");
//    	}
//    	else if(permissions.equals("manager"))
//    	{
//    		client.guiConverter("manager home page", "/gui/.fxml");
//    	}
//    	else 
//    	{
//    		client.guiConverter("ceo home page", "/gui/.fxml");
//    	}
//    	
//    }
//    
//    
    public void UnSuccessfullLogin(String wrong)
    {
    	error.setVisible(true);
    	if(wrong.equals("userName"))
    	{
    		error.setText("The UserName is wrong");
    	}
    	else
    		error.setText("The Password is wrong");
    	
    }
    
//    // Method to update or open OrderDetailView
//    public void openUp() {
//        Platform.runLater(() -> {
//            try {
//                if (orderDetailViewController == null || orderDetailStage == null) {
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/OrderDetailView.fxml"));
//                    Parent root = loader.load();
//                    orderDetailViewController = loader.getController();
//                    orderDetailStage = new Stage();
//                    orderDetailStage.setTitle("Order Details");
//                    orderDetailStage.setScene(new Scene(root));
//                }
//                
//                orderDetailViewController.loadOrder(myOrder);
//                
//                if (!orderDetailStage.isShowing()) {
//                    orderDetailStage.show();
//                }
//                
//            } catch (IOException e) {
//                System.out.println("OpenUp function failed");
//                e.printStackTrace();
//            }
//        });
//    }
    
    // exit button method that `kill` the server and exit the application 
    public void exitApp(ActionEvent event) throws Exception {
        ClientUI.chat.accept("disconnect");
    	System.exit(0);
    }
    
    @FXML
    public void exitApplication(ActionEvent event) {
        try {
			this.exitApp(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    

}
