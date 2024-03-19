package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import bean.Book;
import dao.DBOperation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdatedPageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.print("</h1>update book table</h1>");
		String id = req.getParameter("id");
		int bid = Integer.parseInt(id);
		DBOperation db = new DBOperation();
		bean.Book b = db.getById(bid);
	
		pw.print("<form action='UpdateServlet' method='get'>");
		pw.print("<table>");
		pw.print("<tr><td>id</td></tr>");
		pw.print("<tr><td><input type='text' name='id' value='"+b.getId() + "'></td></tr>");
		pw.print("<tr><td>name</td></tr>");
		pw.print("<tr><td><input type='text' name='bname' value='"+b.getName() + "'></td></tr>");
		pw.print("<tr><td>edition</td></tr>");
		pw.print("<tr><td><input type='text' name='edition' value='"+b.getEdition() + "'></td></tr>");
		pw.print("<tr><td>price</td></tr>");
		pw.print("<tr><td><input type='text' name='price' value='"+b.getPrice() + "'></td></tr>");
		pw.print("<tr><td><input type='submit'></td></tr>");
		pw.print("</table></form>");
		pw.close();
	}

}
