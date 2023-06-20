
public class People {
	// Attributes
	String name;
	String telephone;
	String email;
	String physicalAddr;

	// Constructor
	public People(String name, String telephone, String email, String physicalAddr) {
		this.name = name;
		this.telephone = telephone;
		this.email = email;
		this.physicalAddr = physicalAddr;
	}

	// Method that updates contractor details
	public void setDetails(String newName, String newTelephone, String newEmail, String newPhysicalAddr) {
		name = newName;
		telephone = newTelephone;
		email = newEmail;
		physicalAddr = newPhysicalAddr;

	}

	// Method that displays project information
	public String toString() {
		String output = "\nName: " + name;
		output += "\nTelephone: " + telephone;
		output += "\nPhysical Address: " + physicalAddr;
		output += "\nEmail: " + email;
		output += "\n";
		return output;
	}

}
