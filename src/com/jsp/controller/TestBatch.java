package com.jsp.controller;

import java.util.ArrayList;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class TestBatch {
	public static void main(String[] args) {

		StudentDao studentDao = new StudentDao();

		ArrayList<Student> a1 = new ArrayList<>();

		Student s1 = new Student();
		s1.setId(8);
		s1.setName("Abhi");
		s1.setEmail("Abhi@gmail.com");

		Student s2 = new Student();
		s2.setId(9);
		s2.setName("nitin");
		s2.setEmail("Nitin@gmail.com");

		Student s3 = new Student();
		s3.setId(10);
		s3.setName("vikram");
		s3.setEmail("vikram@gmail.com");

		a1.add(s1);
		a1.add(s2);
		a1.add(s3);

		studentDao.addMultipleStudents(a1);

	}
}
