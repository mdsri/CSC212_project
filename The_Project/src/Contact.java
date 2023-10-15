public class Contact implements Comparable<Contact> {
	// throws exception be carefull
	private String name;
	private int phNumber; // int easier for us compared to string
	private String email;
	private String address;
	private String birthday;
	private String notes;
	private LinkedList_ADT<Event> events;
	
	public Contact(String name, int phNumber, String email, String address, String birthday, String notes) {
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
	}
	

	public String getName() {
		return name;
	}

	public int getphNumber() {
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

	@Override
	public int compareTo(Contact o) {		//without number
		return this.name.compareToIgnoreCase(o.name);
	}
	
	public boolean EqNum(Contact o) {
		return this.phNumber == o.phNumber;
	}
	
	public boolean checkAndSort(Event e) {	// T not found - F found
		if (events.retrieve().noConflict(e))		//maybe last		it's ok same name
			return true;
		while(events.retrieve().noConflict(e) && !events.last()){
			events.findNext();
			/* if (events.retrieve().compareTo(e) == 0)	//comp1
				return false; */
			if(events.retrieve().compareTo(e) >= 0 && events.retrieve().noConflict(e)) {	//comp2
				events.findPrevious();
				return true;
			}
		}
		return false;
	}

	public boolean addEvent(Event e) {
		if (events.isEmpty()) { 
			events.insert(e);
			return true;
		}

		events.findFirst();
		if(events.retrieve().compareTo(e) > 0 && events.retrieve().noConflict(e)) {
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
			System.out.println("No Events");
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
	
	/*
	public void printByName(String n) {
		if(events.isEmpty())
			System.out.println("No Events");
		events.findFirst();
		System.out.println("Event found!"+"\nContact name: " + this.name);
		do {
			System.out.println("\n" + events.retrieve().toString());
			events.findNext();
		}while(!events.last());
	}
	*/
	
	@Override
	public String toString() {
		return "Name:" + name + "\nPhone number: " + phNumber + "\nEmail Address: " + email + "\nAddress: " + address
				+ "\nBirthday: " + birthday + "\nNotes: " + notes;
	}
}
