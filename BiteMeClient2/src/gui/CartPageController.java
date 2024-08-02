package gui;

import java.util.ArrayList;

import EnumsAndConstants.CommandConstants;
import client.ClientUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import logic.CommMessage;
import logic.items;

public class CartPageController {
	private ClientUI client;

	@FXML
	private Button btnBack;

	@FXML
	private Button btnDeleteDish;

	@FXML
	private ListView<items> lstview;
	@FXML
	private TextField price;

	/**
	 * Initializes the controller class.
	 */
	@FXML
	public void Initialize() {
		// Create a message to request the list of restaurants
		ArrayList<String> msg = new ArrayList<>();
		msg.add(client.user.getUserName());
		msg.add(String.valueOf(client.restaurant.getRestaurantId()));
		msg.add(String.valueOf(client.delivery.getDeliveryId()));
		CommMessage cmsg = new CommMessage(CommandConstants.GetOrder, msg);
		client.GetOrderData(cmsg);
	}

	/**
	 * Sets the table with the list of restaurants.
	 *
	 * @param reslist The list of restaurants to display.
	 */
	public void SetTable(ArrayList<items> reslist) {
		// Convert ArrayList to ObservableList
		ObservableList<items> observableList = FXCollections.observableArrayList(reslist);

		// Set the items of the ListView
		lstview.setItems(observableList);
		price.setText(String.valueOf(client.order.getTotal_price()));
	}

	/**
	 * Handles the Done button click event.
	 *
	 * @param event The ActionEvent triggered by the button click.
	 * @throws Exception If an error occurs during the operation.
	 */
	@FXML
	public void handleBtnDeleteDish(ActionEvent event) throws Exception {
		// Add a listener to track the selected item
		lstview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			// newValue is the selected item
			if (newValue != null) {
				ArrayList<items> arr = client.order.getItemsInOrder();
				if (arr.contains(newValue)) {
					client.order.setNumOfItems(client.order.getNumOfItems() - 1);
					double itemp = newValue.getPrice();
					arr.remove(newValue);
					client.order.setItemsInOrder(arr);
					double newPrice = (client.order.getTotal_price());
					newPrice = newPrice - itemp;
					client.order.setTotal_price(newPrice);
					price.setText(String.valueOf(newPrice));
				}

			}
		});

	}

	/**
	 * Handles the Back button click event.
	 *
	 * @param event The ActionEvent triggered by the button click.
	 * @throws Exception If an error occurs during the operation.
	 */
	@FXML
	public void Back(ActionEvent event) throws Exception {
		// Hide the current window
		((Node) event.getSource()).getScene().getWindow().hide();
		// Open the user GUI
		client.guiConverter("Menu Page", "/gui/MenuPage.fxml");
	}
}
