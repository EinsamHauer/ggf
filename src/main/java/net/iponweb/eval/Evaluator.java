package net.iponweb.eval;

import net.iponweb.PathTarget;
import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public interface Evaluator {

    List<TimeSeries> eval(PathTarget target);

    public class DefaultEvaluator implements Evaluator {

        @Override
        public List<TimeSeries> eval(PathTarget target) {
            return null;
        }
    }
}

