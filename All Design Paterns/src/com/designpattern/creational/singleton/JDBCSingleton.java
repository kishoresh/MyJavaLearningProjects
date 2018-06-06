package com.designpattern.creational.singleton;

/* Singleton Design Pattern :-   URL :-http://www.javatpoint.com/singleton-design-pattern-in-java
 * Define a class that has only one instance and provides a global point of access to it.
 *
 * 2 forms of singleton design pattern :-
 * Early Instantiation : creation of instance at load time.
 * Lazy Instantiation  : creation of instance when required.
 *
 * Advantage :-
 * Saves memory as only single instance of object can be reused again and again.
 *
 * Usage :-
 * Mostly used in multi-threaded and database applications.
 * It is used in logging, caching, thread pools, configuration settings etc.
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

class JDBCSingleton {
  //static member holds only one instance of the JDBCSingleton class.
  private static JDBCSingleton jdbc;

  //JDBCSingleton prevents the instantiation from any other class.
  private JDBCSingleton(){

  }

  //Providing gloabal point of access.
  public static JDBCSingleton getInstance(){
	  if (jdbc == null){
		  jdbc = new JDBCSingleton();
	  }
	  return jdbc;
  }

  private Connection getConnection() throws ClassNotFoundException, SQLException{
	  Connection conn = null;
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  conn = DriverManager.getConnection(
			  "jdbc:oracle:thin:@192.168.1.17:1522:IND11G17","DROIDS_XLCore_ORA_16AUGUST","password");

	  return conn;
  }

  public int insertData(int id, String name, String pwd) throws SQLException{
	  int RecordCounter =0;
	  Connection conn = null;
	  PreparedStatement ps = null;

	  try{
		  conn = this.getConnection();
		  ps= conn.prepareStatement("insert into TEST_TABLE values(?,?,?)");
		  ps.setInt(1, id);
		  ps.setString(2, name);
		  ps.setString(3, pwd);
		  RecordCounter = ps.executeUpdate();
	  }catch (Exception e){e.printStackTrace();}finally{
		  if (ps != null){
			  ps.close();
		  }
		  if (conn != null){
			  conn.close();
		  }
	  }
	  return RecordCounter;
  }

  public void viewData(int uid) throws SQLException{
	  Connection conn = null;
	  PreparedStatement ps = null;
	  ResultSet rs = null;

	  try
	  {
		  conn = this.getConnection();

		  ps = conn.prepareStatement("Select * from TEST_TABLE where user_id = ?");
		  ps.setInt(1, uid);
		  rs = ps.executeQuery();

		  while (rs.next()) {
			  System.out.println("UID= "+rs.getInt(1) + "  Name= "+rs.getString(2)+"  Pwd= "+rs.getString(3));
		  }

	  }catch (Exception e) {System.out.print(e);}
	  finally{
		  if (rs != null){
			  rs.close();
		  }if (ps !=null){
			  ps.close();
		  }if (conn !=null){
			  conn.close();
		  }
	  }
  }
}
