package hpack;
import java.sql.*;
import java.util.Scanner;
public class SubjectClass {
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
	static void modify1(String query,Connection con,String y) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,y);
			ps.executeUpdate();
		System.out.println();
		}
			catch(SQLException e) {
			e.printStackTrace();
			}
			finally {
				try {
					ps.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Subject";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			String query = "update subject set Name='Advanced Java Programming Lab' where Code='CSL56'";
			String query1 = "delete from subject where Name=?";
			String query2 = "Select * FROM subject";
			System.out.println("Connected to the database");
			Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			modify(stmt,query);
			System.out.println("Enter subject name to delete");
			String y=in.nextLine();
			modify1(query1,conn,y);
			print(stmt,query2);
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
