package index;

import java.util.ArrayList;

public class User {
	private String username;
	private ArrayList<Subscription> subscribers;
	private ArrayList<Subscription> supportedCreators;
	private ArrayList<Music> musicWorkList;
	private ArrayList<Video> videoWorkList;
	private ArrayList<Image> imageWorkList;
	
	public User(String username) {
		super();
		this.username = username;
		this.subscribers = new ArrayList<>();;
		this.supportedCreators = new ArrayList<>();;
		this.musicWorkList = new ArrayList<>();;
		this.videoWorkList = new ArrayList<>();;
		this.imageWorkList = new ArrayList<>();;
	}
	
	public User(String username, ArrayList<Subscription> subscribers, ArrayList<Subscription> supportedCreators,
			ArrayList<Music> musicWorkList, ArrayList<Video> videoWorkList, ArrayList<Image> imageWorkList) {
		super();
		this.username = username;
		this.subscribers = subscribers;
		this.supportedCreators = supportedCreators;
		this.musicWorkList = musicWorkList;
		this.videoWorkList = videoWorkList;
		this.imageWorkList = imageWorkList;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Subscription> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(ArrayList<Subscription> subscribers) {
		this.subscribers = subscribers;
	}

	public ArrayList<Subscription> getSupportedCreators() {
		return supportedCreators;
	}

	public void setSupportedCreators(ArrayList<Subscription> supportedCreators) {
		this.supportedCreators = supportedCreators;
	}

	public ArrayList<Music> getMusicWorkList() {
		return musicWorkList;
	}

	public void setMusicWorkList(ArrayList<Music> musicWorkList) {
		this.musicWorkList = musicWorkList;
	}

	public ArrayList<Video> getVideoWorkList() {
		return videoWorkList;
	}

	public void setVideoWorkList(ArrayList<Video> videoWorkList) {
		this.videoWorkList = videoWorkList;
	}

	public ArrayList<Image> getImageWorkList() {
		return imageWorkList;
	}

	public void setImageWorkList(ArrayList<Image> imageWorkList) {
		this.imageWorkList = imageWorkList;
	}

	public ArrayList<Work> getWorkByLevel(String level){
		ArrayList<Work> result = new ArrayList<>();
		
		for (Work work : musicWorkList) {
			if(work.getSubscriptionLevel().equals(level)) {
				result.add(work);
			}
		}
		for (Work work : videoWorkList) {
			if(work.getSubscriptionLevel().equals(level)) {
				result.add(work);
			}
		}
		for (Work work : imageWorkList) {
			if(work.getSubscriptionLevel().equals(level)) {
				result.add(work);
			}
		}
		return result;
	}
}

