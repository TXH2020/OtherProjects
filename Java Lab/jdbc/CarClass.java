package hpack;
import java.sql.*;
public class CarClass {
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
	static void modify(Statement stmt,String query) {
		try {
			 stmt.executeUpdate(query);
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
		String dbName = "Car";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			String query = "Select * FROM car";
			String query1 = "insert into car (Model,Company,Price,Year) values ('Innova','Toyota',300000,2010)";
			String query2 = "delete FROM car where Model='ABC'and Year=2010";
			String query3 = "update car set Price=125000 where Price=150000";
			System.out.println("Connected to the database");
			Statement stmt = (Statement) conn.createStatement();
			print(stmt,query);
			modify(stmt,query1);
			print(stmt,query);
			modify(stmt,query2);
			modify(stmt,query3);
			print(stmt,query);
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
