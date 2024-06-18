package index;

public class Music extends Work{

	private String genreName;
	
	public Music(String iD, String title, String type, String subscriptionLevel, String genreName) {
		super(iD, title, type, subscriptionLevel);
		// TODO Auto-generated constructor stub
		this.genreName = genreName;
	}
	
	public void displayData() {
		System.out.println("ID: " + this.getID());
		System.out.println("title: " + this.getTitle());
		System.out.println("type: " + this.getType());
		System.out.println("subscription Level: " + this.getSubscriptionLevel());
		System.out.println("genre name: " + this.getGenreName());
		System.out.println();
	}
	
	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
