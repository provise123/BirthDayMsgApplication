package com.provise.birthday.message.service.impl;

import java.util.List;

import com.provise.birthday.message.dao.AppDao;
import com.provise.birthday.message.dao.impl.AppDaoImpl;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.service.AppService;

/**
 * @author swapnil.patil
 *	The Class appServiceImpl.
 */
public class AppServiceImpl implements AppService{

	AppDao appDao = new AppDaoImpl();
	
	public List<EmployeeModel> getEmployeeList(EmployeeModel model) {
		System.out.println("Entered AppServiceImpl");
		return appDao.getEmployeeList(model);
		 
	}

	
}
