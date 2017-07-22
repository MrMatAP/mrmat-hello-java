package org.mrmat.hello.java.spring.batch.web;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A job launch control interface
 *
 * @author imfeldma
 */
@RestController
public class LaunchController {

    @Autowired
    private JobLauncher jobLauncher;

/*    @Autowired
    private Job job;*/

    @RequestMapping
    public String status() {
        return "OK";
    }

    @RequestMapping("/api/launch")
    public String launch() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        //jobLauncher.run(job, new JobParameters());
        return "Job launched";
    }
}
