import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Phonebook list = new Phonebook();

		int choice = 0, choice2 = 0;
		do {
			try {
				System.out.println("Welcome to the Phonebook App!");
				System.out.println("Please choose an option from the following:");
				System.out.println("1. Add a contact");
				System.out.println("2. Search for a contact");
				System.out.println("3. Delete a contact");
				System.out.println("4. Schedule an event");
				System.out.println("5. Print event details");
				System.out.println("6. Print contacts by first name");
				System.out.println("7. Print all events alphabetically");
				System.out.println("8. Exit");
				System.out.print("Enter your choice: ");

				choice = input.nextInt();

				switch (choice) {
				case 1:
					System.out.print("Enter the contact's name: ");
					String name = input.nextLine();
					System.out.print("Enter the contact's Number: ");
					int phNumber = input.nextInt();
					System.out.print("Enter the contact's Email: ");
					String email = input.next();
					System.out.print("Enter the contact's Address: ");
					String address = input.next();
					System.out.print("Enter the contact's Birthday: ");
					String birthday = input.next();
					System.out.print("Enter the contact's notes: ");
					String notes = input.nextLine();
					Contact a = new Contact(name, phNumber, email, address, birthday, notes);
					if(list.addContact(a)) {
						System.out.println("Contact added successfully!");
						break;
					}
					System.out.println("Contact already added!");
					break;
				case 2:
					System.out.print("Enter the search criteria: "
							+ "\n1. Name"
							+ "\n2. Phone Number"
							+ "\n3. Email Address"
							+ "\n4. Address"
							+ "\n5. Birthday");
					choice2 = input.nextInt();
					switch(choice2) {
					case 1:
						System.out.println("Enter the contact's name: ");
						String searchName = input.nextLine();
						if(list.searchByName(searchName)) {
							list.displayForSearch();
						}
						System.out.println("Contact not found!");
						break;
					case 2:
					}
				case 3:

					System.out.println("Choose how to delete a contact:");
					System.out.println("1. Delete by name");
					System.out.println("2. Delete by phone number");
					System.out.print("Enter your choice: ");

					int deleteChoice = input.nextInt();
					input.nextLine();  
					switch (deleteChoice) {
					case 1: // Delete by name
						System.out.print("Enter the name of the contact to delete: ");
						String deleteName = input.nextLine();

						list.deleteByName(deleteName);

						if (list.deleteByName(deleteName)) {
							System.out.println("Contact with name " + deleteName + " deleted successfully.");
						} else {
							System.out.println("Contact with name " + deleteName + " not found in the Phonebook.");
						}
						break;
					case 2: // Delete by phone number
						System.out.print("Enter the phone number of the contact to delete: ");
						int deleteNumber = input.nextInt();
						input.nextLine();  

						// list.deleteByphNumber(deleteNumber);

						//if (list.deleteByphNumber(deleteNumber)) {
						//	System.out.println("Contact with phone number " + deleteNumber + " deleted successfully.");
						//} else {
						//	System.out.println("Contact with phone number " + deleteNumber + " not found in the Phonebook.");
						//}
						break;
					default:
						System.out.println("Invalid choice for deleting a contact. Please choose 1 or 2.");
						break;
					}
					break;

					/*
					 * case 4: // Schedule an event - Implement this functionality break; case 5: //
					 * Print event details - Implement this functionality break; case 6: // Print
					 * contacts by first name - Implement this functionality break; case 7: // Print
					 * all events alphabetically - Implement this functionality break;
					 */
				case 8:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please select a valid option (1-8).");
				}
			}catch(Exception e){System.out.println("Invalid choise, try again!!");}
		} while (choice != 8);

		input.close();
	}

}