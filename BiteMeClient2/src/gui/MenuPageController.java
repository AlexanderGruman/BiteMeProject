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
import logic.CommMessage;
import logic.items;

/**
 * Controller class for the Restaurant view.
 */
public class MenuPageController {
    private ClientUI client;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;
    
    @FXML
    private Button finish;

    @FXML
    private ListView<items> lstview;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void Initialize() {
        // Create a message to request the list of menus
        ArrayList<String> msg = new ArrayList<>();
        msg.add(String.valueOf(client.restaurant.getMenuId()));
        CommMessage cmsg = new CommMessage(CommandConstants.GetMenu, msg);
        
    }

    /**
     * Sets the table with the list of menus.
     *
     * @param menlist The list of menus to display.
     */
    public void SetTable(ArrayList<items> menlist) {
        // Convert ArrayList to ObservableList
        ObservableList<items> observableList = FXCollections.observableArrayList(menlist);

        // Set the items of the ListView
        lstview.setItems(observableList);
    }

    /**
     * Handles the Done button click event.
     *
     * @param event The ActionEvent triggered by the button click.
     * @throws Exception If an error occurs during the operation.
     */
    @FXML
    public void handleBtnDone(ActionEvent event) throws Exception {
        // Add a listener to track the selected item
        lstview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // newValue is the selected item
            if (newValue != null) {
            	client.currentitem = newValue;
            	// Navigate to the MenuPage
                client.guiConverter("DishPage", "/gui/DishPage.fxml");
            	
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
        // Open the Restaurant Page
        client.guiConverter("RestaurantPage", "/gui/RestaurantPage.fxml");
    }
    
    
    /**
     * Handles the Finish button click event.
     *
     * @param event The ActionEvent triggered by the button click.
     * @throws Exception If an error occurs during the operation.
     */
    @FXML
    public void handleButtonFinish(ActionEvent event) throws Exception {
        // Navigate to the CartPage
        client.guiConverter("CartPage", "/gui/CartPage.fxml");
    }

    
    
    
    
    
    
    
    
    
    
  
}