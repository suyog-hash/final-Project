package project1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;



public class TrainDao {
	String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/train?useSSL=false";
	//String DB_URL="jdbc:mysql://localhost:3306/train?autoReconnect=true&useSSL=FALSE";
	String USERNAME="root";
	String PASSWORD="Sandy@123";
	
	public Train findTrain(int trainNo)
	{
		int TRAIN_NO=trainNo;
		System.out.println(trainNo);
		Train train=null;
		
		try 
		{
			//step1
			Class.forName(DRIVER_NAME);
			System.out.println("Driver class found");
			
			//step2
			System.out.println("Connecting to DataBase...");
			Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("connected");
			//step3
			//PreparedStatement pstmt=con.prepareStatement("SELECT * FROM trains");
			java.sql.Statement stmt  = con.createStatement();
			//pstmt.setInt(1, TRAIN_NO);
			//ResultSet rs=pstmt.executeQuery();
			String sql = "SELECT * FROM trains";
			
			ResultSet rs    = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				train= new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
				
			}
			con.close();
			System.out.println(train);
		}
		catch(Exception e)
		{
			System.out.println("class not found");
			System.out.println(e);
		}
		return train;
			
		}
}