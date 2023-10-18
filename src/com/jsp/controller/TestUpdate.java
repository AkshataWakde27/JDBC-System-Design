package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestUpdate {
	public static void main(String[] args) {
		StudentDao student = new StudentDao();
		String email = "abc@gmail.com";
		boolean b = student.updateStudentById(6, email);
		System.out.println(b);

	}
}
