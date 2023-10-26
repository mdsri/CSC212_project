public class Phonebook {

	private LinkedList_ADT<Contact> contacts;
	private LinkedList_ADT<Event> eventsList;

	public Phonebook() {
		contacts = new LinkedList_ADT<Contact>();
		eventsList = new LinkedList_ADT<Event>();
	}

	public boolean checkAndSort(Contact c) {
		if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))
			return false;
		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().compareTo(c) == 0 || contacts.retrieve().EqNum(c))
				return false;
			else if (contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c))) {
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
		if (contacts.retrieve().compareTo(c) > 0 && !(contacts.retrieve().EqNum(c))) {
			contacts.insertBeforeFirst(c);
			return true;
		}

		if (checkAndSort(c)) {
			contacts.insert(c);
			return true;
		}
		return false;
	}

	public boolean scheduleEventToContact(Event event) {
		return contacts.retrieve().addEvent(event) && addEventsList(event);
	}

	public void printContactEvents(String name) {
		if (searchByName(name)) {
			contacts.retrieve().printEvents();
			return;
		}
		System.out.println("No contact found!");
		return;
	}

	public void printFirstName(String n) {
		contacts.findFirst();
		if (contacts.retrieve().getName().length() >= n.length()
				&& contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
			System.out.println(contacts.retrieve().toString());
		while (!contacts.last()) {
			contacts.findNext();
			if (contacts.retrieve().getName().length() >= n.length()
					&& contacts.retrieve().getName().substring(0, n.length()).equalsIgnoreCase(n))
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
		if (searchByName(name)) {
			System.out.println("Contact deleted!");
			deleteInEventsList();
			contacts.remove();
		} else
			System.out.println("Contact not found!");
	}

	public void deleteByNumber(String number) {
		if (searchByNumber(number)) {
			System.out.println("Contact deleted!");
			deleteInEventsList();
			contacts.remove();
		} else
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
			if (date.charAt(4) == '/' && date.charAt(7) == '/' && Integer.parseInt(date.substring(0, 4)) > 0
					&& Integer.parseInt(date.substring(5, 7)) > 0 && Integer.parseInt(date.substring(8, 10)) > 0)
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
		System.out.println(eventsList.retrieve().toString());
		while (!eventsList.last()) {
			eventsList.findNext();
			System.out.println(eventsList.retrieve().toString());
		}
	}

	public void printEventsListTitle(String title) {
		eventsList.findFirst();
		if (eventsList.retrieve().getTitle().equalsIgnoreCase(title)) {
			System.out.println(eventsList.retrieve().toString());
			while (!eventsList.last()) {
				eventsList.findNext();
				if (eventsList.retrieve().getTitle().equalsIgnoreCase(title))
					System.out.println(eventsList.retrieve().toString());
			}
		} else
			System.out.println("event not found!");
	}

	public void deleteInEventsList() {
		if (eventsList.isEmpty())
			return;
		eventsList.findFirst();
		if (eventsList.retrieve().getContactName().equalsIgnoreCase(contacts.retrieve().getName()))
			eventsList.remove();
		if (!eventsList.isEmpty() && eventsList.last()
				&& eventsList.retrieve().getContactName().equalsIgnoreCase(contacts.retrieve().getName())) {
			eventsList.remove();
			return;
		}
			while (!eventsList.isEmpty() && !eventsList.last()) {
			eventsList.findNext();
			if (eventsList.retrieve().getContactName().equalsIgnoreCase(contacts.retrieve().getName()))
				eventsList.remove();
		}
	}

	public boolean isEmptyEventsList() {
		return eventsList.isEmpty();
	}

}
