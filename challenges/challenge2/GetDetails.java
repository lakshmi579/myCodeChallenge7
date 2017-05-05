package challenges.challenge2;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

//import com.mysql.jdbc.Connection;

public class GetDetails {
	
	
	static void getDetails(){
		try {
			Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","lakshmi","Jyothi579");
			java.sql.Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT ID,name,phone,address FROM mytable;");
		     while (rs.next()) {
		    	 System.out.println(rs.getInt("ID")+ "    "+ rs.getString("name")+"     "+rs.getString("phone")+"  "+ rs.getString("address"));
		     }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
