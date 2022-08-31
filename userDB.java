package userUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Payment;
import model.User;





public class userDB {
	
	private static boolean isSuccess; 
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet result=null;
	//payment check validate
	
	public static boolean paymentvalidate(String username) {
		//payment validate
	
		
		try {
			
			// call data base connection
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from payment where UserName='"+username+"'";
			result=stmt.executeQuery(sql);
			
			if(result.next()) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
				
			}
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		return isSuccess;
	}
	
	
	
	//user validate
	    public static boolean validate(String username,String password) {
	    	
	    	
	    	
	    	try {
	    		// call data base Connection
	    		con=DBconnect.getConnection();
				stmt=con.createStatement();
				String sql="select * from registereduser where UserName='"+username+"' and Password='"+password+"'";
				result=stmt.executeQuery(sql);
				
				if(result.next()) {
					isSuccess=true;
				}
				else {
					isSuccess=false;
					
				}
				
	    		
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    		
	    	}
	    	
	    	
	    	
	    	return isSuccess;
	    }
	    
	    //get payment details from data base
	    public static List<Payment> getpayment(String username){
	    	
	    	ArrayList<Payment> p =new ArrayList<>();
	    	try {
	    		
	    		// call data base connection
	    		con=DBconnect.getConnection();
				stmt=con.createStatement();
				String sql="select * from payment where UserName='"+username+"'";
				result=stmt.executeQuery(sql);
				
				while(result.next()) {
					String userName=result.getString(1);
					String cvv=result.getString(2);
					String cardnumber=result.getString(3);
					String month=result.getString(4);
					String year=result.getString(5);
					
					
					Payment pa=new Payment(0, userName, userName, username, cardnumber, sql, userName, cvv, cardnumber, month, year);
					p.add(pa);
				}
				
				
				
	    		
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	    	return p;
	    	
	    	
	    }
	    
	    //get user details from data base
	    
	    public static List<User> getuser(String username){
	    	
	    	ArrayList<User> user =new ArrayList<>();
	    	
	    	
	    	try {
	    		//call database connection
	    		con=DBconnect.getConnection();
				stmt=con.createStatement();
				String sql="select * from registereduser where UserName='"+username+"'";
				result=stmt.executeQuery(sql);
				
				while(result.next()) {
					int id=result.getInt(1);
					String name=result.getString(2);
					String Username=result.getString(3);
					String email=result.getString(4);
					String contact=result.getString(5);
					String password=result.getString(6);
					
					User u=new User(id,name,Username,email,contact,password);
					user.add(u);
					
				}
	    		
	    		
	    	}
	    	catch(SQLException se) {
	    		se.printStackTrace();
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	
	    	
	    	
	    	
	    	return user;
	    }

//insert data into user table
	    
	public static boolean insertuser(String Name,String UserName,String Email,String ContactNumber,String Password) {
		boolean isSuccess=false;
		
		
		
		try {
			

			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql="insert into registereduser values(0,'"+Name+"','"+UserName+"','"+Email+"','"+ContactNumber+"','"+Password+"')";
			int rs=stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	// insert into data into payment table
	public static boolean insertpayment(String UserName,String CVV,String Cardnumber,String month,String year) {
		
		boolean isSuccess=false;
		
		try {
			
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
		
				String sql="insert into payment values('"+UserName+"','"+CVV+"','"+Cardnumber+"','"+month+"','"+year+"')";
			    int rs=stmt.executeUpdate(sql);
					if(rs > 0) {
						isSuccess=true;
					}
					else {
						isSuccess=false;
					}
					
			
			
			}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
		return isSuccess;
		
	}
	
	
	//update data into user table
	public static boolean updateuser(String id,String Name,String UserName,String Email,String ContactNumber) {
		
		
		try {
			
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="update registereduser set  Name='"+Name+"',UserName='"+UserName+"',Email='"+Email+"',ContactNumber='"+ContactNumber+"'"
					+"where ID='"+id+"'";
			int rs=stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
			
			
		}
		catch(Exception e ) {
			e.printStackTrace();
			
		}
		
		return isSuccess;
		
		
	}
	//get details from user table
	public static List<User> getuserDetails(String id){
		
		
		int translateID=Integer.parseInt(id);
		
		ArrayList<User> us=new ArrayList<>();
		
		try {
			//call data base connection

			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from registereduser where  ID='"+translateID+"'";
			result=stmt.executeQuery(sql);
			
			while(result.next()) {
				int Id=result.getInt(1);
				String Name=result.getString(2);
				String userName=result.getString(3);
				String email=result.getString(4);
				String contact=result.getString(5);
				String password=result.getString(6);
				
				User u=new User(Id,Name,userName,email,contact,password);
				us.add(u);
			}
			
		}
		catch(SQLException se) {
    		se.printStackTrace();
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	
    
		return us;
		
		
	}
	//delete user from user table
	public static boolean deleteuser(String id) {
		
		int translateID=Integer.parseInt(id);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql="delete from registereduser where ID='"+translateID+"'";
			int res=stmt.executeUpdate(sql);
			
			if(res>0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

}
