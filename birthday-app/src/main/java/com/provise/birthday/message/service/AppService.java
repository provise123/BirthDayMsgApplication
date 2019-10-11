package com.provise.birthday.message.service;

import java.util.List;

import com.provise.birthday.message.model.EmployeeModel;

/**
 * @author swapnil.patil
 *	The Interface appService.
 */
public interface AppService {

	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 */
	public List<EmployeeModel> getEmployeeList(EmployeeModel model);
	
	
}
