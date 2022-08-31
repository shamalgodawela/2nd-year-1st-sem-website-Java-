package model;

public class User extends NonregUser{
	private int ID;
	private String Name;
	private String UserName;
	private String Email;
	private String ContactNumber;
	private String Password;
	public User(int id,String name, String userName, String email, String contactNumber, String password) {
		ID=id;
		Name = name;
		UserName = userName;
		Email = email;
		ContactNumber = contactNumber;
		Password = password;
	}
	
	public int getID() {
		return ID;
	}
	public String getName() {
		return Name;
	}

	public String getUserName() {
		return UserName;
	}

	public String getEmail() {
		return Email;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public String getPassword() {
		return Password;
	}



}
