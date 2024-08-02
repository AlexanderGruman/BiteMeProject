package logic;

import java.util.ArrayList;

public class menu {
	
	private int MenuId;
	private int restaurantId; 
	private int numOfItems;
	private ArrayList<items> itemsInMenu;  
	
	public int getMenuId() {
		return MenuId;
	}
	public void setMenuId(int menuId) {
		MenuId = menuId;
	}
	public ArrayList<items> getItemsInMenu() {
		return itemsInMenu;
	}
	public void setItemsInMenu(ArrayList<items> itemsInMenu) {
		this.itemsInMenu = itemsInMenu;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getNumOfItems() {
		return numOfItems;
	}
	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}
	
	
}
