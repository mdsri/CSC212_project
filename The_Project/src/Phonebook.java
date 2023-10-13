public class Phonebook {//

	private LinkedList_ADT<Contact> Contacts;

	public Phonebook() {
		Contacts = null;
	}

	public void sortCurrent(Contact c) {
		Contacts.findFirst();
		if (Contacts.retrieve().getName().compareToIgnoreCase(c.getName()) > 0)
			return;
		do {
			if (Contacts.last())
				return;
			Contacts.findNext();
		} while (Contacts.retrieve().getName().compareToIgnoreCase(c.getName()) < 0);
	}

	public boolean check(Contact contact) {			 //what if there is a contact with different numbers
		Node<Contact> temp = new Node<Contact>();	 // ex: ali - 055 555 5555
		Contacts.findFirst();						 //     ali - 059 999 9999

		if (Contacts.isEmpty()) { // if the list is empty
			return false;
		}

		if (Contacts.first() && Contacts.retrieve().getName().equalsIgnoreCase(temp.data.getName()) // if only one contact in the list
				|| Contacts.retrieve().getphNumber() == temp.data.getphNumber()) {

			return true;
		}

		do { // do while for the linked list has only one contact. or isEmpty()
			if (Contacts.retrieve().getName().equalsIgnoreCase(temp.data.getName())
					|| Contacts.retrieve().getphNumber() == temp.data.getphNumber())
				return true;
			else
				Contacts.findNext();

		} while (Contacts.last() != true); // is it (contacts.last() != true) or only (contacts.last())???

		return false;
	}

	public Contact searchByname(Contact c) {
		Node<Contact> temp = new Node<Contact>();

		if (check(c) == false) {									//the check method checks for name or number  
																	//so maybe the name is not there but number is in the list
			System.out.println("Contact not in the Phonebook");		//will this lead to a problem?
			return null; // is the return needed???
		}

		else {
			do {
				if (Contacts.retrieve().getName().equalsIgnoreCase(temp.data.getName())) {
					return Contacts.retrieve();
				} else {
					Contacts.findNext();
				}

			} while (Contacts.last() != true);// is it (contacts.last() != true) or only (contacts.last())???
		}
		System.out.println("Contact not in the Phonebook");

		return null;

	}

	// event class is not ready yet
}