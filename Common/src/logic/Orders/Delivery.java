package logic.Orders;

import java.io.Serializable;

import EnumsAndConstants.TypeOfProduct;

/**
 *
 */
public class Delivery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8991119981743155411L;
	
	private int  deliveryId;
	private String Address;

	private TypeOfProduct Type;
	private float DeliveryFee;
	private int  orderId;

	private String UsernamesOfParticipants;
	private String NumOfParticipants;





	
	
	
	
	public Delivery(int deliveryId, String address, TypeOfProduct type, float deliveryFee, int orderId,
			String usernamesOfParticipants, String numOfParticipants) {
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

	public TypeOfProduct getType() {
		return Type;
	}

	public void setType(TypeOfProduct type) {
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


	public String getNumOfParticipants() {
		return NumOfParticipants;
	}


	public void setNumOfParticipants(String numOfParticipants) {
		NumOfParticipants = numOfParticipants;
	}


	public String getUsernamesOfParticipants() {
		return UsernamesOfParticipants;
	}


	public void setUsernamesOfParticipants(String usernamesOfParticipants) {
		UsernamesOfParticipants = usernamesOfParticipants;
	}

}
