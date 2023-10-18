package com.jsp.controller;

import com.jsp.dao.StudentDao;

import com.jsp.dto.Student;

import com.mysql.cj.protocol.SocksProxySocketFactory;

public class TestGetId {

	public static void main(String[] args) {

		StudentDao studentdao = new StudentDao();

		Student s = studentdao.getStudentById(3);

		System.out.println(s.getId());

	}

}
