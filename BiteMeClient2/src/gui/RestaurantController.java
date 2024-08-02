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
import logic.Restaurant;

/**
 * Controller class for the Restaurant view.
 */
public class RestaurantController {
    private ClientUI client;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDone;

    @FXML
    private ListView<Restaurant> lstview;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void Initialize() {
        // Create a message to request the list of restaurants
        ArrayList<String> msg = new ArrayList<>();
        CommMessage cmsg = new CommMessage(CommandConstants.GetRestaurants, msg);
        
    }

    /**
     * Sets the table with the list of restaurants.
     *
     * @param reslist The list of restaurants to display.
     */
    public void SetTable(ArrayList<Restaurant> reslist) {
        // Convert ArrayList to ObservableList
        ObservableList<Restaurant> observableList = FXCollections.observableArrayList(reslist);

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
                client.restaurant = newValue;
             // Navigate to the MenuPage
                client.guiConverter("MenuPage", "/gui/MenuPage.fxml");
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
        client.openUserGUI(client.user);
    }
}

