package gui;

import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.CommMessage;

import java.net.URL;
import java.time.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import EnumsAndConstants.CommandConstants;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.Users.*;


public class DishPageController implements Initializable {
	
	private ClientUI client;
	
	@FXML
	private MenuButton idDishesAmount ;
	
	@FXML
	private TextField idFoodRequests;
	
	@FXML
	private TextField idPriceToAddup;

	@FXML
	private Spinner<Integer> idSpinner;

	
	

	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		String price = String.valueOf(client.currentItem.getPrice());
		idPriceToAddup.setText(price);

		
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5);
		valueFactory.setValue(1);
		
		idSpinner.setValueFactory(valueFactory);
		
		idSpinner.valueProperty().addListener(new ChangeListener<Integer>() {

			@Override
			public void changed(ObservableValue<? extends Integer> arg0, Integer arg1, Integer arg2) {
				idPriceToAddup.setText(client.currentItem.getPrice() * idSpinner.getValue());
				
			}
			
		});
		
		
	}
	
	

	
	
	
	
	public void ContinueShopping(ActionEvent event) throws Exception {

		
		// UPDATE TOTAL PRICE
		
		
		
		closeFoodSelection(event);
	}
	
	
	public void closeFoodSelection(ActionEvent event) throws Exception {
	
		//go back to menuPage.fmxl
		((Node) event.getSource()).getScene().getWindow().hide();
		client.guiConverter("Menu Page", "/gui/MenuPage.fxml");
	}
	
	




}
