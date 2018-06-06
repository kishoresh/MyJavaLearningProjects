import java.sql.DriverManager;
import java.sql.*;
/*
 * URL : http://www.javatpoint.com/PreparedStatement-interface
 */
public class TestJDBC {

	public static void main(String[] args) {
		try{
			//1. Load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. Create the connection object
			//The DriverManager class acts as an interface between user and drivers. It keeps track of the drivers that are available and handles establishing a connection between a database and the appropriate driver.
			//Connection is the session between java application and database. Connection interface is a factory of Statement, PreparedStatement, etc.
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

			//3. Create the Statement object
			//The Statement interface provides methods to execute queries with the database.
			Statement stmnt = conn.createStatement();

			//4. ExecuteQuery
			//The object of ResultSet maintains a cursor pointing to a particular row of data.
			ResultSet rs = stmnt.executeQuery("select * from REF_COMPANY");
			while (rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
			}

			//Getting the 3rd row
			rs.absolute(3);
			System.out.println(rs.getString(1)+"  "+rs.getString(2));

			//Paramaterized statement
			//The performance of the application will be faster if you use PreparedStatement interface because query is compiled only once.
			String sql="insert into emp values(?,?)";
			PreparedStatement pstmnt = conn.prepareStatement(sql);
			pstmnt.setInt(1, 101);
			pstmnt.setString(2, "Ratan");

			//Use executeQuery for select statement.
			int i = pstmnt.executeUpdate();
			System.out.println(i + " records updated.");

			//5. Close connection
			conn.close();

		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
