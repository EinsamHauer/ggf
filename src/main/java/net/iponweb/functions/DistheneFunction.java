package net.iponweb.functions;

import net.iponweb.Target;
import net.iponweb.TargetEvaluator;
import net.iponweb.exceptions.InvalidArgumentException;
import net.iponweb.timeseries.TimeSeries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by aivanov on 21.06.2015.
 */
public abstract class DistheneFunction extends Target {

    protected List<Object> arguments = new ArrayList<>();
    protected Class[] argumentTypes;

    public DistheneFunction(String text) {
        super(text);
    }

    public void addArg(Object argument) throws InvalidArgumentException {
        // check argument type
        if (!checkArgument(arguments.size(), argument)) {
            throw new InvalidArgumentException();
        }

        arguments.add(argument);
    }

    protected abstract boolean checkArgument(int position, Object argument);

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                ", arguments=" + arguments +
                '}';
    }
}
