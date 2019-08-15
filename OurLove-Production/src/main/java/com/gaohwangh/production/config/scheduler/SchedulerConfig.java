package com.gaohwangh.production.config.scheduler;

import com.gaohwangh.production.services.SysJobService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/14 16:06
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Bean("schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setConfigLocation(new ClassPathResource("quartz.properties"));
        scheduler.setApplicationContextSchedulerContextKey("applicationContext");
        return scheduler;
    }

    @Bean(initMethod = "initJob")
    public SysJobService sysJobService() {
       return new SysJobService();
    }


}
