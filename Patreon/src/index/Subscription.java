package index;

public class Subscription {
	private String username;
	private String subscriptionLevel;
	
	public Subscription(String username, String subscriptionLevel) {
		super();
		this.username = username;
		this.subscriptionLevel = subscriptionLevel;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSubscriptionLevel() {
		return subscriptionLevel;
	}
	public void setSubscriptionLevel(String subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}
	
	
}

