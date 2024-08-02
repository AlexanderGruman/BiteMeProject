package logic.Orders;

import java.util.ArrayList;

import EnumsAndConstants.TypeOfOrder;

/**
 *
 */
public class Delivery {

	
	private int  deliveryId;
	private String Address;

	private TypeOfOrder Type;
	private float DeliveryFee;
	private int  orderId;

	private ArrayList<String> UsernamesOfParticipants;
	private int NumOfParticipants;





	
	
	
	
	public Delivery(int deliveryId, String address, TypeOfOrder type, float deliveryFee, int orderId,
			ArrayList<String> usernamesOfParticipants, int numOfParticipants) {
		super();
		this.deliveryId = deliveryId;
		Address = address;
		Type = type;
		DeliveryFee = deliveryFee;
		this.orderId = orderId;
		UsernamesOfParticipants = usernamesOfParticipants;
		NumOfParticipants = numOfParticipants;
	}









	public String toString() {
		StringBuilder b = new StringBuilder("Delivery Details:\n");
		if (Address != null) {
			b.append("Address: " + Address);
			return b.toString();
		}
		return "Take Away";
	}

	public TypeOfOrder getType() {
		return Type;
	}

	public void setType(TypeOfOrder type) {
		Type = type;
	}

	public int getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}






	public float getDeliveryFee() {
		return DeliveryFee;
	}






	public void setDeliveryFee(float deliveryFee) {
		DeliveryFee = deliveryFee;
	}






	public int getOrderId() {
		return orderId;
	}






	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getNumOfParticipants() {
		return NumOfParticipants;
	}


	public void setNumOfParticipants(int numOfParticipants) {
		NumOfParticipants = numOfParticipants;
	}


	public ArrayList<String> getUsernamesOfParticipants() {
		return UsernamesOfParticipants;
	}


	public void setUsernamesOfParticipants(ArrayList<String> usernamesOfParticipants) {
		UsernamesOfParticipants = usernamesOfParticipants;
	}

}
