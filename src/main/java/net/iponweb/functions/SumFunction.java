package net.iponweb.functions;

import com.google.common.base.Joiner;
import net.iponweb.Target;
import net.iponweb.TargetEvaluator;
import net.iponweb.exceptions.EvaluationException;
import net.iponweb.exceptions.TimeSeriesNotAlignedException;
import net.iponweb.timeseries.TimeSeries;
import net.iponweb.timeseries.utils.TimeSeriesUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by aivanov on 21.06.2015.
 */
public class SumFunction extends DistheneFunction {


    public SumFunction(String text) {
        super(text);
    }

    @Override
    public List<TimeSeries> evaluate(TargetEvaluator evaluator) throws EvaluationException {
        // all args are targets
        List<TimeSeries> processedArguments = new ArrayList<>();
        for(Object target : arguments) {
            processedArguments.addAll(evaluator.eval((Target) target));
        }

        // check that all aligned
        if (!TimeSeriesUtils.checkAlignment(processedArguments)) {
            throw new TimeSeriesNotAlignedException();
        }

        if (processedArguments.size() == 0) return new ArrayList<>();

        long from = processedArguments.get(0).getFrom();
        long to = processedArguments.get(0).getTo();
        long step = processedArguments.get(0).getStep();
        int length = processedArguments.get(0).getValues().length;

        TimeSeries resultTimeSeries = new TimeSeries(getName(), from, to, step);
        Double[] values = new Double[length];

        for (int i = 0; i < length; i++) {
            values[i] = 0.;
            for(TimeSeries ts : processedArguments) {
                values[i] += ts.getValues()[i] != null ? ts.getValues()[i] : 0.;
            }
        }

        resultTimeSeries.setValues(values);

        return Collections.singletonList(resultTimeSeries);
    }

    private String getName() {
        List<String> names = new ArrayList<>();
        for(Object target : arguments) {
            names.add(((Target) target).getText());
        }

        return "sumSeries(" + Joiner.on(",").skipNulls().join(names) + ")";
    }

    @Override
    protected boolean checkArgument(int position, Object argument) {
        return argument instanceof Target;
    }

}
