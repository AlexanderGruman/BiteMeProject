package Server;

import ServerGui.ServerPortFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerUI extends Application {
    private static EchoServer server;
    private ServerPortFrameController controller;
    private static ServerUI instance;



    public static void main(String[] args) {
        launch(args);
        System.out.println("Server is starting...");
    }

    public static ServerUI getInstance() {
        if (instance == null) {
            instance = new ServerUI();
        }
        return instance;
    }

    public static void runServer(String p, ServerPortFrameController controller) {
        int port = Integer.parseInt(p);
        server = new EchoServer(port, controller);
        try {
            server.listen();
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }
    }
    
    public static boolean runDB(String username, String password, String dbName) {

        try {
            serverDB.connectToDB(username, password, dbName);
            return true;
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
            return false;
        }
    }

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller = new ServerPortFrameController();
        controller.setServerUI(this);
        controller.start(primaryStage);
    }
    
    public static void stopServer() {
    	try {
    		if (server != null) {
    			server.close();
    			System.out.println("Server stopped.");
    		}
    	} catch (Exception e) {
    		System.out.println("Error stopping the server: " + e.getMessage());
    	}
    }
    
    
    public boolean loggedInIndicator() {
    	return server.areAllDisconnected();
    }
    
    public EchoServer getServer() {
    	return server;
    }
}
