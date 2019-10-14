package com.provise.birthday.message.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.provise.birthday.message.app.App;
import com.provise.birthday.message.jobScheduler.BirthdayMailJobScheduler;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.service.AppService;
import com.provise.birthday.message.service.impl.AppServiceImpl;

/**
 * @author swapnil.patil
 *
 */

@Path("/test")
public class EmployeeController {
	App app = new App();
	AppService appService = new AppServiceImpl();
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@GET
	@Path("/empList")
	public List<EmployeeModel> getEmpList(EmployeeModel model)
	{
		System.out.println("ABCD");
		List<EmployeeModel> bdayEmployeeList = appService.getEmployeeList(model);
		System.out.println("AAAAAAAAAAA"+bdayEmployeeList);
		return bdayEmployeeList;
	}
	
	@GET
	@Path("/bdayScheduler")
	public void bdayScheduler()
	{
		logger.info("Inside bdayScheduler...!!!");
		try {
			
			BirthdayMailJobScheduler.mailScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		EmployeeController controller = new EmployeeController();
		controller.bdayScheduler();
		
	}
	
}
