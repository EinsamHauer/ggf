package net.iponweb.timeseries;

/**
 * Created by aivanov on 6/17/15.
 */
public class TimeSeries {

    private String name;
    private Long from;
    private Long to;
    private Long step;

    private Double[] values;

    public TimeSeries(String name, Long from, Long to, Long step) {
        this.name = name;
        this.from = from;
        this.to = to;
        this.step = step;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Long getStep() {
        return step;
    }

    public void setStep(Long step) {
        this.step = step;
    }

    public Double[] getValues() {
        return values;
    }

    public void setValues(Double[] values) {
        this.values = values;
    }
}
