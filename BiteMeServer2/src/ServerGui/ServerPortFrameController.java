package ServerGui;

import java.net.InetAddress;
import java.net.UnknownHostException;

import Server.ServerUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import logic.Users.ClientUser;

public class ServerPortFrameController {
    @FXML
    private Button btnExit;
    
    @FXML
    private Button btnDone;

    @FXML
    private TextField portxt;

    @FXML
    private TextArea connectedUsersTextArea;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField databaseField;

    @FXML
    private Label ipLabel;
    
    @FXML
    private Label hostLabel;
    
    @FXML
    private Label connectionStatusLabel;
    
    @FXML
    private TextArea errorTextArea; // New TextArea for error messages

    private boolean isConnected = false;
    
    private ServerUI serverUI;

    private String getPort() {
        return portxt.getText();
    }
    
    public void setServerUI(ServerUI serverUI) {
    	this.serverUI = serverUI;
    }
    

    public void start(Stage primaryStage) throws Exception {
    	Parent root = FXMLLoader.load(getClass().getResource("/ServerGui/ServerPort.fxml"));
    	Scene scene = new Scene(root);  // Set initial window size to 1200x1000
    	//scene.getStylesheets().add(getClass().getResource("/ServerGui/ServerPort.css").toExternalForm());
    	primaryStage.setTitle("Server Port");
    	primaryStage.setScene(scene);
    	
    	// Add a listener to handle the window close request
    	primaryStage.setOnCloseRequest(event -> {
    		event.consume(); // Consume the event to prevent the default behavior
    		getExitBtn(null); // Call the getExitBtn method
    	});
    	
    	primaryStage.show();
    }
    
    @FXML
    public void initialize() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            ipLabel.setText("IP: " + inetAddress.getHostAddress());
            hostLabel.setText("Host: " + inetAddress.getHostName());
        } catch (UnknownHostException e) {
            ipLabel.setText("IP: Unable to determine");
            hostLabel.setText("Host: Unable to determine");
        }
    }

    @FXML
    public void Done(ActionEvent event) throws Exception {
        if (!isConnected) {
            String port = getPort();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String databaseName = databaseField.getText();

            if (!checkCredentials(port, username, password, databaseName)) {
            	return;
            }
            if (connectToDatabase(username, password, databaseName)) {
                ServerUI.runServer(port, this);
                btnDone.setText("Disconnect");
                isConnected = true;
            } else {
                showError("Failed to connect to the database. Please check your credentials and try again.");
            }
        } else {
            disconnect();
        }
    }
    
    private boolean checkCredentials(String port, String username, String password,String databaseName) {
    	if (port.trim().isEmpty() && username.trim().isEmpty() && password.trim().isEmpty() && databaseName.trim().isEmpty()) {
            showError("All fields must be filled.");
            return false;
        }
        
        if (port.trim().isEmpty()) {
            showError("Port field must be filled.");
            return false;
        }

        if (username.trim().isEmpty()) {
            showError("Username field must be filled.");
            return false;
        }

        if (password.trim().isEmpty()) {
            showError("Password field must be filled.");
            return false;
        }

        if (databaseName.trim().isEmpty()) {
            showError("Database Name field must be filled.");
            return false;
        }
        return true;
    }

    private boolean connectToDatabase(String username, String password, String databaseName) {
    	boolean isConnected2 = ServerUI.runDB(username, password, databaseName);
        Platform.runLater(() -> {
            if (isConnected2) {
                connectionStatusLabel.setText("Status: Connected");
                connectionStatusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
            } else {
                connectionStatusLabel.setText("Status: Not Connected");
                connectionStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
            }
        });
        return isConnected2;
    }

    private void disconnect() {
        //serverDB.closeDBconnection();
    	if (!ServerUI.getInstance().loggedInIndicator()) {
        	showError("Cannot terminate Server , There is still Users connected");
        	return;
        }
        ServerUI.stopServer();
        btnDone.setText("Connect");
        connectionStatusLabel.setText("Status: Not Connected");
        connectionStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
        isConnected = false;
    }


    @FXML
    public void getExitBtn(ActionEvent event) {
        try {
        	if (ServerUI.getInstance().getServer() == null) {
        		throw new NullPointerException();
        	}
        	if (!ServerUI.getInstance().loggedInIndicator()) {
        		showError("Cannot terminate Server , There is still Users connected");
        		return;
        	}
        	ServerUI.getInstance().stopServer();
        }catch (Exception e) {
//        	System.err.println("Error loading FXML or CSS files.");
//            e.printStackTrace();
        }
    	System.out.println("Exiting application...");
        // Close DB connection and stop server
        //serverDB.closeDBconnection();
    	System.gc();
        System.exit(0);
    }

    @FXML
    public void exitApplication(ActionEvent event) {
        //serverDB.closeDBconnection();
//        ServerUI.stopServer();
//        System.exit(0);
        this.getExitBtn(null);
    }
    
    public void updateUI(ClientUser user, boolean connected) {
        Platform.runLater(() -> {
            if (connected) {
                connectedUsersTextArea.appendText(user.toString());
            } else {
                connectedUsersTextArea.appendText(user.toString());
            }
        });
    }

    private void showError(String message) {
        Platform.runLater(() -> {
            errorTextArea.appendText(message + "\n");
        });
    }
}

//package ServerGui;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//import Server.ServerUI;
//import Server.serverDB;
//import javafx.application.Platform;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.stage.Stage;
//
//public class ServerPortFrameController {
//    @FXML
//    private Button btnExit;
//    
//    @FXML
//    private Button btnDone;
//
//    @FXML
//    private TextField portxt;
//
//    @FXML
//    private TextArea connectedUsersTextArea;
//
//    @FXML
//    private TextField usernameField;
//
//    @FXML
//    private PasswordField passwordField;
//
//    @FXML
//    private TextField databaseField;
//
//    @FXML
//    private Label ipLabel;
//    
//    @FXML
//    private Label hostLabel;
//    
//    @FXML
//    private Label connectionStatusLabel;
//
//    private boolean isConnected = false;
//
//    private String getPort() {
//        return portxt.getText();
//    }
//
//    @FXML
//    public void initialize() {
//        try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            ipLabel.setText("IP: " + inetAddress.getHostAddress());
//            hostLabel.setText("Host: " + inetAddress.getHostName());
//        } catch (UnknownHostException e) {
//            ipLabel.setText("IP: Unable to determine");
//            hostLabel.setText("Host: Unable to determine");
//        }
//    }
//
//    @FXML
//    public void Done(ActionEvent event) throws Exception {
//        if (!isConnected) {
//            String port = getPort();
//            String username = usernameField.getText();
//            String password = passwordField.getText();
//            String databaseName = databaseField.getText();
//
//            if (port.trim().isEmpty() || username.trim().isEmpty() || password.trim().isEmpty() || databaseName.trim().isEmpty()) {
//                System.out.println("All fields must be filled.");
//                return;
//            }
//
//            if (connectToDatabase(username, password, databaseName)) {
//                ServerUI.runServer(port, this);
//                btnDone.setText("Disconnect");
//                isConnected = true;
//            } else {
//                System.out.println("Failed to connect to the database. Please check your credentials and try again.");
//            }
//        } else {
//            disconnect();
//        }
//    }
//
//    private boolean connectToDatabase(String username, String password, String databaseName) {
//        boolean isConnected = serverDB.connectToDB(username, password, databaseName);
//        Platform.runLater(() -> {
//            if (isConnected) {
//                connectionStatusLabel.setText("Status: Connected");
//                connectionStatusLabel.setTextFill(javafx.scene.paint.Color.GREEN);
//            } else {
//                connectionStatusLabel.setText("Status: Not Connected");
//                connectionStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
//            }
//        });
//        return isConnected;
//    }
//
//    private void disconnect() {
//        //serverDB.closeDBconnection();
//        ServerUI.stopServer();
//        btnDone.setText("Connect");
//        connectionStatusLabel.setText("Status: Not Connected");
//        connectionStatusLabel.setTextFill(javafx.scene.paint.Color.RED);
//        isConnected = false;
//    }
//
//    public void start(Stage primaryStage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("/ServerGui/ServerPort.fxml"));
//        Scene scene = new Scene(root, 1200, 1000);  // Set initial window size to 1200x1000
//        scene.getStylesheets().add(getClass().getResource("/ServerGui/ServerPort.css").toExternalForm());
//        primaryStage.setTitle("Server Port");
//        primaryStage.setScene(scene);
//
//        // Add a listener to handle the window close request
//        primaryStage.setOnCloseRequest(event -> {
//            event.consume(); // Consume the event to prevent the default behavior
//            getExitBtn(null); // Call the getExitBtn method
//        });
//
//        primaryStage.show();
//    }
//
//    @FXML
//    public void getExitBtn(ActionEvent event) {
//        System.out.println("Exiting application...");
//        // Close DB connection and stop server
//        //serverDB.closeDBconnection();
//        ServerUI.stopServer();
//        System.exit(0);
//        System.gc();
//    }
//
//    @FXML
//    public void exitApplication(ActionEvent event) {
//        //serverDB.closeDBconnection();
////        ServerUI.stopServer();
////        System.exit(0);
//    	this.getExitBtn(null);
//    }
//    
//    public void updateUI(String user, boolean connected) {
//        Platform.runLater(() -> {
//            if (connected) {
//                connectedUsersTextArea.appendText(user + " connected\n");
//            } else {
//                connectedUsersTextArea.appendText(user + " disconnected\n");
//            }
//        });
//    }
//}
