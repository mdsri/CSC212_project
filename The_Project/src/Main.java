import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Phonebook list = new Phonebook();

		int choice = 0;
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
				System.out.println("7. Exit");
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

					int choice2 = input.nextInt();

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
						System.out.println("Enter the contact's Phone Number: ");
						String searchphNumber = input.nextLine();
						if(list.searchByName(searchphNumber)) {
							list.displayForSearch();
						}
						System.out.println("Contact not found!");
						break;
					case 3:
						System.out.println("Enter the contact's Email: ");
						String searchEmail= input.nextLine();
						if(list.searchByName(searchEmail)) {
							list.displayForSearch();
						}
						System.out.println("Contact not found!");
						break;

					case 4:
						System.out.println("Enter the contact's Adress: ");
						String searchAdress= input.nextLine();
						if(list.searchByName(searchAdress)) {
							list.displayForSearch();
						}
						System.out.println("Contact not found!");
						break;

					case 5:
						System.out.println("Enter the contact's Birthday: ");
						String searchBirthday= input.nextLine();
						if(list.searchByName(searchBirthday)) {
							list.displayForSearch();
						}
						System.out.println("Contact not found!");
						break;
					}
				case 3:
					System.out.println("Choose how to delete a contact:");
					System.out.println("1. Delete by name");
					System.out.println("2. Delete by phone number");
					System.out.print("Enter your choice: ");
					int choice3 = input.nextInt();
					switch(choice3) {
					case 1:
						System.out.println("Write the contact name you want to delete: ");
						String nameDelete = input.nextLine();
						list.deleteByName(nameDelete);
						break;
					case 2:
						System.out.println("Write the contact phone number you want to delete: ");
						int deleteNumber = input.nextInt();
						list.deleteByNumber(deleteNumber);
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
				case 4:
                    System.out.print("Enter event title: ");
                    String title = input.nextLine();
                    System.out.print("Enter contact name: ");
                    String conName = input.next();
                    System.out.print("Enter event date and time (DD/MM/YYYY HH:MM): ");
                    String date = input.next();
                    String time = input.next();
                    System.out.println("Enter event location: ");
                    String location = input.nextLine();
                    
                    if(list.searchByName(conName)) {
                        Event e = new Event( title,  date,  time,  location);
                        if(list.scheduleEvent(e))
                        	System.out.println("Event scheduled successfully!");
                    }
                    else
                    	System.out.println("Event conflict!");
                    break;	
				case 5:
					System.out.println("Write Contact name");
					String conEvent = input.nextLine();
					if(list.searchByName(conEvent)) {
						System.out.println("Enter search criteria: ");
						System.out.println("1. Event title");
						System.out.println("2. All events");
						int choiceEvent = input.nextInt();
						switch(choiceEvent) {
						case 1:
							System.out.println("Enter the event title: ");
							String printTitle = input.nextLine();
							list.printEventTitle(printTitle);
							break;
						case 2:
							list.printAllEventsCon();
							break;
						}
					}
					else
						System.out.println("No contact found!");
					break;
				case 6:
					System.out.println("Enter the first name: ");
					String firstName = input.next();
					list.printFirstName(firstName);
				case 7:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please select a valid option (1-7).");
				}
			}catch(Exception e){System.out.println("Invalid choise, try again!!");}
		} while (choice != 7);

		input.close();
	}

}
