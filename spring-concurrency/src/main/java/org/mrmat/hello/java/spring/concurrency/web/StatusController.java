package org.mrmat.hello.java.spring.concurrency.web;

import org.apache.log4j.Logger;
import org.mrmat.hello.java.spring.concurrency.domain.StatusEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * A basic hello world
 *
 * @author imfeldma
 */
@RestController
public class StatusController {

    private static final Logger LOG = Logger.getLogger(StatusController.class);

    @PersistenceContext
    private EntityManager em;

    @RequestMapping("/api/status")
    @Transactional
    public StatusEntity status() {

        //
        // Do make sure we have exactly one StatusEntity

        StatusEntity status = null;
        try {
            status = em.createQuery("SELECT s FROM StatusEntity s", StatusEntity.class).getSingleResult();
        } catch(NoResultException nre) {

            LOG.info("Creating status entity for the first time");
            status = new StatusEntity();
            em.persist(status);
            em.flush();
        } finally {
            return status;
        }
    }

}
