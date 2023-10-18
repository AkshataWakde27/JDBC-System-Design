package com.jsp.controller;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;
import com.mysql.cj.protocol.SocksProxySocketFactory;

public class TestSave {
	public static void main(String[] args) {
		Student student = new Student();
		student.setId(7);
		student.setName("abc");
		student.setEmail("xyz@gmail.com");

		StudentDao studentDao = new StudentDao();
		Student s = studentDao.saveStudent(student);
		System.out.print(s.getName() + " Save Sucessfully");
	}

}
