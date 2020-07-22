package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveData {

	public static void main(String args[]) {
		System.out.println("Starting data retrieval");

		try {

			getCustomerDetails();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void getCustomerDetails() throws SQLException {

		Connection conn = DatabaseConnection.getConnection();

		PreparedStatement preStmt = conn.prepareStatement("SELECT * FROM customer");

		ResultSet rs = preStmt.executeQuery();
		int id;
		String firstName = null;
		String lastName = null;

		while (rs.next()) {
			id = rs.getInt("id");
			firstName = rs.getString("first_name");
			lastName = rs.getString("last_name");

			System.out.println("ID : " + id + ", First Name : " + firstName + ", Last Name : " + lastName);

		}

	}

}
