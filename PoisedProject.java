import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PoisedProject {
	// class variables
	public static String projectNum1;
	public static String projectName1;
	public static String buildType;
	public static String physicalAddress;
	public static String deadline;
	public static int erf;
	public static double fee;
	public static double paid;
	public static boolean completed;
	public static String name;
	public static String tele;
	public static String email;
	public static String address;
	public static final String filePath = "projectFile.txt";
	public static List<String> list = new ArrayList<>();
	public static Project project1;
	public static Project project2;
	public static People customer1;
	public static People architect1;
	public static People contractor1;
	public static People customer2;
	public static People architect2;
	public static People contractor2;

	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Scanner userChoice = new Scanner(System.in);
		String choice = "";
		// User has options on what to do
		while (true) {
			System.out.println(
					"What would you like to do: \nRead file and add objects: r\nCreate new projects: a\nUpdate projects: u\nIncompleted projects: iP\nOverdue Projects: pD\nFinalise projects: fP");
			choice = userChoice.nextLine();
			if (choice.equalsIgnoreCase("e")) {
				break;
			} else if (choice.equalsIgnoreCase("r")) {
				try {
					File f = new File(filePath);
					Scanner file = new Scanner(f);
					while (file.hasNext()) {
						String line = file.nextLine();
						System.out.println(line);
					}
					// Lines from file added to lists
					list = Files.readAllLines(Paths.get(filePath));
					List<String> projectHeading = new ArrayList<>(Arrays.asList(list.get(0)));
					List<String> firstProject = new ArrayList<>(Arrays.asList(list.get(4).split(",")));
					List<String> firstCustom = new ArrayList<>(Arrays.asList(list.get(5).split(",")));
					List<String> firstArchi = new ArrayList<>(Arrays.asList(list.get(6).split(",")));
					List<String> firstContrac = new ArrayList<>(Arrays.asList(list.get(7).split(",")));
					List<String> secondProject = new ArrayList<>(Arrays.asList(list.get(8).split(",")));
					List<String> secondCustom = new ArrayList<>(Arrays.asList(list.get(9).split(",")));
					List<String> secondArchi = new ArrayList<>(Arrays.asList(list.get(10).split(",")));
					List<String> secondContrac = new ArrayList<>(Arrays.asList(list.get(11).split(",")));
					// Class objects created
					project1 = projectObj(firstProject);
					customer1 = peopleObj(firstCustom);
					architect1 = peopleObj(firstArchi);
					contractor1 = peopleObj(firstContrac);
					project2 = projectObj(secondProject);
					customer2 = peopleObj(secondCustom);
					architect2 = peopleObj(secondArchi);
					contractor2 = peopleObj(secondContrac);
					System.out.println("\nObjects created\n");
				} catch (IOException e) {
					e.getStackTrace();
				}
				// User adds an object by entering information
			} else if (choice.equalsIgnoreCase("a")) {
				//necessary methods called to create project
				Project project = userProject();
				People customer = userCustomer();
				People architect = userArchitect();
				People contractor = userContractor();

				File f = new File(filePath);
				FileWriter file;
				file = new FileWriter(f, true);
				//write user project to file
				file.write("\n" + project.projectNum + "," + project.projectName + "," + project.buildType + ","
						+ project.physicalAddr + "," + project.ERF + "," + project.fee + "," + project.amountPaid + ","
						+ project.deadline + "," + project.completed);
				file.write("\n" + customer.name + "," + customer.telephone + "," + customer.email + ","
						+ customer.physicalAddr + "\n" + architect.name + "," + architect.telephone + ","
						+ architect.email + "," + architect.physicalAddr + "\n" + contractor.name + ","
						+ contractor.telephone + "," + contractor.email + "," + contractor.physicalAddr);
				file.close();
				System.out.println("\n");
				System.out.println("Customer, Architect and Contractor details added \n");

			// User can update object info by entering project name
			} else if (choice.equalsIgnoreCase("u")) {
				if (project1 == null || project2 == null) {
					System.out.println("Please read file first!\n");
				}
				else {
			    //Get headings of file
				list = Files.readAllLines(Paths.get(filePath));
				List<String> projectHeading = new ArrayList<>(Arrays.asList(list.get(0)));
				List<String> customerHeading = new ArrayList<>(Arrays.asList(list.get(1)));
				List<String> architectHeading = new ArrayList<>(Arrays.asList(list.get(2)));
				List<String> contractorHeading = new ArrayList<>(Arrays.asList(list.get(3)));
				Scanner userDecision = new Scanner(System.in);
				File file = new File(filePath);
				FileWriter f = new FileWriter(file);
				System.out.println("Enter Project name you wish to update: ");
				String decision = userDecision.nextLine();
				if (decision.equalsIgnoreCase(project1.projectName)) {
					//update method called
					//Writes updated contents to file
					update(project1);
					f.write(String.join(",",projectHeading) + "\n" + String.join(",",customerHeading) + "\n"
							+ String.join(",",architectHeading) + "\n" + String.join(",",contractorHeading));
					f.write("\n" + project1.projectNum + "," + project1.projectName + "," + project1.buildType + ","
							+ project1.physicalAddr + "," + project1.ERF + "," + project1.fee + ","
							+ project1.amountPaid + "," + project1.deadline + "," + project1.completed);
					f.write("\n" + customer1.name + "," + customer1.telephone + "," + customer1.email + ","
							+ customer1.physicalAddr + "\n" + architect1.name + "," + architect1.telephone + ","
							+ architect1.email + "," + architect1.physicalAddr + "\n" + contractor1.name + ","
							+ contractor1.telephone + "," + contractor1.email + "," + contractor1.physicalAddr);
					f.write("\n" + project2.projectNum + "," + project2.projectName + "," + project2.buildType + ","
							+ project2.physicalAddr + "," + project2.ERF + "," + project2.fee + ","
							+ project2.amountPaid + "," + project2.deadline + "," + project2.completed);
					f.write("\n" + customer2.name + "," + customer2.telephone + "," + customer2.email + ","
							+ customer2.physicalAddr + "\n" + architect2.name + "," + architect2.telephone + ","
							+ architect2.email + "," + architect2.physicalAddr + "\n" + contractor2.name + ","
							+ contractor2.telephone + "," + contractor2.email + "," + contractor2.physicalAddr);
					f.close();

				} else if (decision.equalsIgnoreCase(project2.projectName)) {
					//update method called
					//Writes updated contents to file
					update(project2);
					f.write(String.join(",",projectHeading) + "\n" + String.join(",",customerHeading) + "\n"
							+ String.join(",",architectHeading) + "\n" + String.join(",",contractorHeading));
					f.write("\n1." + project1.projectNum + "," + project1.projectName + "," + project1.buildType + ","
							+ project1.physicalAddr + "," + project1.ERF + "," + project1.fee + ","
							+ project1.amountPaid + "," + project1.deadline + "," + project1.completed);
					f.write("\n" + customer1.name + "," + customer1.telephone + "," + customer1.email + ","
							+ customer1.physicalAddr + "\n" + architect1.name + "," + architect1.telephone + ","
							+ architect1.email + "," + architect1.physicalAddr + "\n" + contractor1.name + ","
							+ contractor1.telephone + "," + contractor1.email + "," + contractor1.physicalAddr);
					f.write("\n2." + project2.projectNum + "," + project2.projectName + "," + project2.buildType + ","
							+ project2.physicalAddr + "," + project2.ERF + "," + project2.fee + ","
							+ project2.amountPaid + "," + project2.deadline + "," + project2.completed);
					f.write("\n" + customer2.name + "," + customer2.telephone + "," + customer2.email + ","
							+ customer2.physicalAddr + "\n" + architect2.name + "," + architect2.telephone + ","
							+ architect2.email + "," + architect2.physicalAddr + "\n" + contractor2.name + ","
							+ contractor2.telephone + "," + contractor2.email + "," + contractor2.physicalAddr);
					f.close();
				} else {
					System.out.println("Project name does not exist\n");
				}
				}
			// displays incomplete projects
			} else if (choice.equalsIgnoreCase("iP")) {
				if (project1 == null || project2 == null) {
					System.out.println("Please read file first!\n");
				}else if (project1.completed == false && project2.completed == false) {
					System.out.println("Incomplete projects:");
					System.out.println(project1.toString());
					System.out.println(project2.toString());
				} else if (project1.completed == false && project2.completed == true) {
					System.out.println("Incomplete projects:");
					System.out.println(project1.toString());
				} else if (project1.completed == true && project2.completed == false) {
					System.out.println("Incomplete projects:");
					System.out.println(project2.toString());
				}	
				 else {
					System.out.println("No incomplete projects\n");
				}
				
		
			// displays overdue projects
			} else if (choice.equalsIgnoreCase("pD")) {
				if (project1 == null || project2 == null) {
					System.out.println("Please read file first!\n");
				}else {	
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				Date date1;
				try {
					date1 = sdf.parse(project1.deadline);
					Date date2 = sdf.parse(project2.deadline);
					Date currentDate = new Date();
					sdf.format(currentDate);
					if (date1.compareTo(currentDate) < 0 && date2.compareTo(currentDate) < 0) {
						System.out.println("Overdue tasks:");
						System.out.println(project1.toString());
						System.out.println(project2.toString());

					} else if (date1.compareTo(currentDate) < 0 && date2.compareTo(currentDate) > 0) {
						System.out.println("Overdue tasks:");
						System.out.println(project1.toString());
					} else if (date1.compareTo(currentDate) > 0 && date2.compareTo(currentDate) < 0) {
						System.out.println("Overdue tasks:");
						System.out.println(project2.toString());
					} else {
						System.out.println("No tasks overdue \n");
					}

				} catch (ParseException e) {
					e.printStackTrace();
				}
				}
				// User finalizes project
				// finalised projected is added to new file
			} else if (choice.equalsIgnoreCase("fP")) {
				if (project1 == null || project2 == null) {
					System.out.println("Please read file first!\n");
				}else {	
				File file = new File("completedProject.txt");
				FileWriter f = new FileWriter(file, true);
				Scanner userFinalise = new Scanner(System.in);
				double firstTotal = project1.fee - project1.amountPaid;
				double secondTotal = project2.fee - project2.amountPaid;
				System.out.println("Enter project name you wish to finalise: ");
				String finalise = userFinalise.nextLine();
				if (finalise.equalsIgnoreCase(project1.projectName) && firstTotal > 0) {
					System.out.println(customer1.name + " Invoice:");
					System.out.println("Amount left to pay: " + firstTotal);
					project1.setComplete(true);
					f.write(project1.toString());
					System.out.println("Project finalised \n");
					f.close();
				} else if (finalise.equalsIgnoreCase(project1.projectName) && firstTotal == 0) {
					System.out.println("Project has been finalised");
					Date currentDate = new Date();
					System.out.println(currentDate);
					project1.setComplete(true);
					System.out.println("Project finalised \n");
					f.write(project1.toString());
					f.close();
				} else if (finalise.equalsIgnoreCase(project2.projectName) && secondTotal > 0) {
					System.out.println(customer2.name + " Invoice:");
					System.out.println("Amount left to pay: " + secondTotal);
					project2.setComplete(true);
					f.write(project2.toString());
					f.close();
					System.out.println("Project finalised \n");
				} else if (finalise.equalsIgnoreCase(project2.projectName) && secondTotal == 0) {
					System.out.println("Project has been finalised");
					Date currentDate = new Date();
					System.out.println(currentDate);
					project2.setComplete(true);
					f.write(project2.toString());
					System.out.println("Project finalised \n");
					f.close();
				}
			}
		}
		}
	}

	// Method that creates project objects
	public static Project projectObj(List<String> ObjList) {
		projectNum1 = "";
		projectName1 = "";
		buildType = "";
		physicalAddress = "";
		deadline = "";
		erf = 0;
		fee = 0;
		paid = 0;

		projectNum1 = ObjList.get(0);
		projectName1 = ObjList.get(1);
		buildType = ObjList.get(2);
		physicalAddress = ObjList.get(3);
		String erfNum = ObjList.get(4);
		erf = Integer.parseInt(erfNum);
		String feeNum = ObjList.get(5);
		fee = Double.parseDouble(feeNum);
		String paidNum = ObjList.get(6);
		paid = Double.parseDouble(paidNum);
		deadline = ObjList.get(7);
		String isCompleted = ObjList.get(8);
		completed = Boolean.parseBoolean(isCompleted);

		return new Project(projectNum1, projectName1, buildType, physicalAddress, erf, fee, paid, deadline, completed);
	}

	// Method that creates people objects
	public static People peopleObj(List<String> ObjList) {
		name = "";
		tele = "";
		email = "";
		address = "";

		name = ObjList.get(0);
		tele = ObjList.get(1);
		email = ObjList.get(2);
		address = ObjList.get(3);

		return new People(name, tele, email, address);
	}

	// Method that allows user to create a project
	public static Project userProject() {
		// Variables
		Scanner number = new Scanner(System.in);
		Scanner name = new Scanner(System.in);
		Scanner type = new Scanner(System.in);
		Scanner address = new Scanner(System.in);
		Scanner ERF = new Scanner(System.in);
		Scanner fee = new Scanner(System.in);
		Scanner amount = new Scanner(System.in);
		Scanner deadline = new Scanner(System.in);
		Scanner userCompletion = new Scanner(System.in);

		// user is prompted to enter details of new project
		System.out.println("Enter project number: ");
		String projectNum = number.nextLine();

		System.out.println("Enter project name: ");
		String projectName = name.nextLine();

		System.out.println("Enter building type: ");
		String buildType = type.nextLine();

		System.out.println("Enter physical address of project: ");
		String physicalAddr = address.nextLine();

		System.out.println("Enter ERf number: ");
		int erfNum = ERF.nextInt();

		System.out.println("Enter fee: ");
		double feeAmount = fee.nextInt();

		System.out.println("Enter amount paid: ");
		double amountPaid = amount.nextInt();

		System.out.println("Enter deadline date (yyyy/mm/dd): ");
		String dueDate = deadline.nextLine();

		System.out.println("Is project completed: ");
		Boolean completion = userCompletion.nextBoolean();

		System.out.println("New project has been created!\n");

		return new Project(projectNum, projectName, buildType, physicalAddr, erfNum, feeAmount, amountPaid, dueDate,
				completion);
	}

	// Method that allows user to create customer object
	public static People userCustomer() {
		// Variables
		Scanner name = new Scanner(System.in);
		Scanner telephone = new Scanner(System.in);
		Scanner address = new Scanner(System.in);
		Scanner email = new Scanner(System.in);

		System.out.println("Enter customer name: ");
		String customerName = name.nextLine();

		System.out.println("Enter customer telephone number: ");
		String customerTele = telephone.nextLine();

		System.out.println("Enter customer address: ");
		String customerAddress = address.nextLine();

		System.out.println("Enter customer email: ");
		String customerEmail = email.nextLine();

		return new People(customerName, customerTele, customerAddress, customerEmail);
	}

	// Method that allows user to create architect object
	public static People userArchitect() {
		// Variables
		Scanner name = new Scanner(System.in);
		Scanner telephone = new Scanner(System.in);
		Scanner address = new Scanner(System.in);
		Scanner email = new Scanner(System.in);

		System.out.println("Enter architect name: ");
		String architectName = name.nextLine();

		System.out.println("Enter architect telephone number: ");
		String architectTele = telephone.nextLine();

		System.out.println("Enter architect address: ");
		String architectAddress = address.nextLine();

		System.out.println("Enter architect email: ");
		String architectEmail = email.nextLine();

		return new People(architectName, architectTele, architectAddress, architectEmail);
	}

	// Method that allows user to create contractor object
	public static People userContractor() {
		// Variables
		Scanner name = new Scanner(System.in);
		Scanner telephone = new Scanner(System.in);
		Scanner address = new Scanner(System.in);
		Scanner email = new Scanner(System.in);

		System.out.println("Enter contractor name: ");
		String contractorName = name.nextLine();

		System.out.println("Enter contractor telephone number: ");
		String contractorTele = telephone.nextLine();

		System.out.println("Enter contractor address: ");
		String contractorAddress = address.nextLine();

		System.out.println("Enter contractor email: ");
		String contractorEmail = email.nextLine();

		return new People(contractorName, contractorTele, contractorAddress, contractorEmail);
	}

	// Allows user to update project
	public static Project update(Project project) {

		Project object = project;
		Scanner userUpdate = new Scanner(System.in);
		Scanner userChange = new Scanner(System.in);
		System.out.println(
				"What would you like to change: \nProjectName: pNr\nProjectName: pNme\nBuildType: bT\nAddress: pA\nERF number: e\nFee Amount: f\nAmountPaid: aP\nDeadline: d\nComplete: c ");
		String change = userChange.nextLine();

		if (change.equalsIgnoreCase("pNr")) {
			System.out.println("Enter new Project Number: ");
			String update = userUpdate.nextLine();
			object.setProjectNum(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("pNme")) {
			System.out.println("Enter new Project Name: ");
			String update = userUpdate.nextLine();
			object.setProjectName(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("bT")) {
			System.out.println("Enter new Build Type: ");
			String update = userUpdate.nextLine();
			object.setBuildType(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("pA")) {
			System.out.println("Enter new Address: ");
			String update = userUpdate.nextLine();
			object.setAddress(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("e")) {
			System.out.println("Enter new ERF number: ");
			int update = userUpdate.nextInt();
			object.setERF(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("f")) {
			System.out.println("Enter new Fee amount: ");
			double update = userUpdate.nextDouble();
			object.setFee(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("aP")) {
			System.out.println("Enter new Amount paid: ");
			double update = userUpdate.nextDouble();
			object.setAmount(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("d")) {
			System.out.println("Enter new Deadline: ");
			String update = userUpdate.nextLine();
			object.setDueDate(update);
			System.out.println("Project has been updated");
		} else if (change.equalsIgnoreCase("c")) {
			System.out.println("Project has been marked as completed");
			object.setComplete(true);
		}
		return object;
	}

}
