import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Phonebook list = new Phonebook();

		int choice = 0;
		try {
			do {
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

				try { 
					choice = input.nextInt();
				}
				catch (java.util.InputMismatchException e) {
					System.out.println("Invalid input. Please enter a valid integer choice (1-8).");
					choice = 0;
					input.next(); 
				}

				switch (choice) {
				case 1:
					System.out.print("Enter the contact's name: ");
					input.nextLine();
					String name = input.nextLine();
					System.out.print("Enter the contact's Number: "); 
					String phNumber = input.next();

					if (phNumber.matches("\\d{10}")) {
						System.out.print("Enter the contact's Email: ");
						String email = input.next();
						System.out.print("Enter the contact's Address: ");
						input.nextLine();
						String address = input.nextLine();
						System.out.print("Enter the contact's Birthday (YYYY/MM/DD): ");
						String birthday = input.next();

						if (list.checkIsDate(birthday)) {
							System.out.print("Enter the contact's notes: ");
							input.nextLine();
							String notes = input.nextLine();

							Contact a = new Contact(name, phNumber, email, address, birthday, notes);
							if (list.addContact(a)) {
								System.out.println("Contact added successfully!");
								break;
							} else
								System.out.println("Contact already added!");
						}
					} else
						System.out.println("Invalid number!");
					break;
				case 2:
					if (list.isEmptyContact()) {
						System.out.println("Contact is empty!");
						break;
					}
					System.out.print("Enter the search criteria: " + "\n1. Name" + "\n2. Phone Number"
							+ "\n3. Email Address" + "\n4. Address" + "\n5. Birthday");
					System.out.print("\nEnter your choice:");
					int choice2 = input.nextInt();
					switch (choice2) {
					case 1:
						System.out.print("Enter the contact's name: ");
						input.nextLine();
						String searchName = input.nextLine();
						if (list.searchByName(searchName))
							list.displayForSearch();
						else
							System.out.println("Contact not found!");
						break;
					case 2:
						System.out.print("Enter the contact's Phone Number: ");
						String searchphNumber = input.next();
						if (searchphNumber.matches("\\d{10}")) {
							if (list.searchByNumber(searchphNumber))
								list.displayForSearch();
							else
								System.out.println("Contact not found!");
						} else
							System.out.println("Invalid number");
						break;
					case 3:
						System.out.print("Enter the contact's Email: ");
						String searchEmail = input.next();
						if (list.searchByEmail(searchEmail))
							list.displayForSearch();
						else
							System.out.println("Contact not found!");
						break;
					case 4:
						System.out.print("Enter the contact's Address: ");
						input.nextLine();
						String searchAddress = input.nextLine();
						if (list.searchByAddress(searchAddress))
							list.displayForSearch();
						else
							System.out.println("Contact not found!");
						break;
					case 5:
						System.out.print("Enter the contact's Birthday: ");
						String searchBirthday = input.next();
						if (list.checkIsDate(searchBirthday)) {
							if (list.searchByBirthday(searchBirthday))
								list.displayForSearch();
							else
								System.out.println("Contact not found!");
						} else
							System.out.println("Invalid birthday");
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
					break;
				case 3:
					if (list.isEmptyContact()) {
						System.out.println("Contact is empty!");
						break;
					}
					System.out.println("Choose how to delete a contact:");
					System.out.println("1. Delete by name");
					System.out.println("2. Delete by phone number");
					System.out.print("Enter your choice: ");
					int choice3 = input.nextInt();
					switch (choice3) {
					case 1:
						System.out.print("Write the contact name you want to delete: ");
						input.nextLine();
						String nameDelete = input.nextLine();
						list.deleteByName(nameDelete);
						break;
					case 2:
						System.out.println("Write the contact phone number you want to delete: ");
						String deleteNumber = input.next();
						if (deleteNumber.matches("\\d{10}"))
							list.deleteByNumber(deleteNumber);
						else
							System.out.println("Invalid number!");
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
					break;
				case 4:
					if (list.isEmptyContact()) {
						System.out.println("Contact is empty!");
						break;
					}
					System.out.print("Enter event title: ");
					input.nextLine();
					String title = input.nextLine();
					System.out.print("Enter contact name: ");
					String conName = input.nextLine();
					System.out.print("Enter event date and time (YYYY/MM/DD HH:MM): ");
					String date = input.next();
					String time = input.next();
					if (list.checkIsDate(date) && list.checkIsTime(time)) {
						System.out.print("Enter event location: ");
						input.nextLine();
						String location = input.nextLine();

						if (list.searchByName(conName)) {
							Event e = new Event(title, date, time, location, conName);
							if (list.scheduleEventToContact(e))
								System.out.println("Event scheduled successfully!");
							else
								System.out.println("Conflict Event ");
						} else
							System.out.println("Contact not found!");
					} else
						System.out.println("Invalid date!");
					break;
				case 5:
					if (list.isEmptyContact() || list.isEmptyEventsList()) {
						System.out.println("It's empty!");
						break;
					}
					System.out.println("Enter search criteria: ");
					System.out.println("1. contact name");
					System.out.println("2. event title");
					System.out.println("Enter your choice: ");
					int choiceEvent = input.nextInt();
					switch (choiceEvent) {
					case 1:
						System.out.println("Enter contact name: ");
						input.nextLine();
						String eventCon = input.nextLine();
						list.printContactEvents(eventCon);
						break;
					case 2:
						System.out.println("Enter the event title: ");
						input.nextLine();
						String eventTitle = input.nextLine();
						list.printEventsListTitle(eventTitle);
						break;
					default:
						System.out.println("Envalid choice");
					}
					break;
				case 6:
					if (list.isEmptyContact()) {
						System.out.println("Contact is empty!");
						break;
					}
					System.out.print("Enter the first name: ");
					String firstName = input.next();
					list.printFirstName(firstName);
					break;
				case 7:
					if (list.isEmptyContact() || list.isEmptyEventsList()) {
						System.out.println("It's empty!");
						break;
					}
					list.printEventsListAll();
					break;
				case 8:
					System.out.println("Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please select a valid option (1-8).");
				}

			} while (choice != 8);
		} catch (Exception e) {
			System.out.println("Invalid enter, try again!!");
		}
		input.close();
	}
}
