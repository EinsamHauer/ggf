package net.iponweb.functions;

import com.google.common.base.Function;
import net.iponweb.timeseries.TimeSeries;

import java.util.List;

/**
 * Created by aivanov on 6/17/15.
 */
public interface GraphiteFunction extends Function<List<Object>, List<TimeSeries>> {


}
