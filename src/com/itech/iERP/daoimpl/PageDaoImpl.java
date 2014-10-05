package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

public class PageDaoImpl 
{
public String pageAccess(String id,DataSource ds){
		
		String result=null;
			Connection con=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			try {
			
				con=ds.getConnection();
				String sql="SELECT screenname FROM screenmaster where screenid =? and active=true ";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				while(rs.next()){
				result=rs.getString(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				try {
					if(con!=null)con.close();
				} catch (Exception e2) {}
			}
		
			
			return result ;
		
	}

}
