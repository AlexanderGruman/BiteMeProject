package gui;

import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BusinessCustomerHomePageController {

	private ClientUI client;
	@FXML
	private Button btnBack;
	@FXML
	private Button btnStartOrder;
	@FXML
	private Button btnPreviusOrder;
	@FXML
	private ImageView personalData;
	
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
