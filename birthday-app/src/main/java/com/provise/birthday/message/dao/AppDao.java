package com.provise.birthday.message.dao;

import java.util.List;

import com.provise.birthday.message.model.EmployeeModel;

/**
 * @author swapnil.patil
 *	The Interface appDao.
 */
public interface AppDao {
	/**
	 * Gets the employee list.
	 *
	 * @return the employee list
	 */
	public List<EmployeeModel> getEmployeeList(EmployeeModel model);

	
}
