package org.mrmat.hello.java.spring.batch.service;

import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Listens for job execution status
 *
 * @author imfeldma
 */
public class JobStatus implements JobExecutionListener {

    private static final Logger LOG = Logger.getLogger(JobStatus.class);

    @Override
    public void beforeJob(JobExecution execution) {
        LOG.info("Executing job " + execution.getJobId());
    }

    @Override
    public void afterJob(JobExecution execution) {
        LOG.info("Job " + execution.getJobId() + " finished with status " + execution.getStatus());
    }
}
