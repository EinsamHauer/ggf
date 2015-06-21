package net.iponweb;

import net.iponweb.exceptions.EvaluationException;
import net.iponweb.exceptions.TimeSeriesNotAlignedException;
import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public abstract class Target {

    private String text;

    public Target(String text) {
        this.text = text;
    }

    public abstract List<TimeSeries> evaluate(TargetEvaluator evaluator) throws EvaluationException;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
