package com.jsp.controller;

import com.jsp.dao.StudentDao;

public class TestDelete {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println(studentDao.deleteStudentById(4));
	}
}
