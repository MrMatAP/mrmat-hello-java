package org.mrmat.hello.java.spring.concurrency;

import javax.persistence.*;

/**
 * An entity storing metrics
 *
 * @author imfeldma
 */
@Entity
@Access(AccessType.FIELD)
public class MetricEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Basic
    Long freeMemory;

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

    public Long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(Long freeMemory) {
        this.freeMemory = freeMemory;
    }
}
