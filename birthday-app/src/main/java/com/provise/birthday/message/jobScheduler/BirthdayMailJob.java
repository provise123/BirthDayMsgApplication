package com.provise.birthday.message.jobScheduler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.provise.birthday.message.config.ApplicationConfig;
import com.provise.birthday.message.model.EmployeeModel;
import com.provise.birthday.message.model.Mail;
import com.provise.birthday.message.service.AppService;
import com.provise.birthday.message.service.MailService;
import com.provise.birthday.message.service.impl.AppServiceImpl;

public class BirthdayMailJob implements Job {
	private Logger logger = LoggerFactory.getLogger(BirthdayMailJob.class);
    AppService appService =  new AppServiceImpl();
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("Entered execute method");
		System.out.println("Entered execute method");
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setDOB(new Date());
		
		System.out.println("input to getEmployList method::"+employeeModel);
		List<EmployeeModel> empModels = appService.getEmployeeList(employeeModel);
		System.out.println("empModels::"+empModels);
		
		if (!empModels.isEmpty() || !empModels.contains(null)||empModels.size()==0) {
			Mail mail = new Mail();
			mail.setMailFrom("koteswar.rao@proviseconsulting.com"); // email id of mail sender
			mail.setMailSubject("Birthday Wishes ");
			AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
			MailService mailService = (MailService) context.getBean("mailService");
			for (EmployeeModel empModel : empModels) {

				Map<String, Object> model = new HashMap<String, Object>();
				model.put("firstName", empModel.getFirstName());
				model.put("lastName", empModel.getLastName());
				model.put("location", "Bangalore");
				model.put("signature", "ProVise ");
				// adding the birthday person emailId
				mail.setMailTo(empModel.getEmailAddress());// koteswar.rao@proviseconsulting.com
				mail.setModel(model);
				// sending Email to each individual
				mailService.sendEmail(mail);
				
				System.out.println("sending email to::"+empModel.getEmailAddress());
			}
			context.close();
		} 
		System.out.println("Exiting execute method");
		logger.info("Exiting execute method");
	}
}
