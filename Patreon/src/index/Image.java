package index;

public class Image extends Work{
	
	private String imageType;

	public Image(String iD, String title, String type, String subscriptionLevel, String imageType) {
		super(iD, title, type, subscriptionLevel);
		// TODO Auto-generated constructor stub
		this.imageType = imageType;
	}
	
	public void displayData() {
		System.out.println("ID: " + this.getID());
		System.out.println("title: " + this.getTitle());
		System.out.println("type: " + this.getType());
		System.out.println("subscription Level: " + this.getSubscriptionLevel());
		System.out.println("image type: " + this.getImageType());
		System.out.println();
	}
	
	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}


	
	
}
