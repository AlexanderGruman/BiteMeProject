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
import logic.Supplier;

public class MenuPageController {
	private ClientUI client;
	private ObservableList<Menu> data;
	@FXML
	private Button btnBack;
	@FXML
	private TableView<Menu> MenuTable;
	@FXML
	private TableColumn<Menu,String> MenuName;
	@FXML
	private TableColumn<String,Button> btnChoose;
	@FXML
	private Button[] ChooseDishBtn;
	
	@FXML
	public void Intialize()
	{
		ArrayList<String> restaurant=new ArrayList<String>();
		restaurant.add(client.supplier.getRestaurantName());
		client.SendMenuData(new CommMessage(new CommandConstants().getMenuDataCommand,restaurant));
	}
	public void setTable()
	{
        // Initialize the columns.
		MenuName.setCellValueFactory(new PropertyValueFactory<>("name"));
		btnChoose.setCellValueFactory(new PropertyValueFactory<>("chooseMenuButton"));
        // Initialize the data list and set it to the TableView.
        data = FXCollections.observableArrayList();
        MenuTable.setItems(data);
        Menu newMenu = new Menu(data.); // Replace with actual data.
        
        data.add(newMenu);
	}
	public void Back(ActionEvent event) throws Exception {
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Restaurant page", "/gui/RestaurantPage.fxml");

	}

}
