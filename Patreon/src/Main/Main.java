package Main;
import java.util.ArrayList;
import java.util.Scanner;

import work.Image;
import work.Music;
import work.Video;
import work.Work;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<User> userList = new ArrayList<>();
	User loginUser = null;
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		mainMenu();
		
		
	}
	
	public void insertUser() {
		
		
		System.out.print("Input username: ");
		String name = scan.nextLine();
		
		User user = new User(name);
		userList.add(user);
		
		
	}
	
	
	public void login() {
		
		for (User user : userList) {
			
			System.out.println("-" + user.username);
			
		}
		
		System.out.println("Input your username: ");
		String name = scan.nextLine();
		
		for(User user : userList) {
			
			if(user.username.equals(name) ) {
				loginUser = user;
				break;
				
			}
			
		}
		
		
	}
	
	public void mainMenu() {
		int choice = 0;
		
		
		while(loginUser == null) {
		do {
		System.out.println("*1. Insert new Pateron user");
		System.out.println("*2. Login");
		System.out.println("*3. Exit");
		
		System.out.print(">> ");
		choice = scan.nextInt();
		scan.nextLine();
		}while(choice < 1 || choice > 3);
		
		switch(choice) {
		
		case 1:
			
			insertUser();
			break;
		case 2:
			
			login();
			break;
		case 3:
			return;
		
		
		}
		
		
		if(loginUser != null) userMenu();
		
		
	}
		
		userMenu();
}
	
	public void insertNewWork() {
		Work work = null;
		
		
		String type;
		do {
		System.out.print("Input work type music | video | image | : ");
		type = scan.nextLine();
		}while(!type.equals("music") && !type.equals("video") && !type.equals("image"));
		
		
		if(type.equals("music")){
			
			
			System.out.print("Input music genre name: ");
			String genre = scan.nextLine();
			
			work = new Music(genre);
			
			
		}
		else if(type.equals("video")){
			int minute = -1;
			int seconds = -1;
			
			do {
			System.out.println("Input video duration (minutes): ");
			
			try {
			
			 minute = scan.nextInt();
			
			}
			catch(Exception e) {
				System.out.println("Input a number!");
				minute = -1;
			}
			
			finally {
				scan.nextLine();
				
			}
			
			
			}while(minute == -1);
			
			
			do {
				System.out.println("Input video duration (seconds): ");
				
				try {
				
				 seconds = scan.nextInt();
				
				}
				catch(Exception e) {
					System.out.println("Input a number!");
					seconds = -1;
				}
				
				finally {
					scan.nextLine();
					
				}
				
				
				}while(seconds == -1);
			
			work = new Video(minute, seconds);
			
			
			
		}
		else if(type.equals("image")) {
			
			String imageType;
			
			do {
			System.out.print("Input image type [JPEG | PNG]: ");
			imageType = scan.nextLine();
			
			
			
			
			}while(!imageType.equals("JPEG") && !imageType.equals("PNG"));
			
			work = new Image(imageType);
			
		}
		
			String title;
			String subscriptionLevel;
			
			System.out.println("Input work title: ");
			title = scan.nextLine();
			
			do {
				
				System.out.println("Input subscription level[bronze | silver | gold]: ");
				subscriptionLevel = scan.nextLine();
				
				
			}while(!subscriptionLevel.equals("bronze") && !subscriptionLevel.equals("silver") && !subscriptionLevel.equals("gold"));
		
			work.setTitle(title);
			work.setSubscriptionlevel(subscriptionLevel);
			
			loginUser.addToworkList(work);
		
	}
	
	
	@SuppressWarnings("null")
	public void supportCreator() {
		ArrayList<User> eligibleList = new ArrayList<>();
		for (User user : userList) {
			if(user.equals(loginUser)) continue;
			if(loginUser.findInsSubscribed(user)) continue;
			
			
			System.out.println("- "+ user.username);	
			eligibleList.add(user);
		}
			String username;
			String subscriptionLevel;
			User toSubscribe = null;
			boolean found = false;
			
			
			do {
				System.out.print("Input a username to subscribe: ");
				username = scan.nextLine();
			
				for (User user : eligibleList) {
					if(user.username.equals(username)) {
						found = true;
						break;
					}
					
				}
				
			
			}while(!found);
			
			
			
			do {
				
				System.out.println("Input subscription level[bronze | silver | gold]: ");
				subscriptionLevel = scan.nextLine();
				
				
			}while(!subscriptionLevel.equals("bronze") && !subscriptionLevel.equals("silver") && !subscriptionLevel.equals("gold"));
			
			loginUser.addSubscribed(toSubscribe, subscriptionLevel);
			toSubscribe.addSubscriber(loginUser, subscriptionLevel);
			
		}
		
		
		public void viewAllSubscriber() {
			loginUser.showSubscriber();
		}
	
		
	
	
	
		public void viewYourWork() {
		loginUser.showWork();
		}
	
		public void viewAccesibleWork() {
			loginUser.showSubscribedWork();
			
		}
	
		public void logout() {
			loginUser = null;
			
		}
	
	public void userMenu() {
		int choice = 0;
		
		while(loginUser != null) {
		do {
		System.out.println("1. Insert new Work");
		System.out.println("2. Support a Creator");
		System.out.println("3. View all subscriber");
		System.out.println("4. View your work");
		System.out.println("5. View accesible work");
		System.out.println("6. Log out");
		System.out.print(">> ");
		choice = scan.nextInt();
		scan.nextLine();
		
		}while(choice < 1 || choice > 6);
		
		switch(choice) {
		
		case 1:
			insertNewWork();
			break;
		case 2:
			supportCreator();
			break;
		case 3:
			viewAllSubscriber();
			break;
		case 4:
			viewYourWork();
			break;
		case 5:
			viewAccesibleWork();
			break;
			
		case 6:
			logout();
			break;
		
		}
		
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Main();
		
		
	}

}
