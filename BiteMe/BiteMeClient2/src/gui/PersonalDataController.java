package gui;

import java.util.ArrayList;

import EnumsAndConstants.CommandConstants;
import client.ClientUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.CommMessage;
import logic.Users.*;

public class PersonalDataController {
	private ClientUI clientui;
	@FXML
	private Button btnBack = null;
	@FXML
	private Button btnUpdate = null;
	@FXML
	private TextField Name;
	@FXML
	private Text error;

	@FXML
	private TextField Phone;
	@FXML
	private TextField FamilyName;
	@FXML
	private TextField Email;
	@FXML
	private TextField Id;
	
	@FXML
	public void intialize()
	{
		//add the personaldata
		ArrayList<String> data=new ArrayList<String>();
		data.add(clientui.user.getUserName().toString());
		data.add(clientui.user.getPassword().toString());
		clientui.sendUserPersonalData(new CommMessage(CommandConstants.getPersonalData,data));
	 Name.setText(clientui.user.getFirstName());
	 Phone.setText(clientui.user.getPhoneNumber());
	 FamilyName.setText(clientui.user.getLastName());
	 Email.setText(clientui.user.getEmail());
	 Id.setText(clientui.user.getId());
	}
	
	public void UpdateDetails(ActionEvent event)
	{
		clientui.user.setFirstName(Name.getText());
		clientui.user.setLastName(FamilyName.getText());
		clientui.user.setPhoneNumber(Phone.getText());
		clientui.user.setEmail(Email.getText());
		clientui.user.setId(Id.getText());
		ArrayList<String> data=new ArrayList<String>();
		data.add(clientui.user.toString());
		clientui.sendUserPersonalData(new CommMessage(CommandConstants.setPersonalData,data));
		error.setText(clientui.ReturnMsgToGui());
		error.setVisible(true);
	}
	
	public void back(ActionEvent event) throws Exception{
		//check what customer it is?
		((Node) event.getSource()).getScene().getWindow().hide();
		clientui.openUserGUI(clientui.user);
	}
	
	
}
