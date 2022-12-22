package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtil {
	public static Connection cons;
	
	public static Connection getConnectedToDb() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		cons=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","sah_utk");
		return cons;
	}
	public static void Display() {
		try{
			getConnectedToDb();
			String str="select empno,ename,sal,hiredate"
					+ " from emp where deptno=?,date(hiredate)>? order "
					+ "by sal";
			PreparedStatement pstmt=cons.prepareStatement(str);
			pstmt.setInt(1, 10);
			pstmt.setString(2, "2022-12-12");
			ResultSet rset= pstmt.executeQuery(str);
			while(rset.next()) {
				System.out.printf(" %d  %s %.1f %s ",rset.getInt(1),rset.getString(2),rset.getDouble(3),rset.getString(4));
			}
			rset.close();
		}catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
//	public static void 
}