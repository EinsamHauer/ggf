package net.iponweb;

import net.iponweb.exceptions.EvaluationException;
import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public class PathTarget extends Target {

    private String path;
    private String tenant;
    private Long from;
    private Long to;

    public PathTarget(String text, String path, String tenant, Long from, Long to) {
        super(text);
        this.path = path;
        this.tenant = tenant;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "PathTarget{" +
                "path='" + path + '\'' +
                '}';
    }

    @Override
    public List<TimeSeries> evaluate(TargetEvaluator evaluator) throws EvaluationException {
        return evaluator.visit(this);
    }
}
