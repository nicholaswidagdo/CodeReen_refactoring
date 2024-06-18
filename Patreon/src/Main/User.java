package Main;
import java.util.ArrayList;

import work.Image;
import work.Music;
import work.Video;
import work.Work;

public class User {

	
	String username;
	ArrayList<Work> workList;
	ArrayList<Subscribe> subscriber;
	ArrayList<Subscribe> subscribed;
	
	
	public User(String username) {
		// TODO Auto-generated constructor stub
		
		this.username = username;
		workList = new ArrayList<>();
		subscriber = new ArrayList<>();
		subscribed = new ArrayList<>();
		
		
	}
	
	public void addToworkList(Work work) {
		
		workList.add(work);
	}

	//refactor
	public void showWork() {
		if(workList.isEmpty()) {
			System.out.println("No works uploaded yet !");	
			return;
		}
		
		
		System.out.println("Music");
		System.out.println("=====================");
		for (Work work : workList) {
			if(work instanceof Music) {
				Music music = (Music) work;
				
				System.out.println("ID: "+ work.getId());
				System.out.println("Title: "+ work.getTitle());
				System.out.println("Subscription Level: "+ work.getSubscriptionlevel());
				System.out.println("Music genre: "+ music.getGenre());
				System.out.println();
			}
		}
		
		System.out.println("Video");
		System.out.println("=====================");
		for (Work work : workList) {
			if(work instanceof Video) {
				Video video = (Video) work;
				
				System.out.println("ID: "+ work.getId());
				System.out.println("Title: "+ work.getTitle());
				System.out.println("Subscription Level: "+ work.getSubscriptionlevel());
				System.out.println("Video duration: "+ video.getDuration());
				System.out.println();
			}
		}
		
		
		System.out.println("Image");
		System.out.println("=====================");
		for (Work work : workList) {
			if(work instanceof Image) {
				Image image = (Image) work;
				
				System.out.println("ID: "+ work.getId());
				System.out.println("Title: "+ work.getTitle());
				System.out.println("Subscription Level: "+ work.getSubscriptionlevel());
				System.out.println("Image Type: "+ image.getType());
				System.out.println();
			}
		}
		
		
		
	
	}
	
	
	
	
	
	
	public boolean findInsSubscribed(User toSearch) {
		for (Subscribe subscribe : subscribed) {
			if(subscribe.user.equals(toSearch)) {
				return true;
			}
		}
		return false;
	}
	
	
	//refactor
	public void addSubscriber(User toSubscribe, String level) {
		
		
		Subscribe subs = new Subscribe(toSubscribe, level);
		subscriber.add(subs);
	}
	

	public void addSubscribed(User toSubscribe, String level) {
		
		
		Subscribe subs = new Subscribe(toSubscribe, level);
		subscribed.add(subs);
	}
	
	
	
	public void showSubscriber() {
		if(subscriber.isEmpty()) {
			System.out.println("No subscriber");
			return;
		}
		
		System.out.println("Gold");
		System.out.println("======================");
		for (Subscribe subscribe : subscriber) {
			if(subscribe.subscriptionLevel.equals("gold")) {
				System.out.println(subscribe.user.username);
				
			}
		}
		
		
		
		System.out.println("Silver");
		System.out.println("======================");
		for (Subscribe subscribe : subscriber) {
			if(subscribe.subscriptionLevel.equals("silver")) {
				System.out.println(subscribe.user.username);
				
			}
		}
		
		System.out.println("Bronze");
		System.out.println("======================");
		for (Subscribe subscribe : subscriber) {
			if(subscribe.subscriptionLevel.equals("bronze")) {
				System.out.println(subscribe.user.username);
				
			}
		}
		
		
		
	}
		
	public void showSubscribedWork() {
		for (Subscribe subscribe : subscribed) {
			System.out.println("Works by: "+ subscribe.user.username);
			subscribe.user.showWork();
		}
		
	}

	
	
}