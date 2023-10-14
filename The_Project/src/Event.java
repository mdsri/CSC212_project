// Not completed //
public class Event {

	private String title;
	private String date;
	private String time; // 24H
	private String location;
	// and the contact involved <-----

	// Note: نحتاج نربط كونتاكت بالايفنت ونقدر نفترض انه كل كونتاكت له ايفنت واحد
	//

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override // don't forget to connect contact and no conflict
	public String toString() {
		return "Event title: " + title + "\nEvent date and time (MM/DD/YYYY - HH:MM): " + date + " - " + time
				+ "\nEvent location: " + location;
	}

	// public String printByName(), printByTitle()////ظ

}