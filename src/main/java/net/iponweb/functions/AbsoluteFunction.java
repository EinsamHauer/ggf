package net.iponweb.functions;

import net.iponweb.Target;
import net.iponweb.TargetEvaluator;
import net.iponweb.exceptions.EvaluationException;
import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public class AbsoluteFunction extends DistheneFunction {

    public AbsoluteFunction(String text) {
        super(text);
    }

    @Override
    public List<TimeSeries> evaluate(TargetEvaluator evaluator) throws EvaluationException {
        return null;
    }

    @Override
    protected boolean checkArgument(int position, Object argument) {
        return argument instanceof Target;
    }
}
