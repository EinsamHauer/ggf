package net.iponweb;

import com.google.gson.Gson;
import net.iponweb.exceptions.EvaluationException;
import net.iponweb.functions.DistheneFunction;
import net.iponweb.timeseries.TimeSeries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aivanov on 21.06.2015.
 */
public class TargetEvaluator {

    private Map<String, TimeSeries> mock = new HashMap<>();

    public TargetEvaluator() throws IOException {
        BufferedReader input =  new BufferedReader(new FileReader(new File("test_data.json")));
        Gson gson = new Gson();

        List<Map<String, Object>> entries = gson.fromJson(input, List.class);

        for (Map<String, Object> entry : entries) {
            String target = (String) entry.get("target");
            List<List<Double>> datapoints = (List<List<Double>>) entry.get("datapoints");

            TimeSeries ts = new TimeSeries(target, datapoints.get(0).get(1).longValue(), datapoints.get(datapoints.size() - 1).get(1).longValue(), 60L);

            List<Double> values = new ArrayList<>();
            for(List<Double> point : datapoints) {
                values.add(point.get(0));
            }

            ts.setValues(values.toArray(new Double[1]));

            mock.put(target, ts);
        }

        input.close();

    }

    public List<TimeSeries> eval(Target target) throws EvaluationException {
        return target.evaluate(this);
    }

    public List<TimeSeries> visit(PathTarget pathTarget) {
        System.out.println("Evaulating path (mock up): " + pathTarget.toString());
        List<TimeSeries> tss = new ArrayList<>();
        tss.addAll(mock.values());
        return tss;
    }

    public List<TimeSeries> visit(DistheneFunction function) throws EvaluationException {
        return function.evaluate(this);
    }
}
