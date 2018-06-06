package com.designpattern.structural.facade.simplified;
/*
 * we have an application with set of interfaces to use MS Sql/Oracle DB and to generate different types of reports, 
 * such as Word report & PDF report.
 * 
 * Here we define a higher level interface (FacadeHelper) which makes the subsystem's (SQLHelper, OracleHelper) easier to use.
 */

import java.sql.Connection;

interface Helper{
	public Connection getDBConnection();
	public void generatePDFReport(String tableName, Connection con);
	public void generateWordReport(String tableName, Connection con);
}

class SQLHelper implements Helper{
    @Override
	public Connection getDBConnection() {
		// get conn
		return null;
	}    
    @Override
    public void generateWordReport(String tableName, Connection con) {
    	// TODO Auto-generated method stub    	
    }    
    @Override
    public void generatePDFReport(String tableName, Connection con) {
    	// TODO Auto-generated method stub    	
    }
}

class OracleHelper implements Helper{
	@Override
	public Connection getDBConnection() {
		// TODO Auto-generated method stub
		return null;
	}	
	@Override
	public void generateWordReport(String tableName, Connection con) {
		// TODO Auto-generated method stub		
	}	
	@Override
	public void generatePDFReport(String tableName, Connection con) {
		// TODO Auto-generated method stub		
	}
}

public class FacadeHelper {

	public static enum DBType{
		SQL, ORACLE;
	}
	public static enum ReportType{
		MSWORD, PDF;
	}
	
	public static void generateReport(DBType dbType, ReportType reportType, String tablename){
		Connection con = null;
		switch (dbType) {
		case ORACLE:
			OracleHelper oraHelper = new OracleHelper();
			con = oraHelper.getDBConnection();
			switch (reportType) {
			case MSWORD:
				oraHelper.generateWordReport(tablename, con);
				break;
			case PDF:
				oraHelper.generatePDFReport(tablename, con);
				break;
			}		
			break;
		case SQL:
			SQLHelper sqlHelper = new SQLHelper();
			con = sqlHelper.getDBConnection();
			switch (reportType) {
			case MSWORD:
				sqlHelper.generateWordReport(tablename, con);
				break;
			case PDF:
				sqlHelper.generatePDFReport(tablename, con);
				break;
			}		
			break;
		}
	}
	
	public static void main(String[] args) {
		String tableName = "EMPLOYEE";
		// Without using FacadeHelper
		OracleHelper oraHelper = new OracleHelper();
		Connection con = oraHelper.getDBConnection();
		oraHelper.generatePDFReport(tableName, con);
		oraHelper.generateWordReport(tableName, con);
		
		SQLHelper sqlHelper = new SQLHelper();
		Connection con2 = sqlHelper.getDBConnection();
		sqlHelper.generatePDFReport(tableName, con2);
		sqlHelper.generateWordReport(tableName, con2);
		
		//Using the FacadeHelper. This looks more clean.
		FacadeHelper.generateReport(DBType.ORACLE, ReportType.MSWORD, tableName);
		FacadeHelper.generateReport(DBType.SQL, ReportType.PDF, tableName);
	}

}
