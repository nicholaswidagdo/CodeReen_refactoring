package index;

public class Video extends Work{

	private Integer duration;

	public Video(String iD, String title, String type, String subscriptionLevel, Integer duration) {
		super(iD, title, type, subscriptionLevel);
		// TODO Auto-generated constructor stub
		this.duration = duration;
	}
	
	public void displayData() {
		System.out.println("ID: " + this.getID());
		System.out.println("title: " + this.getTitle());
		System.out.println("type: " + this.getType());
		System.out.println("subscription Level: " + this.getSubscriptionLevel());
		System.out.println("duration: " + this.getDuration());
		System.out.println();
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}
