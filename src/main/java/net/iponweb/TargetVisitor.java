package net.iponweb;

import main.java.net.iponweb.grammar.GraphiteBaseVisitor;
import main.java.net.iponweb.grammar.GraphiteParser;

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
        return new PathTarget(tenant, from, to, ctx.pathExpression().getText());
    }

    @Override
    public Target visitExpressionCall(GraphiteParser.ExpressionCallContext ctx) {
        GraphiteParser.CallContext call = ctx.call();
        FunctionTarget function = new FunctionTarget(tenant, from, to, call.FunctionName().getText());

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
    }


}
