package logic.Orders;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

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
	private Date ApprovedByResDate;
	private Time ApprovedByResTime;
	private Date RecievedByCustomerDate;
	private Time RecievedByCustomerTime;
	private TypeOfOrder Type;
	//                Order updatedOrder = new Order("", orderNumber, price, 0, address); // Assuming restaurant and list number are not required here

	public Order(int orderId, int numOfItems, OrderStatus status, double total_price, String restaurantId,
			boolean isLate, String username, int deliveryID, Date approvedByResDate, Time approvedByResTime,
			Date recievedByCustomerDate, Time recievedByCustomerTime, TypeOfOrder type) {
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
	public Order(int numOfItems,double total_price, OrderStatus status, String restaurantId, int deliveryID, TypeOfOrder type) {
		super();
		NumOfItems = numOfItems;
		Status = status;
		RestaurantId = restaurantId;
		DeliveryID = deliveryID;
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
	public Date getApprovedByResDate() {
		return ApprovedByResDate;
	}
	public void setApprovedByResDate(Date approvedByResDate) {
		ApprovedByResDate = approvedByResDate;
	}
	public Time getApprovedByResTime() {
		return ApprovedByResTime;
	}
	public void setApprovedByResTime(Time approvedByResTime) {
		ApprovedByResTime = approvedByResTime;
	}
	public Date getRecievedByCustomerDate() {
		return RecievedByCustomerDate;
	}
	public void setRecievedByCustomerDate(Date recievedByCustomerDate) {
		RecievedByCustomerDate = recievedByCustomerDate;
	}
	public Time getRecievedByCustomerTime() {
		return RecievedByCustomerTime;
	}
	public void setRecievedByCustomerTime(Time recievedByCustomerTime) {
		RecievedByCustomerTime = recievedByCustomerTime;
	}
	public TypeOfOrder getType() {
		return Type;
	}
	public void setType(TypeOfOrder type) {
		Type = type;
	}
	

	

	

}
