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
	
	public boolean checkName(String n) {	// T found - F not found
		if(contacts.isEmpty())
			return false;
		contacts.findFirst();
		if (contacts.retrieve().getName().equalsIgnoreCase(n))
			return true;
		while(contacts.last()) {
			contacts.findFirst();
			if (contacts.retrieve().getName().equalsIgnoreCase(n))
				return true;
		}
		return false;
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
	
	public boolean scheduleEvent(String name, Event event) {
		if(checkName(name)) {
			return contacts.retrieve().addEvent(event);
		}
		return false;
	}
	
	public void printContactEvents(String name) {
		if(checkName(name)) {
			contacts.retrieve().printAllEvents();
			return;
		}
		System.out.println("No contact found!");
		return;
	}

	
	public void printFirstName(String n) {		//throws long name 
		if(contacts.isEmpty()) {
			System.out.println("No contacts!");
			return;
		}
		contacts.findFirst();
		if(contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
			System.out.println(contacts.toString());
		while(!contacts.last()) {
			contacts.findNext();
			if(contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
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
	
	public boolean deleteByName(String c) {
		if (contacts.isEmpty())
			return false;
		contacts.findFirst();
		if (contacts.retrieve().getName().equalsIgnoreCase(c)) {
			contacts.remove();
			return true;
		}
		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getName().equalsIgnoreCase(c)) {
				contacts.remove();
				return true;
			}
		}
		return false;
	}

	public boolean deleteByNumber(int c) {
		if (contacts.isEmpty())
			return false;
		contacts.findFirst();
		if (contacts.retrieve().getphNumber() == c) {
			contacts.remove();
			return true;
		}
		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getphNumber() == c) {
				contacts.remove();
				return true;
			}
		}
		return false;
	}
	
	public void displayForSearch() {
		System.out.println("Contact found!\n" + contacts.toString());
	}
	

	// event class is not ready yet
}
