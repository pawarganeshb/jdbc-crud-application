
package com.student.management.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

	static boolean flag = false;

	public static boolean insertData(Student st) {

		try {
			Connection con = ConnectionProvider.createConnection();
			String insert = "INSERT INTO students (sname, sphone, scity) VALUES (?, ?, ?)";

			PreparedStatement statement = con.prepareStatement(insert);

			statement.setString(1, st.getStudentName());
			statement.setString(2, st.getStudentPhone());
			statement.setString(3, st.getStudentCity());

			statement.executeUpdate();
			flag = true;

			con.close(); // Close the connection after use

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int usrID) {
		try {
			Connection con = ConnectionProvider.createConnection();
			String delete = "DELETE FROM students WHERE sid = ?";

			PreparedStatement statement = con.prepareStatement(delete);

			statement.setInt(1, usrID);

			statement.executeUpdate();
			flag = true;

			con.close(); // Close the connection after use

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void showDetails() {
		try {
			Connection con = ConnectionProvider.createConnection();
			String show = "SELECT *FROM students";

			Statement statement = con.createStatement();

			ResultSet set = statement.executeQuery(show);

			while (set.next()) {

				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("ID: " + id);
				System.out.println("Name: " + name);
				System.out.println("Phone: " + phone);
				System.out.println("City: " + city);
				System.out.println("===========================");

			}
			flag = true;

			con.close(); // Close the connection after use

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static boolean updateStudent(int sid, Student updatedStudent) {

	    try {
	        Connection con = ConnectionProvider.createConnection();
	        String update = "UPDATE students SET sname = ?, sphone = ?, scity = ? WHERE sid = ?";

	        PreparedStatement statement = con.prepareStatement(update);

	        statement.setString(1, updatedStudent.getStudentName());
	        statement.setString(2, updatedStudent.getStudentPhone());
	        statement.setString(3, updatedStudent.getStudentCity());
	        statement.setInt(4, sid);

	        int rowsUpdated = statement.executeUpdate();

	        if (rowsUpdated > 0) {
	            flag = true;
	        }

	        con.close(); // Close the connection after use

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}

}
