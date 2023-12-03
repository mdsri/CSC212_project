public class Phonebook {

	private ContactBST contacts;
	private LinkedList_ADT<Event> eventsList;

	public Phonebook() {
		contacts = new ContactBST();
		eventsList = new LinkedList_ADT<Event>();
	}

	
	public boolean insertContact(Contact c) {
		if(!contacts.search(c.getphNumber()) && !contacts.search(c.getphNumber()))
			return contacts.insert(c.getName(), c);
		return false;
	}
	
	public boolean searchContact(String n) {
		return contacts.search(n);
	}
	
	public boolean searchContactAndDisplay(String n) {
		return contacts.searchAndDisplay(n);
	}
	public Contact retrieveContact() {
		return contacts.retrieve();
	}
	
	
	public void deleteContact(String n, char c) {
		if(contacts.search(n)) {
			deleteInEventsList();
			contacts.removeKey(contacts.retrieveSearch().getName());
			System.out.println("Contact deleted!");
		}
		else 
			System.out.println("Contact not found!");
	}
	
	public boolean schedEventOrAppo(Event x) {
		return contacts.retrieveSearch().addEvent(x) && addEventsList(x) 
				&& eventsList.retrieve().insertContactInEvent(contacts.retrieveSearch());
	}
	
	public boolean insertContactInEvent(Contact c) {
		if(contacts.search(c.getName()))
			return eventsList.retrieve().insertContactInEvent(c) 
					&& contacts.retrieveSearch().addEvent(eventsList.retrieve());
		return false;
	}

	public void printContactEvents(String name) {
		if (contacts.search(name)) {
			contacts.retrieve().printEvents();
			return;
		}
		System.out.println("No contact found!");
		return;
	}
	
	public void printFirstName(String n) {
		contacts.printFirstName(n);
	}

	public void displayForSearch() {
		System.out.println("Contact found!\n" + contacts.retrieve().toString());
	}
	

	public boolean isEmptyContact() {
		return contacts.empty();
	}

	public boolean checkIsDate(String date) {
		try {
			if (date.charAt(4) == '/' && date.charAt(7) == '/' && Integer.parseInt(date.substring(0, 4)) > 0
					&& Integer.parseInt(date.substring(5, 7)) > 0
					&& Integer.parseInt(date.substring(5, 7)) < 13
					&& Integer.parseInt(date.substring(8, 10)) > 0
					&& Integer.parseInt(date.substring(8, 10)) < 32)
				return true;
			else {
				System.out.println("Invalid Date!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid Date!");
			return false;
		}
	}

	public boolean checkIsTime(String time) {
		try {
			if (time.charAt(2) == ':' && Integer.parseInt(time.substring(0, 2)) >= 0
					&& Integer.parseInt(time.substring(3, 5)) >= 0)
				return true;
			else {
				System.out.println("Invalid time!");
				return false;
			}
		} catch (Exception e) {
			System.out.println("Invalid time!");
			return false;
		}
	}

	// All Events methods

	public boolean SortEventsList(Event e) {
		while (!eventsList.last()) {
			eventsList.findNext();
			if (eventsList.retrieve().compareTo(e) >= 0) {
				eventsList.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addEventsList(Event e) {
		if (eventsList.isEmpty()) {
			eventsList.insert(e);
			return true;
		}

		eventsList.findFirst();
		if (eventsList.retrieve().compareTo(e) >= 0) {
			eventsList.insertBeforeFirst(e); // before
			return true;
		}

		else if (SortEventsList(e)) {
			eventsList.insert(e);
			return true;
		}
		return false;
	}

	public void printEventsListAll() {
		eventsList.findFirst();
		eventsList.retrieve().printEventDetails();
		while (!eventsList.last()) {
			eventsList.findNext();
			eventsList.retrieve().printEventDetails();
		}
	}

	public void printEventsListTitle(String title) {
		eventsList.findFirst();
		boolean findIt = false;
		if (eventsList.retrieve().getTitle().equalsIgnoreCase(title)) {
			eventsList.retrieve().printEventDetails();
			findIt = true;
		}
		while (!eventsList.last()) {
			eventsList.findNext();
			if (eventsList.retrieve().getTitle().equalsIgnoreCase(title)) {
				eventsList.retrieve().printEventDetails();
				findIt = true;
			}
		}
		if(!findIt)
			System.out.println("event not found!");
	}
	public void deleteInEventsList() {
		if (eventsList.isEmpty())
			return;
		eventsList.retrieve().deleteContactInEvent(contacts.retrieveSearch().getName());
	}

	public boolean isEmptyEventsList() {
		return eventsList.isEmpty();
	}
	
	public void printAllContacts() {
		contacts.printAllContactsDetails();
	}

}