public class Phonebook {

	private LinkedList_ADT<Contact> Contacts;
	
	public Phonebook() {
		Contacts = null;
	}
	
	/*
	public void sortAdd(Contact c) {
		Contacts.findFirst();
		do {
			if (Contacts.last()) // add after front if in first time true
				return;
			Contacts.findNext();
		} while (Contacts.retrieve().getName().compareToIgnoreCase(c.getName()) < 0);
	}

	public boolean check(Contact c) { // True if found so don't add
		Contacts.findFirst();
		
		// To check first one and maybe last
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
	*/
	
	public boolean checkAndSort(Contact c) {	// T not found - F found
		if (Contacts.retrieve().compareTo(c) == 0 || Contacts.retrieve().EqNum(c))		//comp1
			return false;
		while(!Contacts.last()){
			Contacts.findNext();
			if (Contacts.retrieve().compareTo(c) == 0 || Contacts.retrieve().EqNum(c))	//comp1
				return false;
			else if(Contacts.retrieve().compareTo(c) > 0 && !(Contacts.retrieve().EqNum(c))) {	//comp2
				Contacts.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addContact(Contact c) {
		if (Contacts.isEmpty()) //comp2
			Contacts.insert(c);
		
		Contacts.findFirst();
		if(Contacts.retrieve().compareTo(c) > 0 && !(Contacts.retrieve().EqNum(c)))
			Contacts.insertBeforeFirst(c);		//assume in add
		
		if(checkAndSort(c)) {
			Contacts.insert(c);
			return true;
		}	
		return false;
	}

	public boolean searchByName(String n) {
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();

		if (Contacts.retrieve().getName().equalsIgnoreCase(n))	//assume not in add and check first one
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getName().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByEmail(String n) {
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();
		if (Contacts.retrieve().getEmail().equalsIgnoreCase(n))
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getEmail().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}

	public boolean searchByNumber(int n) {
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();
		if (Contacts.retrieve().getphNumber() == n)
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getphNumber() == n)
				return true;
		}
		return false;
	}
	
	public boolean searchByAddress(String n) {
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();
		if (Contacts.retrieve().getAddress().equalsIgnoreCase(n))
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getAddress().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByBirthday(String n) {
		if (Contacts.isEmpty())
			return false;

		Contacts.findFirst();
		if (Contacts.retrieve().getBirthday().equalsIgnoreCase(n))
			return true;

		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getBirthday().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean deleteByName(String c) {
		if (Contacts.isEmpty())
			return false;
		Contacts.findFirst();
		if (Contacts.retrieve().getName().equalsIgnoreCase(c)) {
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
		return false;
	}

	public boolean deleteByNumber(int c) {
		if (Contacts.isEmpty())
			return false;
		Contacts.findFirst();
		if (Contacts.retrieve().getphNumber() == c) {
			Contacts.remove();
			return true;
		}
		while (!Contacts.last()) {
			Contacts.findNext();
			if (Contacts.retrieve().getphNumber() == c) {
				Contacts.remove();
				return true;
			}
		}
		return false;
	}
	

	// event class is not ready yet
}
