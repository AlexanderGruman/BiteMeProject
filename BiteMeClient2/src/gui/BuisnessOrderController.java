package gui;

import java.awt.Label;
import java.awt.MenuItem;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

public class BuisnessOrderController {
	private ClientUI client;
	@FXML
	private MenuButton menubutton;

	@FXML
	private MenuItem item1, item2, item3, item4, item5;
	@FXML
	private Label email1, email2, email3, email4, email5;

	@FXML
	private TextField text1, text2, text3, text4, text5;

	@FXML
	private Button choosebtn;
	@FXML
	private Button backbtn;

	@FXML
	public void initialize(ActionEvent event) {
		Label[] labels = { email1, email2, email3, email4, email5 };
		TextField[] fields = { text1, text2, text3, text4, text5 };
		MenuItem[] items = { item1, item2, item3, item4, item5 };
		MenuItem clicked = (MenuItem) event.getSource();
		for (int i = 0; i < 5; i++) {
			labels[i].setVisible(false);
			fields[i].setVisible(false);
		}
		for (int i = 0; i < 5; i++) {
			if (clicked == items[i]) {
				for (int j = 0; j < i; j++) {
					labels[j].setVisible(true);
					fields[j].setVisible(true);
				}
				break;
			}
		}
	}

	public void Back(ActionEvent event) throws Exception {
			((Node) event.getSource()).getScene().getWindow().hide();
			client.guiConverter("Login Order", "/gui/LoginPage.fxml");
		}
	public void ChooseRes(ActionEvent event) throws Exception
	{
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Restaurant", "/gui/RestaurantPage.fxml");
	}
}
