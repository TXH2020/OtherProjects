package hpack;

import java.util.Scanner;
import java.sql.*;
public class Week4Prog2{	
	public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	String user="root";
	String pass="";
	String dbName="bank_account";
	String url="jdbc:mysql://localhost:3306/";
	Connection con=null;
	Savepoint s1=null;
	try {
	con=DriverManager.getConnection(url+dbName,user,pass);
	package hpack;

import java.util.Scanner;
import java.sql.*;
public class Week4Prog2{	
	public static void main(String args[]) {
	Scanner in=new Scanner(System.in);
	String user="root";
	String pass="";
	String dbName="bank_account";
	String url="jdbc:mysql://localhost:3306/";
	Connection con=null;
	Savepoint s1=null;
	try {
	con=DriverManager.getConnection(url+dbName,user,pass);
	con.setAutoCommit(false);
	String q1="update bank set Balance=40000 where Account_Name='erty'";
	String q2="update bank set Balance=50000j where Account_Name='sfdagdfg'";
	Statement st=con.createStatement();
	st.executeUpdate(q1);
	//con.commit();
	s1=con.setSavepoint();
	st.executeUpdate(q2);
	con.commit();
	con.releaseSavepoint(s1);
	}
	catch(SQLException e) {
		try {
			con.rollback(s1);
			con.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
