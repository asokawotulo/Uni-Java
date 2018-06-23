package packages;
import java.sql.*;
import java.util.Scanner;

public class Database{
	private Connection conn;
	private Statement stm;
	private PreparedStatement pStm;

	public Database(String db_name, String db_username, String db_password, String db_port){
		try{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:"+db_port+"/"+db_name+"?useSSL=false", db_username, db_password);
			stm = conn.createStatement();
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	public void describeTable(String table_name){
		try{
			ResultSet rs = stm.executeQuery("select * from "+table_name);
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("No. of columns : " + rsmd.getColumnCount());
			for(int i = 1; i < rsmd.getColumnCount()+1; i++){
				System.out.println("Name of column " + i + ": " + rsmd.getColumnName(i));
				System.out.println("Type of column " + i + ": " + rsmd.getColumnTypeName(i));
				System.out.println("Size of column " + i + ": " + rsmd.getColumnDisplaySize(i));
				System.out.println();
			}
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
	public void printContent(String table_name){
		try{
			ResultSet rs = stm.executeQuery("select * from " + table_name);
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("==========================");
			while(rs.next()) {
				for(int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.printf("%-15s", rsmd.getColumnName(i).replaceAll("_", " "));
				}
				System.out.println();
				for(int i = 1; i < rsmd.getColumnCount()+1; i++){
					System.out.printf("%-15s", rs.getString(i));
				}
				System.out.println();
			}
			System.out.println("==========================");
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
	}
}