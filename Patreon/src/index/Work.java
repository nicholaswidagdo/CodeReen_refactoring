package index;

public class Work {
	
	private String ID, title, type, subscriptionLevel;
	
	public Work(String iD, String title, String type, String subscriptionLevel) {
		super();
		ID = iD;
		this.title = title;
		this.type = type;
		this.subscriptionLevel = subscriptionLevel;
	}
	
	public void displayData() {
		
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSubscriptionLevel() {
		return subscriptionLevel;
	}

	public void setSubscriptionLevel(String subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}
	
	

}
