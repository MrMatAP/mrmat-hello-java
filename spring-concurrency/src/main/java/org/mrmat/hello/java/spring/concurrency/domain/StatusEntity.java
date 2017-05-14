package org.mrmat.hello.java.spring.concurrency.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A status entity
 *
 * @author imfeldma
 */
@Entity
@Access(AccessType.FIELD)
public class StatusEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Basic
    private Long freeMemoryEntries = 0L;

    @Basic
    private Long activeThreadEntries = 0L;

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

    public Long getFreeMemoryEntries() {
        return freeMemoryEntries;
    }

    public void setFreeMemoryEntries(Long freeMemoryEntries) {
        this.freeMemoryEntries = freeMemoryEntries;
    }

    public Long getActiveThreadEntries() {
        return activeThreadEntries;
    }

    public void setActiveThreadEntries(Long activeThreadEntries) {
        this.activeThreadEntries = activeThreadEntries;
    }
}
