package net.iponweb;

import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public class PathTarget extends Target {

    private String path;

    public PathTarget(String tenant, Long from, Long to, String path) {
        super(tenant, from, to);
        this.path = path;
    }

    @Override
    public String toString() {
        return "PathTarget{" +
                "path='" + path + '\'' +
                '}';
    }

    @Override
    public List<TimeSeries> eval() {
        return null;
    }
}
