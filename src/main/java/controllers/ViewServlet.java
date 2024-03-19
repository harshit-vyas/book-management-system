package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;


import org.apache.jasper.tagplugins.jstl.core.ForEach;

import bean.Book;
import dao.DBOperation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		DBOperation db = new DBOperation();
		List<Book> list= db.getAllRecord();
		pw.print("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "  <head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <title>Bootstrap demo</title>\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\r\n"
				+ "  </head><body>");
		
		pw.print("<h2><a href='index.html'>Add More</a></h2>");
		pw.print("<table class='table table-dark table-striped-columns'");
		pw.print("<tr><th>bookid</th>"
				+ "<th scope='col'>bookname</th>"
				+"<th scope='col'>bookedition</th>"
				+"<th scope='col'>bookprice</th>"
				+"<th scope='col'>update</th>"
				+"<th scope='col'>delete</th>"
				+"</tr>");
		for(Book lt : list) {
			pw.print("<tr><td>"+lt.getId()+"</td><td>"+lt.getName()+
					"</td><td>"+lt.getEdition()+"</td><td>"+lt.getPrice()+
					"</td><td><a href='DeleteServlet?id="
					+ lt.getId()+"'>delete</a></td><td><a href='UpdatedPageServlet?id="
							+ lt.getId()+"'>update</a></td>>");
			
		}
		pw.print(" <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "  </body>\r\n"
				+ "</html> ");
		pw.close();
	}
	
}
