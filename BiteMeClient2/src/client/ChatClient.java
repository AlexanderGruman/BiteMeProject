package client;

import java.io.IOException;

import common.ChatIF;
import gui.OrderDetailViewController;
import gui.StartPageController;
import javafx.application.Platform;
import logic.Orders.Order;
import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient {
    // Instance variables **********************************************
    
    ChatIF clientUI;
    public static boolean awaitResponse = false;
    private static Order targetOrder = null;
    public static StartPageController startPageController;
    
    // Constructors ****************************************************
    
    public ChatClient(String host, int port, ChatIF clientUI) throws IOException {
        super(host, port);
        this.clientUI = clientUI;
    }

    // Instance methods ************************************************
    
    
    public void handleMessageFromServer(Object msg) {
        if (msg instanceof Order) {
            targetOrder = (Order) msg;
        }
        else if (msg instanceof String) {
        	 String[] parts = ((String) msg).split("/");
             String response = parts[0];
//            String response = (String) msg;
             if ("can disconnect".equals(parts[0])) {
            	 awaitResponse = false;
             	 return;
             }  //for if no record -> awaitResponse = false ,startPageController.getInstance().showRecordError("no Record found for given Order ID = " + parts[1]);
             Platform.runLater(() -> {
                if ("Update Successful".equals(response)) {
                	double prc = Double.parseDouble(parts[1]);
                	targetOrder.setTotal_price(prc);
                }
                
                else {
                    startPageController.getInstance().displayUpdateFailedMessage();
                }
            });
        }
        awaitResponse = false;
    }

    public void handleMessageFromClientUI(String message) {
        try {
        	
            awaitResponse = true;
            sendToServer(message);
            while (awaitResponse) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("handleMessageFromClientUI FAILED");
            e.printStackTrace();
            clientUI.display("Could not send message to server: Terminating client." + e);
            quit();
        }
    }

    public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {}
        System.exit(0);
    }
}
