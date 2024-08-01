package logic;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Class to hold a messages between server and client.
 * 
 * This class holds the object with the proper class for the request.
 * 
 */
public class CommMessage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1062261494793351579L;
	
	//data from server to client
	private boolean isSucceeded;  //flag for indicate if Operation succeeded 
	private String msg; //description why not succeded
	private Object dataFromServer; //requested Object from server (if succeeded)
	private String dataType; //data type of object 
	
	//data from client to server
	private String commandForServer;  //command from user to perform //ENUM
	private ArrayList<String> messageForServer;  //command descriptions
	private Object objectForServer; //object for server for create or else
	
	
	

	public CommMessage() {
	}

	//constructor for server use
	public CommMessage(boolean isSucceeded, String msg, Object dataFromServer) {
		this.isSucceeded = isSucceeded;
		this.msg = msg;
		this.dataFromServer = dataFromServer;
	}


	//constructor for client use
	public CommMessage(String commandForServer, ArrayList<String> messageForServer) {
		this.commandForServer = commandForServer;
		this.messageForServer = messageForServer;
	}
	
	public CommMessage(String commandForServer, ArrayList<String> messageForServer,Object objectForServer) {
		this.commandForServer = commandForServer;
		this.messageForServer = messageForServer;
		this.objectForServer = objectForServer;
	}
	
	

	@Override
	public String toString() {
		if (dataFromServer != null) {
			return "[Request Type: " + commandForServer + ",Object: " + dataFromServer.toString() + "]";
		}
		return "[Request Type: " + commandForServer + "]";
	}

	public Object getObjectForServer() {
		return objectForServer;
	}
	
	public void setObjectForServer(Object objectForServer) {
		this.objectForServer = objectForServer;
	}
	
	/**
	 * @return the commMessage
	 */
	public Object getCommMessage() {
		return dataFromServer;
	}
	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	
	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}
	
	/**
	 * @param commMessage the commMessage to set
	 */
	public void setCommMessage(Object serverResponse) {
		this.dataFromServer = serverResponse;
	}
	
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public String getCommandForServer() {
		return commandForServer;
	}
	
	public void setCommandForServer(String commandForServer) {
		this.commandForServer = commandForServer;
	}
	
	public ArrayList<String> getMessageForServer() {
		return messageForServer;
	}
	
	public void setMessageForServer(ArrayList<String> messageForServer) {
		this.messageForServer = messageForServer;
	}
	
	public boolean isSucceeded() {
		return isSucceeded;
	}
	
	public void setSucceeded(boolean isSucceeded) {
		this.isSucceeded = isSucceeded;
	}
	
	public Object getDataFromServer() {
		return dataFromServer;
	}
	
	public void setDataFromServer(Object dataFromServer) {
		this.dataFromServer = dataFromServer;
	}
}
