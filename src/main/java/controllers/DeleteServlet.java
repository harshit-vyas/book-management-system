package controllers;


import java.io.IOException;
import java.io.PrintWriter;

import dao.DBOperation;
import bean.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		System.out.println("delete servlet called");
		String id = req.getParameter("id");
		int bid = Integer.parseInt(id);
		DBOperation db = new DBOperation();
		System.out.println("delete servlet called");
		boolean bool = db.delete(bid);
		if(!bool) {
			pw.println("</p>record deleted</p>");
			resp.sendRedirect("ViewServlet");
		}
		else {
			pw.print("<p>record not deleted</p>");
		}
		pw.close();
	}

	
}
