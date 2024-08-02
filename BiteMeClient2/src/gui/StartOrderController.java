package gui;

import java.io.IOException;

import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class StartOrderController {
	private ClientUI client;
	@FXML
	private Button deliveryBtn;
	@FXML
	private Button pickUpBtn;
	@FXML
	private Button FutureBtn;
	@FXML
	private Button backBtn;

	public void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start Order", "/gui/UserHomePage.fxml");

	}

	public void Delivery(ActionEvent event) throws Exception{
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start Delivery", "/gui/DeliveryPage.fxml");

	}

	public void PickUp(ActionEvent event) throws Exception{
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start PickUp", "/gui/PickUpPage.fxml");
	}

	public void Future(ActionEvent event) throws Exception{
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start Future Order", "/gui/PickUpPage.fxml");
	}
}
