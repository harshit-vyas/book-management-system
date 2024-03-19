package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Book;


public class DBOperation {
	String url = "jdbc:mysql://localhost:3306/demo?autoReconnect=true&useSSL=false";
	String id = "root";
	String pass = "ROOT";
	Connection con=null;
	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public boolean insert(Book b) {
		boolean bool=true;
		
		try {
			connect();
			PreparedStatement ps = con.prepareStatement("insert into book value(?,?,?,?)");
			ps.setInt(1, b.getId());
			ps.setString(2, b.getName());
			ps.setString(3, b.getEdition());
			ps.setInt(4, b.getPrice());
			bool = ps.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
	
	public boolean delete(int id) {
		System.out.println("delete method called");
		boolean b = true; 
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement("delete from book where id = ?");
			ps.setInt(1, id);
			b= ps.execute();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("delete method end");
		return b;
	}
	
	public boolean update(Book b) {
		boolean bool=true;
		try {
			connect();
			System.out.println("update method 1");
			PreparedStatement ps  = con.prepareStatement("update book set id=?, name=?, edition=?, price=? where id=?");
			ps.setInt(1, b.getId());	
			ps.setString(2, b.getName());
			ps.setString(3, b.getEdition());
			ps.setInt(4, b.getPrice());
			ps.setInt(5, b.getId());
			System.out.println("update method 2");
			bool=ps.execute();
			System.out.println("update method 3");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("update method end");
		return bool;
	}
	
	public Book getById(int id) {
		Book b = new Book();
		try {
			connect();
			PreparedStatement ps = con.prepareStatement("select *from book where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setEdition(rs.getString(3));
				b.setPrice(rs.getInt(4));
			}
			con.close();
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return b;
	}
	
	public  List<Book> getAllRecord() {
		List<Book> list = new ArrayList<Book>();
		try {
			connect();
			PreparedStatement ps= con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b= new Book();
				b.setId(rs.getInt(1));
				b.setName(rs.getString(2));
				b.setEdition(rs.getString(3));
				b.setPrice(rs.getInt(4));
				list.add(b);			
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
}
