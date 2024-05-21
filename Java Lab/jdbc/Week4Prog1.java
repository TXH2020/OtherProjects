package hpack;

import java.util.Scanner;
import java.sql.*;
public class Week4Prog1{
	static void print(ResultSet rs) {
		try {
			String f[]=new String[4];
			while(rs.next()) {
				for(int i=0;i<4;i++)
					f[i]=rs.getString(i+1);
				System.out.println(f[0]+"\t"+f[1]+"\t"+f[2]+"\t"+f[3]);
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
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
		ps.setDouble(4, Double.parseDouble(info[3]));
		ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
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
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Customer";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");
			Statement stmt = conn.createStatement();
			String query="insert into customer (Id,Name,Type_of_Customer,Amount_Spent) values (?,?,?,?)";
			String info[]=new String[4];
			System.out.println("Enter Id,Name,Type_of_Customer,Amount_Spent");
			info[0]=Integer.toString(in.nextInt());
			in.nextLine();
			info[1]=in.nextLine();
			info[2]=in.nextLine();
			info[3]=Double.toString(in.nextDouble());
			modify1(query,conn,info);
			String query1="Select * from customer";
			ResultSet rs = stmt.executeQuery(query1);
			print(rs);
			System.out.println("Customer database metadata is:");
			System.out.println(conn.getMetaData());
			System.out.println("ResultSet Metadata is:");
			System.out.println(rs.getMetaData());
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