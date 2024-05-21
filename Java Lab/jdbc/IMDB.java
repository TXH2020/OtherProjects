package hpack;
import java.sql.*;
import java.util.Scanner;
public class IMDB {
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
	static void modify1(String query,Connection con,String info[]) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(info[0]));
			ps.setString(2,info[1]);
			ps.setString(3,info[2]);
			ps.setFloat(4,Float.parseFloat(info[3]));
			ps.setInt(5,Integer.parseInt(info[4]));
			ps.execute();
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
		String dbName = "Movies";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			String query = "Select * FROM movie";
			String query1 = "insert into movie (ID,Movie_Name,Genre,IMDB_Rating,Year) values (?,?,?,?,?)";
			String query2 = "delete FROM movie where IMDB_Rating<5";
			String query3 = "update movie set Genre='Sci-Fi' where ID=10";
			System.out.println("Connected to the database");
			Statement stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			print(stmt,query);
			ResultSet rs = stmt.executeQuery(query);
			rs.absolute(5);
			String f1,f2,f3,f4,f5;
			f1 = rs.getString(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			f4 = rs.getString(4);
			f5 = rs.getString(5);
			System.out.println(f1+"  "+f2+" "+f3+" "+f4+" "+f5+"\n");
			String info[]=new String[5];
			System.out.println("Enter movie ID,Movie_Name,Genre,IMDB_Rating,Year");
			info[0]=in.nextLine();
			info[1]=in.nextLine();
			info[2]=in.nextLine();
			info[3]=in.nextLine();
			info[4]=in.nextLine();
			modify1(query1,conn,info);
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
