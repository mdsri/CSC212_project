public class Contact implements Comparable<Contact> {
	private String name;
	private String phNumber;
	private String email;
	private String address;
	private String birthday;
	private String notes;
	private LinkedList_ADT<Event> events;
	
	public Contact(String name, String phNumber, String email, String address, String birthday, String notes) {
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		events = new LinkedList_ADT<Event>();
	}
	
	public String getName() {
		return name;
	}

	public String getphNumber() {
		return phNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getNotes() {
		return notes;
	}
	
	public String getTitleEvent() {
		return events.retrieve().getTitle();
	}

	@Override
	public int compareTo(Contact o) {		//without number
		return this.name.compareToIgnoreCase(o.name);
	}
	
	public boolean EqNum(Contact o) {
		return this.phNumber.equalsIgnoreCase(o.phNumber);
	}
	
	public boolean noConflictEventAdd(Event e) {
		events.findFirst();
		if(!events.retrieve().noConflict(e)) {
			return false;
		}
		else {
			while(!events.last()) {
				events.findNext();
				if(!events.retrieve().noConflict(e))
					return false;
			}
		}
		return true;
	}
	
	public boolean checkAndSort(Event e) {	// T not found - F found
		while(!events.last()){
			events.findNext();
			if(events.retrieve().compareTo(e) >= 0) {	
				events.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addEvent(Event e) {
		if (events.isEmpty()) { 
			events.insert(e);
			return true;
		}
		
		if(!noConflictEventAdd(e)) {
			return false;
		}

		events.findFirst();
		if(events.retrieve().compareTo(e) >= 0) {
			events.insertBeforeFirst(e);		//before
			return true;
		}
		
		else if(checkAndSort(e)) {
			events.insert(e);
			return true;
		}	
		return false;
	}
	
	public void printByTitle(String title) {
		if(events.isEmpty())
			System.out.println("No events!");
		events.findFirst();
		if(events.retrieve().getTitle().equalsIgnoreCase(title)) {
			System.out.println("Events found!"
					+"\nContact name: "+ this.name
					+"\n" + events.retrieve().toString());

			while(!events.last()) {
				events.findNext();
				if(events.retrieve().getTitle().equalsIgnoreCase(title))
					System.out.println("\n" + events.retrieve().toString());
			}
		}
		else 
			System.out.println("No events!");
	}

	public void printAllEvents() {
		if(events.isEmpty())
			System.out.println("Contact doesn't have an events!");
		events.findFirst();
		System.out.println("Contact name: "+ this.name
							+"\n" + events.retrieve().toString());
		while(!events.last()) {
			events.findNext();
			System.out.println("\n" + events.retrieve().toString());
		}
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "\nPhone number: " + phNumber + "\nEmail Address: " + email + "\nAddress: " + address
				+ "\nBirthday: " + birthday + "\nNotes: " + notes;
	}
}
