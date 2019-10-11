package com.provise.birthday.message.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.service.AppService;
import com.provise.birthday.message.service.impl.AppServiceImpl;

/**
 * @author swapnil.patil
 *
 */
public class EmployeeController {

	AppService appService = new AppServiceImpl();
	
	@GET
	@Path("empList")
	public List<EmployeeModel> getEmpList(EmployeeModel model)
	{
		System.out.println("ABCD");
		List<EmployeeModel> bdayEmployeeList = appService.getEmployeeList(model);
		System.out.println("AAAAAAAAAAA"+bdayEmployeeList);
		return bdayEmployeeList;
	}
}
