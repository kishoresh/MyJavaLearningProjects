package com.jdbc.connection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
/*
 * Note that mysql JDBC driver jar file is added to the Project Libraries.
 */
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.PreparedStatement;

import sun.util.locale.provider.AvailableLanguageTags;

public class TestJDBC {
	private static Connection conn;
	private static String insertBook = "insert into books(bookid, book_name, category, author, price, image, content, date_pub) values(?,?,?,?,?,?,?,?)";
	private static String dt = "2017-11-12 13:20:23";
	
	//Database Connection and DriverManager
	public static Connection getDBConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");      //useSSL=false is added to the conn string as i am getting an warning.
			try{
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?useSSL=false","kishores", "KANtu1234");
				//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false","kishores","KANtu123");
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}catch (ClassNotFoundException e) {
			System.out.println("Driver not registered. Exception : " + e.getMessage());
		}
		return con;
	}
	
	//DatabaseMetaData Interface : Returns the DB related informtion.
	public static void displayDBInfo(){
		try{
			//Database info from the Connection object
			java.sql.DatabaseMetaData dbmd = conn.getMetaData();
			
			System.out.println("Database Information");
			System.out.println("Driver Name : " + dbmd.getDriverName());
			System.out.println("User Name : "+ dbmd.getUserName());
			System.out.println("Database Product name : " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version : " + dbmd.getDatabaseProductVersion());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//ResultSetMetaData Interface : Returns the metadata info related to the Resulset.
	public static void displayResultSetInfo(){
		try{
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from books");
			
			//Use ResultSetMetaData to get the info of the resultset table
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("ResultSetMetaData Information");			
			System.out.println("Table name : "+rsmd.getTableName(1));
			System.out.println("Total No of columns : "+rsmd.getColumnCount());
			System.out.println("Column[1] Name : " + rsmd.getColumnName(1));
			System.out.println("Column[1] Type : "+ rsmd.getColumnTypeName(1));
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Using Statement interface. Display all the records.
	public static void displayResultSetDataUsingStatement(){
		try{			
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from books where bookid = 124");
			while (rs.next()){
				System.out.println("Book ID : "+rs.getString(1) + " Name : " + rs.getString(2)+" Category :" + rs.getString(3)
				  +" Author : "+rs.getString(4)+" Price : "+rs.getDouble(5) + " Pub Dt : " + rs.getTimestamp(9));

				//Reading a Blob field and saving in a file
				java.sql.Blob b = rs.getBlob(6);
				byte barr[] = b.getBytes(1, (int) b.length());
				FileOutputStream fo = new FileOutputStream("D:\\Test.jpg");
				fo.write(barr);
				fo.close();

				//Reading CLOB field and saving in file
				Clob clb = rs.getClob(7);				
				Reader reader = clb.getCharacterStream();
				FileWriter fw = new FileWriter("D:\\Test.txt");
				int j;
				while ((j=reader.read())!= -1){
					fw.write((char)j); 
				}
				fw.close();				
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (FileNotFoundException ex){
			System.out.println(ex.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Using PreparedStatement interface, insert data to table
	public static void insertRecord(FileInputStream fis, FileReader fr){
		try{		
			Timestamp timestamp = Timestamp.valueOf(dt);   //Convert the string to Timestamp		
			java.sql.PreparedStatement ps = conn.prepareStatement(insertBook);
			//Below is commented as instead we are taking inputs from user in the next code.
			ps.setInt(1, 124);
			ps.setString(2, "Mastering C++-3");
			ps.setString(3, "Technology");
			ps.setString(4, "Kishore Sharma");
			ps.setDouble(5, 230.90);
			ps.setBinaryStream(6, fis, fis.available());
			ps.setCharacterStream(7, fr);
			ps.setTimestamp(8, timestamp);

			int n = ps.executeUpdate();
			System.out.println(n + " No of records inserted");	
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//Take input from user and insert into table.
	public static void insertRecordWithUserInput(FileInputStream fis, FileReader fr){
		try{		
			//Date date = Date.valueOf(dt);			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			do{
				System.out.println("Want to Enter Book Details (n/y) : ");
				String cont = br.readLine();
				if (cont.startsWith("n")){ break;}

				java.sql.PreparedStatement ps = conn.prepareStatement(insertBook);

				System.out.println("Book ID : ");
				int id = Integer.parseInt(br.readLine());
				System.out.println("Book Name : ");
				String name = br.readLine();
				System.out.println("Book Category : ");
				String cat = br.readLine();
				System.out.println("Author : ");
				String aut = br.readLine();
				System.out.println("Price : ");
				Double price = Double.parseDouble(br.readLine());
				System.out.println("Date of Publish : ");
				Timestamp timestamp = Timestamp.valueOf(br.readLine());

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setString(3, cat);
				ps.setString(4, aut);
				ps.setDouble(5, price);
				//Setting the Blob & CLOB parameter
				ps.setBinaryStream(6, fis, fis.available());
				ps.setCharacterStream(7, fr);
				ps.setTimestamp(8, timestamp);
				
				int i = ps.executeUpdate();
				System.out.println(i + " No of records inserted");		

				System.out.println("Do you want to continue (y/n) ? ");
				String c = br.readLine();
				if (c.startsWith("n")){
					break;
				}				
			}while (true);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		try{
			conn = getDBConnection();
			displayDBInfo();
			
			FileInputStream fi = new FileInputStream("C:\\Users\\kishores\\Pictures\\P_20170818_161007.jpg");
			FileReader fr = new FileReader("C:\\Users\\kishores\\Documents\\21stAug2017.txt");
					
			//insertRecord(fi, fr);
			insertRecordWithUserInput(fi, fr);			

			displayResultSetDataUsingStatement();
			displayResultSetInfo();
			
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
}
