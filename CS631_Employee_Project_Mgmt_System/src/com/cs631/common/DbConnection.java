package com.cs631.common;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	Connection conn=null;
	public Connection dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/cs631DB?useUnicode=true&characterEncoding=utf8","root", "rootroot");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public static void main(String[] args) {
		DbConnection dbConnection=new DbConnection();
		Connection con=dbConnection.dbConnect();
		if(con!=null) {
			System.out.println("Connection established successfully.");
		}else {
			System.out.println("Connection not established yet.");
		}
		
	} 
}