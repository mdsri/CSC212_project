public class Phonebook {

	private LinkedList_ADT<Contact> contacts;
	
	public Phonebook() {
		contacts = null;
	}
	
	/*
	public void sortAdd(Contact c) {
		contacts.findFirst();
		do {
			if (contacts.last()) // add after front if in first time true
				return;
			contacts.findNext();
		} while (contacts.retrieve().getName().compareToIgnoreCase(c.getName()) < 0);
	}

	public boolean check(Contact c) { // True if found so don't add
		contacts.findFirst();
		
		// To check first one and maybe last
		if (contacts.retrieve().getName().equalsIgnoreCase(c.getName())
				|| contacts.retrieve().getphNumber() == c.getphNumber())
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getName().equalsIgnoreCase(c.getName())
					|| contacts.retrieve().getphNumber() == c.getphNumber())
				return true;
		}

		return false;
	}
	*/
	
	public boolean checkAndSort(Contact c) {	// T not found - F found
		if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))		//قدامه الحين
			return false;
		while(!contacts.last()){
			contacts.findNext();
			if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))	//comp1
				return false;
			else if(contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c))) {	//comp2
				contacts.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addContact(Contact c) {
		if (contacts.isEmpty()) //comp2
			contacts.insert(c);
		
		contacts.findFirst();
		if(contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c)))	//وراه
			contacts.insertBeforeFirst(c);		//assume in add
		
		if(checkAndSort(c)) {
			contacts.insert(c);
			return true;
		}	
		return false;
	}
	
	public boolean scheduleEvent(Event event) {
		return contacts.retrieve().addEvent(event);
	}
	
	public void printContactEvents(String name) {
		if(searchByName(name)) {
			contacts.retrieve().printAllEvents();
			return;
		}
		System.out.println("No contact found!");
		return;
	}
	
	public void printEventTitle(String title) {
		contacts.retrieve().printByTitle(title);
	}
	
	public void printAllEventsCon() {
		contacts.retrieve().printAllEvents();
	}

	
	public void printFirstName(String n) {
		if(contacts.isEmpty()) {
			System.out.println("No contacts!");
			return;
		}
		contacts.findFirst();
		if(contacts.retrieve().getName().length() >= n.length() &&
				contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
			System.out.println(contacts.toString());
		while(!contacts.last()) {
			contacts.findNext();
			if(contacts.retrieve().getName().length() >= n.length() &&
					contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
				System.out.println(contacts.toString());
		}
	}
	
	public boolean searchByName(String n) {
		if (contacts.isEmpty())
			return false;

		contacts.findFirst();

		if (contacts.retrieve().getName().equalsIgnoreCase(n))	//assume not in add and check first one
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getName().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByEmail(String n) {
		if (contacts.isEmpty())
			return false;

		contacts.findFirst();
		if (contacts.retrieve().getEmail().equalsIgnoreCase(n))
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getEmail().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}

	public boolean searchByNumber(int n) {
		if (contacts.isEmpty())
			return false;

		contacts.findFirst();
		if (contacts.retrieve().getphNumber() == n)
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getphNumber() == n)
				return true;
		}
		return false;
	}
	
	public boolean searchByAddress(String n) {
		if (contacts.isEmpty())
			return false;

		contacts.findFirst();
		if (contacts.retrieve().getAddress().equalsIgnoreCase(n))
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getAddress().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByBirthday(String n) {
		if (contacts.isEmpty())
			return false;

		contacts.findFirst();
		if (contacts.retrieve().getBirthday().equalsIgnoreCase(n))
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getBirthday().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	/*
	 * public boolean deleteByName(String c) { if (contacts.isEmpty()) return false;
	 * contacts.findFirst(); if (contacts.retrieve().getName().equalsIgnoreCase(c))
	 * { contacts.remove(); return true; } while (!contacts.last()) {
	 * contacts.findNext(); if (contacts.retrieve().getName().equalsIgnoreCase(c)) {
	 * contacts.remove(); return true; } } return false; }
	 */

	public void deleteByName(String name) {
		if(searchByName(name)) {
			System.out.println("Contact deleted!");
			contacts.remove();
		}
		System.out.println("Contact not found");
	}
	
	public void deleteByNumber(int number) {
		if(searchByNumber(number)) {
			System.out.println("Contact deleted!");
			contacts.remove();
		}
		System.out.println("Contact not found");
	}
	
	/*
	 * public boolean deleteByNumber(int c) { if (contacts.isEmpty()) return false;
	 * contacts.findFirst(); if (contacts.retrieve().getphNumber() == c) {
	 * contacts.remove(); return true; } while (!contacts.last()) {
	 * contacts.findNext(); if (contacts.retrieve().getphNumber() == c) {
	 * contacts.remove(); return true; } } return false; }
	 */
	
	public void displayForSearch() {
		System.out.println("Contact found!\n" + contacts.toString());
	}
	

	// event class is not ready yet
}
