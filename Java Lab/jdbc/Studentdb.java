package hpack;

import java.sql.*;
public class Studentdb {
	static void print(Statement stmt,String query) {
		
		String f1,f2,f3,f4;
		try {
			ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			f1 = rs.getString(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			f4 = rs.getString(4);
			System.out.println(f1+"  "+f2+" "+f3+" "+f4);	
		} //end while
		System.out.println();
		}
			catch(SQLException e) {
			e.printStackTrace();
			}
			
			catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Student";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = DriverManager.getConnection(url+dbName,userName,password);
			String query = "Select * FROM student";
			String query1 = "Select * FROM student where Semester=5";
			String query2 = "Select * FROM student where Semester=5 and CGPA>8";
			String query3 = "Select * FROM student where CGPA>8";
			System.out.println("Connected to the database");
			Statement stmt = conn.createStatement();
			print(stmt,query);
			print(stmt,query1);
			print(stmt,query2);
			print(stmt,query3);
			conn.close();
			System.out.println("Disconnected from database");
			} //end try
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			}

			catch(SQLException e) {
			e.printStackTrace();
			}
			
			catch (Exception e) {
			e.printStackTrace();
		}
	}

}
