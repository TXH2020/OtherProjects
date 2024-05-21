package hpack;
import java.sql.*;
import java.util.Scanner;
public class Week3Prog1{
	static void print(ResultSet rs) {
		String f1,f2,f3,f4,f5;
		try {
		while (rs.next()){
			f1 = rs.getString(1);
			f2 = rs.getString(2);
			f3 = rs.getString(3);
			f4 = rs.getString(4);
			f5 = rs.getString(5);
			System.out.println(f1+"  "+f2+" "+f3+" "+f4+" "+f5);	} //end while
		System.out.println();}
			catch(SQLException e) {
			e.printStackTrace();}
			catch (Exception e) {
			e.printStackTrace();}}
	static void modify1(String query,Connection con,int id,String n) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2, n);
			ResultSet rs=ps.executeQuery();
			print(rs);}
			catch(SQLException e) {
			e.printStackTrace();}
			finally {
				try {
					ps.close();}
				catch(Exception e) {
					e.printStackTrace();}}}
	static void modify2(String query,Connection con,String info[]) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(info[0]));
			ps.setString(2,info[1]);
			ps.setInt(3,Integer.parseInt(info[2]));
			ps.setString(4,info[3]);
			ps.setInt(5,Integer.parseInt(info[4]));
			ps.execute();
		System.out.println();}
			catch(SQLException e) {
			e.printStackTrace();}
			finally {
				try {
					ps.close();}
				catch(Exception e) {
					e.printStackTrace();}}}
	static void modify(String query,Connection con,int year) {
		PreparedStatement ps=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1,year);
			ResultSet rs=ps.executeQuery();
			print(rs);
		System.out.println();}
			catch(SQLException e) {
			e.printStackTrace();}
			finally {
				try {
					ps.close();}
				catch(Exception e) {
					e.printStackTrace();}}}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "Department";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String password = "";
		try {
			Class.forName(driver).getDeclaredConstructor().newInstance();
	conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
			String query = "Select * FROM department";
			String query1 = "select * from department where Year_Established=?";
			String query2 = "select * from department where Dept_ID=? and Name=?";
			String query3 = "insert into department (Dept_ID,Name,Year_Established,Head_Name,No_of_Employees) values("
					+ "?,?,?,?,?)";
			String query4 = "Select * FROM department";
			System.out.println("Connected to the database");
			Statement stmt = (Statement) conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			print(rs);
			System.out.println("Enter year of existence for search");
			int year=in.nextInt();
			modify(query1,conn,year);
			System.out.println("Enter Department ID and Name for search");
			int id=in.nextInt();
			in.nextLine();
			String name=in.nextLine();
			modify1(query2,conn,id,name);
			String info[]=new String[5];
			System.out.println("Enter Dept_ID,Name,Year_Established,Head_Name,No_of_Employees"
					+ "to insert into the database");
			info[0]=in.nextLine();
			info[1]=in.nextLine();
			info[2]=in.nextLine();
			info[3]=in.nextLine();
			info[4]=in.nextLine();
			modify2(query3,conn,info);
			ResultSet rs1 = stmt.executeQuery(query4);
			print(rs1);
			conn.close();
			System.out.println("Disconnected from database");} //end try
		catch(ClassNotFoundException e) {
			e.printStackTrace();}
			catch(SQLException e) {
			e.printStackTrace();}
			catch (Exception e) {
			e.printStackTrace();
		}}}