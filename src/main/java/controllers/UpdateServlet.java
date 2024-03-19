package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Book;
import dao.DBOperation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw= resp.getWriter();
		String id = req.getParameter("id");
		int bid = Integer.parseInt(id);
		String bname = req.getParameter("bname");
		String bedition = req.getParameter("edition");
		String price = req.getParameter("price");
		int bprice = Integer.parseInt(price);
		Book b= new Book();
		DBOperation db = new DBOperation(); 
		b.setId(bid);
		b.setName(bname);
		b.setEdition(bedition);
		b.setPrice(bprice);
		boolean bool = db.update(b);
		if(!bool) {
			pw.print("<p>record updated</p>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		else {
			pw.print("<p>record not updated</p>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
	}
	
}
