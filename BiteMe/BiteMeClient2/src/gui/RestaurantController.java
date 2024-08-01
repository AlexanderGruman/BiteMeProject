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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.CommMessage;
import logic.Users.Supplier;

public class RestaurantController {

	private ClientUI client;
	private ObservableList<Supplier> data;
	@FXML
	private Button btnBack;
	@FXML
	private TableView<Supplier> resTable;
	@FXML
	private TableColumn<Supplier,String> resName;
	@FXML
	private TableColumn<String,Button> btnChoose;
	
	

	@FXML
	public void Intialize()
	{
		ArrayList<String> client.SendRestaurantData(new CommMessage( CommandConstants.GetRestaurants,));
	}
	public void setTable()
	{
        // Initialize the columns.
		resName.setCellValueFactory(new PropertyValueFactory<>("name"));
		btnChoose.setCellValueFactory(new PropertyValueFactory<>("chooseMenuButton"));

        // Initialize the data list and set it to the TableView.
        data = FXCollections.observableArrayList();
        resTable.setItems(data);
        Supplier newRestaurant = new Supplier(client.supplier.getRestaurantName(),client.supplier.getRestaurantType()); // Replace with actual data.
        data.add(newRestaurant);
	}
	public void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Start Order", "/gui/UserHomePage.fxml");

	}
	

}
