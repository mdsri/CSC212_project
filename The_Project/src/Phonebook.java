public class Phonebook {

	private LinkedList_ADT<Contact> Contacts;

	public Phonebook() {
		Contacts = null;
	}

	public void sortAdd(Contact c) {
		Contacts.findFirst();
		do {
			if (Contacts.last()) // add front
				return;
			Contacts.findNext();
		} while (Contacts.retrieve().getName().compareToIgnoreCase(c.getName()) < 0);
	}

	public boolean check(Contact c) { // True if found so not add
		Contacts.findFirst();

		if (Contacts.retrieve().getName().equalsIgnoreCase(c.getName())
				|| Contacts.retrieve().getphNumber() == c.getphNumber())
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getName().equalsIgnoreCase(c.getName())
					|| Contacts.retrieve().getphNumber() == c.getphNumber())
				return true;
		}

		return false;
	}

	public boolean addContact(Contact c) {
		if (check(c))
			return false;
		if (Contacts.retrieve().getName().compareToIgnoreCase(c.getName()) > 0 || Contacts.isEmpty())
			Contacts.insertBeforeFirst(c);
		sortAdd(c);
		Contacts.insert(c);
		return true;
	}

	public boolean searchByname(String n) { // Made by Mohammed
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();

		if (Contacts.retrieve().getName().equalsIgnoreCase(n))
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getName().equalsIgnoreCase(n))
				return true;
		}
		return false;

	}

	public boolean deleteByname(String c) {
		Contacts.findFirst();
		if (Contacts.isEmpty()) {
			System.out.println("Contact not found Phonebook empty");
			return false;
		}
		if (Contacts.first() && Contacts.retrieve().getName().equalsIgnoreCase(c)) {
			Contacts.remove();
			return true;
		}
		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getName().equalsIgnoreCase(c)) {
				Contacts.remove();
				return true;
			}
		}
		System.out.println("Contact not found");
		return false;
	}

	public boolean deleteByphNumber(int c) {
		Contacts.findFirst();
		if (Contacts.isEmpty()) {
			System.out.println("Contact not found Phonebook empty");
			return false;
		}
		if (Contacts.first() && Contacts.retrieve().getphNumber() == c) {
			return true;
		}
		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getphNumber() == c) {
				Contacts.remove();
				return true;
			}
		}
		System.out.println("Contact not found");
		return false;
	}

	// the following method made by Anas, tell me if u find something wrong

	public Contact searchByName(String name) { // this method will search by the name of the user
		if (Contacts.isEmpty()) {
			return null;
		}

		Contacts.findFirst();

		while (!Contacts.last()) {
			Contact currentContact = Contacts.retrieve();
			if (currentContact.getName().equalsIgnoreCase(name)) {
				return currentContact;
			}
			Contacts.findNext();
		}

		// Check the last contact cuz the while loop will be false when reach the last

		Contact currentContact = Contacts.retrieve();
		if (currentContact.getName().equalsIgnoreCase(name)) {
			return currentContact;
		}

		return null;
	}

	// this method will search by the number of the user
	public Contact searchByNumber(int phoneNumber) {
		if (Contacts.isEmpty()) {
			return null;
		}

		Contacts.findFirst();

		while (!Contacts.last()) {
			Contact currentContact = Contacts.retrieve();
			if (currentContact.getphNumber() == phoneNumber) {
				return currentContact;
			}
			Contacts.findNext();
		}

		// Check the last contact cuz the while loop will be false when reach the last

		Contact currentContact = Contacts.retrieve();
		if (currentContact.getphNumber() == phoneNumber) {
			return currentContact;
		}

		return null;
	}

	// this method will search by the Email of the user
	public Contact searchByEmail(String email) {
		if (Contacts.isEmpty()) {
			return null;
		}

		Contacts.findFirst();

		while (!Contacts.last()) {
			Contact currentContact = Contacts.retrieve();
			if (currentContact.getEmail().equalsIgnoreCase(email)) {
				return currentContact;
			}
			Contacts.findNext();
		}

		// Check the last contact cuz the while loop will be false when reach the last

		Contact currentContact = Contacts.retrieve();
		if (currentContact.getEmail().equalsIgnoreCase(email)) {
			return currentContact;
		}

		return null;
	}

	public Contact searchByBirthday(String birthday) {
		// this method will search by the birthday of the user "Unhappy birthday"
		if (Contacts.isEmpty()) {
			return null;
		}

		Contacts.findFirst();

		while (!Contacts.last()) {
			Contact currentContact = Contacts.retrieve();
			if (currentContact.getBirthday().equalsIgnoreCase(birthday)) {
				return currentContact;
			}
			Contacts.findNext();
		}

		// Check the last contact cuz the while loop will be false when reach the last

		Contact currentContact = Contacts.retrieve();
		if (currentContact.getBirthday().equalsIgnoreCase(birthday)) {
			return currentContact;
		}

		return null;
	}

	public Contact searchByAddress(String address) {
		// this method will search by the Address of the user
		if (Contacts.isEmpty()) {
			return null;
		}

		Contacts.findFirst();

		while (!Contacts.last()) {
			Contact currentContact = Contacts.retrieve();
			if (currentContact.getAddress().equalsIgnoreCase(address)) {
				return currentContact;
			}
			Contacts.findNext();
		}

		// Check the last contact cuz the while loop will be false when reach the last

		Contact currentContact = Contacts.retrieve();
		if (currentContact.getAddress().equalsIgnoreCase(address)) {
			return currentContact;
		}

		return null;
	}

	// event class is not ready yet
}
