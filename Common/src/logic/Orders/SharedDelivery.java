package logic.Orders;

import EnumsAndConstants.TypeOfProduct;

public class SharedDelivery extends Delivery {

	public SharedDelivery(int deliveryId, String address, TypeOfProduct type, float deliveryFee, int orderId,
			String usernamesOfParticipants, String numOfParticipants) {
		super(deliveryId, address, type, deliveryFee, orderId, usernamesOfParticipants, numOfParticipants);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 3803571920726125209L;

}
