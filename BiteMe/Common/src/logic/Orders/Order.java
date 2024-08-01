package logic.Orders;

import java.io.Serializable;
import java.util.Objects;

import EnumsAndConstants.OrderStatus;
import EnumsAndConstants.TypeOfOrder;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;


	
	private int orderId;
	private int NumOfItems;
	private OrderStatus Status;
	private double Total_price;
	private String RestaurantId;
	private boolean IsLate;
	private String Username;
	private int DeliveryID;
	private String ApprovedByResDate;
	private String ApprovedByResTime;
	private String RecievedByCustomerDate;
	private String RecievedByCustomerTime;
	private TypeOfOrder Type;
	public Order(int orderId, int numOfItems, OrderStatus status, double total_price, String restaurantId,
			boolean isLate, String username, int deliveryID, String approvedByResDate, String approvedByResTime,
			String recievedByCustomerDate, String recievedByCustomerTime, TypeOfOrder type) {
		super();
		this.orderId = orderId;
		NumOfItems = numOfItems;
		Status = status;
		Total_price = total_price;
		RestaurantId = restaurantId;
		IsLate = isLate;
		Username = username;
		DeliveryID = deliveryID;
		ApprovedByResDate = approvedByResDate;
		ApprovedByResTime = approvedByResTime;
		RecievedByCustomerDate = recievedByCustomerDate;
		RecievedByCustomerTime = recievedByCustomerTime;
		Type = type;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getNumOfItems() {
		return NumOfItems;
	}
	public void setNumOfItems(int numOfItems) {
		NumOfItems = numOfItems;
	}
	public OrderStatus getStatus() {
		return Status;
	}
	public void setStatus(OrderStatus status) {
		Status = status;
	}
	public double getTotal_price() {
		return Total_price;
	}
	public void setTotal_price(double total_price) {
		Total_price = total_price;
	}
	public String getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		RestaurantId = restaurantId;
	}
	public boolean isIsLate() {
		return IsLate;
	}
	public void setIsLate(boolean isLate) {
		IsLate = isLate;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getDeliveryID() {
		return DeliveryID;
	}
	public void setDeliveryID(int deliveryID) {
		DeliveryID = deliveryID;
	}
	public String getApprovedByResDate() {
		return ApprovedByResDate;
	}
	public void setApprovedByResDate(String approvedByResDate) {
		ApprovedByResDate = approvedByResDate;
	}
	public String getApprovedByResTime() {
		return ApprovedByResTime;
	}
	public void setApprovedByResTime(String approvedByResTime) {
		ApprovedByResTime = approvedByResTime;
	}
	public String getRecievedByCustomerDate() {
		return RecievedByCustomerDate;
	}
	public void setRecievedByCustomerDate(String recievedByCustomerDate) {
		RecievedByCustomerDate = recievedByCustomerDate;
	}
	public String getRecievedByCustomerTime() {
		return RecievedByCustomerTime;
	}
	public void setRecievedByCustomerTime(String recievedByCustomerTime) {
		RecievedByCustomerTime = recievedByCustomerTime;
	}
	public TypeOfOrder getType() {
		return Type;
	}
	public void setType(TypeOfOrder type) {
		Type = type;
	}
	

	

	

}
