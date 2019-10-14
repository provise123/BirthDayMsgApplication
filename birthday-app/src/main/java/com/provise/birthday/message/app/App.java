package com.provise.birthday.message.app;

import org.quartz.SchedulerException;

import com.provise.birthday.message.jobScheduler.BirthdayMailJobScheduler;

public class App {
	
	public static void mailScheduler() {
		
		try {
			
			BirthdayMailJobScheduler.mailScheduler();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

}
