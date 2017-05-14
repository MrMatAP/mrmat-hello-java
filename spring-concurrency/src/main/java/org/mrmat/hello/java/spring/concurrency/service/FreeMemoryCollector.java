package org.mrmat.hello.java.spring.concurrency.service;

import org.apache.log4j.Logger;
import org.mrmat.hello.java.spring.concurrency.domain.FreeMemory;
import org.mrmat.hello.java.spring.concurrency.domain.StatusEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Collects free memory and stores it in the database
 *
 * @author imfeldma
 */
public class FreeMemoryCollector {

    private static final Logger LOG = Logger.getLogger(FreeMemoryCollector.class);

    @PersistenceContext
    EntityManager em;

    private Runtime runtime;

    @Scheduled(fixedDelay=1000)
    @Transactional
    public void collectFreeMemory() {
        FreeMemory freeMemory = new FreeMemory();
        freeMemory.setFreeMemory(runtime.freeMemory());
        em.persist(freeMemory);
        LOG.info("Free memory: " + freeMemory.getFreeMemory());

        StatusEntity statusEntity = em.createQuery("SELECT s FROM StatusEntity s", StatusEntity.class).getSingleResult();
        statusEntity.setFreeMemoryEntries(statusEntity.getFreeMemoryEntries() + 1);
        em.persist(statusEntity);

        em.flush();
    }

    @PostConstruct
    public void init() {
        LOG.info("FreeMemoryCollector starting");
        runtime = Runtime.getRuntime();
    }

    @PreDestroy
    public void destroy() {
        LOG.info("FreeMemoryCollector stopping");
    }
}
