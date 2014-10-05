package com.itech.iERP.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itech.iERP.forms.PrevilegeForm;

public class PrevilegeDaoImpl 
{

	public static List<PrevilegeForm> listAll(DataSource ds){
		List<PrevilegeForm> previlegeList= new ArrayList<PrevilegeForm>();
		PrevilegeForm previlegeForm=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=ds.getConnection();
			int functionId=1;
			for(int i=0;i<23;i++)
			{
			String sql="SELECT * FROM ROLE_ACCESS_MASTER WHERE FUNCTIONID=?";
			pstmt=con.prepareStatement(sql);	
			pstmt.setLong(1, functionId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				previlegeForm= new PrevilegeForm();
				previlegeForm.setPrevilegeId(rs.getLong("ID"));				
				previlegeForm.setRoleId(rs.getLong("ROLEID"));
				previlegeForm.setFunctionId(rs.getLong("FUNCTIONID"));
				//System.out.println("function:"+previlegeForm.getFunctionId());
				previlegeForm.setAccess(rs.getLong("ACCESS"));
				previlegeList.add(previlegeForm);
			}
			++functionId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return previlegeList;
	}

	public static String[] sorting(String[]access)
	{
		int len=access.length;
		String[] dest=new String[len];
		String[] temp=new String[len];
		
		
		return dest;
		
	}
	
	public static boolean updateAccess(String[] access,long roleId,DataSource ds){
		boolean result=false;
		String[] arr=sorting(access);
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int i=0;
		try {
			con=ds.getConnection();
			
			String sql="SELECT * FROM ROLE_ACCESS_MASTER WHERE ROLEID=?";
			pstmt=con.prepareStatement(sql);		
			pstmt.setLong(1, roleId);
			rs=pstmt.executeQuery();
			while(rs.next()){
		update(rs.getLong("ID"),access[i],con);
			++i;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(con!=null)con.close();
			} catch (Exception e2) {}
		}
		return result=true;
	}
public static void update(long id,String access,Connection con)
		
	{
	PreparedStatement pstmt=null;
	
	try {
		String sql="UPDATE ROLE_ACCESS_MASTER SET ACCESS=? WHERE ID="+id;
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, access);
		pstmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	}

public static List<PrevilegeForm> listAllRoleFn(long roleId,DataSource ds){
	List<PrevilegeForm> previlegeList= new ArrayList<PrevilegeForm>();
	PrevilegeForm previlegeForm=null;
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		con=ds.getConnection();
		int functionId=1;
		for(int i=0;i<5;i++)
		{
		String sql="SELECT * FROM ROLE_ACCESS_MASTER WHERE ROLEID=?";
		pstmt=con.prepareStatement(sql);		
		pstmt.setLong(1, roleId);
		rs=pstmt.executeQuery();
		while(rs.next()){
			previlegeForm= new PrevilegeForm();
			previlegeForm.setPrevilegeId(rs.getLong("ID"));			
			previlegeForm.setRoleId(rs.getLong("ROLEID"));
			previlegeForm.setFunctionId(rs.getLong("FUNCTIONID"));
			//System.out.println("function:"+previlegeForm.getFunctionId());
			previlegeForm.setAccess(rs.getLong("ACCESS"));
			previlegeList.add(previlegeForm);
		}
		++functionId;
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally{
		try {
			if(con!=null)con.close();
		} catch (Exception e2) {}
	}
	return previlegeList;
 }
  
}
