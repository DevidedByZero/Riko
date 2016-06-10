package orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBController {

	private String name, pass;
	Connection connection;

	public DBController(String name, String pass){

		this.name = name;
		this.pass = pass;

		init();

	}

	private void init() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection = null;
		try {
			connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/postgres","michael", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("CONNECTED");
	}

	public boolean insert(){

		Statement stmt = null;
		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		String sql1 = "INSERT INTO customer (f_name,l_name,phone) "
				+ "VALUES ('Brian', 'Cohen', '0541234567');";

		String sql2 = "INSERT INTO rik_order (description, phone, s_id)"
				+ "VALUES ('Outdoor bag blue', '0541234567', 999);";


		try {
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public void select() throws SQLException{
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery( "SELECT * FROM rik_order NATURAL JOIN customer ;" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while ( rs.next() ) {
			System.out.println(rs.getString(1));
		}
		rs.close();
		stmt.close();
		connection.close();

	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
