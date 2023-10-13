
public class Contact implements Comparable<Contact>{

	private String name;
	private int phNumber; // int easier for us compared to string
	private String email;
	private String address;
	private String birthday;
	private String notes;
	
								
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
	public int compareTo(Contact o) {
		if(this.phNumber == o.phNumber)
			return 0;
		return this.name.compareToIgnoreCase(o.name);
	}

	
}
