package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Book;
import dao.DBOperation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		String id = req.getParameter("bookid");
		int bid = Integer.parseInt(id);
		String bname = req.getParameter("bookname");
		String bedition = req.getParameter("bookedition");
		String price = req.getParameter("bookprice");
		int bprice = Integer.parseInt(price);
		DBOperation db = new DBOperation();
		Book b= new Book();
		b.setId(bid);
		b.setName(bname);
		b.setEdition(bedition);
		b.setPrice(bprice);
		boolean bool = db.insert(b);
		if(!bool) {
			pw.print("<p>record saved</p>");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		else {
			pw.print("sorry unable to save");
			req.getRequestDispatcher("index.html").include(req, resp);
		}
		pw.close();
	}
}
