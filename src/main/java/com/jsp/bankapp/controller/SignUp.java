package com.jsp.bankapp.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.jsp.bankapp.dao.UserDao;
import com.jsp.bankapp.entity.Address;
import com.jsp.bankapp.entity.User;
import com.jsp.bankapp.util.Role;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class SignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDao dao = null;
		String name=req.getParameter("name");
		String email = req.getParameter("email");
		long phone = Long.parseLong(req.getParameter("phone"));
		LocalDate dob = LocalDate.parse(req.getParameter("dob"));
		String role = req.getParameter("role");
		Role role2=Role.valueOf(role);
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String door_no = req.getParameter("door_no");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pin = req.getParameter("pin");
		User user = null;
		try {
			user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhone(phone);
			user.setDob(dob);
			user.setRole(role2);
			user.setPassword(password);
			
			Address userAddress=new Address();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message=null;
		dao.saveUser(user);
		User saveUser=dao.saveUser(user);
		if(saveUser!=null) {
			resp.sendRedirect("index.jsp");
		}else {
			message="data not saved";
		}
	}
}
