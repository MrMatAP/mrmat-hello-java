package org.mrmat.hello.java.spring.concurrency.service;

import org.apache.log4j.Logger;
import org.mrmat.hello.java.spring.concurrency.domain.ActiveThreads;
import org.mrmat.hello.java.spring.concurrency.domain.StatusEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Collects the currently active threads and writes them into the database
 *
 * @author imfeldma
 */
public class ActiveThreadsCollector {

    private static final Logger LOG = Logger.getLogger(FreeMemoryCollector.class);

    @PersistenceContext
    private EntityManager em;

    @Scheduled(fixedDelay=1000)
    @Transactional
    public void collectActiveThreads() {
        ActiveThreads activeThreads = new ActiveThreads();
        activeThreads.setActiveThreads(Thread.activeCount());
        em.persist(activeThreads);
        LOG.info("Active Threads: " + activeThreads.getActiveThreads());

        StatusEntity statusEntity = em.createQuery("SELECT s FROM StatusEntity s", StatusEntity.class).getSingleResult();
        statusEntity.setActiveThreadEntries(statusEntity.getActiveThreadEntries() + 1);
        em.persist(statusEntity);

        em.flush();
    }

    @PostConstruct
    public void init() {
        LOG.info("ActiveThreadsCollector starting");
    }

    @PreDestroy
    public void destroy() {
        LOG.info("ActiveThreadsCollector stopping");
    }
}
