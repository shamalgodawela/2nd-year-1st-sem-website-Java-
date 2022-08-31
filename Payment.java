package model;

public class Payment extends User {
	private String username;
	private String cvv;
	private String cardNumber;
	private String month;
	private String year;
	
	
	
	public Payment(int id, String name, String userName, String email, String contactNumber, String password,
			String username2, String cvv, String cardNumber, String month, String year) {
		super(id, name, userName, email, contactNumber, password);
		username = username2;
		this.cvv = cvv;
		this.cardNumber = cardNumber;
		this.month = month;
		this.year = year;
	}

	public String getUsername() {
		return username;
	}

	public String getCvv() {
		return cvv;
	}
	
	public String getCardnumber() {
		return cardNumber;
	}
	
	public String getMonth() {
		return month;
	}
	
	public String getYear() {
		return year;
	}


	
	
	

}
