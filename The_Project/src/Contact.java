public class Contact implements Comparable<Contact> {
	// throws exception be carefull
	private String name;
	private int phNumber; // int easier for us compared to string
	private String email;
	private String address;
	private String birthday;
	private String notes;
	private LinkedList_ADT<Event> events;
	
	/*
	public Contact(String name, int phNumber, String email, String address, String birthday, String notes) {
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
	}
	*/

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

	public String toString() {
		return "Name:" + name + "\nPhone number: " + phNumber + "\nEmail Address: " + email + "\nAddress: " + address
				+ "\nBirthday: " + birthday + "\nNotes: " + notes;
	}
	
	public boolean checkAndSort(Event e) {	// T not found - F found
		if (events.retrieve().compareTo(e) == 0)		//no same title
			return false;
		while(!events.last()){
			events.findNext();
			if (events.retrieve().compareTo(e) == 0)	//comp1
				return false;
			else if(events.retrieve().compareTo(e) > 0) {	//comp2
				events.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addEvent(Event c) {
		if (events.isEmpty()) //comp2
			events.insert(c);
		
		events.findFirst();
		if(events.retrieve().compareTo(c) > 0)
			events.insertBeforeFirst(c);		//assume in add
		
		if(checkAndSort(c)) {
			events.insert(c);
			return true;
		}	
		return false;
	}
	
	public void printByTitle(String title) {
		if(events.isEmpty())
			System.out.println("No Events");
		events.findFirst();
		if(events.retrieve().getTitle().equalsIgnoreCase(title)) {
			System.out.println("Event found!"+"\nContact name: "+ this.name);
			events.retrieve().toString();
			return;
		}
		while(!events.last()) {
			events.findFirst();
			if(events.retrieve().getTitle().equalsIgnoreCase(title)) {
				System.out.println("Event found!"+"\nContact name: "+ this.name);
				events.retrieve().toString();
				return;
			}
		}
		System.out.println("No Events");
	}
	
	public void printByName(String n) {
		if(events.isEmpty())
			System.out.println("No Events");
		events.findFirst();
		if(events.retrieve().getTitle().equalsIgnoreCase(title)) {
			System.out.println("Event found!"+"\nContact name: "+ this.name);
			events.retrieve().toString();
			return;
		}
		while(!events.last()) {
			events.findFirst();
			if(events.retrieve().getTitle().equalsIgnoreCase(title)) {
				System.out.println("Event found!"+"\nContact name: "+ this.name);
				events.retrieve().toString();
				return;
			}
		}
		System.out.println("No Events");
	}

}
