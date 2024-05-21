package hpack;
import java.sql.*;
public class Week2prog2 {
static void print(Statement stmt,String query) {
		String f1,f2,f3,f4,f5;
		try {
			ResultSet rs = stmt.executeQuery(query);
		while (rs.next())
		{
			f1 = rs.getString(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			f4 = rs.getString(4);
			f5 = rs.getString(5);
			System.out.println(f1+"  "+f2+" "+f3+" "+f4+" "+f5);	
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
		String dbName = "Employee";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			String query = "Select * FROM employee";
			String query1 = "Select * FROM employee where Project='Web Development'";
			String query2 = "Select * FROM employee where Project='Web Development'and Salary>75000";
			String query3 = "Select * FROM employee where Salary<50000";
			System.out.println("Connected to the database");
			Statement stmt = (Statement) conn.createStatement();
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
		}}}
