package org.mrmat.hello.java.spring.concurrency.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * A record of active threads
 *
 * @author imfeldma
 */
@Entity
@Access(AccessType.FIELD)
public class ActiveThreads implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date ts = new Date();

    @Basic
    private Integer activeThreads;

    //
    // Getter/Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getActiveThreads() {
        return activeThreads;
    }

    public void setActiveThreads(Integer activeThreads) {
        this.activeThreads = activeThreads;
    }
}
