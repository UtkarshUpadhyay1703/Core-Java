package com.tester;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DbUtil;

public class TestSql {

	public static void main(String[] args){
		//1.Eatablishing the Connection
		try(Connection con=DbUtil.getConnectedToDb()){
			//2.Query
			String sql="Select * from emp";
			//3.Associate Query with connections
			Statement stmt=con.createStatement();
			//4.Fire the query
			ResultSet rset=stmt.executeQuery(sql);
			//5.get the result
			while(rset.next()) {
				System.out.println(rset.getInt(1)+"  "+
			rset.getString("ename")+"  "+
						rset.getString("job")+"  "+
			rset.getDouble("sal"));
			}
			rset.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
