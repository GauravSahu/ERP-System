package com.itech.iERP.handler;

import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import com.cete.dynamicpdf.imaging.tiff.f;
import com.cete.dynamicpdf.text.u;
import com.itech.iERP.daoimpl.LeaveModuleDaoImpl;
import com.itech.iERP.forms.LeaveModuleForm;

public class LeaveModuleHandler 
{
	LeaveModuleDaoImpl impl = new LeaveModuleDaoImpl();
	
	public String getApprover(DataSource dataSource, long userid)
	{
		return impl.getApprover(dataSource,userid);
	}

	public List<LeaveModuleForm> listEmp(DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.listEmp(dataSource);
	}

	public String addRole(LeaveModuleForm leavemoduleform,Timestamp ftimets, Timestamp ttimets,long userid,int approverId,String allfiles, DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.add(leavemoduleform,ftimets,ttimets,userid,approverId,allfiles,dataSource);
	}

	public int getApproverid(DataSource dataSource, long userid)
	{
		// TODO Auto-generated method stub
		return impl.getApproverId(dataSource, userid);
	}

	public List<LeaveModuleForm> leaveRequests(long userid,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.leaveRequests(userid,dataSource);
	        }

	public String changeRole(int l, LeaveModuleForm leavemoduleform,
			DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.changeRole(l,leavemoduleform,dataSource);
	}

	public String changeRole1(int l, LeaveModuleForm leavemoduleform,
			DataSource dataSource) 
	{
		// TODO Auto-generated method stub
		return impl.changeRole1(l,leavemoduleform,dataSource);
	}

	public List<LeaveModuleForm> listEmp1(DataSource dataSource) {
		// TODO Auto-generated method stub
		return impl.listEmp1(dataSource);
	}

	public List<LeaveModuleForm> listLeaveList(Timestamp ftimets,
			Timestamp ttimets, LeaveModuleForm leavemoduleform,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listleave(ftimets,ttimets,leavemoduleform,dataSource);
	      }

	public List<LeaveModuleForm> listLeaveList1(
			LeaveModuleForm leavemoduleform, DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listLeaveList1(leavemoduleform,dataSource);
	       }


	public List<LeaveModuleForm> listLeaveHist(long userid, String username,
			DataSource dataSource) 
			{
		// TODO Auto-generated method stub
		return impl.listLeaveHist(userid,username,dataSource);
	}

	public List<LeaveModuleForm> listLeavestat(long userid, String username,
			DataSource dataSource)
			{
		// TODO Auto-generated method stub
		return impl.listLeavestat(userid,username,dataSource);
	       }

	public int listbal(DataSource dataSource, long userid) 
	{
		// TODO Auto-generated method stub
		return impl.listbal(dataSource,userid);
	}

	public int listapp(DataSource dataSource, long userid) {
		// TODO Auto-generated method stub
		return impl.listapp(dataSource,userid);
	}

	public int listrej(DataSource dataSource, long userid)
	{
		// TODO Auto-generated method stub
		return impl.listrej(dataSource,userid);
	}

	public String getApproverMailId(DataSource dataSource, int approverId)
	{
		// TODO Auto-generated method stub
		return impl.getApproverMailId(dataSource,approverId);
	}

	public String getNotifyMailId(DataSource dataSource, String userId1) 
	{
		// TODO Auto-generated method stub
		return impl.getNotifyMailId(dataSource,userId1);
	}

	public String name(DataSource dataSource, long userid)
	{
	
		return impl.getName(dataSource,userid);
	}


}
