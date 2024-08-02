package logic.Reports;

import java.io.File;

import EnumsAndConstants.*;
import logic.Users.BranchManager;

public class QuarterReport extends Report {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -5532624314759118258L;
private BranchManager branchManager;
	
	public QuarterReport(String reportID, String title,
			String date, File content, BranchLocation branchLocation, BranchManager branchManager) {
		super(reportID, title, date, content, branchLocation);
		this.branchManager = branchManager;
	}

	/**
	 * @return the branchManager
	 */
	public BranchManager getBranchManager() {
		return branchManager;
	}
	
}
