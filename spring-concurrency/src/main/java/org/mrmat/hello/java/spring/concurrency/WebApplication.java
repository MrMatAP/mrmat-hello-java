package org.mrmat.hello.java.spring.concurrency;

import org.mrmat.hello.java.spring.concurrency.service.ActiveThreadsCollector;
import org.mrmat.hello.java.spring.concurrency.service.FreeMemoryCollector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableScheduling
public class WebApplication {

    @Bean
    public FreeMemoryCollector freeMemoryCollector() {
        return new FreeMemoryCollector();
    }

    @Bean
    public ActiveThreadsCollector activeThreadsCollector() {
        return new ActiveThreadsCollector();
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(25);
        return taskExecutor;
    }

	/**
	 * Start a web server when running from the command line
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}
