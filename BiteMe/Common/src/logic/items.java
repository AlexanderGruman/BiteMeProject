package logic;

import java.io.Serializable;
import java.util.ArrayList;
import EnumsAndConstants.*;

/**
*         dishName, ArrayList<Component> components, float price
 */

public class items implements Serializable {

	private static final long serialVersionUID = -3079554028160660848L;
	
	private int ItemID;
	private String ItemName;
	private float price;
	private int MenuID;
	private TypeOfProduct Type;
	private String Selection;
	private ProductSize Size;
	private Doneness Doneness;
	private String Restrictions;
	public items(int itemID, String itemName, float price, int menuID, TypeOfProduct type, String selection,
			ProductSize size, EnumsAndConstants.Doneness doneness, String restrictions) {
		super();
		ItemID = itemID;
		ItemName = itemName;
		this.price = price;
		MenuID = menuID;
		Type = type;
		Selection = selection;
		Size = size;
		Doneness = doneness;
		Restrictions = restrictions;
	}
	public int getItemID() {
		return ItemID;
	}
	public void setItemID(int itemID) {
		ItemID = itemID;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getMenuID() {
		return MenuID;
	}
	public void setMenuID(int menuID) {
		MenuID = menuID;
	}
	public TypeOfProduct getType() {
		return Type;
	}
	public void setType(TypeOfProduct type) {
		Type = type;
	}
	public String getSelection() {
		return Selection;
	}
	public void setSelection(String selection) {
		Selection = selection;
	}
	public ProductSize getSize() {
		return Size;
	}
	public void setSize(ProductSize size) {
		Size = size;
	}
	public Doneness getDoneness() {
		return Doneness;
	}
	public void setDoneness(Doneness doneness) {
		Doneness = doneness;
	}
	public String getRestrictions() {
		return Restrictions;
	}
	public void setRestrictions(String restrictions) {
		Restrictions = restrictions;
	}
	
	

	
	
	
}
