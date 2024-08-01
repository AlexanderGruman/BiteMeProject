package logic;

import java.io.Serializable;
import EnumsAndConstants.BranchLocation;
import logic.Users.BranchManager;

public class Branch implements Serializable {

	/**
	 * 
	 */
	private BranchLocation branchLocation;
	private int NumOfRestaurants;
	private BranchManager branchManager;
	private static final long serialVersionUID = 7545747177565237611L;

	
	public Branch(BranchLocation branchLocation, BranchManager branchManager, int NumOfRestaurants) {
		super();
		this.branchLocation = branchLocation;
		this.branchManager = branchManager;
		this.setNumOfRestaurants(NumOfRestaurants);
	}
		
	
	/**
	 * @return the BranchLocation
	 */
	public BranchLocation getBranchLocation() {
		return branchLocation;
	}
	
	/**
	 * @return the branchManager
	 */
	public BranchManager getBranchManager() {
		return branchManager;
	}
	
	/**
	 * @param BranchLocation the branchName to set
	 */
	public void setBranchLocation(BranchLocation branchLocation) {
		this.branchLocation = branchLocation;
	}
	
	/**
	 * @param branchManager the branchManager to set
	 */
	public void setBranchManager(BranchManager branchManager) {
		this.branchManager = branchManager;
	}


	public int getNumOfRestaurants() {
		return NumOfRestaurants;
	}


	public void setNumOfRestaurants(int numOfRestaurants) {
		NumOfRestaurants = numOfRestaurants;
	}
		
}
