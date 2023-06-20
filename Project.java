
public class Project {
	// Attributes
	String projectNum;
	String projectName;
	String buildType;
	String physicalAddr;
	int ERF;
	double fee;
	double amountPaid;
	String deadline;
	boolean completed;

	// Constructor
	public Project(String projectNum, String projectName, String buildType, String physicalAddr, int ERF, double fee,
			double amountPaid, String deadline, boolean completed) {
		this.projectNum = projectNum;
		this.projectName = projectName;
		this.buildType = buildType;
		this.physicalAddr = physicalAddr;
		this.ERF = ERF;
		this.fee = fee;
		this.amountPaid = amountPaid;
		this.deadline = deadline;
		this.completed = completed;
	}

	public void setProjectNum(String userProjectNum) {
		projectNum = userProjectNum;
	}

	public void setProjectName(String userProjectName) {
		projectName = userProjectName;
	}

	public void setBuildType(String userBuildType) {
		buildType = userBuildType;
	}

	public void setAddress(String userPhysicalAddr) {
		physicalAddr = userPhysicalAddr;
	}

	public void setERF(int userERF) {
		ERF = userERF;
	}

	public void setFee(double userFee) {
		fee = userFee;
	}

	public void setAmount(double userAmountPaid) {
		amountPaid = userAmountPaid;
	}

	public void setComplete(boolean userComplete) {
		completed = userComplete;
	}

	// Method that updates deadline date
	public void setDueDate(String date) {
		deadline = date;
	}

	// Method that updates the fee
	public void setFeeChange(double newFee) {
		fee = newFee;
	}

	// Method that displays project information
	public String toString() {
		String output = "Project number: " + projectNum;
		output += "\nProject name: " + projectName;
		output += "\nBuild type: " + buildType;
		output += "\nPhysical Address: " + physicalAddr;
		output += "\nERF number: " + ERF;
		output += "\nFee: " + fee;
		output += "\nAmount paid: " + amountPaid;
		output += "\nDeadline: " + deadline;
		output += "\nCompleted: " + completed;
		output += "\n";

		return output;
	}

}
