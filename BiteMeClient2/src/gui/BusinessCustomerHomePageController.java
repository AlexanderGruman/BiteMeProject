package gui;

import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import logic.Users.User;

public class BusinessCustomerHomePageController {

	@FXML
	private Button btnLogout;
	
	@FXML
	private Button btnStartBusinessOrder;
	
	@FXML
	private Button btnPreviusOrder;
	
	@FXML
	private Button btnContactUs;
	
	@FXML
	private ImageView personalData;
	
	private ClientUI client;
	
    private User user;
    
    public BusinessCustomerHomePageController(User user) {
    	this.user = user;
    }
    
	public void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Login", "/gui/LoginPage.fxml");

	}
	public void PreviusOrder(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Previus Order", "/gui/PreviusOrderPage.fxml");

	}
	public void StartOrder(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start Order", "/gui/StartOrderPage.fxml");

	}
	public void PersonalData(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("PersonalData Page", "/gui/PersonalDataPage.fxml");

	}
}
