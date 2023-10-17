public class Phonebook {

	private LinkedList_ADT<Contact> contacts;
	private LinkedList_ADT<Event> AllEvents;
	
	public Phonebook() {
		contacts = new LinkedList_ADT<Contact>();
		AllEvents = new LinkedList_ADT<Event>();
	}
	
	
	public boolean checkAndSort(Contact c) {	// T not found - F found
		if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))
			return false;
		while(!contacts.last()){
			contacts.findNext();
			if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))
				return false;
			else if(contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c))) {
				contacts.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addContact(Contact c) {
		if (contacts.isEmpty()) {
			contacts.insert(c);
			return true;
		}
		
		contacts.findFirst();
		if(contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c))) {
			contacts.insertBeforeFirst(c);
			return true;
		}
		
		if(checkAndSort(c)) {
			contacts.insert(c);
			return true;
		}	
		return false;
	}
	
	public boolean scheduleEvent(Event event) {
		return contacts.retrieve().addEvent(event) && addAllEvents(event);
	}
	
	public void printContactEvents(String name) {
		if(searchByName(name)) {
			contacts.retrieve().printAllEvents();
			return;
		}
		System.out.println("No contact found!");
		return;
	}
	
	public void printFirstName(String n) {
		contacts.findFirst();
		if(contacts.retrieve().getName().length() >= n.length() &&
				contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
			System.out.println(contacts.retrieve().toString());
		while(!contacts.last()) {
			contacts.findNext();
			if(contacts.retrieve().getName().length() >= n.length() &&
					contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
				System.out.println(contacts.retrieve().toString());
		}
	}
	
	public boolean searchByName(String n) {
		contacts.findFirst();

		if (contacts.retrieve().getName().equalsIgnoreCase(n))	
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getName().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByEmail(String n) {
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

	public boolean searchByNumber(String n) {
		contacts.findFirst();
		if (contacts.retrieve().getphNumber().equalsIgnoreCase(n))
			return true;

		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getphNumber().equalsIgnoreCase(n))
				return true;
		}
		return false;
	}
	
	public boolean searchByAddress(String n) {
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

	public void deleteByName(String name) {
		if(searchByName(name)) {
			System.out.println("Contact deleted!");
			deleteInAllEvents();
			contacts.remove();
		}
		else
			System.out.println("Contact not found!");
	}
	
	public void deleteByNumber(String number) {
		if(searchByNumber(number)) {
			System.out.println("Contact deleted!");
			deleteInAllEvents();
			contacts.remove();
		}
		else
			System.out.println("Contact not found!");
	}
	
	public void displayForSearch() {
		System.out.println("Contact found!\n" + contacts.retrieve().toString());
	}
	
	public boolean isEmptyContact() {
		return contacts.isEmpty();
	}
	
	public boolean checkIsDate(String date) {
		try {
			if(date.charAt(4) == '/' && date.charAt(7) == '/' && Integer.parseInt(date.substring(0, 4)) > 0 
					&& Integer.parseInt(date.substring(5, 7)) > 0  && Integer.parseInt(date.substring(8, 10)) > 0 )
				return true;
			else {
				System.out.println("Incorrect Date");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Incorrect date");
			return false;
		}
	}
	
	
	//////////////////////////////////////////////////////////////	All Events
	
	public boolean checkAndSortAllEvents(Event e) {	// T not found - F found
		while(!AllEvents.last()){
			AllEvents.findNext();
			if(AllEvents.retrieve().compareTo(e) >= 0) {	
				AllEvents.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addAllEvents(Event e) {
		if (AllEvents.isEmpty()) { 
			AllEvents.insert(e);
			return true;
		}
		
		AllEvents.findFirst();
		if(AllEvents.retrieve().compareTo(e) >= 0) {
			AllEvents.insertBeforeFirst(e);		//before
			return true;
		}
		
		else if(checkAndSortAllEvents(e)) {
			AllEvents.insert(e);
			return true;
		}	
		return false;
	}
	
	public void printAllTheEvents() {
			AllEvents.findFirst();
			System.out.println(AllEvents.retrieve().toString());
			while(!AllEvents.last()) {
				AllEvents.findNext();
				System.out.println(AllEvents.retrieve().toString());
			}
	}
	
	public void printAllEventsTitle(String title) {
			AllEvents.findFirst();
			if(AllEvents.retrieve().getTitle().equalsIgnoreCase(title))
				AllEvents.retrieve().toString();
			while(!AllEvents.last()) {
				AllEvents.findNext();
				if(AllEvents.retrieve().getTitle().equalsIgnoreCase(title))
					AllEvents.retrieve().toString();
			}
		}
	public void deleteInAllEvents() {
		if(AllEvents.isEmpty())
			return;
		AllEvents.findFirst();
		if(contacts.retrieve().getTitleEvent().equalsIgnoreCase(AllEvents.retrieve().getTitle()))
			AllEvents.remove();
		while(!AllEvents.last())
			if(contacts.retrieve().getTitleEvent().equalsIgnoreCase(AllEvents.retrieve().getTitle()))
				AllEvents.remove();
	}
	
	public boolean isEmptyAllEvents() {
		return AllEvents.isEmpty();
	}
	
}
