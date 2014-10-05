package com.itech.iERP.daoimpl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.crypto.spec.PSource;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.itech.iERP.constants.iERPConstants;
import com.itech.iERP.forms.UserForm;
import com.itech.iERP.utils.EncryptUtil;

//This page contailns calling a applicationresource file calling and integartion 
public class UserDaoImpl 
{
	private Properties configProp = new Properties();

	public List<UserForm> listAll(long compid, DataSource dataSource) 
	{
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		String dob = null;
		String cdob = null;
		
		try
		{
			
		   con = dataSource.getConnection();
		   InputStream in =  this.getClass().getClassLoader().getResourceAsStream("/ApplicationResources.properties");
			   			try
			   			{   				
			   configProp.load(in);
			   			}
			   			catch 
			   			(IOException e) 
			   {
			   				
			   e.printStackTrace();
			   	}
			   			
          // String sql= configProp.getProperty("select.discipline");;
		   String sql = "SELECT * FROM usermaster where COMPANYID = '"+compid+"'";
		   pstmt=con.prepareStatement(sql);
		   rs=pstmt.executeQuery();
		   while(rs.next())
		   {
			   userForm = new UserForm();
			   userForm.setUserid(rs.getInt("USERID"));
			   userForm.setUsername(rs.getString("USERNAME"));
			   userForm.setPassword(rs.getString("PASSWORD"));
			   userForm.setFirstname(rs.getString("FIRSTNAME"));
			   userForm.setLastname(rs.getString("LASTNAME"));
			   userForm.setPhone1(rs.getString("PHONE1"));
			   userForm.setPhone2(rs.getString("PHONE2"));
			   userForm.setEmailid(rs.getString("EMAILID"));
			   userForm.setRoleid(rs.getInt("ROLEID"));
			   userForm.setCompanyid(rs.getInt("COMPANYID"));
			   userForm.setActive(rs.getBoolean("ACTIVE"));
			 
			   dob = rs.getString("Dateofbirth");
			   System.out.println("Fist "+dob);
			   String S = dob.substring(0,10);
			   
			   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			   SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
			   String ds2 = sdf2.format(sdf1.parse(S));
			   System.out.println("required format "+ds2);
			   
			   
			   //String S = new SimpleDateFormat("MM/dd/yyyy").format(dob);
			   System.out.println("After Conversion "+S);
			   userForm.setMyDate(ds2);
			   userForm.setAge1(rs.getString("Age"));  
			   userForm.setFathername(rs.getString("FatherName"));
			   userForm.setMothername(rs.getString("MotherName"));
			   userForm.setDoj(rs.getString("Dateofjoining"));
			   userForm.setSalaryaccountnumber(rs.getString("salaryaccountnumber"));
			   userForm.setBankid(rs.getString("bankname"));
			   userForm.setEmercontnumber(rs.getString("emergencycontactnumber"));
			   userForm.setPresentadd(rs.getString("presentaddress"));
			   userForm.setPermadd(rs.getString("permanentaddress"));
			   userForm.setRoleid(rs.getInt("ROLEID"));
			   userForm.setApprover(rs.getString("APPROVER"));
			   userForm.setGender(rs.getString("MaritialStatus"));
			   userForm.setSpousename(rs.getString("spousename"));
			   userForm.setSpouseage(rs.getString("spouseage"));
			   userForm.setSpouseeducadet(rs.getString("spouseeducationqualification"));
			   userForm.setSpousejobdetails(rs.getString("spousejobdetails"));
			   userForm.setChilddetails(rs.getString("childrendetails"));
			   userForm.setDepeparentdetails(rs.getString("dependentparentdetails"));
			   list.add(userForm);
		   }
		}
		catch (Exception e) 
		{
		   System.out.println("Exception is "+e);
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
			  System.out.println(e2);
			}
		}
		return list;
	}

	public String add(long compid, Timestamp dob, Timestamp doj, UserForm userForm, DataSource dataSource)
	{
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;

		try
		{
			con=dataSource.getConnection();
			String sql = "select * from usermaster where USERNAME='"+userForm.getUsername()+"' and ACTIVE=1";
			System.out.println("cvhfhg"+sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				
				result=iERPConstants.DUPLICATE_NAME_MESSAGE;
			
			else
			{
				if(!userForm.getUsername().equalsIgnoreCase("") && !userForm.getUsername().equalsIgnoreCase(null))
				{
										
					sql = "insert into usermaster(USERNAME,PASSWORD,FIRSTNAME,LASTNAME,PHONE1,PHONE2,EMAILID,ROLEID,COMPANYID,ACTIVE,APPROVER,Dateofbirth,Dateofjoining,age,FatherName,MotherName,salaryaccountnumber,bankname,emergencycontactnumber,presentaddress,permanentaddress,MaritialStatus,spousename,spouseage,spouseeducationqualification,spousejobdetails,childrendetails,dependentparentdetails,employeeid,pancardnumber,pfdetails,bloodgroup,desigid) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					if(pstmt!=null)
					pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userForm.getUsername());
					pstmt.setString(2,EncryptUtil.encrypt( userForm.getPassword()));
					pstmt.setString(3, userForm.getFirstname());
					pstmt.setString(4, userForm.getLastname());
					pstmt.setString(5, userForm.getPhone1());
					pstmt.setString(6, userForm.getPhone2());
					pstmt.setString(7, userForm.getEmailid());
					//pstmt.setString(9, userForm.getSsn());
					pstmt.setInt(8, userForm.getRoleid());
					pstmt.setLong(9, compid);
					pstmt.setBoolean(10, true);
					pstmt.setInt(11,userForm.getAppId());
					pstmt.setTimestamp(12, dob);
					pstmt.setTimestamp(13,doj);
					pstmt.setString(14,userForm.getAge1());
					pstmt.setString(15,userForm.getFathername());
					pstmt.setString(16,userForm.getMothername());
					pstmt.setString(17,userForm.getSalaryaccountnumber());
					pstmt.setString(18,userForm.getBankid());
					pstmt.setString(19,userForm.getEmercontnumber());
					pstmt.setString(20,userForm.getPresentadd());
					pstmt.setString(21,userForm.getPermadd());
					pstmt.setString(22,userForm.getGender());
					pstmt.setString(23,userForm.getSpousename());
					pstmt.setString(24,userForm.getSpouseage());
					pstmt.setString(25,userForm.getSpouseeducadet());
					pstmt.setString(26,userForm.getSpousejobdetails());
					pstmt.setString(27,userForm.getChilddetails());
					pstmt.setString(28,userForm.getDepeparentdetails());
					pstmt.setString(29,userForm.getEmployeeid());
					pstmt.setString(30,userForm.getPancardnumber());
					pstmt.setString(31,userForm.getPfdetails());
					pstmt.setString(32,userForm.getBloodgroup());
					pstmt.setString(33,userForm.getDesiid());
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_ADDED;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return result;
	}

	public String changeStatus(UserForm userForm, DataSource dataSource)
	{
		
		String result = iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
		   con = dataSource.getConnection();
		   String sql = "update usermaster set active = ? where USERID=?";
		   pstmt=con.prepareStatement(sql);
		   pstmt.setBoolean(1,userForm.isActive());
		   pstmt.setInt(2, userForm.getUserid());
		   pstmt.executeUpdate();
		   result=iERPConstants.REC_STATUS_CHANGED;
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return result;
	}

	public String update(UserForm userForm, DataSource dataSource) 
	{
		String result=iERPConstants.FAILURE_MESSAGE;
		Connection con = null;
		PreparedStatement pstmt = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "SELECT * FROM usermaster WHERE USERNAME AND PASSWORD AND FIRSTNAME AND LASTNAME AND PHONE1 AND PHONE2 AND EMAILID LIKE ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userForm.getUsername());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				result=iERPConstants.No_Change;
			else
			{
				if(!userForm.getUsername().equalsIgnoreCase("") && !userForm.getUsername().equalsIgnoreCase(null))
				{
					sql="UPDATE usermaster SET USERNAME=?,PASSWORD=?,FIRSTNAME=?,LASTNAME=?,PHONE1=?,PHONE2=?,EMAILID=?,ROLEID=?,COMPANYID=?,APPROVER=?,Dateofbirth=?,Age=?,FatherName=?,MotherName=?,Dateofjoining=?,salaryaccountnumber=?,bankname=?,MaritialStatus=?,spousename=?,spouseage=?,spouseeducationqualification=?,spousejobdetails=?,presentaddress=?,permanentaddress=?,emergencycontactnumber=?,childrendetails=?,dependentparentdetails=? WHERE USERID=?";
					if(pstmt!=null)pstmt.close();
					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,userForm.getUsername());
					pstmt.setString(2,userForm.getPassword());
					pstmt.setString(3, userForm.getFirstname());
					pstmt.setString(4, userForm.getLastname());
					pstmt.setString(5, userForm.getPhone1());
					pstmt.setString(6, userForm.getPhone2());
					pstmt.setString(7, userForm.getEmailid());
					//pstmt.setString(8,userForm.getSsn());
					pstmt.setInt(8, userForm.getRoleid());
					pstmt.setInt(9, userForm.getCompanyid());
					pstmt.setInt(10, userForm.getUserid());
					pstmt.setString(11,userForm.getApprover());
					pstmt.setString(12,userForm.getMyDate());
					pstmt.setString(13,userForm.getAge1());
					pstmt.setString(14,userForm.getFathername());
					pstmt.setString(15,userForm.getMothername());
					pstmt.setString(16,userForm.getDoj());
					pstmt.setString(17,userForm.getSalaryaccountnumber());
					pstmt.setString(18,userForm.getBankname());
					pstmt.setString(19,userForm.getGender());
					pstmt.setString(20,userForm.getSpousename());
					pstmt.setString(21,userForm.getSpouseage());
					pstmt.setString(22,userForm.getSpouseeducadet());
					pstmt.setString(23,userForm.getSpousejobdetails());
					pstmt.setString(24,userForm.getPresentadd());
					pstmt.setString(25,userForm.getPermadd());
					pstmt.setString(26,userForm.getEmercontnumber());
					pstmt.setString(27,userForm.getChilddetails());
					pstmt.setString(28,userForm.getDepeparentdetails());
					pstmt.executeUpdate();
					if(rs!=null)
						rs.close();
					result=iERPConstants.REC_UPDATED;
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		return result;
	}

	public List<UserForm> activeList(DataSource dataSource) 
	{
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from usermaster where active = true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				 userForm.setUserid(rs.getInt("USERID"));
				   userForm.setUsername(rs.getString("USERNAME"));
				   userForm.setPassword(rs.getString("PASSWORD"));
				   userForm.setFirstname(rs.getString("FIRSTNAME"));
				   userForm.setLastname(rs.getString("LASTNAME"));
				   userForm.setPhone1(rs.getString("PHONE1"));
				   userForm.setPhone2(rs.getString("PHONE2"));
				   userForm.setEmailid(rs.getString("EMAILID"));
				  // userForm.setSsn(rs.getString("SSN"));
				   userForm.setRoleid(rs.getInt("ROLEID"));
				   userForm.setCompanyid(rs.getInt("COMPANYID"));
				   userForm.setActive(rs.getBoolean("ACTIVE"));
				   list.add(userForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}

	public List<UserForm> roleList(long compid, DataSource dataSource) 
	{
		
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from rolemaster where active = true and compid = '"+compid+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				
				   userForm.setRoleid(rs.getInt("ROLEID"));
				   userForm.setRolename(rs.getString("rolename"));
				   
				   list.add(userForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}

	public List<UserForm> companyList(DataSource dataSource) {
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from companymaster where active = true";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				
				   userForm.setCompanyid(rs.getInt("companyid"));
				   userForm.setCompanyname(rs.getString("companyname"));
				   
				   list.add(userForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}

	public List<UserForm> ApproveList(long compid, DataSource dataSource) {
		// TODO Auto-generated method stub
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from usermaster where active = true and COMPANYID = '"+compid+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				
				   userForm.setAppId(rs.getInt("USERID"));
				   userForm.setApprover(rs.getString("FIRSTNAME"));
				   
				   list.add(userForm);
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}

	public List<UserForm> desiList(long compid, DataSource dataSource)
	{
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from designationmaster where active = true and compid = '"+compid+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				
				   userForm.setDesiid(rs.getString("desgid"));
				   userForm.setDesiname(rs.getString("designationname"));
				   list.add(userForm);	
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}

	public List<UserForm> banklist(long compid, DataSource dataSource) 
	{
		List<UserForm> list = new ArrayList<UserForm>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserForm userForm = null;
		try
		{
			con = dataSource.getConnection();
			String sql = "select * from bankmaster where active = true and compid = '"+compid+"'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				userForm = new UserForm();
				
				   userForm.setBankid(rs.getString("BANKID"));
				   userForm.setBankname(rs.getString("BANKNAME"));
				   list.add(userForm);	
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(con!=null)
					con.close();
			}
			catch (Exception e2)
			{
				System.out.println(e2);
			}
		
		}
		return list;
	}
   
	
}
