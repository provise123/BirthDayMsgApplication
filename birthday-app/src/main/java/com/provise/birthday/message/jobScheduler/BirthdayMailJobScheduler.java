package com.provise.birthday.message.jobScheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BirthdayMailJobScheduler {
	private static Logger logger = LoggerFactory.getLogger(BirthdayMailJobScheduler.class);

	public static void mailScheduler() throws SchedulerException {
		logger.info("Entered mailScheduler method");
		JobDetail birthdayMailJob = JobBuilder.newJob(BirthdayMailJob.class).withIdentity("birthdayJob").build();
		Trigger tgr1 = TriggerBuilder.newTrigger().withIdentity("cronTrigger1")
				.withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(17,59)).build();
		// CronScheduleBuilder.cronSchedule("*/5 * * * * ?")
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.start();
		scheduler.scheduleJob(birthdayMailJob, tgr1);
		logger.info("Exiting mailScheduler mehtod");
	}
}
