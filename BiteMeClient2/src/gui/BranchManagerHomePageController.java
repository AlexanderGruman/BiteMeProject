package gui;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controller class for the Manager Home Page.
 * This class handles the interaction logic for the ManagerHomePage.fxml file.
 */
public class BranchManagerHomePageController {
	
	private ClientUI client;

    @FXML
    private Button viewMonthlyReportButton;

    @FXML
    private Button RegisterCustomerButton;

    @FXML
    private Button ContactUsButton;

    @FXML
    private Button logoutButton;

    /**
     * Handles the View Monthly Report button action.
     * This method is called when the view Monthly report button is pressed.
     */
    @FXML
    private void handleViewMonthlyReportButtonAction() {
    	client.guiConverter("View Monthly Report", "/gui/ChooseReportPage.fxml");
    }

    /**
     * Handles the Register Customer button action.
     * This method is called when the Register Customer button is pressed.
     */
    @FXML
    private void handleRegisterCustomerButtonAction() {
    	client.guiConverter("Register Customer", "/gui/RegisterCustomer.fxml");
    }

    /**
     * Handles the Contact Us button action.
     * This method is called when the Contact Us button is pressed.
     */
    @FXML
    private void handleContactUsButtonAction() {
        System.out.println("Thank you for contacting us, we will contact you via email");
    }

    /**
     * Handles the Log Out button action.
     * This method is called when the Log Out button is pressed.
     * It disconnects the client and logs out of the application.
     *
     * @param event the action event
     * @throws Exception if there is an error during logout
     */
    @FXML
    private void handleLogOutButtonAction(ActionEvent event) throws Exception {
    	client.closeUserGUI(client.user);
    }
}
