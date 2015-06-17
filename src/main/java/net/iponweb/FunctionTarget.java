package net.iponweb;

import net.iponweb.timeseries.TimeSeries;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public class FunctionTarget extends Target {

    private String name;
    private List<Object> args = new ArrayList<>();

    public FunctionTarget(String tenant, Long from, Long to, String name) {
        super(tenant, from, to);
        this.name = name;
    }

    public void addArg(Object arg) {
        args.add(arg);
    }

    @Override
    public String toString() {
        return "FunctionTarget{" +
                "name='" + name + '\'' +
                ", args=" + args +
                '}';
    }

    @Override
    public List<TimeSeries> eval() {
        return null;
    }
}
