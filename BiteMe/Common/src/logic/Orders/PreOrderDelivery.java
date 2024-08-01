package logic.Orders;

import EnumsAndConstants.TypeOfProduct;

public class PreOrderDelivery extends Delivery {

	public PreOrderDelivery(int deliveryId, String address, TypeOfProduct type, float deliveryFee, int orderId,
			String usernamesOfParticipants, String numOfParticipants, String deliveryTime) {
		super(deliveryId, address, type, deliveryFee, orderId, usernamesOfParticipants, numOfParticipants);
		this.deliveryTime = deliveryTime;
		// TODO Auto-generated constructor stub
	}

	private String deliveryTime;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2785999044405825850L;

	/**
	 * @return the deliveryTime
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String toString() {
		if (deliveryTime != null) {
			return super.toString() + "\nDelivery Scheduled to: " + deliveryTime;
		}
		return super.toString();
	}
}
