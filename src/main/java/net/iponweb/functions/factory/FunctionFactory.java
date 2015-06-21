package net.iponweb.functions.factory;

import net.iponweb.exceptions.InvalidFunctionException;
import net.iponweb.functions.AverageFunction;
import net.iponweb.functions.DistheneFunction;
import net.iponweb.functions.SumFunction;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aivanov on 21.06.2015.
 */
public class FunctionFactory {

    private static final Map<String, Class<? extends DistheneFunction>> registry = new HashMap<>();

    static {
        registry.put("sumSeries", SumFunction.class);
        registry.put("averageSeries", AverageFunction.class);
    }

    public static DistheneFunction getFunction(String name) throws InvalidFunctionException {
        if (registry.get(name) == null) {
            throw new InvalidFunctionException();
        }

        try {
            Constructor<DistheneFunction> constructor = (Constructor<DistheneFunction>) registry.get(name).getConstructor(String.class);
            return constructor.newInstance(name);
        } catch (Exception e) {
            throw new InvalidFunctionException();
        }
    }
}
