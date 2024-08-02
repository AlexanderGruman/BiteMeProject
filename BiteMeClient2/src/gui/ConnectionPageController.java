package gui;

import java.util.ArrayList;

import EnumsAndConstants.CommandConstants;
import client.ClientUI;
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

public class ConnectionPageController {
	
	@FXML
	private Button btnConnect = null;
	
	@FXML
	private TextField ipField;
	
	@FXML
	private TextField portField;
	
	@FXML
	private Button submitOrderId = null;
	
	@FXML
	private Text errorMsg;
	
	private ClientUI client = new ClientUI();
	
	@FXML
	public void connectToServer(ActionEvent event) throws Exception {
		String ipDestination = ipField.getText();
		int port = Integer.parseInt(portField.getText());
		boolean succeed = client.newConnection(ipDestination,port);
		if(succeed) {
			((Node)event.getSource()).getScene().getWindow().hide();
			client.guiConverter("Connection Page", "/gui/LoginPage.fxml", new LoginPageController());
		}
		else {
			errorMsg.setVisible(true);
			errorMsg.setText("IP incorrect, server unreachable");
		}
	}
	
	
	 public void start(Stage primaryStage) {
	        try {
	        	Parent root = FXMLLoader.load(getClass().getResource("/gui/ConnectionPage.fxml"));
	            Scene scene = new Scene(root);
	            primaryStage.setTitle("Connection Page");
	            primaryStage.setScene(scene);
	            primaryStage.show();  
	        } catch (Exception e) {
	            System.err.println("Error loading FXML or CSS files of the Connection Page");
	            e.printStackTrace();
	        }     
	    }
	
	
		public void getExitBtn(ActionEvent event) throws Exception {
			ArrayList sendToServer = new ArrayList<>();
			sendToServer.add("localhost");
			client.chat.accept(new CommMessage(CommandConstants.disconnectClientFromServer,sendToServer));
	
		
		}		
			
		
			
		public void exitApp(ActionEvent event) throws Exception {
			
			System.exit(0);
		
		}
			
			
			
	
		
		
		

	
}