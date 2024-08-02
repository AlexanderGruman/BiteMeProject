package gui;

import client.ClientUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Orders.Order;


public class OrderDetailViewController {
    private Order myOrder;
    
    @FXML
    private Button btnBack = null;
    
    @FXML
    private Button btnUpdate = null;
    
    @FXML
    private TextField RstField;
    
    @FXML
    private TextField OrdNumField;
    
    @FXML
    private TextField OrdLField;
    
    @FXML
    private TextField AddyField;
    
    @FXML
    private TextField PriceField;
    
    private static OrderDetailViewController instance;

    public OrderDetailViewController() {
        instance = this;
    }

    public static OrderDetailViewController getInstance() {
        return instance;
    }

    // Method to receive order from client and display it
    public void loadOrder(Order externalOrder) {
        myOrder = externalOrder;
        this.RstField.setText(myOrder.getRestaurants());
        this.OrdNumField.setText(String.valueOf(myOrder.getOrder_number()));
        this.OrdLField.setText(String.valueOf(myOrder.getOrder_list_number()));
        this.AddyField.setText(myOrder.getOrder_adress());
        this.PriceField.setText(String.valueOf(myOrder.getTotal_price()));
    }
    
    // Method to update order details in the view
    public void updateOrderDetails(Order updatedOrder) {
        this.myOrder = updatedOrder;
    	this.PriceField.setText(String.valueOf(updatedOrder.getTotal_price()));
        this.AddyField.setText(updatedOrder.getOrder_adress());
    }
    
    public void backToStart(ActionEvent event) {
//        ((Node) event.getSource()).getScene().getWindow().hide(); // hiding primary window
//        StartPageController.getInstance().openUp(myOrder);
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
    
    public void updateDbRequest(ActionEvent event) {
        String newAddress = AddyField.getText();
        String newPrice = PriceField.getText();
        String PK = OrdNumField.getText();
        String restaurant = RstField.getText();
        String orderList = OrdLField.getText();
        
        
        

        // Run the update request in a separate thread to prevent blocking the UI
        new Thread(() -> {
            try {
                ClientUI.requestOrderUpdate("POST/" + PK + "/" + newPrice + "/" + newAddress + "/" + restaurant + "/" + orderList);
                Platform.runLater(() -> {
                    // Optionally, display a success message or update UI
                });
            } catch (Exception e) {
                Platform.runLater(() -> {
                    System.err.println("Error updating order.");
                    e.printStackTrace();
                });
            }
        }).start();
    }
}
