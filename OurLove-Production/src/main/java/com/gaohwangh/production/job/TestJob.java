package com.gaohwangh.production.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gaohwangh.api.model.SysJobModel;
import com.gaohwangh.production.dao.SysJobDao;
import com.gaohwangh.production.utils.SpringBeanFactoryUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author gaoh
 * @version 1.0
 * @date 2019/8/13 14:42
 */
@Component(value = "testJob")
@Slf4j
public class TestJob {

    //每十秒执行一次
//    @Scheduled(cron = "0/10 * * * * ? *")
    @Transactional(rollbackFor = {Exception.class})
    public void execute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.CHINA);// 输出北京时间
        log.info(TestJob.class.getName() + "  " + sdf.format(new Date(System.currentTimeMillis())));

        SysJobDao sysJob  = SpringBeanFactoryUtils.getApplicationContext().getBean(SysJobDao.class);
        List<SysJobModel> sysJobModels = sysJob.selectAll();
        for (SysJobModel jobModel : sysJobModels) {
            log.info(jobModel + "");
        }
    }
}
