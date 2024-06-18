package work;

import java.util.Random;

public class Work {

	String title;
	String subscriptionlevel;
	String id;
	
	public Work() {
		// TODO Auto-generated constructor stub
		Random rand = new Random();
		
		id = "";
		for(int i =1;i<=9 ;i++) {
			id += String.valueOf(rand.nextInt(10)); 
			
		}
		
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSubscriptionlevel() {
		return subscriptionlevel;
	}


	public void setSubscriptionlevel(String subscriptionlevel) {
		this.subscriptionlevel = subscriptionlevel;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	
	
}
