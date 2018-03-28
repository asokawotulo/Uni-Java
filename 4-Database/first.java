import java.sql.*;
import java.util.Scanner;

public class first{
	public static int options(Scanner scn){
		System.out.println("[1] Create\n[2] Read\n[3] Update\n[4] Delete\n[5] End");
		return Integer.parseInt(scn.nextLine());
	}

	public static void main(String[] args){
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Java?useSSL=false", "root", "")){
			Scanner scn = new Scanner(System.in);
			PreparedStatement pStmt;
			Statement stmt = conn.createStatement();
			String name;
			String query;
			int id;
			int option = 0;

			while(option != 5){
				switch(option){
					case 1:
						query = "INSERT INTO Java (name) VALUES(?)";
						pStmt = conn.prepareStatement(query);

						System.out.print("Name: ");
						name = scn.nextLine();
						pStmt.setString(1, name);

						pStmt.executeUpdate();

						break;
					case 2:
						query = "SELECT * FROM Java";
						ResultSet rset = stmt.executeQuery(query);

						System.out.println("==========================");
						System.out.println("ID  | Name");
						while(rset.next()) {
							id = rset.getInt("id");
							name = rset.getString("name");
							System.out.printf("%-3d | %-20s \n", id, name);
						}
						System.out.println("==========================");

						break;
					case 3:
						query = "UPDATE Java SET name = ? WHERE id = ?";
						pStmt = conn.prepareStatement(query);

						System.out.print("ID: ");
						id = Integer.parseInt(scn.nextLine());
						System.out.print("Name: ");
						name = scn.nextLine();

						pStmt.setString(1, name);
						pStmt.setInt(2, id);
						pStmt.executeUpdate();

						break;
					case 4:
						query = "DELETE FROM Java WHERE id = ?";
						pStmt = conn.prepareStatement(query);

						System.out.print("ID: ");
						id = Integer.parseInt(scn.nextLine());

						pStmt.setInt(1, id);
						pStmt.executeUpdate();
						break;
				}
				option = options(scn);
			}
		} catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}