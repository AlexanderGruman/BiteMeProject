package Server;

import ServerGui.ServerPortFrameController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerUI extends Application {
    private static EchoServer server;
    private static ServerUI instance;
    private static String[] launchArgs;



    public static void main(String[] args) {
        launchArgs = args; // Store the arguments for later use
        launch(args);
        System.out.println("Server is starting...");
    }

    // singelton 
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ServerGui/ServerPort.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Server Configuration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public boolean loggedInIndicator() {
    	return server.areAllDisconnected();
    }
    
    public EchoServer getServer() {
    	return server;
    }
}
