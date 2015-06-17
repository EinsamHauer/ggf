package net.iponweb;

import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public abstract class Target {

    private String tenant;
    private Long from;
    private Long to;

    public Target(String tenant, Long from, Long to) {
        this.tenant = tenant;
        this.from = from;
        this.to = to;
    }

    public abstract List<TimeSeries> eval();

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }
}
