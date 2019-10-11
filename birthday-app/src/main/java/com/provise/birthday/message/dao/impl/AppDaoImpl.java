package com.provise.birthday.message.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orientechnologies.orient.core.db.ODatabaseSession;
import com.provise.birthday.message.activities.db.AppOps;
import com.provise.birthday.message.dao.AppDao;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.util.EmpDBUtil;

/**
 * @author swapnil.patil
 *	The Class appDaoImpl.
 */
public class AppDaoImpl implements AppDao{
	
	public List<EmployeeModel> getEmployeeList(EmployeeModel model) {
		System.out.println("Entered AppDaoImpl");
		List<EmployeeModel> attrList = new ArrayList<EmployeeModel>();
		Date dob =model.getDOB();
		ODatabaseSession db = EmpDBUtil.getClientConnection();
		attrList = AppOps.getAllEmployeeData(db,dob);
		return attrList; 
	}
	
	
}
