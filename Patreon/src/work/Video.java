package work;

public class Video extends Work {

	int minute;
	int second;
	
	public Video(int minute, int second) {
		super();
		this.minute = minute;
		this.second = second;
	}
	
	
	public String getDuration() {
		
		return minute + ":" + second;
				
	}
	
	

}
