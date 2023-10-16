public class Phonebook {

	private LinkedList_ADT<Contact> contacts;
	private LinkedList_ADT<Event> AllEvents;
	
	public Phonebook() {
		contacts = new LinkedList_ADT<Contact>();
		AllEvents = new LinkedList_ADT<Event>();
	}
	
	
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
	
	/*
	   public void printEventTitle(String title) {
		contacts.retrieve().printByTitle(title);
	}
	*/
	
	/*public void printAllEventsCon() {
		contacts.retrieve().printAllEvents();
	}
	 */
	
	public void printFirstName(String n) {
		//if(contacts.isEmpty()) {
			//System.out.println("No contacts!");
			//return;
		//}
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
		//if (contacts.isEmpty())
			//return false;

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
		//if (contacts.isEmpty())
			//return false;

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
		//if (contacts.isEmpty())
			//return false;

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
		//if (contacts.isEmpty())
			//return false;

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
		//if (contacts.isEmpty())
			//return false;

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
		System.out.println("Contact not found");
	}
	
	public void deleteByNumber(int number) {
		if(searchByNumber(number)) {
			System.out.println("Contact deleted!");
			deleteInAllEvents();
			contacts.remove();
		}
		System.out.println("Contact not found");
	}
	
	public void displayForSearch() {
		System.out.println("Contact found!\n" + contacts.retrieve().toString());
	}
	
	public boolean isEmptyContact() {
		return contacts.isEmpty();
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
		//if(!AllEvents.isEmpty()){
			AllEvents.findFirst();
			AllEvents.retrieve().toString();
			while(!AllEvents.last()) {
				AllEvents.findNext();
				AllEvents.retrieve().toString();
			}
		//}
		//else 
			//System.out.println("No Events!");
	}
	
	public void printAllEventsTitle(String title) {
		//if(!AllEvents.isEmpty()){
			AllEvents.findFirst();
			if(AllEvents.retrieve().getTitle().equalsIgnoreCase(title))
				AllEvents.retrieve().toString();
			while(!AllEvents.last()) {
				AllEvents.findNext();
				if(AllEvents.retrieve().getTitle().equalsIgnoreCase(title))
					AllEvents.retrieve().toString();
			}
		}
		//else 
			//System.out.println("No Events!");
	//}
	
	public void deleteInAllEvents() {
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
