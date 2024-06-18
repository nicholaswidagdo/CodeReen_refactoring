package index;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner scan = new Scanner(System.in);
	ArrayList<User> uList = new ArrayList<>();
	
	String currentUser = "";
	int currentUserIdx = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
	
	public Main() {
		generateDummyData();
		mainMenu();
	}
	
	public void generateDummyData() {
		uList.add(new User("Fred"));
		uList.add(new User("Tom"));
		uList.add(new User("Jerry"));
		uList.add(new User("Moli"));
		
		//insert dummy work untuk Tom
		uList.get(1).getMusicWorkList().add(new Music("111", "requim", "music", "gold", "jazz"));
		uList.get(1).getMusicWorkList().add(new Music("123", "idol", "music", "silver", "pop"));
		uList.get(1).getVideoWorkList().add(new Video("124", "aaaa", "video", "bronze", 123));
		uList.get(1).getImageWorkList().add(new Image("125", "aaaa", "image", "bronze", "JPEG"));
		
		//insert dummy work untuk Moli
		uList.get(3).getMusicWorkList().add(new Music("323", "qwerty", "music", "silver", "pop"));
		uList.get(3).getVideoWorkList().add(new Video("324", "asdf", "video", "bronze", 123));
		uList.get(3).getImageWorkList().add(new Image("325", "aazxvczaa", "image", "bronze", "JPEG"));
		
		ArrayList<Subscription> tempSupport = new ArrayList<>();
		ArrayList<Subscription> tempSubscriber = new ArrayList<>();
		
		//insert dummy supported creator untuk Fred
		tempSupport.add(new Subscription("Tom", "silver"));
		tempSupport.add(new Subscription("Moli", "silver"));
		uList.get(0).setSupportedCreators(tempSupport);
		
		//insert Fred sebagai subscriber untuk Tom dan Moli
		tempSubscriber.add(new Subscription("Fred", "silver"));
		uList.get(1).setSubscribers(tempSubscriber);
		uList.get(3).setSubscribers(tempSubscriber);
		
		tempSupport = new ArrayList<>();
		tempSubscriber = new ArrayList<>();
		
		//insert dummy supported creator untuk Tom
		tempSupport.add(new Subscription("Fred", "gold"));
		tempSupport.add(new Subscription("Jerry", "silver"));
		uList.get(1).setSupportedCreators(tempSupport);
		
		//insert Tom sebagai subscriber untuk Fred
		tempSubscriber.add(new Subscription("Tom", "gold"));
		uList.get(0).setSubscribers(tempSubscriber);
		
		tempSubscriber = new ArrayList<>();
		
		//insert Tom sebagai subscriber untuk Jerry
		tempSubscriber.add(new Subscription("Tom", "silver"));
		uList.get(2).setSubscribers(tempSubscriber);
		
	}
	
	public boolean validateUserLogin(String username) {
		//untuk setiap user, cek apakah username diinput saat login ada atau tidak.
		//kalo ada return true (login), kalo tidak ada, return false (input ulang).
		for (int i=0; i<uList.size(); i++) {
			if(uList.get(i).getUsername().compareTo(username) == 0) {
				currentUserIdx = i;
				return true;				
			}
		}
		return false;
	}
	
	public boolean validateLevel(String level) {
		if(level.compareTo("bronze") == 0 || level.compareTo("silver") == 0 || level.compareTo("gold") == 0) {
			return true;
		}
		return false;
	}
	
	public String generateId() {
		String result = "";
		
		for(int i=0; i<9; i++) {
			result += (int) (Math.random()*10) + "";
		}
		
		return result;
	}
	
	public int getUserIdxByUsername(String username) {
		int idx = -1;
		
		for(int i=0; i<uList.size(); i++) {
			if(uList.get(i).getUsername().equals(username)) {
				idx = i;
				break;
			}
		}
		
		return idx;
	}
	
	public void mainMenu() {
		int mMenu = 0;
		
		do {
			System.out.println("1. Insert new patreon user");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print(">> ");
			mMenu = scan.nextInt();
			scan.nextLine();
			
			switch(mMenu) {
			case 1:
				insertUser();
				break;
			case 2:
				login();
				break;			
			}
		}while(mMenu != 3);
	}
	
	public void insertUser() {
		String newUsername = "";
		
		System.out.print("Input new username: ");
		newUsername = scan.nextLine();
		
		uList.add(new User(newUsername));
	}
	
	public void login() {
		currentUser = "";
		
		System.out.println("List of available users:");
		for (int i = 0; i < uList.size(); i++) {
			System.out.printf("%d. %s\n", i+1, uList.get(i).getUsername());
		}
		
		do {
			System.out.print("Enter username to login: ");
			currentUser = scan.nextLine();
		}while(validateUserLogin(currentUser) == false);
		
		userMenu();
	}
	
	public void userMenu() {
		int uMenu = 0;
		
		do {
			System.out.println("1. Insert new work");
			System.out.println("2. Support a creator");
			System.out.println("3. View all subscriber");
			System.out.println("4. View your work");
			System.out.println("5. View accessible work");
			System.out.println("6. Exit");
			System.out.print(">> ");
			uMenu = scan.nextInt();
			scan.nextLine();
			
			switch(uMenu) {
			case 1:
				insertWork();
				break;
			case 2:
				supportCreator();
				break;
			case 3:
				viewSubscriber();
				break;
			case 4:
				viewWork();
				break;
			case 5:
				viewAccessible();
				break;
			}
			
		}while(uMenu != 6);
	}
	
	public void insertWork() {
		String ID, title, type, subscriptionLevel;
		String genreName = null, imageType = null;
		Integer duration = null;
		
		do {
			System.out.print("Input work type: ");
			type = scan.nextLine();
		}while (type.compareTo("music") != 0 && type.compareTo("video") != 0 && type.compareTo("image") != 0);
		
		if(type.compareTo("music") == 0) {
			System.out.print("Input genre name: ");
			genreName = scan.nextLine();
		}
		else if(type.compareTo("video") == 0) {
			System.out.print("Input video duration: ");
			duration = scan.nextInt();
			scan.nextLine();
		}
		else {
			System.out.print("Input image type: ");
			imageType = scan.nextLine();
		}
		
		System.out.print("Input work title: ");
		title = scan.nextLine();
		
		do {
			System.out.print("Input subscription level: ");
			subscriptionLevel = scan.nextLine();
		}while(validateLevel(subscriptionLevel) == false);
		
		ID = generateId();
		
		if(type.compareTo("music") == 0) {
			uList.get(currentUserIdx).getMusicWorkList().add(new Music(ID, title, type, subscriptionLevel, genreName));
		}
		else if(type.compareTo("video") == 0) {
			uList.get(currentUserIdx).getVideoWorkList().add(new Video(ID, title, type, subscriptionLevel, duration));
		}
		else {
			uList.get(currentUserIdx).getImageWorkList().add(new Image(ID, title, type, subscriptionLevel, imageType));
		}
	}

	public void supportCreator() {
		ArrayList<String> availableUser = new ArrayList<>();
		String tUsername = "", supportedUsername = "";
		String usernameToSupport, subscriptionLevel;
		boolean take = true;
		
		//filter agar hanya ambil username yang belum di support
		//loop untuk setiap username yang ada dalam sistem
		for(int i=0; i<uList.size(); i++) {
			take = true;
			tUsername = uList.get(i).getUsername();

			//loop untuk setiap username yang sudah disupport oleh current user
			for(int j=0; j<uList.get(currentUserIdx).getSupportedCreators().size(); j++) {
				supportedUsername = uList.get(currentUserIdx).getSupportedCreators().get(j).getUsername();
				//dari semua username yang ada, cek apakah username tsb sudah ada dalam list support atau belum. apabila username ini sudah ada dalam list supported, kita flag untuk tidak tampilin usernamenya dan break
				if(tUsername.compareTo(supportedUsername) == 0 || tUsername.compareTo(currentUser) == 0) {
					take = false;
					break;
				}
			}
			//simpan username karena belum di support
			if(take == true) {
				availableUser.add(tUsername);
			}
		}
		
		
		//display semua username yang belum disupport
		System.out.println("users you haven't support: ");
		for(int i=0; i<availableUser.size(); i++) {
			System.out.println(availableUser.get(i));
		}
		
		System.out.print("Input username to support: ");
		usernameToSupport = scan.nextLine();
		
		do {
			System.out.print("Input subscription level: ");
			subscriptionLevel = scan.nextLine();
		}while(validateLevel(subscriptionLevel) == false);
		
		//tambahkan usernameToSupport ke dalam list supported creator
		uList.get(currentUserIdx).getSupportedCreators().add(new Subscription(usernameToSupport, subscriptionLevel));
		
		//tambahkan current user ke dalam list subscriber usernameToSupport
		int supportCreatorIdx = getUserIdxByUsername(usernameToSupport);
		uList.get(supportCreatorIdx).getSubscribers().add(new Subscription(currentUser, subscriptionLevel));
		
	}
	
	public void viewSubscriber() {
		ArrayList<String> goldSubs = new ArrayList<>();
		ArrayList<String> silverSubs = new ArrayList<>();
		ArrayList<String> bronzeSubs = new ArrayList<>();
		
		//filter dahulu setiap subscriber pada user ini kedalam masing masing level.
		for (Subscription s : uList.get(currentUserIdx).getSubscribers()) {
			switch(s.getSubscriptionLevel()) {
			case "gold":
				goldSubs.add(s.getUsername());
				break;
			case "silver":
				silverSubs.add(s.getUsername());
				break;
			case "bronze":
				bronzeSubs.add(s.getUsername());
				break;
			}
		}
		
		System.out.println("============gold:============");
		//tampilkan semua username gold subscriber
		for (String username : goldSubs) {
			System.out.println(username);
		}
		
		System.out.println("============silver:============");
		//tampilkan semua username silver subscriber
		for (String username : silverSubs) {
			System.out.println(username);
		}
		
		System.out.println("============bronze:============");
		//tampilkan semua username bronze subscriber
		for (String username : bronzeSubs) {
			System.out.println(username);
		}
	}
	
	public void viewWork() {
		if(uList.get(currentUserIdx).getMusicWorkList().size() == 0 &&
				uList.get(currentUserIdx).getVideoWorkList().size() == 0 &&
				uList.get(currentUserIdx).getImageWorkList().size() == 0) {
			System.out.println("No works uploaded yet");
			return;
		}
		
		System.out.println("============Music:============");
		for (int i=0; i<uList.get(currentUserIdx).getMusicWorkList().size(); i++) {
			uList.get(currentUserIdx).getMusicWorkList().get(i).displayData();
		}
		
		System.out.println("============Video:============");
		for (int i=0; i<uList.get(currentUserIdx).getVideoWorkList().size(); i++) {
			uList.get(currentUserIdx).getVideoWorkList().get(i).displayData();
		}
		
		System.out.println("============Image:============");
		for (int i=0; i<uList.get(currentUserIdx).getImageWorkList().size(); i++) {
			uList.get(currentUserIdx).getImageWorkList().get(i).displayData();
		}
	}

	public void viewAccessible() {
		ArrayList<Work> goldContent = new ArrayList<>();
		ArrayList<Work> silverContent = new ArrayList<>();
		ArrayList<Work> bronzeContent = new ArrayList<>();
		
		if(uList.get(currentUserIdx).getSupportedCreators().size() == 0) {
			System.out.println("No works you can see because no supported creator");
		}
		else {
			//loop untuk semua supported creators pada user saat ini
			for(int i=0; i<uList.get(currentUserIdx).getSupportedCreators().size(); i++) {
				String username = uList.get(currentUserIdx).getSupportedCreators().get(i).getUsername();
				String level = uList.get(currentUserIdx).getSupportedCreators().get(i).getSubscriptionLevel();
				
//				System.out.println(username + " " + level);
				
				int idx = getUserIdxByUsername(username);
				
				if(level.equals("gold")) {
					goldContent.addAll(uList.get(idx).getWorkByLevel("gold"));
					silverContent.addAll(uList.get(idx).getWorkByLevel("silver"));
					bronzeContent.addAll(uList.get(idx).getWorkByLevel("bronze"));
				}
				else if(level.equals("silver")) {
					silverContent.addAll(uList.get(idx).getWorkByLevel("silver"));
					bronzeContent.addAll(uList.get(idx).getWorkByLevel("bronze"));
				}
				else if(level.equals("bronze")) {
					bronzeContent.addAll(uList.get(idx).getWorkByLevel("bronze"));
				}
			}
			
			//apabila tidak bisa mengakses work manapun karena level subscription kerendahan
			if(goldContent.size() == 0 && silverContent.size() == 0 && bronzeContent.size() == 0) {
				System.out.println("No works you can see");
			}
			else {
				System.out.println("============gold:============");
				for (int i = 0; i < goldContent.size(); i++) {
					goldContent.get(i).displayData();
				}
				
				System.out.println("============silver:============");
				for (int i = 0; i < silverContent.size(); i++) {
					silverContent.get(i).displayData();
				}
		
				System.out.println("============bronze:============");
				for (int i = 0; i < bronzeContent.size(); i++) {
					bronzeContent.get(i).displayData();
				}
			}
		}
		
	}
}
