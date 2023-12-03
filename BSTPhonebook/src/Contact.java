
public class Contact implements Comparable<Contact> {
	private String name;
	private String phNumber;
	private String email;
	private String address;
	private String birthday;
	private String notes;
	private LinkedList_ADT<Event> appointments;			//Event or appointement
	private String key;

	public Contact(String name, String phNumber, String email, String address, String birthday, String notes) {
		this.name = name;
		this.phNumber = phNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.notes = notes;
		this.appointments = new LinkedList_ADT<Event>();
		this.key = name;
	}

	public String getKey() {
        return key;
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

	public String getTitleEA() {
		return appointments.retrieve().getTitle();
	}

	@Override
	public int compareTo(Contact o) {		////////////////////////////////
		return this.name.compareToIgnoreCase(o.name);
	}

	public boolean EqNum(Contact o) {
		return this.phNumber.equalsIgnoreCase(o.phNumber);
	}

	public boolean noConflictEventAdd(Event e) {
		appointments.findFirst();
		if (!appointments.retrieve().noConflict(e)) {
			return false;
		} else {
			while (!appointments.last()) {
				appointments.findNext();
				if (!appointments.retrieve().noConflict(e))
					return false;
			}
		}
		return true;
	}

	public boolean sortEvent(Event e) {
		while (!appointments.last()) {
			appointments.findNext();
			if (appointments.retrieve().compareTo(e) >= 0) {
				appointments.findPrevious();
				return true;
			}
		}
		return true;
	}

	public boolean addEvent(Event e) {
		if (appointments.isEmpty()) {
			appointments.insert(e);
			return true;
		}

		if (!noConflictEventAdd(e)) {
			return false;
		}

		appointments.findFirst();
		if (appointments.retrieve().compareTo(e) >= 0) {
			appointments.insertBeforeFirst(e);
			return true;
		}

		else if (sortEvent(e)) {
			appointments.insert(e);
			return true;
		}
		return false;
	}

	public void printByTitle(String title) {
		if (appointments.isEmpty())
			System.out.println("No appointments!");
		appointments.findFirst();
		if (appointments.retrieve().getTitle().equalsIgnoreCase(title)) {
			System.out.println("appointments found!" + "\nContact name: " + this.name + "\n" + appointments.retrieve().toString());

			while (!appointments.last()) {
				appointments.findNext();
				if (appointments.retrieve().getTitle().equalsIgnoreCase(title))
					System.out.println("\n" + appointments.retrieve().toString());
			}
		} else
			System.out.println("No appointments!");
	}

	public void printEvents() {
		if (appointments.isEmpty())
			System.out.println("Contact doesn't have an appointments!");
		appointments.findFirst();
		System.out.println("Contact name: " + this.name + "\n" + appointments.retrieve().toString());
		while (!appointments.last()) {
			appointments.findNext();
			System.out.println("\n" + appointments.retrieve().toString());
		}
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nPhone number: " + phNumber + "\nEmail Address: " + email + "\nAddress: " + address
				+ "\nBirthday: " + birthday + "\nNotes: " + notes;
	}
}