package com.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.dto.Student;
import com.jsp.helper.HelperClass;

public class StudentDao {
	HelperClass helperclass = new HelperClass();
	// to save student
	Connection connection = null;
	private List<Student> a1;

	// GetId
	public Student getStudentById(int id) {

		connection = helperclass.getConnection();

		String sql = "SELECT * FROM student WHERE id=?";

		Student student2 = new Student();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, id);

//execute the statement

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id2 = resultSet.getInt(1);

				String name = resultSet.getString(2);

				String email = resultSet.getString(3);

				student2.setId(id2);

				student2.setName(name);

				student2.setEmail(email);

			}

		} catch (SQLException e) {

// TODO Auto-generated catch block

			e.printStackTrace();

		}

		finally {

			try {

				connection.close();

			} catch (SQLException e) {

// TODO Auto-generated catch block

				e.printStackTrace();

			}

		}

		return student2;

	}

//===========================================================================================================================================================
//Update	  
	public boolean updateStudentById(int id, String email) {
		connection = helperclass.getConnection();
		// create connection
		String sql = "UPDATE student set email=? WHERE Id=?";
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setString(1, email);
			preparedstatement.setInt(2, id);

			// execute statement
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;

	}

//=============================================================================================================================================================
	// getAll
	public List<Student> getAllStudent() {
		connection = helperclass.getConnection();
		String sql = "SELECT * FROM student";
		ArrayList<Student> al = null;

		try {

			PreparedStatement preparedstatement = connection.prepareStatement(sql);

			// execute the statement
			ResultSet resultset = preparedstatement.executeQuery();
			al = new ArrayList<>();
			while (resultset.next()) {
				int id = resultset.getInt(1);
				String name = resultset.getString(2);
				String email = resultset.getString(3);
				Student s = new Student();
				s.setId(id);
				s.setName(name);
				s.setEmail(email);
				al.add(s);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return al;

	}

	// =============================================================================================================================================================
	// delete
	public boolean deleteStudentById(int id) {

		connection = helperclass.getConnection();
		String sql = "DELETE From student WHERE id=?";
		boolean res = false;
		try {
			PreparedStatement preparedstatement = connection.prepareStatement(sql);
			preparedstatement.setInt(1, id);

			// execute
			int res2 = preparedstatement.executeUpdate();
			if (res2 > 0) {
				res = true;
			} else {
				res = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

// ================================================================================================================================================================
	public Student saveStudent(Student student) {
		Connection connection = helperclass.getConnection();

		String sql = "INSERT INTO student values(?,?,?)";

		// create statement

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getEmail());

			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// execute the statement

		return student;
	}

//===============================================================================================================================================================
	public void addMultipleStudents(List<Student> students) {
		connection = helperclass.getConnection();

		String sql = "INSERT INTO student VALUES(?,?,?)";

		// create statement
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);

			// execute statement
			for (Student s : students) {
				preparedStatement.setInt(1, s.getId());
				preparedStatement.setString(2, s.getName());
				preparedStatement.setString(3, s.getEmail());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			System.out.println("All Good");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
