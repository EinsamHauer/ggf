package net.iponweb;

import main.java.net.iponweb.grammar.GraphiteBaseVisitor;
import main.java.net.iponweb.grammar.GraphiteParser;
import net.iponweb.exceptions.InvalidArgumentException;
import net.iponweb.exceptions.InvalidFunctionException;
import net.iponweb.functions.DistheneFunction;
import net.iponweb.functions.factory.FunctionFactory;
import org.antlr.v4.runtime.misc.ParseCancellationException;

/**
 * Created by aivanov on 14.06.2015.
 */
public class TargetVisitor extends GraphiteBaseVisitor<Target> {

    private String tenant;
    private Long from;
    private Long to;

    public TargetVisitor(String tenant, Long from, Long to) {
        this.tenant = tenant;
        this.from = from;
        this.to = to;
    }

    @Override
    public Target visitExpressionPathExpression(GraphiteParser.ExpressionPathExpressionContext ctx) {
        return new PathTarget(ctx.getText(), ctx.pathExpression().getText(), tenant, from, to);
    }

    @Override
    public Target visitExpressionCall(GraphiteParser.ExpressionCallContext ctx) {
        GraphiteParser.CallContext call = ctx.call();
        try {
            DistheneFunction  function = FunctionFactory.getFunction(call.FunctionName().getText());
            function.setText(ctx.getText());

            for(GraphiteParser.ArgContext arg : call.args().arg()) {
                if (arg instanceof GraphiteParser.ArgExpressionContext) {
                    function.addArg(visit(arg));
                } else if (arg instanceof GraphiteParser.ArgBooleanContext) {
                    function.addArg(Boolean.parseBoolean(arg.getText()));
                } else if (arg instanceof GraphiteParser.ArgNumberContext) {
                    function.addArg(Double.parseDouble(arg.getText()));
                } else if (arg instanceof GraphiteParser.ArgStringContext) {
                    function.addArg(arg.getText());
                }
            }

            return function;
        } catch (InvalidFunctionException | InvalidArgumentException e) {
            e.printStackTrace();
            throw new ParseCancellationException(e);
        }


    }


}
