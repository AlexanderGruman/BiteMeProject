package client;

import java.io.IOException;
import java.util.ArrayList;

import EnumsAndConstants.CommandConstants;
import common.ChatIF;
import gui.LoginPageController;
import logic.CommMessage;
import logic.Users.Supplier;
import logic.Users.User;
import ocsf.client.AbstractClient;

public class ChatClient extends AbstractClient {
	// Instance variables **********************************************

	ChatIF clientUI;
	public static boolean awaitResponse = false;
	private static ClientUI clientui = null;

	// Constructors ****************************************************

	public ChatClient(String host, int port, ChatIF clientUI) throws IOException {
		super(host, port);
		this.clientUI = clientUI;
	}

	// Instance methods ************************************************

	public void handleMessageFromServer(Object msg) {
		CommMessage messageFromSrv = new CommMessage();
		messageFromSrv = (CommMessage) msg;
		switch (messageFromSrv.getCommandForServer()) {
		case ConnectionSuccessful:
			if (messageFromSrv.isSucceeded()) {
				clientui.newConnection(getHost());
			}
			else {
				
			}
		case Login:
			User user = (User)messageFromSrv.getDataFromServer();
			if (messageFromSrv.isSucceeded()) {
				clientui.openUserGUI(user);
			} else {
				clientui.showMsgInLoginPage(messageFromSrv.getMsg());
			}
			break;
		
		case disconnectClientFromServer:
			if(messageFromSrv.isSucceeded()) {
				clientui.closeAppAfterDisconnectClient();
			} else {
				System.out.println("Unable to discconect");
			}
			break;
		
		case LogOut:
			if (messageFromSrv.isSucceeded()) {
				User user2 = (User) messageFromSrv.getDataFromServer();
				user2.setIsLoggedIn(0);
				clientui.closeUserGUI(user2);
			} else {
				clientui.showMsgInLoginPage(messageFromSrv.getMsg());
			}
			break;
			
		case "PersonalData":
			if (messageFromSrv.isSucceeded()) {
				User user = (User) messageFromSrv.getDataFromServer();
				clientui.user = user;
				clientui.reciveMsgToGui("Update Successfull");
			} else {
				clientui.reciveMsgToGui("error in updating user");
			}
		case "GetRestaurantData":
            if (messageFromSrv.isSucceeded()) {
                ArrayList<Supplier> restaurantData = (ArrayList<Supplier>) messageFromSrv.getDataFromServer();
                clientui.updateRestaurantData(restaurantData);
            } else {
                System.out.println("Failed to retrieve restaurant data");
            }
			break;

		}
		
	}

	

	public void handleMessageFromClientUI(Object msg) {
		try {

			awaitResponse = true;
			sendToServer(msg);
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
		} catch (IOException e) {
		}
		System.exit(0);
	}
}
